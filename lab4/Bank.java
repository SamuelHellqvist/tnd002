package lab4;
import java.util.ArrayList;
public class Bank {

	public final String NAME; //constant will not change
	private ArrayList<Account> theAccounts = new ArrayList<Account>();
	private ArrayList<Loan> theLoans = new ArrayList<Loan>();//New for lab4
	//Stores all the loans handled by the bank, dynamic array
	
	//constructor
	public Bank(String arg) {
		NAME = arg;
		Account.setBank(this);//Gets a chosen bank
	}
	//method that search through all the accounts and see if the arg matches with an account NAME
	//if not, return null
	public CurrentAccount searchAccounts(String arg) {
		for(int i = 0; i < theAccounts.size(); ++i) {
			if(theAccounts.get(i).getCostumer().equals(arg)) {
				return (CurrentAccount) theAccounts.get(i);
			}
		}
		return null;
	}
	//if we search through the accounts and can't find an account we create one for that NAME
	public String createAccount(String arg1, double arg2, double arg3) {
		
		if(searchAccounts(arg1) == null) {
			
			CurrentAccount newAccount = new CurrentAccount(arg1, arg2, arg3);
			theAccounts.add(newAccount);//adds current to the account list
			theAccounts.add(newAccount.otherAccount); //adds savins to the account list
			return "Current and savings account created for " + arg1;
			
		}
		
		else {
			return "Account(s) already exists for " + arg1;
			//if there already is an account we say so
		}
		
	}
	//the same method as the one above but without creating a savings account
	public String createAccount(String arg1, double arg2) {
		if(searchAccounts(arg1)== null) {
			CurrentAccount newAccount = new CurrentAccount(arg1, arg2);
			theAccounts.add(newAccount);
			return "Current account created for " + arg1;
			
		}
		
		else {
			return "Account already exists for " + arg1;
		}
	}
	
	//transfers the money between current and savings depending on the argument
	public void currentToSavings(String arg1, double arg2) {
		CurrentAccount personalSavings = searchAccounts(arg1);
		personalSavings.savings(arg2);
		
	}
	
	
	//We check if a person has an account at the bank, if they do we write out their information
	public String checkPerson(String arg) {
		String out = arg + "\n";
		CurrentAccount info = searchAccounts(arg);
		
		if(info == null) {
			out = "Person does not exist";
		}
		
		else {
			out += info.toString();
			if(info.otherAccount != null) {
				out += info.otherAccount.toString();
			}
			//New for lab4
			for (Loan e : theLoans) { //We go throung the array theLoans
				if(e.otherAccount == info) { //if an element in the array belongs to the person, we add their loan to the string
					out += e.toString();
				}
			}
		}
		return out;
	}
	//Transfer the amount arg3 from the account arg1 to the account arg2
	public void transfer(String arg1, String arg2, double arg3) {
		CurrentAccount sender = searchAccounts(arg1);
		CurrentAccount reciever = searchAccounts(arg2);
		
		if(sender != null && reciever !=null) { //If both people have an account
			sender.send(arg3, reciever); //We send the arg3 from arg1 to arg2
			//send method handles receive method so we do not need to use it here
		}
	}
	//Creates an instance of Loan and add it to the array theLoans
	public void getLoan(CurrentAccount arg) {
		theLoans.add(new Loan(arg));
		//The rest is handled by the constructor in Account
	}
	
	public void cashPayment(String arg1, double arg2) {
		CurrentAccount theAccount = searchAccounts(arg1);
		//A person, arg1, can pay off loans using the amount arg2
		
		//We go through theLoans
		for (int i = 0; i < theLoans.size(); i++) {
			if(theLoans.get(i).otherAccount == theAccount) {//if the person has a loan
				if (arg2 > 0) {// & if the money is above zero we can pay off the loan
					arg2 = theLoans.get(i).payOff(arg2);
					if(arg2 >= 0) {//& if the money is more or equal to zero we remove the loan and it is paid of completely
						theLoans.remove(i); 
						i--;
					}
				}
			}
		}
		if (arg2 > 0) {//If the money is above zero
			theAccount.recieve("Cash Payment", arg2);//We use the receive function to add it back to the current account
		}
	}
	//We go through both theAccounts and theLoans
	public void computeAnnualChange() {
		for(int i = 0; i < theAccounts.size(); i++) {
			theAccounts.get(i).annualChange(); //Changing the balance in the accounts
			
		}
		for(int i = 0; i < theLoans.size(); i++) {
			theLoans.get(i).annualChange();//Changing the balance in the loans
			
		}
	}
	
	//We write out the Bank, how many accounts there is in total and how much money there is
	//in current/saving accounts
	//Updated for lab4
	public String toString() {
		String out = "Bank: " + NAME + "\n";
		out = out + "Accounts: " + theAccounts.size() + "\n";
		out = out + "Loans: " + theLoans.size() + "\n"; //We add the output of all loans
		
		
		double sumMainMoney = 0;
		double sumSavings = 0;
		double sumLoans = 0; //We add the sum of all loans
		for(int i = 0; i <  theAccounts.size(); ++i) {
			if(theAccounts.get(i)instanceof CurrentAccount) {
				sumMainMoney = sumMainMoney + theAccounts.get(i).getBalance();
			}
			
			if((theAccounts.get(i).otherAccount != null) && (theAccounts.get(i).otherAccount instanceof SavingsAccount)) {
				sumSavings = sumSavings + theAccounts.get(i).otherAccount.getBalance();
			}
		}
		//Go through thLoans and add all loans together in sumLoans
		for (int j = 0; j < theLoans.size(); ++j) {
			sumLoans = sumLoans + theLoans.get(j).getBalance();
		}
		out = out + "Money in current / savings accounts and debt: " + sumMainMoney + " / " + sumSavings + " / " + sumLoans;
		
		return out;
	}
}
