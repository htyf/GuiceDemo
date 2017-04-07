package zyf.moudles;

import zyf.annotations.Bad;
import zyf.annotations.Good;
import zyf.interfaces.Player;
import zyf.interfaces.impl.BadPlayer;
import zyf.interfaces.impl.GoodPlayer;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.name.Names;

public class PlayerModule implements Module{

	public void configure(Binder binder) {
//		binder.bind(Player.class).annotatedWith(Names.named("Good")).to(GoodPlayer.class);
//		binder.bind(Player.class).annotatedWith(Names.named("Bad")).to(BadPlayer.class);        
		binder.bind(Player.class).annotatedWith(Good.class).to(GoodPlayer.class);
		binder.bind(Player.class).annotatedWith(Bad.class).to(BadPlayer.class);        
	}
}
