package spring.interfaces.impl;

import java.util.Date;

import spring.interfaces.HelloWorld;


public class HelloWorldImpl  implements HelloWorld {

	@Override
	public String sayHello(String user) {
		// TODO Auto-generated method stub
		return String.format("Welcome to Guice with spring, %1$s. Now is %2$tF %2$tH:%2$tM:%2$tS.", user,new Date());
	}

}
