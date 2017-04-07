package zyf.main;

import zyf.annotations.Home;
import zyf.annotations.Www;
import zyf.interfaces.Service;
import zyf.interfaces.impl.HomeService;
import zyf.interfaces.impl.WwwService;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.name.Named;
import com.google.inject.name.Names;

/**
 * 一个接口有多个实体类 
 * 
 * @author yanfangzhang
 *
 */
public class MultiInterfaceServiceDemo {
    @Inject
    @Www
    private Service wwwService;
    @Inject
    @Home
    private Service homeService;
    @Inject
    @Www
    private static Service wwwSer;
    @Inject
    @Home
    private static Service homeSer;
//    @Inject
//	@Named("www")
//	private static Service www;
//	@Inject
//	@Named("home")
//	private static Service home;
    public static void main(String[] args) {
        MultiInterfaceServiceDemo misd = Guice.createInjector(new Module() {
            @Override
            public void configure(Binder binder) {
                binder.bind(Service.class).annotatedWith(Www.class).to(WwwService.class);
                binder.bind(Service.class).annotatedWith(Home.class).to(HomeService.class);
            }
        }).getInstance(MultiInterfaceServiceDemo.class);
        misd.homeService.execute();
        misd.wwwService.execute();
        
        /* 问题（1）静态注入多个服务怎么写？
         * 解答：先根据注解讲多实现的映射关系映射好，然后请求静态注入
         * */
       Guice.createInjector(new Module(){

			@Override
			public void configure(Binder binder) {
				binder.bind(Service.class).annotatedWith(Www.class).to(WwwService.class);
				binder.bind(Service.class).annotatedWith(Home.class).to(HomeService.class);
				binder.requestStaticInjection(MultiInterfaceServiceDemo.class);
			}
        });
       MultiInterfaceServiceDemo.wwwSer.execute();
       MultiInterfaceServiceDemo.homeSer.execute();
       
       
      /* 问题（2）：如果不小心一个属性绑定了多个接口怎么办？
       * 解答：不可以绑定多个服务。否则将报错
       *...has more than one annotation annotated with ...
       * */
       
       /*问题（3）：不想写注解来区分多个服务，怎么办？
        * 解答：Google帮我们提供了一个Names的模板来生成注解
        * 使用Named来标注我们的服务应该使用什么样的注解，
        * 当然前提是我们已经将相应的服务与注解关联起来了。
        * 需要注意的是 不能讲Names和注解混合使用，只能用他们其中的一个
        * 详见类NoAnnotationMultiInterfaceServiceDemo 
        * */
//       Guice.createInjector(new Module(){
//		@Override
//		public void configure(Binder binder) {
//			binder.bind(Service.class).annotatedWith(Names.named("www")).to(WwwService.class);
//			binder.bind(Service.class).annotatedWith(Names.named("home")).to(HomeService.class);
//			binder.requestStaticInjection(MultiInterfaceServiceDemo.class);
//		}
//       });
//       MultiInterfaceServiceDemo.home.execute();
//       MultiInterfaceServiceDemo.www.execute();
    }
}
