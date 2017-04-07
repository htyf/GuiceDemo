package zyf.annotation.test;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class HelloClient {
	//创建一个测试程序  
	public static void main(String[] args) {  

		Injector in = Guice.createInjector() ;  
		//得到HelloCaller的实例  
//		HelloCaller helloCaller = in.getInstance(HelloCaller.class) ;  
//		HelloCaller1 helloCaller = in.getInstance(HelloCaller1.class) ;  
//		HelloCaller2 helloCaller = in.getInstance(HelloCaller2.class) ;  
		HelloCaller3 helloCaller = in.getInstance(HelloCaller3.class) ;  
		//调用sayHello方法  
		helloCaller.sayHello();  
	}  

}
