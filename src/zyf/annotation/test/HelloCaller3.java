package zyf.annotation.test;

import com.google.inject.Inject;

public class HelloCaller3 {
	
    @Inject  
    private static Hello hello ;  
      
    public static void sayHello(){  
        hello.sayHello() ;  
    }  
}
