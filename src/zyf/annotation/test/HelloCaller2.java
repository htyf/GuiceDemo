package zyf.annotation.test;

import com.google.inject.Inject;  

//HelloCaller将会去调用Hello这个接口提供的服务  
public class HelloCaller2 {  
	private Hello hello ;  
	
	
	public Hello getHello() {
		return hello;
	}

	//通过setter方法来注入hello属性  
	@Inject 
	public void setHello(Hello hello) {
		this.hello = hello;
	}
	public void sayHello(){  
		hello.sayHello() ;  
	}  
}  
