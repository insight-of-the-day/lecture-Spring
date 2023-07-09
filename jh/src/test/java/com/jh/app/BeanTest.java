package com.jh.app;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jh.app.annotation.TV;
import com.jh.app.junit.Restraurant;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class BeanTest {
	
	
	@Test
	public void test() {
		System.out.println("testtest");
	}
	@Autowired
	ApplicationContext ctx;
	
	@Test
	public void createBeanTest() {
		TV tv=(TV)ctx.getBean("tv");
		assertNotNull(tv);
	}
	
	
	
	String a=null;
	@Test
	public void a() {
		assertNotNull("fff",a);
	}
	@Autowired
	Restraurant res;

	@Test
	public void createRestraurant() {
		res.open();
	}
}
