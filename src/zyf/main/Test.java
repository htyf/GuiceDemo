package zyf.main;

import zyf.interfaces.impl.Cat;
import zyf.interfaces.impl.Dog;
import zyf.moudles.AnimaiMoudle;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Test {

	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new AnimaiMoudle());
//		Dog dog = injector.getInstance(Dog.class);
//		dog.eat();
//		dog.move();
		Cat cat = injector.getInstance(Cat.class);
		cat.eat();
		cat.move();

	}

}
