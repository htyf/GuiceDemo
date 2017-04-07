package zyf.annotation.test;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class HelloClient1 {
	//创建一个测试程序  
	public static void main(String[] args) {  

		Injector in = Guice.createInjector(new Module(){

			@Override
			public void configure(Binder binder) {
				 //  实现静态注入  
                binder.requestStaticInjection(HelloCaller3.class) ;  
			}
			
		}) ;  
		//得到HelloCaller的实例  
		HelloCaller3 helloCaller = in.getInstance(HelloCaller3.class) ;  
		//调用sayHello方法  
		helloCaller.sayHello();  
	}  

}
