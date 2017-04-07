package zyf.moudles;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.google.inject.AbstractModule;
import com.google.inject.Binder;
import com.google.inject.BindingAnnotation;
/**
 * 2.一个接口有多个实现类的绑定：注解绑定
 * 借助注解区分接口的不同实现类。
 * 两种方式：自定义注解或使用Guice提供的@Named注解
 */
public class AnimalMoudleMoreImpl extends AbstractModule{

	@Override
	protected void configure() {
//		Binder binder = new  
		
	}

	/**
	 *  自定义注解：
	 *  @BindingAnnotation 告诉Guice这是一个绑定注解。
	 *  如果在一个位置（FIELD, PARAMETER, METHOD），使用多个绑定注解，Guice会报错。
	 *  @Target({FIELD, PARAMETER, METHOD})注解生效的位置
	 *  @Retention(RUNTIME) 这个注解在运行时起作用
	 *  @author yanfangzhang
	 *
	 */
//	@BindingAnnotation @Target({ FIELD, PARAMETER, METHOD }) @Retention(RUNTIME)
//	public @interface PayPal {}

	
}
