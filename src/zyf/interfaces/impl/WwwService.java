package zyf.interfaces.impl;

import zyf.interfaces.Service;

public class WwwService implements Service {
    @Override
    public void execute() {
        System.out.println("www.imxylz.cn");
    }
}
