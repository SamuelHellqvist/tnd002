package lab2;

import java.io.*;

public class Lab2 {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); //Global constant reader, works kinda like std::cin in c++
	public static void main(String[] args) throws IOException {
			
		Dictionary theDictionary = new Dictionary(); 
		File file;
		System.out.println("Type filename: ");
		
		int i = 0;
		do {
			file = new File(reader.readLine());
			System.out.println(file);
			i++;
			if(i == 3) {
				System.out.println("File not found");
				System.exit(0);
			}
			
		}while(file.exists()==false && i < 3);
		
		reader.close();
		
		String builder = new String();
		
		try {
			BufferedReader fileR = new BufferedReader(new FileReader(file));
			
			String str;
			
			while((str = fileR.readLine()) != null) {
				builder = builder + str;
				}
			
			fileR.close();
			
			builder.trim();
			
			//(" +") takes away all the empty spaces in the string
			String[] splitArray = builder.split(" +");
			
			for(int j = 0; j < splitArray.length; j++) {
				try{
					Integer.parseInt(splitArray[j]);
				}
				catch(NumberFormatException e){
					System.out.println(theDictionary.addString(splitArray[j]));
				}
			}
			
			theDictionary.toString();
			
			System.out.println(theDictionary);
			
			System.out.println(theDictionary.sortList(Word.BYCOUNTS));
			theDictionary.sortList(Word.BYCOUNTS);
			System.out.println(theDictionary);
			
			System.out.println(theDictionary.sortList(Word.BYNAME));
			theDictionary.sortList(Word.BYNAME);
			System.out.println(theDictionary);
			
			System.out.println(theDictionary.sortList(Word.ORIGINAL));
			theDictionary.sortList(Word.ORIGINAL);
			System.out.println(theDictionary);
			
			//writes to a file 
			File f2 = new File("result.txt");
			f2.createNewFile();
			BufferedWriter writeResult = new BufferedWriter(new FileWriter(f2, false));
			
			theDictionary.sortList(Word.ORIGINAL);
			
			int k = 0;
			
			try {
				writeResult.write(theDictionary.sortList(Word.ORIGINAL));
				while(theDictionary.returnWord(k) != "End") {
					System.out.println(theDictionary.returnWord(k));
					writeResult.write(theDictionary.returnWord(k)+ "\n");
					k = k + 1;
				}
			
			
			}
			catch(IOException e) {
				System.out.println("Error");
			}
			writeResult.flush();
			writeResult.close();
		}
		catch(IOException ex) {
			System.out.println("Problems when reading file ");
		}
		
	}

}