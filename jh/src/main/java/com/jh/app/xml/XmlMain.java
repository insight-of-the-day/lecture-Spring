package com.jh.app.xml;

import org.springframework.context.support.GenericXmlApplicationContext;


public class XmlMain {
	
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx=new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		TV tv=(TV)ctx.getBean("xmlTV");
		tv.on();

	}

}
