package web.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.interfaces.HelloWorld;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;
/**
 * 根据Guice的Servlet要求，每一个Servlet必须是单例的，因此这里强制加上@Singleton。
 * @author yanfangzhang
 *
 */
@Singleton
public class HelloWorldServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	/**
	 * 自动注入Injector对象，然后通过Inject对象获取我们的服务，
	 * 注意我们没有将HttpServletRequest和HttpServletResponse手动注入到我们的服务中。
	 */
	@Inject
	private Injector inj;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		resp.getWriter().append("Hello, guice! "+new Date());
		inj.getInstance(HelloWorld.class).execute();
		inj.getInstance(HelloWorld.class).execute();
	}

}
