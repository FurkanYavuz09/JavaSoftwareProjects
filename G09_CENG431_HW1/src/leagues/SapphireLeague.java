package leagues;


import java.util.List;

import user.User;

public class SapphireLeague extends League{

	
	
	public SapphireLeague(List<User> allUsers) {
		super(allUsers);
		// TODO Auto-generated constructor stub
		this.setPromotedUsers();
		
	}

	

	@Override
	public void setPromotedUsers() {
		// TODO Auto-generated method stub
		for (int i=0; i<super.allUsers.size(); i++) {
			if (super.allUsers.get(i).getNumOfStreak()>=30 && (super.allUsers.get(i).getTotalPoint()>5000 || super.allUsers.get(i).getCurrentUnit() >= 10)) {
				super.willBePromoted.add(super.allUsers.get(i));
				super.allUsers.get(i).setRank("Ruby");
			}
		}
		super.deletePromotedUsers();
	}
}
