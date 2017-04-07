package aop.interfaces.impl;

import org.aopalliance.intercept.MethodInvocation;

import aop.interfaces.BeforeService;

public class BeforeServiceImpl  implements BeforeService {

	@Override
	public void before(MethodInvocation invocation) {
		System.out.println("before method "+invocation.getMethod().getName());
	}

}
