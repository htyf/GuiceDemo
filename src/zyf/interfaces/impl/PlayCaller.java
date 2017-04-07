package zyf.interfaces.impl;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class PlayCaller {
	@Inject
	@Named("Good")
	private GoodPlayer good;
	@Inject
	@Named("Bad")
	private BadPlayer bad;
	
	public void bat(){
		good.bat();
	};
    public void bowl(){
    	good.bowl();
    };

}
