package zyf.provider;

import zyf.interfaces.Service;
import zyf.interfaces.impl.WwwService;

import com.google.inject.Provider;

public class WwwServiceProvider implements Provider<Service>{

	@Override
	public Service get() {
		
		/**
		 * 每次调用都新建一个新的WwwService对象出来。
		 */
		return new WwwService();
	}

}
