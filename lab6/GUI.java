package lab6;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class GUI extends JFrame implements ActionListener{
	
	//Creating a PhoneBook that we can use in this class
	PhoneBook myPhoneBook = new PhoneBook();
	
	//Creating a new list and a new integer that will be used later
	ArrayList<Person> myArray = new ArrayList<Person>();
	int personCounter = 0;

	//Creating buttons
	JButton btnLoad;
	JButton btnSave;
	JButton btnSearch;
	JButton btnNext;
	JButton btnAdd;
	JButton btnDelete;
	
	//Creating text fields
	JTextField searchField;
	JTextField nameField;
	JTextField numberField;
	
	//Creating panels
	JPanel rightPanel;
	JPanel leftPanel;
	
	
	public GUI(){		
		setTitle("Interactive phonebook");
		
		Font myFont = new Font("SansSerif", Font.PLAIN, 20);
		
		//Declaring buttons
		btnLoad = new JButton("Load phonebook");
		btnLoad.setFont(myFont);
		btnLoad.addActionListener(this);
		
		btnSave = new JButton("Save phonebook");
		btnSave.setFont(myFont);
		btnSave.addActionListener(this);
		btnSave.setEnabled(false);
		
		btnSearch = new JButton("Search");
		btnSearch.setFont(myFont);
		btnSearch.addActionListener(this);
		btnSearch.setEnabled(false);
		
		btnNext = new JButton("Next name");
		btnNext.setFont(myFont);
		btnNext.addActionListener(this);
		btnNext.setEnabled(false);
		
		btnAdd = new JButton("Add person");
		btnAdd.setFont(myFont);
		btnAdd.addActionListener(this);
		btnAdd.setEnabled(false);
		
		btnDelete = new JButton("Delete person");
		btnDelete.setFont(myFont);
		btnDelete.addActionListener(this);
		btnDelete.setEnabled(false);
		
		//Declaring text fields
		searchField = new JTextField();
		searchField.setFont(myFont);
		searchField.addActionListener(this);
		
		nameField = new JTextField();
		nameField.setFont(myFont);
		nameField.setEditable(false);
		
		numberField = new JTextField();
		numberField.setFont(myFont);
		numberField.setEditable(false);
		
		//Declaring the right panel
		leftPanel = new JPanel(new GridLayout(3, 2));
		
		//Adding the buttons to the right panel
		leftPanel.add(btnLoad);
		leftPanel.add(btnLoad);
		leftPanel.add(btnSave);
		leftPanel.add(btnSearch);
		leftPanel.add(btnNext);
		leftPanel.add(btnAdd);
		leftPanel.add(btnDelete);
		
		//Declaring the left panel
		rightPanel = new JPanel(new GridLayout(3, 1));
		
		//Adding the text fields to the left panel
		rightPanel.add(searchField);
		rightPanel.add(nameField);
		rightPanel.add(numberField);
		
		
		//Declaring the container as app (as in application)
		//We need to get the content pane to add things to it
		Container app = getContentPane();
		
		//setting the layout of app
		app.setLayout(new GridLayout(1, 2));
		
		//adding the panels to the app
		app.add(leftPanel);
		app.add(rightPanel);
		
		//pack makes the window be as big as it need to be for everything to fit
		pack(); 
		
		//setting the visibility to true so we can see the window
		setVisible(true); 
		
		//Makes it so we can press the x to exit the GUI
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	//Giving functions to the applications elements using an actionPerformed class
	public void actionPerformed(ActionEvent ae) {
		//load button
		if(ae.getSource() == btnLoad || ae.getSource() == searchField) { 	//If we pressed load or enter
			String userInput = searchField.getText(); 						// We read in the text in the searchField
			String loadResult = myPhoneBook.load(userInput);				//We call the function load and use the string we've read as the input argument
			searchField.setText("");										//We empty searchField 
			nameField.setText(loadResult);									//We put the output from our function load into nameField
			
			if(loadResult == "Phonebook loaded") {							//If the phone book is loaded, we enable all buttons except next
				btnSave.setEnabled(true);
				btnSearch.setEnabled(true);
				btnAdd.setEnabled(true);
				btnDelete.setEnabled(true);
			}
		}
		
		if(ae.getSource() == btnSearch) {									//If we press search
			String searchInput = searchField.getText();						//We read in the string in searchField
			searchField.setText("");										//We empty the searchField 
			myArray = myPhoneBook.search(searchInput);								//We call the search function and use the string from searchField as an input argument
			if(myArray.size() == 0) {
				nameField.setText("Provide a name");
				numberField.setText("");
			}
			else if(myArray.size() == 1) {
				
				
				nameField.setText(myArray.get(0).getFullname());
				String phoneNumber = Integer.toString(myArray.get(0).getPhoneNumber());
				numberField.setText(phoneNumber);
			}
			else {
				
				btnNext.setEnabled(true);
				personCounter = 0;
				nameField.setText(myArray.get(personCounter).getFullname());
				String phoneNumber = Integer.toString(myArray.get(personCounter).getPhoneNumber());
				numberField.setText(phoneNumber);
			}
		}
		
		
		//shows the next person if there is two or more with the same surname
		if(ae.getSource() == btnNext) {
			personCounter++;
			nameField.setText(myArray.get(personCounter).getFullname());
			String phoneNumber = Integer.toString(myArray.get(personCounter).getPhoneNumber());
			numberField.setText(phoneNumber);
			
			if(personCounter == myArray.size() - 1) {
				btnNext.setEnabled(false);
				personCounter = 0;
			}
		}
		
		//deletes the current person
		if(ae.getSource() == btnDelete) {
			String state = myPhoneBook.deletePerson(nameField.getText(), Integer.parseInt(numberField.getText()));
			myArray.remove(personCounter);
			searchField.setText(state);
			personCounter--;
		}
		
		//Creates a new file in the directory with all the persons in the phone book
		if(ae.getSource() == btnSave) {
			String saveInput = searchField.getText();
			
				nameField.setText(myPhoneBook.Save(saveInput));
				myPhoneBook.Save(saveInput);
		}
		
		//adds a person to the phone book
		if(ae.getSource() == btnAdd) {
			if(!nameField.isEditable() && !numberField.isEditable()) {
				nameField.setText("");
				numberField.setText("");
				searchField.setText("Type in name and phone number");
				nameField.setEditable(true);
				numberField.setEditable(true);
			}
			
			
			else{
				//If the method returns false we should not add a person
	
				if(!myPhoneBook.addPerson(nameField.getText(), Integer.parseInt(numberField.getText()))) { //The ! means that the statement is false
					searchField.setText("Person can not be added");
					nameField.setText("");
					numberField.setText("");
				}
				
				//if the method return true we add a person and tells the user that a person have been added
				else {
					myPhoneBook.addPerson(nameField.getText(), Integer.parseInt(numberField.getText()));
					nameField.setEditable(false);
					numberField.setEditable(false);
					searchField.setText("Person added");
					nameField.setText("");
					numberField.setText("");
				}
				
				
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		
		GUI myGUI = new GUI();

	}
}
