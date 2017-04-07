package learnGuice;


class FileStorage implements Storage{

	@Override
	public void store(String uniqueId, Data data) {
		System.out.println("file--->"+uniqueId+":"+data);
		
	}

	@Override
	public Data retrieve(String uniqueId) {
		
		return null;
	}

}
