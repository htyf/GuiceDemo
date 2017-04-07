package dwr.listener;
import org.directwebremoting.guice.DwrGuiceServletContextListener;

import dwr.interfaces.HelloWorld;
import dwr.interfaces.impl.HelloWorldImpl;

/**
 * 写一个dwr的listener来注入我们的模块。
 * @author yanfangzhang
 *
 */
public class MyDwrGuiceServletContextListener extends DwrGuiceServletContextListener{

	@Override
	protected void configure() {
		//使用bindRemotedAs来将我们的服务开放出来供dwr远程调用。
		 bindRemotedAs("helloworld", HelloWorld.class)
		 .to(HelloWorldImpl.class).asEagerSingleton();
		
	}

}
