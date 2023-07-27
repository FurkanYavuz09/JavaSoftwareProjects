package leagues;


import java.util.List;

import user.User;

public class BronzeLeague extends League{

	public BronzeLeague(List<User> users){
		super( users );
		this.setPromotedUsers();
	}

	@Override
	public void setPromotedUsers() {
		// TODO Auto-generated method stub
		for (int i=0; i<super.allUsers.size(); i++) {
			if (i<15) {
				super.willBePromoted.add(super.allUsers.get(i));
				super.allUsers.get(i).setRank("Silver");
			}
		}
		super.deletePromotedUsers();
		
	}
	
	
}
