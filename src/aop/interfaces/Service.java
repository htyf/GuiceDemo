package aop.interfaces;

import aop.interfaces.impl.ServiceImpl;

import com.google.inject.ImplementedBy;

@ImplementedBy(ServiceImpl.class)
public interface Service {
	void sayHello();
}
