package learnGuice;

public class Data {
	private String name;
	private String content;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Data(String name, String content) {
		super();
		this.name = name;
		this.content = content;
	}
	public Data() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Data [name=" + name + ", content=" + content + "]";
	}
	
	

}
