package com.cvte.controller;

import com.cvte.dao.*;
import com.cvte.entity.*;
import com.cvte.util.JsonRedisSeriaziler;
import com.cvte.service.impl.PubServiceImpl;
import com.cvte.util.RedisOperator;
import com.cvte.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping(value = "/msgpush")
public class RequestController {


    @Resource(name="pubServiceImpl")
    private PubServiceImpl pubService;


    @Autowired
    IUserDao userDao;

    @Autowired
    IRequestDao requestDao;

    @Autowired
    ITextTemplateDao templateDao;

    @Autowired
    IPushEntityDao pushEntityDao;

    @Autowired
    IPushUrlDao pushUrlDao;

    @Autowired
    RedisOperator redisOperator;

    /**
     * 短信推送
     */
    @RequestMapping(value = "/phone", method = RequestMethod.POST)
    @Transactional(rollbackFor=Exception.class)
    public String phonePost(
            @RequestParam(value = "appid",required = true) String appid,
            @RequestParam(value = "push",required = true) String push,
            @RequestParam("sign") String sign,                      //短信签名
            @RequestParam(value = "template_id",defaultValue = "0") Integer template_id,
            @RequestParam(value ="params",defaultValue = "") String params,
            @RequestParam("content") String content,
            @RequestParam(value = "needreply",defaultValue = "0") Integer needreply,
            @RequestParam(value = "isTongbu",defaultValue = "0") Integer isTongbu) {

        //验证appid
        User user = userDao.findByAppid(appid);
        if(user == null||!appid.equals(user.getAppid())){
            return "-1";
        }

        //封装--请求实体,存入mysql
        RequestEntity entity = new RequestEntity(appid, sign ,  push,  template_id,  params,  content, needreply, isTongbu, TimeUtil.getDate());
        requestDao.addRequestEntity(entity);//id已在属性中

        //转成json,发布到“第一个频道”
        String msg = JsonRedisSeriaziler.seriazileAsString(entity);
        pubService.publisher("user:topic",msg);


        //提交成功后,返回本次请求id(id>0)
        return String.valueOf(entity.getId());
//        return "test";
    }


    /**
     * 处理POST请求，用来创建插入TextTemplate
     */
    @RequestMapping(value = "/template", method = RequestMethod.POST)
    @Transactional(rollbackFor=Exception.class)
    public String addTemplate(
            @RequestParam("appid") String appid,
            @RequestParam("text") String text,
            @RequestParam("paramsNum") Integer paramsNum) {

        //验证appid
        User user = userDao.findByAppid(appid);
        if(user == null||!appid.equals(user.getAppid())){
            return "-1";
        }

        //存入mysql
        TextTemplate textTemplate = new TextTemplate(paramsNum, text);
        templateDao.addTemplate(textTemplate);

        //模板保存成功后,返回模板id(id>0)
        return String.valueOf(textTemplate.getId());
    }


    @RequestMapping(value = "/callback", method = RequestMethod.POST)
    @Transactional(rollbackFor=Exception.class)
    public String searchResult(
            @RequestParam("appid") String appid,
            @RequestParam("requestCode") String requestCode,
            @RequestParam("push") String push) {

        //验证appid
        User user = userDao.findByAppid(appid);
        if(user == null||!appid.equals(user.getAppid())){
            return "-1";
        }

        List<PushEntity> list = null;
        if("".equals(push)){//查询appid-requestCode 下所有的
            list = pushEntityDao.findAllByAppidAndRequestCode(appid, requestCode);
        }else {
            List<String> pushAddresses = Arrays.asList(push.split(","));
//            list = pushEntityDao.findByAppidAndRequestCode(appid, requestCode , pushAddresses);
        }

        //转成json
        String json = JsonRedisSeriaziler.seriazileAsString(list);
        return json;
    }



    /**
     * 邮件推送
     */
    @RequestMapping(value = "/mail", method = RequestMethod.POST)
    @Transactional(rollbackFor=Exception.class)
    public String mailPost(
            @RequestParam(value = "appid",required = true) String appid,
            @RequestParam(value = "push",required = true) String push,
            @RequestParam(value = "sendMailer",required = true) String sign,
            @RequestParam("template_id") Integer template_id,
            @RequestParam(value = "params" ,required = true) String params,  //第一个参数=subject
            @RequestParam("content") String content,
            @RequestParam(value = "needreply",defaultValue = "0") Integer needreply,
            @RequestParam(value = "isTongbu",defaultValue = "0") Integer isTongbu) {

        //验证appid
        User user = userDao.findByAppid(appid);
        if(user == null||!appid.equals(user.getAppid())){
            return "-1";
        }

        //封装--请求实体,存入mysql
        RequestEntity entity = new RequestEntity(appid, sign ,  push,  template_id,  params,  content, needreply, isTongbu, TimeUtil.getDate());
        requestDao.addRequestEntity(entity);

        //转成json,发布到“第一个频道”
        String msg = JsonRedisSeriaziler.seriazileAsString(entity);
        pubService.publisher("user:topic",msg);

        //提交成功后,返回本次请求id(id>0)
        return String.valueOf(entity.getId());
    }


    /**
     * 邮件推送
     */
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    @Transactional(rollbackFor=Exception.class)
    public String modifyUrl(
            @RequestParam(value = "type",required = true) String type, //type=mail、sms
            @RequestParam(value = "url",required = true) String url) {

        //存入mysql
        pushUrlDao.modifyUrl(new PushUrl(type , url));

        //刷新redis缓存的值
        redisOperator.save(type ,url);
        return "1";
    }


}
