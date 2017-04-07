package zyf.main;

import com.google.inject.Guice;
import com.google.inject.Inject;

/**
 * setter注入
 */
import zyf.interfaces.Service;

public class SetterInjectDemo {
    private Service service;
    @Inject
    public void setService(Service service) {
        this.service = service;
    }
    public Service getService() {
        return service;
    }
    public static void main(String[] args) {
        SetterInjectDemo sid = Guice.createInjector().getInstance(SetterInjectDemo.class);
        sid.getService().execute();
        
        SetterInjectDemo sijd = new SetterInjectDemo();
        Guice.createInjector().injectMembers(sijd);
        sijd.getService().execute();
        
    }
}

