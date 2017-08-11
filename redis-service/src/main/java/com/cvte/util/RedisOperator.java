package com.cvte.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service
public class RedisOperator {


    @Autowired
    RedisTemplate redisTemplate;

    public static final String TONGBU_LIST = "tongBuPushList_t";
    public static final String YIGBU_LIST = "yiBuPushList_t";


    public void rightPushTongbu(String string){
        ListOperations<String, String> listOper = (ListOperations<String, String> )redisTemplate.opsForList();

        listOper.rightPush("tongBuPushList_t2",string);
    }

    public void rightPushYibu(String string){
        ListOperations<String, String> listOper = (ListOperations<String, String> )redisTemplate.opsForList();

        listOper.rightPush("yiBuPushList_t2",string);
    }

    public String rightPopTongbu(){
        ListOperations<String, String> listOper = (ListOperations<String, String> )redisTemplate.opsForList();
        return listOper.rightPop("tongBuPushList_t2");
    }

    public String rightPopYibu(){
        ListOperations<String, String> listOper = (ListOperations<String, String> )redisTemplate.opsForList();
        return listOper.rightPop("yiBuPushList_t2");
    }


    public void save(String type,String url) {
        ValueOperations<String, String> valueOper = redisTemplate.opsForValue();
        valueOper.set(type, url);
    }

    public String read(String type) {
        ValueOperations<String, String> valueOper = redisTemplate.opsForValue();
        return valueOper.get(type);
    }


}
