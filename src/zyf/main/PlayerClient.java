package zyf.main;

import java.util.Map;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

import zyf.annotations.Bad;
import zyf.annotations.Good;
import zyf.interfaces.Player;
import zyf.moudles.PlayerModule;

public class PlayerClient {
	@Inject
	@Good
	private Player goodPlayer ;
	
	@Inject
	@Bad
	private Player badPlayer;
	
	public static void main(String[] args) {

//		Injector injector = Guice.createInjector(new Module[]{new PlayerModule()});
		Injector injector = Guice.createInjector(new PlayerModule());
		PlayerClient client = injector.getInstance(PlayerClient.class);
		client.goodPlayer.bat();
		client.goodPlayer.bowl();
		client.badPlayer.bat();
		client.badPlayer.bowl();
	}
}
