package zyf.moudles;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import zyf.interfaces.IAnimal;
import zyf.interfaces.impl.Cat;
import zyf.interfaces.impl.Dog;

import com.google.inject.AbstractModule;
import com.google.inject.Binder;
import com.google.inject.BindingAnnotation;

/**
 * 定义一个Module管理接口与实现类的绑定关系：
 * @author yanfangzhang
 *
 */
public class AnimaiMoudle extends AbstractModule{

	@Override
	public void configure() {
		/**
		 * 1.最简单的绑定：链接绑定
		 * 语法：bind(接口类.class).to(实现类.class)
		 * 链接绑定绑定接口到实现类。
		 * 任何使用接口的地方都可以得到自动注入的实现类。
		 * 注意：这种绑定只能绑定一个实现类，如果绑定多个实现类，则会报错
		 */
		bind(IAnimal.class).to(Dog.class);
//		bind(IAnimal.class).to(Cat.class);
		
		
		
	}
	
}
