package zyf.main;

import com.google.inject.Guice;
import com.google.inject.Inject;

import zyf.interfaces.HelloWorld;
import zyf.interfaces.Service;

/**
 * 构造方法注入
 * @author yanfangzhang
 *
 */
public class ConstructorInjectDemo {
	private Service service;
	private HelloWorld helloWorld;
	
	@Inject
	public ConstructorInjectDemo(Service service, HelloWorld helloWorld) {
		super();
		this.service = service;
		this.helloWorld = helloWorld;
	}
	
	@Inject
	public ConstructorInjectDemo(Service service) {
		super();
		this.service = service;
	}

	public Service getService() {
		return service;
	}

	public HelloWorld getHelloWorld() {
		return helloWorld;
	}

	public static void main(String[] args) {
		/*
		 * 我们在构造函数上添加@Inject来达到自动注入的目的。
		 * 构造函数注入的好处是可以保证只有一个地方来完成属性注入，
		 * 这样可以确保在构造函数中完成一些初始化工作（尽管不推荐这么做）
		 * 。当然构造函数注入的缺点是类的实例化与参数绑定了，
		 * 限制了实例化类的方式。
		 * */
		ConstructorInjectDemo demo = Guice.createInjector().getInstance(ConstructorInjectDemo.class);
		demo.getService().execute();
		/* 问题1：构造函数中可以自动注入多个参数么？
		 * 解答：可以 非常完美的支持了多参数构造函数注入。
		 * 当然了没有必要写多个@Inject，而且写了的话不能通过编译。*/
//		ConstructorInjectDemo demo = Guice.createInjector().getInstance(ConstructorInjectDemo.class);
//		demo.getService().execute();
//		System.out.println(demo.getHelloWorld().sayHello());
		
		
	}

}
