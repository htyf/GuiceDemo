package zyf.main;

import zyf.interfaces.Service;
import zyf.provider.WwwServiceProvider;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.Provider;

/**
 * Provider注入
 * @author yanfangzhang
 *
 */
public class ProviderServiceDemo {
	@Inject
	private Service service;
	
	public Service getService() {
		return service;
	}

	@Inject
	private Provider<Service> provider;
	
	public static void main(String[] args) {
		Injector inj = Guice.createInjector(new Module() {
			
			@Override
			public void configure(Binder binder) {
				binder.bind(Service.class).toProvider(WwwServiceProvider.class);
			}
		});
		ProviderServiceDemo demo = inj.getInstance(ProviderServiceDemo.class);
		demo.getService().execute();
		
		/*如果不用Moudle,可以在接口上直接使用注解@ProvidedBy(WwwServiceProvider.class)*/
		Injector injr = Guice.createInjector();
		ProviderServiceDemo demo1 = injr.getInstance(ProviderServiceDemo.class);
		demo1.getService().execute();
		
		/*上面两种方式都是注入的服务，也可以不注入服务直接注入provider*/
		ProviderServiceDemo prov = Guice.createInjector(new Module(){
			@Override
			public void configure(Binder binder) {
				binder.bind(Service.class).toProvider(WwwServiceProvider.class);
			}
		}).getInstance(ProviderServiceDemo.class);
		prov.provider.get().execute();
	}
	
	
}
