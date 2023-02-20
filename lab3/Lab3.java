package lab3;

public class Lab3 {

	public static void main(String[] args) {
		
		Bank theBank = new Bank("Great Northern Bank");
		
		System.out.println("Testing createAccount");
		System.out.println(theBank.createAccount("Peter", 1000.0, 2000.0));
		System.out.println(theBank.createAccount("Peter", 1000.0, 2000.0));		
		System.out.println(theBank.createAccount("Sofia", 3000.0, 18000.0));		
		System.out.println(theBank.createAccount("Olga", 1000.0, 1000.0));
		System.out.println(theBank.createAccount("Alex", 1000.0));
		System.out.println(theBank);

		System.out.println();
				
		
		System.out.println("Testing the search function");
		System.out.println(theBank.checkPerson("Peter"));
		System.out.println(theBank.checkPerson("Sofia"));
		System.out.println(theBank.checkPerson("Olga"));
		System.out.println(theBank.checkPerson("Alex"));
		
		
		System.out.println("Testing the money transfer from current to savings account");
		theBank.currentToSavings("Peter",-1000);
		theBank.currentToSavings("Sofia", 2500);
		theBank.currentToSavings("Olga", 1500);
		theBank.currentToSavings("Alex", 1500);
		
		
		System.out.println(theBank.checkPerson("Peter"));
		System.out.println(theBank.checkPerson("Sofia"));
		System.out.println(theBank.checkPerson("Olga"));
		System.out.println(theBank.checkPerson("Alex"));
		
		System.out.println();
		System.out.println(theBank.checkPerson("Peter"));
		theBank.currentToSavings("Peter",5000);
		System.out.println(theBank.checkPerson("Peter"));
		
	}

}
