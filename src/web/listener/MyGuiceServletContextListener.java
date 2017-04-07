package web.listener;

import web.servlet.HelloWorldServlet;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;

/**
 * 完成guice的初始化
 * @author yanfangzhang
 *
 */
public class MyGuiceServletContextListener extends GuiceServletContextListener{

	@Override
	protected Injector getInjector() {
		// TODO Auto-generated method stub
		return Guice.createInjector(new ServletModule(){
			@Override
			protected void configureServlets() {
				// 将某个PATH映射到一个Servlet上
				//这里将/helloworld这个地址映射到HelloWorldServlet上
				serve("/helloworld").with(HelloWorldServlet.class);
			}
		});
	}

}
