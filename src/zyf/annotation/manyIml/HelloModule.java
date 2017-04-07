package zyf.annotation.manyIml;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.name.Names;

public class HelloModule implements Module{  
  
    @Override  
    public void configure(Binder binder) {  
        //通过annotatedWith 中使用Named方法来绑定多个实现类  
        binder.bind(Hello.class).annotatedWith(Names.named("HelloImpl1")).to(HelloImpl1.class) ;  
        binder.bind(Hello.class).annotatedWith(Names.named("HelloImpl2")).to(HelloImpl2.class) ;  
    }  
}  
