package zyf.interfaces.impl;

import com.google.inject.Inject;

import zyf.interfaces.Player;

public class BadPlayer implements Player{

	@Inject
    public BadPlayer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void bat() {
        System.out.println("I think i can face the ball");
    }

    public void bowl() {
        System.out.println("I dont know bowling");
    }

}