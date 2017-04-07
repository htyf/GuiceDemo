package zyf.model;

import com.google.inject.Inject;

public class Person {

    private Mobile mobile;
    private Laptop laptop;

    /**
     * 使用 @Inject 注释来直接引用 Laptop 和 Mobile 对象。
     * 注意我们这儿使用的是构造方法层次上的注入。
     * @param mobile
     * @param laptop
     */
    @Inject
    public Person(Mobile mobile, Laptop laptop){
        this.mobile = mobile;
        this.laptop = laptop;
    }

    public void diplayInfo(){
        System.out.println("Mobile:" + mobile);
        System.out.println("Laptop:" + laptop);
    }
}
