package multilingualism;

import user.*;
import java.util.List;
import leagues.*;

public class Queries {

	
	List<User> users;
	
	public Queries(List<User> users) {
		this.users = users;
	}
	
	
	public void query1() {
		int maxPoint = 0;
		User maxPointUser = null;
		for (int i=0; i<this.users.size(); i++) {
			User user = this.users.get(i);
			if (user.getTotalPoint() > maxPoint) {
				maxPointUser = user;
				maxPoint = user.getTotalPoint();
			}
		}
		System.out.println(maxPointUser.getUsername()+" " +maxPoint+" points");
	}
	public void query2() {
		int unitNumber = 0;
		User advancedUnitUser = null;
		for (int i=0; i<this.users.size(); i++) {
			User user = this.users.get(i);
			if (user.getCurrentUnit() > unitNumber) {
				advancedUnitUser = user;
				unitNumber = user.getCurrentUnit();
			}
		}
		System.out.println(advancedUnitUser.getUsername()+" Unit " +unitNumber);
	}
			
	public void query3(String language, int maxUnitNumber) {
		System.out.println(language +" "+ maxUnitNumber+" Units");
	}
	
	public void query4(String language, int maxQuizNumber) {
		System.out.println(language +" "+ maxQuizNumber+" Quizzes");
		
	}
	public void query5(SetLeagues leagues, int n) {
		
		String leaderboard = "";
		List<User> leagueUsers = leagues.getSilver().getAllUsers();
		
		for(int i=0; i< leagueUsers.size(); i++) {
			
				leaderboard = leaderboard+ Integer.toString(i+1)+"." + leagueUsers.get(i).getUsername()+" ";
				
				if (i==n-1) {
					break;
				}		
		}
		
		System.out.println(leagues.getLanguage()+" Silver League Top "+n+": "+leaderboard );
	}

}
