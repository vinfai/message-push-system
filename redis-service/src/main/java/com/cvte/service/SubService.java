/**
 * 2014-7-2 
 * SubService.java 
 * author:Edwin Chen
 */
package com.cvte.service;

import org.springframework.data.redis.connection.MessageListener;

/**
 * 订阅服务接口
 */
public interface SubService extends MessageListener {

}
