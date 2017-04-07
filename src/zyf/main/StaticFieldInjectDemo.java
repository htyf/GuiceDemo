package zyf.main;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Module;

import zyf.interfaces.Service;

/**
 * 静态属性注入
 * @author yanfangzhang
 *
 */
public class StaticFieldInjectDemo {
    @Inject
    private static Service service;
    public static void main(String[] args) {
        Guice.createInjector(new Module() {
            @Override
            public void configure(Binder binder) {
            	/**
            	 * 实际上static字段（属性）是类相关的，
            	 * 因此我们需要请求静态注入服务。
            	 * 但是一个好处是在外面看起来我们的服务没有Guice绑定，
            	 * 甚至client不知道（或者不关心）服务的注入过程。
            	 */
                binder.requestStaticInjection(StaticFieldInjectDemo.class);
            }
        });
        StaticFieldInjectDemo.service.execute();
    }
}
