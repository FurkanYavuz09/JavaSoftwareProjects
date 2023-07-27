package leagues;


import java.util.List;

import user.User;

public class SilverLeague extends League {

	public SilverLeague(List<User> allUsers) {
		super(allUsers);
		// TODO Auto-generated constructor stub
		this.setPromotedUsers();
		
	}

	@Override
	public void setPromotedUsers() {
		// TODO Auto-generated method stub
		for (int i=0; i<super.allUsers.size(); i++) {
			if (i<10) {
				super.willBePromoted.add(super.allUsers.get(i));
				super.allUsers.get(i).setRank("Golden");
			}
		}
		super.deletePromotedUsers();
	}

	
	
}
