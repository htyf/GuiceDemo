package zyf.interfaces;

import zyf.interfaces.impl.HelloWorldImpl;

import com.google.inject.ImplementedBy;

@ImplementedBy(HelloWorldImpl.class)
public interface HelloWorld {
	String sayHello();
}
