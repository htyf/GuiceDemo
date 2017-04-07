package zyf.annotation.test;

import com.google.inject.Inject;  

//HelloCaller将会去调用Hello这个接口提供的服务  
public class HelloCaller1 {  
	private Hello hello ;  
	//@Inject注解写在构造方法上，通过构造方法的方式注入属性hello  
	@Inject  
	public HelloCaller1(Hello hello){  
		this.hello = hello ;  
	}  

	public void sayHello(){  
		hello.sayHello() ;  
	}  
}  
