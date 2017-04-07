package zyf.main;

import zyf.interfaces.Service;
import zyf.interfaces.impl.WwwService;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.Module;
import com.google.inject.Provider;
import com.google.inject.Scope;

/**
 * 与线程绑定的作用域scope
 * @author yanfangzhang
 *
 */
public class ThreadScopeDemo {
	/**
	 * ThreadServiceScope类是一个与线程绑定的作用域（利用ThreadLocal特性），
	 * 当当前线程中没有构造一个对象的时候先构造一个出来，然后放入线程上下文中，
	 * 以后每次都从线程中获取对象。
	 * @author yanfangzhang
	 *
	 */
	 static class ThreadServiceScope implements Scope{
		 ThreadLocal<Object> threadLocal = new ThreadLocal<Object>();

		@Override
		public <T> Provider<T> scope(Key<T> key, final Provider<T> unscoped) {
			// TODO Auto-generated method stub
			return new Provider<T>() {
				
				@Override
				public T get() {
					T instance = (T) threadLocal.get();
					if(instance==null){
						instance = unscoped.get();
						threadLocal.set(instance);
					}
					return instance;
				}
			};
		}
		
	}

	@Override
	public String toString() {
		return "Scopes.ThreadServiceScope";
	}

	public static void main(String[] args) {
		final Injector inj = Guice.createInjector(new Module() {
			
			@Override
			public void configure(Binder binder) {
				//将WwwService服务以ThreadServiceScope的作用域绑定到Service服务上
				binder.bind(Service.class).to(WwwService.class).in(new ThreadServiceScope());
			}
		});
		for(int i=0;i<3;i++){
			 new Thread("Thread-"+i) {
	                public void run() {
	                    for(int m=0;m<3;m++) {
	                    	//输出当前对象的hashCode
	                        System.out.println(String.format("%s!%d:%d",//
	                                getName()//当前线程的名称
	                                ,m//
	                                ,inj.getInstance(Service.class).hashCode()));
	                        try {
	                            Thread.sleep(50L);
	                        } catch (Exception e) {
	                        }
	                    }
	                }
	            }.start();
		}
		//结果：同一线程三次输出的hashcode值相同
	}
}
