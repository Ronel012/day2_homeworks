package two;

import java.util.Map;
import java.util.HashMap;

public class Smartphone extends Telephone{
	private String phoneNo;
	private String operatingSystem;
	private Map<String, String> contacts = new HashMap<>();
	
	public Smartphone(String phoneNo, String operatingSystem){
		this.phoneNo = phoneNo;
		this.operatingSystem = operatingSystem;
	}
	
	
	//adding contact
	public void addContact(String name, String phoneNo){
		contacts.put(name, phoneNo);
	}
	
	//removing contact
	public void removeContact(String name){
		contacts.remove(name);
	}
	
	
	//calling phone number
	//check the caller
	public void call(String phoneNo){
		if (!this.phoneNo.equals(phoneNo)){
			super.call(phoneNo);
		} else {
			System.out.println("You cannot call yourself!");
		}
		
	}
	
	
	//overload call method
	//calling the phone number
	public void call(String name, String phoneNo){
	
		//check if already exists the name in contacts
		if(this.contacts.containsKey(name)){	
			System.out.println("Calling from contacts");
			call(phoneNo);
		}
	}
	
	
	//display contact
	public void displayContacts(){
		System.out.println("\nYour contacts: ");
		contacts.forEach((name, phoneNo) -> System.out.println(name + " " + phoneNo));
		
	}
	
	
	//display smartphone
	public void displaySmartPhone(){
		System.out.println("Your smarthphone is here: ");
		System.out.println("Your phone number: " + this.phoneNo);
		System.out.println("Your phone OS: " + this.operatingSystem);
	
	}
	
}
