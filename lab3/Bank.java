package lab3;
import java.util.ArrayList;
public class Bank {

	public final String NAME; //constant will not change
	private ArrayList<Account> theAccounts = new ArrayList<Account>();
	
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
			if((info.otherAccount != null) && (info.otherAccount instanceof SavingsAccount)) {
				Account savinginfo = info.getSavingAccount();
				out = out + savinginfo.toString();
				}
			out = out + info.toString();
		}
		return out;
		}
	
	//We write out the Bank, how many accounts there is in total and how much money there is
	//in current/saving accounts
	public String toString() {
		String out = "Bank: " + NAME + "\n";
		out = out + "Accounts: " + theAccounts.size() + "\n";
		
		double sumMainMoney = 0;
		double sumSavings = 0;
		for(int i = 0; i <  theAccounts.size(); ++i) {
			if(theAccounts.get(i)instanceof CurrentAccount) {
				sumMainMoney = sumMainMoney + theAccounts.get(i).getBalance();
			}
			
			if((theAccounts.get(i).otherAccount != null) && (theAccounts.get(i).otherAccount instanceof SavingsAccount)) {
				sumSavings = sumSavings + theAccounts.get(i).otherAccount.getBalance();
			}
		}
		out = out + "Money in current / savings accounts: " + sumMainMoney + "/" + sumSavings;
		
		return out;
	}
}
