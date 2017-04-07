package aop.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import com.google.inject.Inject;

import aop.interfaces.BeforeService;


public class AfterMethodInterceptor implements MethodInterceptor{
	@Inject
	private BeforeService beforeService;

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		beforeService.before(invocation);
		Object ret = null;
		try {
			ret = invocation.proceed();
		} finally{
			System.out.println("after "+invocation.getMethod().getName());
		}
		return ret;
	}


}
