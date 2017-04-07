package learnGuice;


public class StorageClient {
	public static void main(String[] args) {
		 // Making use of file storage. 
        Storage storage = new FileStorage();
        storage.store("123", new Data("文件1","save some important information"));

        // Making use of the database.
        storage = new DatabaseStorage();
        storage.store("456", new Data("文件2","我是超人"));
	}

}
