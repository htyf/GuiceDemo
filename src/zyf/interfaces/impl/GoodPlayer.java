package zyf.interfaces.impl;

import javax.annotation.Generated;

import com.google.inject.Inject;

import zyf.interfaces.Player;

public class GoodPlayer implements Player{
	
	@Inject
	public GoodPlayer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void bat() {
        System.out.println("I can hit any ball");
    }

    public void bowl() {
        System.out.println("I can also bowl");
    }
}
