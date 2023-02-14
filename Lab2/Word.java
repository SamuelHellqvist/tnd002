package lab2;

public class Word {
	public static int ORIGINAL = 0;
	public static int BYNAME = 1;
	public static int BYCOUNTS = 2;
	
	private static int sortCriterion = ORIGINAL;
	
	private String theWord;
	
	private int count = 0;
	
	public Word(String arg1, int arg2) {
		theWord = arg1;
		count = arg2;
	}
	
	public int getCount() {
		return count;
	}
	
	public String getWord() {
		return theWord;
	}
	
	public static void setCriterion(int arg) {
		sortCriterion = arg;
	}
	
	public static int getCriterion() {
		return sortCriterion;
	}
	
	public int compareTo(Word arg) {
		int v = 3;
		if(sortCriterion == ORIGINAL) {
			return 2;
		}
		else if (sortCriterion == BYNAME){
			//System.out.println(theWord.compareTo(arg.theWord));
			return theWord.compareTo(arg.theWord); //sort alphabetically
		}
		else if (sortCriterion == BYCOUNTS) {
			if (count < arg.count) {
				v = -1;
			}
			else if(count == arg.count) {
				v = 0;
			}
			else {
				v = 1;
			}
		}
		return v;
	}
	
	public String toString() {
		return String.format("Word: %10s   Count: %3d",getWord(), getCount());
	}
}