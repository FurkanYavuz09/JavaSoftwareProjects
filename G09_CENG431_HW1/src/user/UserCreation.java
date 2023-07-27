package user;

import java.io.*;  
import java.util.Random;
import java.util.Scanner;  

public class UserCreation {
	private User [] users;
	
	public User[] getUsers() {
		return users;
	}

	public UserCreation(String fileName) {
		
		this.create(fileName);
		
	}

	public void create(String fileName) {
		String[] languages = {"German", "Turkish",  "Italian", "Spanish"};
		int lenCsv  = findLenCsv(fileName);
		
		User[] users = new User[lenCsv];
		
		Random random = new Random();
	     
		//parsing a CSV file into Scanner class constructor  
		Scanner sc = null;
		try {
			sc = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		sc.useDelimiter("\n");   //sets the delimiter pattern  
		for (int i=0; i < lenCsv; i++){
			String[] row =sc.next().split(";");
			users[i] = new User(row[0], row[1]);
			users[i].setNumOfStreak(random.nextInt(365));
			users[i].setChosenLanguage(languages[random.nextInt(4)]);
			//find and returns the next complete token from this scanner  
			//break;
		}   
		sc.close();  //closes the scanner  
		this.users = users;
	}
	
private  int findLenCsv(String fileName) {
	
	int len = 0;
	Scanner sc = null;
	try {
		sc = new Scanner(new File(fileName));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		System.out.println("file not found");
		e.printStackTrace();
	}  
	sc.useDelimiter("\n");   //sets the delimiter pattern  
	while (sc.hasNext())  //returns a boolean value  
	{  
		sc.next();
		len+=1;
		
	}   
	sc.close();  //closes the scanner
	return len;
}
}


 