package com.cvte.service.impl;

import com.cvte.dao.IPushEntityDao;
import com.cvte.dao.ITextTemplateDao;
import com.cvte.entity.PushEntity;
import com.cvte.entity.TextTemplate;
import com.cvte.service.MailService;
import com.cvte.util.RedisOperator;
import com.cvte.util.TimeUtil;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {

    @Autowired
    IPushEntityDao pushEntityDao;

    @Autowired
    ITextTemplateDao templateDao;

    @Autowired
    RedisOperator redisOperator;

    @Override
    public void sendMail(PushEntity pe) throws Exception {

        String pushAddress = pe.getPushAddress();
        String sign = pe.getSign();
        Integer templateId = pe.getTemplateId();
        String params = pe.getParams();
        String content = pe.getContent();
        String url = pe.getNeedreply()==1 ?  "http://localhost:8080/pubsub/room?appid="+pe.getAppid()+"&requestCode="+pe.getRequestCode()+"&pushAddress="+pushAddress:"";

        if(templateId > 0){
            TextTemplate textTemplate = templateDao.findTemplateById(templateId);
            content = textTemplate.getText()+url;
        }else {
            content+=url;// 无模板时
        }

        //替换模板参数
        JSONArray paramsArray = JSONArray.fromObject(params);
        for (int i = 1; i < paramsArray.size() ;i++){
            content = content.replace( "{"+i+"}", paramsArray.get(i).toString());
        }

        //从redis读取邮件接口
        String mailPushUrl = redisOperator.read("mail");

        try {
            Thread.sleep(2000);//模拟发送
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            pe.setTime(TimeUtil.getDate());
            pe.setStatus(1);
            pe.setResult(1);//设置推送状态
            pushEntityDao.addPushEntity(pe);//存入mysql
            System.out.println("邮件推送人="+sign+",内容="+content+"subject="+paramsArray.getString(0));
        }

    }
}
