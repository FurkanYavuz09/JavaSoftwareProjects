package csvIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;


public class CsvReader {

	
	
	
	public List<List<String>> create(String fileName) {
		
		int lenCsv  = findLenCsv(fileName);
		
		List<List<String>> allLines = new ArrayList<List<String>>() ;
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
			String row =sc.next();
			String[] line = row.split(",");
			List<String> l = Arrays.asList(line);
			allLines.add(l);
			
			//find and returns the next complete token from this scanner  
		}   
		sc.close();  //closes the scanner  
		return allLines;
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
