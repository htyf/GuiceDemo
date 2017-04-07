package web.interfaces.impl;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.inject.Inject;
import com.google.inject.servlet.RequestScoped;

import web.interfaces.HelloWorld;

@RequestScoped
public class HelloWorldImpl implements HelloWorld{
	private HttpServletRequest request;
	private HttpServletResponse response;

	@Inject
	public HelloWorldImpl(HttpServletRequest request,
			HttpServletResponse response) {
		super();
		this.request = request;
		this.response = response;
	}


	@Override
	public void execute() throws IOException {
		String name=request.getParameter("user");
		if(name==null||name.length()<1){
			name="Guest";
		}
		response.getWriter().append(String.format("Hello, %s. %s -> sessionId=%s,hashCode=%d \n", name,new Date(),request.getSession().getId(),hashCode()));


	}


}
