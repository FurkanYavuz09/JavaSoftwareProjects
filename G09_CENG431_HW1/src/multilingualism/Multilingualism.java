package multilingualism;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import csvIO.CsvReader;
import csvIO.CsvWriter;
import random.RandomNumberGenerator;
import user.User;
import user.UserCreation;
import leagues.*;

public class Multilingualism {

	public  void application() {
			UserCreation userCreation  = new UserCreation("data//users.csv");
			List<User>  users = Arrays.asList(userCreation.getUsers());
			
			RandomNumberGenerator random = new RandomNumberGenerator();
			
			CsvWriter writer = new CsvWriter();
			
			List<List<String>> content;
			File f = new File("output//languages.csv");
			if(f.exists() && !f.isDirectory()) { 
			    // read languages.csv
				CsvReader csvreader = new CsvReader();
				content = csvreader.create("output//languages.csv");
			}
			else {
				
				// create languages.csv
				CreateLanguages languagesToCsv = new CreateLanguages();
				
				content = languagesToCsv.getContent();
				
				writer.writeCsv("output/languages.csv", content);
			}
			
			
			String[] languages = {"German", "Turkish",  "Italian", "Spanish"};
			
			int[] languageQuizNumbers = findTotalQuizNumbers(languages, content);
			
			int maxQuizIndex = findMaxElementIndex(languageQuizNumbers);
			
			int[] languageUnitNumbers = findTotalUnitNumbers(languages, content);
			
			int maxUnitIndex = findMaxElementIndex(languageUnitNumbers);
			 
			List<List<String>> userCsv = new ArrayList<List<String>>();
			
			for (int i=0; i<users.size(); i++) {
				List<String> userInfo = new ArrayList<String>();
				userInfo.add(users.get(i).getUsername()+";"+users.get(i).getPassword().substring(0, users.get(i).getPassword().length() - 1));
				userInfo.add(users.get(i).getChosenLanguage());
				int languageIndex = Arrays.asList(languages).indexOf(users.get(i).getChosenLanguage());
				
				List<String> languageData = content.get(languageIndex);
				
				int quizNumberToSolve = random.generateInt(6, languageQuizNumbers[languageIndex]);
				
				users.get(i).setNumOfQuizzesToTake(quizNumberToSolve);
				
				//System.out.println(quizNumberToSolve);
				
				int solvedQuizzes = 0;
				
				int userPoint = 0;
				
				int unitNumber = 0;
				
				for (int j=0; j<languageData.size(); j++) {
					
					if (languageData.get(j).charAt(0) == 'Q') {
						solvedQuizzes+=1;
						String[] questionTypes = languageData.get(j+1).split(":");
						for (int k=0; k<questionTypes.length; k++) {
							
							String str = questionTypes[k].substring(0, questionTypes[k].length() - 1);
							
							int typeNum = Integer.valueOf(str);
							
							for (int question=0; question<typeNum; question++) {
								
								int isCorrect = random.generateInt(0, 2);//User answer correct or not. 1  = correct, 0 = false
								
								if (isCorrect == 1) {
									char questionType = questionTypes[k].charAt(questionTypes[k].length()-1);
									if (questionType == 'W') {
										userPoint+=5;
									}
									else if (questionType == 'R') {
										userPoint+=10;				
									}
									else if (questionType == 'S') {
										userPoint+=8;
									}
									else if (questionType == 'L'){
										userPoint+=7;
									}
								}
							}
						}
					}
					else if (languageData.get(j).charAt(0) == 'U') {
						
						unitNumber+=1;
					}
					
					if (solvedQuizzes == quizNumberToSolve){
						users.get(i).setCurrentUnit(unitNumber);
						userInfo.add("Unit "+Integer.toString(unitNumber));
						userInfo.add(Integer.toString(solvedQuizzes));
						
						break;
					}
					
				}
				users.get(i).setTotalPoint(userPoint);
				userInfo.add(Integer.toString(userPoint) + " Points");
				userCsv.add(userInfo);
				
			}
			
			writer.writeCsv("data//users.csv", userCsv);
			
			List<User> german = getUsersByLanguage(languages[0], users);
			SetLeagues setGermanLeagues = new SetLeagues(german, languages[0]);
			//System.out.println(german.size());
			
			List<User> turkish = getUsersByLanguage(languages[1], users);
			SetLeagues setTurkishLeagues = new SetLeagues(turkish, languages[1]);
			//System.out.println(turkish.size());
			
			List<User> italian = getUsersByLanguage(languages[2], users);
			SetLeagues setItalianLeagues = new SetLeagues(italian, languages[2]);
			//System.out.println(italian.size());
			
			List<User> spanish = getUsersByLanguage(languages[3], users);
			SetLeagues setSpanishLeagues = new SetLeagues(spanish, languages[3]);
			//System.out.println(spanish.size());
			
			
			
		
			Queries queries = new Queries(users);
			queries.query1();
			queries.query2();
			queries.query3(languages[maxUnitIndex], languageUnitNumbers[maxUnitIndex]);
			queries.query4(languages[maxQuizIndex], languageQuizNumbers[maxQuizIndex]);
			queries.query5(setItalianLeagues, 3);
				
		}
		
		public  int[] findTotalQuizNumbers(String[] language, List<List<String>> content) {
			int[] quizNumbers = new int[language.length];
			
			for (int i=0; i<content.size(); i++) {
				int num = 0;
				List<String> line = content.get(i);
				for (int j=0; j<line.size(); j++) {
					if (line.get(j).charAt(0) == 'Q') {
						num+=1;
					}
				}
				quizNumbers[i] = num;
			}
			
			return quizNumbers;
		}
		
		public  int[] findTotalUnitNumbers(String[] language, List<List<String>> content) {
			int[] unitNumbers = new int[language.length];
			for (int i=0; i<content.size(); i++) {
				int num = 0;
				List<String> line = content.get(i);
				for (int j=0; j<line.size(); j++) {
					if (line.get(j).charAt(0) == 'U') {
						num+=1;
					}
				}
				unitNumbers[i] = num;
			}
			
			return unitNumbers;
		}
		public  int findMaxElementIndex(int[] elements) {
		    int max = elements[0];
		    int index = 0;
		    for (int i = 0; i < elements.length; i++) 
		    {
		      if (max < elements[i]) 
		      {
		        max = elements[i];
		        index = i;
		      }
		    }
		    return index;
		}
			
		public  List<User> getUsersByLanguage(String language, List<User>  users ){
			List<User> languageUsers = new ArrayList<User>();
			
			for (int i=0; i<users.size(); i++) {
				if (users.get(i).getChosenLanguage() == language) {
					languageUsers.add(users.get(i));
				}
			}
			return languageUsers;
		}
}
