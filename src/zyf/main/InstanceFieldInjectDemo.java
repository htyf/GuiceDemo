package zyf.main;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Module;

import zyf.interfaces.Service;

/**
 * 注入实例变量的属性
 * @author yanfangzhang
 *
 */
public class InstanceFieldInjectDemo {
    @Inject
    private Service service;
    public static void main(String[] args) {
    	/*第一种方式：使用module*/
       final InstanceFieldInjectDemo ifid = new InstanceFieldInjectDemo();
        Guice.createInjector(new Module() {
            @Override
            public void configure(Binder binder) {
                binder.requestInjection(ifid);
            }
        });
        ifid.service.execute();
        
        /*第二种方式：不使用moudle  此方法也支持Setter注入。*/
    	InstanceFieldInjectDemo ifi = new InstanceFieldInjectDemo();
        Guice.createInjector().injectMembers(ifi);
        ifi.service.execute();
    }
}
