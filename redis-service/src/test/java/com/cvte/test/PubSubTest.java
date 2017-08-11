
package com.cvte.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cvte.service.impl.PubServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/spring-context.xml",
		"classpath:config/redis-context.xml" })
public class PubSubTest {
	@Autowired
	private PubServiceImpl pubservice ;
	
	@Test
	public void PubTest() {
		String message = "chenhaoran2";
		pubservice.publisher("user:topic",message);
	}
}
