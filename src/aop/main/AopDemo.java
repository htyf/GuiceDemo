package aop.main;

import aop.interceptor.LoggerMethodInterceptor;
import aop.interfaces.Service;
import aop.interfaces.impl.ServiceImpl;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.Scopes;
import com.google.inject.matcher.Matcher;
import com.google.inject.matcher.Matchers;
import com.google.inject.name.Named;
import com.google.inject.name.Names;

/**
 * Guice实现切面
 * @author yanfangzhang
 *
 */
public class AopDemo {
	@Inject
	private Service service;

	public static void main(String[] args) {
		Injector inj = Guice.createInjector(new Module() {
			@Override
			public void configure(Binder binder) {
				binder.bind(Service.class).to(ServiceImpl.class).in(Scopes.SINGLETON);
				//绑定一个拦截器，这个拦截器匹配任何类的带有log注解的方法
				binder.bindInterceptor(Matchers.any(),//代表任何类 
						Matchers.annotatedWith(Names.named("log")), //代表类中带有log注解的方法
						new LoggerMethodInterceptor());//自定义的切面类
			}
		});
		inj.getInstance(AopDemo.class).service.sayHello();
//		inj.getInstance(AopDemo.class).service.sayHello();
//		inj.getInstance(AopDemo.class).service.sayHello();
	}
}
