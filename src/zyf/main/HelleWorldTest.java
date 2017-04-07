package zyf.main;

import org.junit.Assert;
import org.junit.Test;

import zyf.interfaces.HelloWorld;
import zyf.interfaces.impl.HelloWorldImpl;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.Provider;
import com.google.inject.Scopes;

public class HelleWorldTest {
	@Test
    public void testSayHello() {
//      Injector inj=  Guice.createInjector(new Module() {
//            @Override
//            public void configure(Binder binder) {
//                binder.bind(HelloWorld.class).to(HelloWorldImpl.class);
//            }
//        });
//      HelloWorld hw = inj.getInstance(HelloWorld.class);
//      Assert.assertEquals(hw.sayHello(), "Hello, world!");
      
     /* 问题（1）HelloWorld是单例的么？ 	 
      * 结果：HelloWorld不是单例的，每次都会返回一个新的实例。*/
//      HelloWorld hw2 = inj.getInstance(HelloWorld.class);
//      System.out.println(hw.hashCode()+"->"+hw2.hashCode());
//      Assert.assertEquals(hw.hashCode(), hw2.hashCode());
      
     /* 问题（2）HelloWorld的实例是HelloWorldImpl么？可以强制转型么？
      * 解答（2），结果输出zyf.interfaces.impl.HelloWorldImpl，
      * 看来确实只是返回了一个正常的实例，并没有做过多的转换和代理。*/
//      System.out.println(hw.getClass().getName());
      
      /*问题（3），如果绑定多个实现到同一个接口上会出现什么情况？
       * 解答（3） Guice不允许多个实例绑定到同一个接口上，否则报错*/
      /*问题（4），可以绑定一个实现类到实现类么？
       * 解答：不可以自己绑定到自己。
       *（错误）binder.bind(HelloWorldImpl.class).to(HelloWorldImpl.class);
       * 也就是说只能绑定一个类的子类到其本身。
       * （正确）binder.bind(HelloWorldImpl.class).to(HelloWorldSubImpl.class);
       * 前面父类后面子类 
       * */
      
      
      /*问题（5），可以绑定到我们自己构造出来的实例么？
       * 解答：当然可以，方法如下：
       * */
//		 Injector inj=  Guice.createInjector(new Module() {
//             @Override
//             public void configure(Binder binder) {
//                 binder.bind(HelloWorld.class).toInstance(new HelloWorldImpl());
//             }
//         });
//       HelloWorld hw = inj.getInstance(HelloWorld.class);
//       System.out.println(hw.sayHello());
        
       
      /*问题（6），我不想自己提供逻辑来构造一个对象可以么？
       * 解答：可以
       * Guice提供了一个方式（Provider），允许自己提供构造对象的方式。
       * */
//      Injector inj=  Guice.createInjector(new Module() {
//          @Override
//          public void configure(Binder binder) {
//               binder.bind(HelloWorld.class).toProvider(new Provider<HelloWorld>() {
//
//				@Override
//				public HelloWorld get() {
//					// TODO Auto-generated method stub
//					return new HelloWorldImpl();
//				}
//			});
//          }
//      });
//    HelloWorld hw = inj.getInstance(HelloWorld.class);
//    System.out.println(hw.sayHello());
    
	
		/*问题（7），实现类可以不经过绑定就获取么？
		比如我想获取HelloWorldImpl的实例而不通过Module绑定么
		解答：可以 实际上Guice能够自动寻找实现类。
		*/
//		Injector inj=  Guice.createInjector();
//		HelloWorld hw = inj.getInstance(HelloWorldImpl.class);
//		System.out.println(hw.sayHello());
		
		/*问题（8），可以使用注解方式完成注入么？不想手动关联实现类。
		 * 解答：Guice提供了注解的方式完成关联。
		 * 我们需要在接口上指明此接口被哪个实现类关联了。
		 * 如：     @ImplementedBy(HelloWorldImpl.class)
      			public interface HelloWorld {
          		String sayHello();
      			}
      	 * 事实上对于一个已经被注解的接口我们仍然可以使用Module来关联，
      	 * 这样获取的实例将是Module关联的实例，而不是@ImplementedBy注解关联的实例。
      	 * 这样仍然遵循一个原则，手动优于自动。
		 * */
		
		
		/*问题（9）再回头看问题（1）怎么绑定一个单例？
		 * 解答：第一种在module中用in注明sington
		 * 第二种使用自动注入@Singleton在实体类上添加注解
		 * */
		Injector inj = Guice.createInjector(new Module(){

			@Override
			public void configure(Binder binder) {
				binder.bind(HelloWorld.class).to(HelloWorldImpl.class).in(Scopes.SINGLETON);
			}
			
		});
		HelloWorld hw = inj.getInstance(HelloWorld.class);
	    HelloWorld hw2 = inj.getInstance(HelloWorld.class);
	    System.out.println(hw.hashCode() + "->" + hw2.hashCode());
	}
}
