package web.interfaces;

import java.io.IOException;

import web.interfaces.impl.HelloWorldImpl;

import com.google.inject.ImplementedBy;

@ImplementedBy(HelloWorldImpl.class)
public interface HelloWorld {
	void execute() throws IOException;
}
