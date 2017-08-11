package com.cvte.controller;

import com.cvte.dao.IUserDao;
import com.cvte.entity.User;
import com.cvte.util.JsonRedisSeriaziler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(value = "/msgpush")
public class UserController {


    @Autowired
    IUserDao userDao;


    public static String getAppid() {
        int machineId = 1;// 最大支持1-9个集群机器部署
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if (hashCodeV < 0) {// 有可能是负数
            hashCodeV = -hashCodeV;
        }
        // 0 代表前面补充0
        // d 代表参数为正数型
        return machineId + String.format("%010d", hashCodeV);// //整数长度为10，如果不到10位就用0填充
    }


    /**
     * 处理POST请求，用来创建插入User
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String addUser(
            @RequestParam("userName") String userName,
            @RequestParam("passwd") String passwd) {

        //生成appid
        String appid = getAppid();
        User user = new User(userName, passwd, appid);

        int result = userDao.addUser(user);
        if (result > 0) {
            //转成json
            String json = JsonRedisSeriaziler.seriazileAsString(user);
            return json;
        }
        return "null";
    }
}
