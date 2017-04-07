package zyf.interfaces.impl;

import zyf.interfaces.IAnimal;

public class Cat implements IAnimal{

	@Override
	public void run() {
		System.out.println("猫跑");
	}

	@Override
	public void eat() {
		System.out.println("猫吃东西");
		
	}

	@Override
	public void move() {
		System.out.println("猫动");
		
	}

}
