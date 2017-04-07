package zyf.main;

import zyf.interfaces.Service;
import zyf.interfaces.impl.HomeService;
import zyf.interfaces.impl.WwwService;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Module;

/**
 * 选项注入描述的是如果不能从Guice容器中注入一个对象，那么可以使用一个默认的对象。
 * 第19行描述的是选项注入，如果不能从Guice容器中获取一个Service服务
 * 那么就使用默认的WwwService，否则就是用获取的服务。
 * 如果将第26行注释去掉我们就可以看到实际上调用的是HomeService服务了
 * @author yanfangzhang
 *
 */
public class OptionalInjectionDemo {
	@Inject(optional=true)
	Service service = new WwwService();
	public static void main(String[] args) {
		Guice.createInjector(new Module() {
			public void configure(Binder binder) {
//				binder.bind(Service.class).to(HomeService.class);
			}
		}).getInstance(OptionalInjectionDemo.class).service.execute();
	}
}
