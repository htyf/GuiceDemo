package aop.matchers;

import aop.interfaces.impl.ServiceImpl;

import com.google.inject.matcher.Matcher;

public class ServiceClassMatcher implements Matcher<Class<?>>{

	@Override
	public Matcher<Class<?>> and(Matcher<? super Class<?>> other) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean matches(Class<?> t) {
		// TODO Auto-generated method stub
		return t==ServiceImpl.class;//表示只匹配ServiceImpl类
	}

	@Override
	public Matcher<Class<?>> or(Matcher<? super Class<?>> other) {
		// TODO Auto-generated method stub
		return null;
	}

}
