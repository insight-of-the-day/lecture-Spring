package com.jh.app.annotation;

import org.springframework.context.support.GenericXmlApplicationContext;


import com.jh.app.xml.TV;


public class AnnotationMain {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx=new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		TV tv=(TV)ctx.getBean("tv");
		tv.on();

	}

}
