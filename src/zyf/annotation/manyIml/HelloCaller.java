package zyf.annotation.manyIml;

import com.google.inject.Inject;
import com.google.inject.name.Named;

//将一个接口绑定到多个实现类上  
public class HelloCaller {  
    
  @Inject  
  @Named("HelloImpl1")  
  private Hello helloImpl1 ;  
  @Inject  
  @Named("HelloImpl2")  
  private Hello helloImpl2 ;  
    
  public void sayHello1(){  
      helloImpl1.satHello() ;  
  }  
    
  public void sayHello2(){  
      helloImpl2.satHello() ;  
  }  
}  
