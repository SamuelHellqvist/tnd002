package lab6;
import java.util.*;
import java.io.*;

public class PhoneBook {

	//Variables
	private ArrayList<Person> listOfNumbers;
	
	
	//Constructor
	public PhoneBook() {
		listOfNumbers = new ArrayList<Person>();
	}
	
	
	//Methods
	public String load(String arg) {								//Method to read in a file
		
		String A;
		listOfNumbers.clear();										//We empty our phonebook so we can create a new one
		File file = new File(arg);
		
		if(!file.exists()) {										//If the file does not exist we return that information
			return "File not found";
		}
		
		try {														//We have a try-catch to catch errors when reading in the file
			
			BufferedReader fileReader = new BufferedReader(new FileReader(file));	//We creater a reader, it reads off our file
			
			String line;											 
			
			while ((line = fileReader.readLine()) != null) {     		//Each time we can read a line in the file, that becomes our string line
				String[] personInfo = line.split(" +");					//We have a string array because we want to create two strings that are conected
				Person adding = new Person(personInfo[0], personInfo[1], //adding is a new instance of Person with name,surname and phonenumber
						Integer.valueOf(personInfo[2]));
				listOfNumbers.add(adding);								//We add the new instance to our list(which was emptied earlier)
				
		        }
			fileReader.close();											//We close the reader
			A = "Phonebook loaded";										//We have an output in our string
			
		}catch(IOException e) {											//We catch the exceptions
			return("Try again");										//If we were to catch an exception we have a different output to the string
		}
		
		return A;														//We always return a String
	}
	
	public ArrayList<Person> search(String arg){						//Searchs through our list if there is an instance with the name or number you're looking for
		ArrayList<Person>searchResult = new ArrayList<Person>();
		int number;
		
		try {															//If the try works, the person has enetered numbers
			number = Integer.parseInt(arg);								//We make the phone number into a string
		}
		catch (NumberFormatException e) {								//If it's not a number we catch it and put number to -1
			number = -1;
		}
		
		if(number == -1) { 												//If it's not a number aka -1, it is a name
		
			for(int i = 0; i < listOfNumbers.size(); ++i) {				//We go through our list, if we have a match between the surname and arg we add it to a new list
				if(listOfNumbers.get(i).getSurname().equals(arg)) {
					searchResult.add(listOfNumbers.get(i));
				}
				
			}
		}
		else {															//Same thing but when we get a number input
			for(int i = 0; i < listOfNumbers.size(); ++i) {				//Are only added once, they are unique
				if(listOfNumbers.get(i).getPhoneNumber() == number) {
					searchResult.add(listOfNumbers.get(i));
				}
			}
		}
		
		return searchResult;											//We send back the list of search result
	}
	
	public String deletePerson(String arg1, int arg2) {
	
		for (int i = 0; i < listOfNumbers.size(); ++i) {
			if(listOfNumbers.get(i).getPhoneNumber() == arg2 || listOfNumbers.get(i).getSurname().equals(arg1)) {
				listOfNumbers.remove(i);
				return "Person deleted";
			}
		}
		return "The person/number does not exist";
	}
	
	public boolean addPerson(String arg1, int arg2) {
		String[] numberOfWords = arg1.split(" +");
		
		int checker = 0;
		
		for(int i = 0; i < listOfNumbers.size(); ++i) {
			if(arg2 == listOfNumbers.get(i).getPhoneNumber()) {
				checker = -1;
			}
			else {
				checker = 1;
			}
		}
		if(numberOfWords.length != 2 || checker == -1) {
			return false;
		}
		else {
			Person adding = new Person(numberOfWords[0], numberOfWords[1], arg2);
			listOfNumbers.add(adding);
			return true;
		}
	}
	
	
	public String Save(String arg) {
		try {
			BufferedWriter fileWriter = new BufferedWriter(new FileWriter(new File(arg)));
			for(int i =0; i < listOfNumbers.size(); ++i) {
				fileWriter.write(String.format("%20s %5d\n",listOfNumbers.get(i).getFullname()
						, listOfNumbers.get(i).getPhoneNumber()));
			}
			fileWriter.close();
			return("Saved" + listOfNumbers.size() + "people to the file");
		}catch(IOException e) {
			return("Could not save to the file");
		}
	}
}
