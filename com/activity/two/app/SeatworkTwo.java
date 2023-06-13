package two.app;

import two.Telephone;
import two.Phone;
import two.Smartphone;



public class SeatworkTwo{

	public static void main(String args[]){
		Telephone telephone = new Telephone();
		
		//for telephone
		System.out.println("From telephone object:");
		telephone.call("111111");
		telephone.call("ronel");
		
		//from smartphone
		System.out.println("\nFrom smartphone object:");
		Smartphone smartphone1 = new Smartphone("09156138510", "Android");
		smartphone1.displaySmartPhone();
		
		//adding contacts using smartphone object
		smartphone1.addContact("Adobo", "222222222");
		smartphone1.addContact("Sinigang", "3333333");
		smartphone1.addContact("Nilagang baboy", "444444");
		smartphone1.addContact("Chicken curry", "555555");
		smartphone1.addContact("mang inasal", "666666");
		
		//display all contacts
		smartphone1.displayContacts();
		
		//remove 1 contact
		smartphone1.removeContact("mang inasal");
		
		//call a phonenumber
		System.out.println("\nCalling a number: ");
		smartphone1.call("09123");
		
		smartphone1.call("3333333");
	
	}
}
