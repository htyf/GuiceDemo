package zyf.annotation.manyIml;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class HelloClient {
	 public static void main(String[] args) {  
         
	        Injector in = Guice.createInjector(new HelloModule()) ;  
	        HelloCaller caller = in.getInstance(HelloCaller.class) ;  
	          
	        caller.sayHello1() ;  
	        caller.sayHello2() ;  
	    }  
}
