package zyf.main;

import java.util.Properties;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Module;
import com.google.inject.name.Named;
import com.google.inject.name.Names;

/**
 *  绑定Properties
 * @author yanfangzhang
 *
 */
public class PropertiesInjectDemo {
	@Inject
	@Named("url")
	private String url;
	public static void main(String[] args) {
		PropertiesInjectDemo demo = Guice.createInjector(new Module() {
			@Override
			public void configure(Binder binder) {
				Properties pro  =  new Properties();
				pro.setProperty("url", "www.baidu.com");
				Names.bindProperties(binder, pro);
			}
		}).getInstance(PropertiesInjectDemo.class);
		System.out.println(demo.url);
	}

}
