package zyf.main;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

/**
 * 对象默认在第一次调用时被创建，也即所谓的延时加载，
 * Guice也允许对象在注入到Guice容器中时就被创建出来(显然这是针对单例模式才有效)。
 * Eagerly Loading Bindings （立即初始化）
 * @author yanfangzhang
 *
 */
public class EagerSingletonDemo {
	 public EagerSingletonDemo() {
	        System.out.println(" constuctor:"+System.nanoTime());
	    }
	    void doit() {
	        System.out.println("       doit:"+System.nanoTime());
	    }
	    public static void main(String[] args) throws Exception{
	        Injector inj = Guice.createInjector(new Module() {
	            @Override
	            public void configure(Binder binder) {
	                binder.bind(EagerSingletonDemo.class).asEagerSingleton();
	            }
	        });
	        System.out.println("before call:"+System.nanoTime());
//	        Thread.sleep(100L);
	        inj.getInstance(EagerSingletonDemo.class).doit();
	    }

}
