package zyf.annotation.test;

//这里没有加@Singleton，表示是动态创建这个类，不是单例的  
public class HelloImpl implements Hello{  
    
  @Override  
  public void sayHello() {  
      System.out.println("HelloImpl Say Hello");  
  }  
}  
