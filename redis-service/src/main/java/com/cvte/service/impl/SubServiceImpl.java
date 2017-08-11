/**
 * 2014-7-2 
 * SubServiceImpl.java 
 * author:Edwin Chen
 */
package com.cvte.service.impl;

import com.cvte.util.JsonRedisSeriaziler;
import com.cvte.entity.PushEntity;
import com.cvte.entity.RequestEntity;
import com.cvte.util.RedisOperator;
import com.cvte.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;

import com.cvte.service.SubService;

import java.util.Arrays;
import java.util.List;

/**
 * @author new
 * 
 */

public class SubServiceImpl implements SubService {

	@Autowired
	RedisOperator redisOperator;

	@Autowired
	private PubServiceImpl pubService;


	@Autowired
	MailServiceImpl mailService;

	@Autowired
	SmsServiceImpl smsService;

	private PushEntity pushEntity = null;


	@Override
	public void onMessage(Message message, byte[] pattern) {


		if(new String(message.getChannel()).equals("user:topic")){

			RequestEntity entity = JsonRedisSeriaziler.deserializeAsObject(new String(message.getBody()),RequestEntity.class);
			System.out.println("requestEntity="+entity.toString());

			Integer id = entity.getId();
			String appid = entity.getAppid();
			String sign = entity.getSign();
			String push = entity.getPush();
			Integer templateId = entity.getTemplateId();
			String params = entity.getParams();
			String content = entity.getContent();
			Integer needreply = entity.getNeedreply();
			Integer isTongbu = entity.getIsTongbu();

			List<String> pushList = Arrays.asList(push.split(","));

			for (int i = 0 ; i < pushList.size() ;i++){

				pushEntity = new PushEntity(appid, String.valueOf(id), pushList.get(i),  sign,  templateId,  params,  content,  0,  0, TimeUtil.getDate());
				pushEntity.setNeedreply(needreply);
				String msg = JsonRedisSeriaziler.seriazileAsString(pushEntity);


				if(isTongbu ==1){
					redisOperator.rightPushTongbu(msg);
				}else {
					redisOperator.rightPushYibu(msg);
				}

				//发布消息
				pubService.publisher("user:newPushTask" , msg);
			}

		}else if(new String(message.getChannel()).equals("user:newPushTask")){

			String s = redisOperator.rightPopTongbu();
			if(s == null){
				s = redisOperator.rightPopYibu();
			}

			PushEntity pe = JsonRedisSeriaziler.deserializeAsObject( s , PushEntity.class);

			String pushAddress = pe.getPushAddress();

			if (pushAddress.contains("@")){//邮件
				try {
					mailService.sendMail(pe);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else{
				//短信
				try {
					smsService.sendSms(pe);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}
}
