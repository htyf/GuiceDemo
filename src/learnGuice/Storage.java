package learnGuice;


public interface Storage {
	public void store(String uniqueId, Data data);
	public Data retrieve(String uniqueId);
}
