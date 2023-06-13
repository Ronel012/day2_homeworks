class main{

	public static void main(String args[]){
	
		Smartphone a = new Smartphone("1111", "Ubuntu");
		System.out.println(a.toString());
		
		a.addContact("Ronel", "09123451");
		a.displayContacts();
		
		
		//calling
		System.out.println("Calling...");
		a.call("1111");
		a.call("qwe");
		a.call("Ronel", "09123451");
		
		
	
	}
}
