package lab2;

import java.util.*;

public class Dictionary {

	public ArrayList<Word> theList = new ArrayList<Word>();
	private ArrayList<Word> backup = null;
	
	
	
	public String addString(String arg) {
		String output="";
		
		for(int i = 0; i < theList.size(); ++i) {
			if(theList.get(i).getWord().equals(arg)) {
				//System.out.println("i am in the if :)");
				theList.set(i, new Word(arg, theList.get(i).getCount()+1));
				return theList.get(i).toString();
			}
		}
		Word addedWord = new Word(arg, 1);
		theList.add(addedWord);
		output = addedWord.toString();
		return output;
	}
	
	
	
	public String sortList(int arg) {
		String a = ""; //Creates empty string
		if(backup == null) {//Checks to see if it is the first time we use backup
			backup = new ArrayList<Word>(); //**NOTE** GLOBAL VARIABEL **NOTE**
			System.out.println(theList.size());
			for(int i = 0; i < theList.size(); i++) {
				 //Creates deep copy
				backup.add(new Word(theList.get(i).getWord(), theList.get(i).getCount()));
			}
		}
		
		else {
			if (arg == Word.ORIGINAL) { //if the argument is equal to ORIGINAL we create shallow copy
				theList = backup;
				Word.setCriterion(Word.ORIGINAL);
				return "Word list was reset";
			}
			else{ //Otherwise we set the Criterion to arg
				Word.setCriterion(arg);
				Word temp; //Creates new word
				for(int i = 0; i < theList.size(); ++i) { //Goes into a nested for loop to compare two neighbours
					for(int k = i+1; k < theList.size(); ++k){
						if(theList.get(k).compareTo(theList.get(i)) == 1 || theList.get(k).compareTo(theList.get(i)) > 1) {//Swaps elements if one is bigger
							temp = theList.get(i);
							theList.set(i,theList.get(k));
							theList.set(k, temp);
						}
					}	
				}
		}
		
		
		
			if(arg == Word.BYNAME) { //Fills our empty string with the right output depending on the arg
				a = "Sorted alphabetically";
			}
			else {
				a = "Sorted by counts";
			}
		}//returns our string with the right output
		return a;	
	}
	
	
	
	public String returnWord(int arg) {
		String end = "End"; //Creating String
		if(arg >= theList.size()) { //Returning string if the arg is larger than the size of the array theList
			return end;
		}
		else { //Else we return the value of the method toString
			return theList.get(arg).toString();
		}
	}
	
	
	
	public String toString() {
		String content = ("Content:  \n");
		for (int i = 0; i < theList.size(); ++i) {
			content = content + theList.get(i).toString()+"\n";
		}
		return content;
	}
	
	
}
