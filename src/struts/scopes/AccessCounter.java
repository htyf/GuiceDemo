package struts.scopes;

import java.util.concurrent.atomic.AtomicInteger;

import com.google.inject.servlet.SessionScoped;

/**
 * SessionScope级别的对象绑定访问次数。
 * @author yanfangzhang
 *
 */
@SessionScoped
public class AccessCounter {
	private AtomicInteger count = new AtomicInteger(0);
	 public int visit() {
		 return count.incrementAndGet();
	 }
	@Override
	public String toString() {
		return String.format("AccessCounter#%s:%d", this.hashCode(), count.get());
	}
	
}
