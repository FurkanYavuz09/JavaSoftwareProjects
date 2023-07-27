package leagues;

import java.util.ArrayList;
import java.util.List;

import user.*;

public abstract class League {

	public List<User> allUsers = new ArrayList<User>();

	public List<User> willBePromoted = new ArrayList<User>();
	
	public League(List<User> allUsers) {
		
		this.allUsers = allUsers;
	}
	
	
	public abstract void setPromotedUsers();
	
	public void deletePromotedUsers() {
		List<User> newUsers = new ArrayList<User>();
		
		for (int j=0; j<this.allUsers.size(); j++) {

			for (int i=0; i<this.willBePromoted.size(); i++) {
				if (this.willBePromoted.get(i).getUsername() != this.allUsers.get(j).getUsername()) {
				
					newUsers.add(this.allUsers.get(j));
				}
			}
		}
		this.allUsers = newUsers;
		
	}


	public List<User> getAllUsers() {
		return allUsers;
	}


	public List<User> getWillBePromoted() {
		return willBePromoted;
	}
	
	
	
	
}
