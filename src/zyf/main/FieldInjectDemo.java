package zyf.main;

import com.google.inject.Guice;
import com.google.inject.Inject;

import zyf.interfaces.Service;

/**
 * 属性注入
 * @author yanfangzhang
 *
 */
public class FieldInjectDemo {
	/**
	 * 将接口Service通过@Inject注解注入到FieldInjectDemo类中
	 * Service服务已经通过@ImplementedBy注解关联到ServiceImpl 类中
	 */
	@Inject
	private /*static*/ Service servcie;
	public Service getServcie() {
		return servcie;
	}


	public static void main(String[] args) {
//		FieldInjectDemo demo = Guice.createInjector().getInstance(FieldInjectDemo.class);
//		demo.getServcie().execute();
		
		/*问题（1）：可以自己构造FieldInjectDemo 对象而不通过Guice么？
		 * 解答：不可以，因为FieldInjectDemo不属于Guice容器（暂且称为容器吧）托管，
		 * 这样Service服务没有机会被注入到FieldInjectDemo类中
		 * */
//		 FieldInjectDemo fd = new FieldInjectDemo();
//	     fd.getServcie().execute();
		
		/*问题（2）：可以注入静态属性么？
		 * 解答：Guice还不支持静态字段注入。
		 * */
	}

}
