package lab6;

public class Person {

	
	//Variables
	private String givenName;
	private String surname;
	private int phoneNumber;
	
	
	//Constructor
	public Person(String arg1, String arg2, int arg3) {
		givenName = arg1;
		surname = arg2;
		phoneNumber = arg3;
	}
	
	
	//Methods
	public String getSurname() {
		return surname;
	}
	
	public String getFullname() {
		return givenName + " " + surname;
	}
	
	public int getPhoneNumber() {
		return phoneNumber;
	}
}
