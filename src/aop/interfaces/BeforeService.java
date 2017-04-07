package aop.interfaces;

import org.aopalliance.intercept.MethodInvocation;

import com.google.inject.ImplementedBy;

import aop.interfaces.impl.BeforeServiceImpl;

@ImplementedBy(BeforeServiceImpl.class)
public interface BeforeService {

	void before(MethodInvocation invocation);
}

