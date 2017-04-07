package zyf.moudles;

import zyf.interfaces.Add;
import zyf.interfaces.impl.SimpleAdd;

import com.google.inject.Binder;
import com.google.inject.Module;

public class AddModule implements Module{

	@Override
	public void configure(Binder binder) {
		/**
		 * 告诉 Guice 将 SimpleAdd 实现类绑定到 Add 接口上，
		 * 也就是说在客户端调用Add.add() 方法时，
		 * 实际会去执行 SimpleAdd.add() 方法
		 */
//		binder.bind(Add.class).to(SimpleAdd.class);
//		binder.bind(Add.class).toInstance(new SimpleAdd());;
	}

}
