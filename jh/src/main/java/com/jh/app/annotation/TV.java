package com.jh.app.annotation;

import org.springframework.stereotype.Component;

@Component("tv")
public class TV implements Things {

	@Override
	public void on() {
		System.out.println("it's g");

	}

}
