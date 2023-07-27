package leagues;

import java.util.ArrayList;
import java.util.List;

import user.User;

public class GoldenLeague extends League{

	
	
	public GoldenLeague(List<User> allUsers) {
		super(allUsers);
		// TODO Auto-generated constructor stub
		this.setPromotedUsers();
		
	}

	

	@Override
	public void setPromotedUsers() {
		// TODO Auto-generated method stub
		for (int i=0; i<super.allUsers.size(); i++) {
			if (i<5 && super.allUsers.get(i).getNumOfStreak()>=7) {
				super.willBePromoted.add(super.allUsers.get(i));
				super.allUsers.get(i).setRank("Sapphire");
			}
		}
		super.deletePromotedUsers();
	}
	
}
