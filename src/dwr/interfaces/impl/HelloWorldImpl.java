package dwr.interfaces.impl;

import java.util.Date;

import dwr.interfaces.HelloWorld;

public class HelloWorldImpl  implements HelloWorld {

	@Override
	public String sayHello() {
		// TODO Auto-generated method stub
		return  "Hello, guice";
	}

	@Override
	public Date getSystemDate() {
		// TODO Auto-generated method stub
		return new Date();
	}

}
