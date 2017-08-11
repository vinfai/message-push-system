/**
 * 2014-7-2 
 * PubSubServiceImpl.java 
 * author:Edwin Chen
 */
package com.cvte.service.impl;



import javax.annotation.Resource;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.cvte.service.PubService;

/**
 * @author new
 *
 */
@Service
public class PubServiceImpl implements PubService {
	@Resource(name="stringRedisTemplate")
	private  StringRedisTemplate stringRedisTemplate;


	/*发布消息到Channel*/
	public void publisher(String topic , String message) {
		stringRedisTemplate.convertAndSend(topic, message);
	}
}
