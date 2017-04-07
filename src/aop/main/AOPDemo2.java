package aop.main;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.Scopes;
import com.google.inject.matcher.Matchers;
import com.google.inject.name.Names;

import aop.interceptor.AfterMethodInterceptor;
import aop.interfaces.Service;
import aop.interfaces.impl.ServiceImpl;

/**
 * 切面（拦截器）注入依赖
 * 尽管切面允许注入其依赖，
 * 但是这里需要注意的是，如果切面依赖仍然走切面的话那么程序就陷入了死循环，很久就会堆溢出。
 * @author yanfangzhang
 *
 */
public class AOPDemo2 {
	@Inject
	private Service service;
	public static void main(String[] args) {
		Injector inj = Guice.createInjector(new Module() {
			
			@Override
			public void configure(Binder binder) {
//				binder.bind(Service.class).to(ServiceImpl.class).in(Scopes.SINGLETON);
				 AfterMethodInterceptor after= new AfterMethodInterceptor();
				binder.requestInjection(after);//必须要
				binder.bindInterceptor(Matchers.any(),
						Matchers.annotatedWith(Names.named("log")), 
						after);
			}
		});
		inj.getInstance(AOPDemo2.class).service.sayHello();
	}
	

}
