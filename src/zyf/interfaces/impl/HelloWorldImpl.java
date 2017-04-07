package zyf.interfaces.impl;

import zyf.interfaces.HelloWorld;

public class HelloWorldImpl implements HelloWorld {
    @Override
    public String sayHello() {
        return "Hello, world!";
    }
}
