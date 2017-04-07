package zyf.interfaces.impl;

import zyf.interfaces.IAnimal;

public class Dog implements IAnimal {

	@Override
	public void run() {
		System.out.println("狗叫");

	}

	@Override
	public void eat() {
		System.out.println("狗狗吃东西");
	}

	@Override
	public void move() {
		System.out.println("狗狗走路");

	}

}
