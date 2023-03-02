package lab5;

import java.util.*;
import javax.swing.JOptionPane; //Library for swing methods


public class EstateAgent {

	//VARIABLES
	
	public final static int ALLBUILDINGS = 1;
	public final static int CITYBUILDINGS = 2;
	public final static int COTTAGES = 3;
	public final String NAME;
	private ArrayList<Building> theBuildings = new ArrayList<Building>();
	private ArrayList<CityProperty> theCityBuildings = new ArrayList<CityProperty>();
	private ArrayList<Cottage> theCottages = new ArrayList<Cottage>();
	
	//CONSTRUCTOR
	
	public EstateAgent(String arg) {
		NAME = arg;
	}
	
	//METHODS
	
	public String addBuilding(Building arg) {
		theBuildings.add(arg);
		if(arg instanceof Cottage) {
			theCottages.add((Cottage)arg);										//**pin** why '(Cottage)'
			String output = "Added cottage";
			return output;
		}else {
			theCityBuildings.add((CityProperty) arg);
			String output = "Added city building";
			return output;
		}	
	}
	
	public String sort(int arg) {
		String input = JOptionPane.showInputDialog("Write 1 or 2"); 			//Pop-up window
		int sortNumber = Integer.parseInt(input);								//Makes the string an int
		if(sortNumber == 1 || sortNumber == 2) {
			Building.selection = sortNumber; 									//We sort it after squaremeter or price
			if(arg == ALLBUILDINGS) {
				Collections.sort(theBuildings);									//**what does collection do?** //We sort theBuildings 
				updateList();
			}
			else if(arg == COTTAGES) {
				Collections.sort(theCottages);									//We sort the arraylist theCottage
				updateList(COTTAGES);
			}
			else if(arg == CITYBUILDINGS) {
				ArrayList<Building> buildingList = new ArrayList<Building>(); 
				for(int i = 0; i < theCityBuildings.size(); ++i) {
					buildingList.add((Building) theCityBuildings.get(i)); 		//Deep copy, 
																				//(Building) makes it so we use the elements not the interface
				}
				Collections.sort(buildingList); 								//Now we can sort the list, bc it has the elements!
				theCityBuildings.clear(); 										//Empty the old arraylist
				
				for(int j = 0; j < buildingList.size(); ++j) { 					//We add the sorted elements to the original arraylist
					theCityBuildings.add((CityProperty) buildingList.get(j));
				}
				
				updateList(CITYBUILDINGS);
			}
			if(sortNumber == 1) {												//If selection is 1 or 2 we go through out ifs and for loops and we return the right output
				return "Sorted by price";
			}
			else {
				return "Sorted by area";
			}
		}
		else {																	//If selection is not 1 or 2 we send out error message
			return  "Invalid input.";
		}
	}
	
	public void updateList() {													//If we sort one list, we sort all others based on the first list
		Collections.sort(theCottages);											//We don't need to sort theBuildings because we choose that as an option in our sort

		ArrayList<Building> sortedCityBuilding = new ArrayList<Building>();		//We need a new array to save the elements, not the interfaces
		for(int i = 0; i < theCityBuildings.size(); ++i) {						//We go through the arraylist of instaces
			sortedCityBuilding.add((Building) theCityBuildings.get(i));			//We add the elements of theCityBuildings, sorted as Buildings, into our new array
		}
		theCityBuildings.clear();												//We need to empty the old array
		Collections.sort(sortedCityBuilding);									//We sort the new array
		
		for(int j = 0; j < sortedCityBuilding.size(); ++j) {					//We add the elements from our new array to the old, emptied array
			theCityBuildings.add((CityProperty) sortedCityBuilding.get(j));     //Why '(CityProperty)'
		}	
	}
	
	public void updateList(int arg) {											//We only want to sort a specific list
		if (arg == COTTAGES) {
			int counter = 0;
			for(int i= 0; i < theBuildings.size();++i) {
				if(theBuildings.get(i) instanceof Cottage) {
					theBuildings.set(i, theCottages.get(counter));				//set changes the order in allbuildings to match the one in theCottages
					++counter;													//Get counter helps us with the index of the sorted cottage-list
				}
			}
		}
		else {
			int counter = 0;
			for(int i= 0; i < theBuildings.size();++i) {						//We do the same procedure for citybuildings
				if(theBuildings.get(i) instanceof CityProperty) {
					theBuildings.set(i,(Building)theCityBuildings.get(counter)); //(Building) needs to be there because of the interface
					++counter;
				}
			}
		}
	}
	
	public String toString() {
		String B = "";
		String C = "";
		String D = "";
		for (int i = 0; i < theBuildings.size(); ++i) {
			B += theBuildings.get(i).toString()+"\n";
		}
		for (int j = 0; j < theCottages.size(); ++j) {
			C += theCottages.get(j).toString()+"\n";
		}
		
		for(int k = 0; k < theCityBuildings.size(); ++k) {
			D += theCityBuildings.get(k).toString()+"\n";
		}
		String estate = String.format("Estate agent:  %16s\nAll buildings: \n%16s\nCottages: \n%16s,\nVillas and apartements: \n%16s", NAME, B, C, D);
		return estate;
	}
}
