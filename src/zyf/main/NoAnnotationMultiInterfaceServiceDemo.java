package zyf.main;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Module;
import com.google.inject.name.Named;
import com.google.inject.name.Names;

import zyf.interfaces.Service;
import zyf.interfaces.impl.HomeService;
import zyf.interfaces.impl.WwwService;

/**
 * 没有注解的多实现
 * @author yanfangzhang
 *
 */
public class NoAnnotationMultiInterfaceServiceDemo {
	@Inject
	@Named("Www")
	private static Service wwwService;
	@Inject
	@Named("Home")
	private static Service homeService;
	public static void main(String[] args) {
		Guice.createInjector(new Module() {
			@Override
			public void configure(Binder binder) {
				binder.bind(Service.class).annotatedWith(Names.named("Www")).to(WwwService.class);
				binder.bind(Service.class).annotatedWith(Names.named("Home")).to(HomeService.class);
				binder.requestStaticInjection(NoAnnotationMultiInterfaceServiceDemo.class);
			}
		});
		NoAnnotationMultiInterfaceServiceDemo.homeService.execute();
		NoAnnotationMultiInterfaceServiceDemo.wwwService.execute();
	}

}
