package struts.actions;

import com.google.inject.Inject;

import struts.interfaces.Service;
import struts.scopes.AccessCounter;

public class AccessStatusAction {
	AccessCounter counter;
	Service service;
	String message;
	@Inject
	public AccessStatusAction(AccessCounter counter, Service service) {
		super();
		this.counter = counter;
		this.service = service;
	}

	public String execute() {
		return "success";
	}

	public int getCount() {
		return counter.visit();
	}

	public String getStatus() {
		return service.getStatus();
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
