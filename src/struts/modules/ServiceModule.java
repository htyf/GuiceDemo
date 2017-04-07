package struts.modules;

import struts.interfaces.Service;
import struts.interfaces.impl.ServiceImpl;

import com.google.inject.Binder;
import com.google.inject.Module;

public class ServiceModule implements Module {

	@Override
	public void configure(Binder binder) {
		// TODO Auto-generated method stub
		 binder.bind(Service.class).to(ServiceImpl.class);
	}

}
