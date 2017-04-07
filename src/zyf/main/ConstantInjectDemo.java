package zyf.main;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Module;
import com.google.inject.name.Named;
import com.google.inject.name.Names;

/**
 * 绑定常量
 * @author yanfangzhang
 *
 */
public class ConstantInjectDemo {
	@Inject
	@Named("v")
	private int v;
	@Inject
	@Named("s")
	private int s;
	@Inject
	@Named("abc")
	private String abc;
	public static void main(String[] args) {
		ConstantInjectDemo demo = Guice.createInjector(new Module() {
			@Override
			public void configure(Binder binder) {
				binder.bindConstant().annotatedWith(Names.named("v")).to(12);
				binder.bind(int.class).annotatedWith(Names.named("s")).toInstance(13);
				binder.bind(String.class).annotatedWith(Names.named("abc")).toInstance("abc");
			}
		}).getInstance(ConstantInjectDemo.class);
		System.out.println(demo.v);
		System.out.println(demo.s);
		System.out.println(demo.abc);
	}
}
