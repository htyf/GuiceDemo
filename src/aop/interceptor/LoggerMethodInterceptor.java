package aop.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
/**
 * 在aopalliance中定义拦截器
 * 自定义的方法拦截器，用于输出方法的执行时间（用纳秒描述）
 * 在MethodInvocation中我们一定要调用proceed()方法，这样我们的服务才能被执行。
 * 当然了如果为了做某些控制我们就能决定是否调用服务代码了
 * 
 * System.currentTimeMillis() 起始时间是基于 1970.1.1 0:00:00 这个确定的时间的，返回毫秒
 * System.nanoTime()是基于cpu核心的时钟周期来计时，它的开始时间是不确定的,返回纳秒。
 * @author yanfangzhang
 *
 */
public class LoggerMethodInterceptor implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		String methodName = invocation.getMethod().getName();
		long startTime = System.nanoTime();
		System.out.println(String.format("before method[%s] at %s", methodName,startTime));
		Object obj=null;
		try {
			obj = invocation.proceed();
		}finally{
			 long endTime=System.nanoTime();
			 System.out.println(String.format(" after method[%s] at %s, cost(ns):%d", methodName, endTime,(endTime-startTime)));
		}
		return obj;
	}

}
