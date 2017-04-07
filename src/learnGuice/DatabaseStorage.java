package learnGuice;


public class DatabaseStorage implements Storage{

	@Override
	public void store(String uniqueId, Data data) {
		System.out.println("database--->"+uniqueId+":"+data);
		
	}

	@Override
	public Data retrieve(String uniqueId) {
		// TODO Auto-generated method stub
		return null;
	}

}
