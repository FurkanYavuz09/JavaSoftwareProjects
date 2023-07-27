package leagues;


import java.util.List;
import java.util.ArrayList;
import user.User;



public class SetLeagues {

	private String language;
	private List<User> allUsers ;
	private BronzeLeague bronze;
	private SilverLeague silver;
	private GoldenLeague golden;
	private SapphireLeague sapphire;
	private RubyLeague ruby;
	
	public SetLeagues(List<User> allUsers, String language) {
		this.language = language;
		this.allUsers = allUsers;
		this.sortUsersByPoint(0, this.allUsers.size()-1);
		this.allUsers = this.reverseList(this.allUsers);
		this.putUsersToLeagues();
	}
	
	private List<User> reverseList(List<User> users) {
		List<User> reversedList = new ArrayList<User>();
		for (int i=users.size()-1; i>=0; i--) {
			reversedList.add(users.get(i));
		}
		return reversedList;
		
	}
	
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	
	public List<User> getAllUsers() {
		return allUsers;
	}

	public RubyLeague getRuby() {
		return ruby;
	}


	public GoldenLeague getGolden() {
		return golden;
	}


	public SapphireLeague getSapphire() {
		return sapphire;
	}
	
	public BronzeLeague getBronze() {
		return bronze;
	}


	public SilverLeague getSilver() {
		return silver;
	}


	private void putUsersToLeagues() {
		
		BronzeLeague bronze  = new BronzeLeague(this.allUsers);
		this.bronze = bronze;
		
		SilverLeague silver = new SilverLeague(bronze.getWillBePromoted());
		this.silver = silver;
		
		GoldenLeague golden = new GoldenLeague(silver.getWillBePromoted());
		this.golden = golden;
		
		SapphireLeague sapphire = new SapphireLeague(golden.getWillBePromoted());
		this.sapphire = sapphire;
		
		RubyLeague ruby = new RubyLeague(sapphire.getWillBePromoted());
		this.ruby = ruby;
		
		
	}
	private void sortUsersByPoint(int low, int high) {
        int i = low, j = high;
        // Get the pivot element from the middle of the list
        int pivot = this.allUsers.get(low + (high-low)/2).getTotalPoint();

        // Divide into two lists
        while (i <= j) {
            // If the current value from the left list is smaller than the pivot
            // element then get the next element from the left list
            while (this.allUsers.get(i).getTotalPoint() < pivot) {
                i++;
            }
            // If the current value from the right list is larger than the pivot
            // element then get the next element from the right list
            while (this.allUsers.get(j).getTotalPoint() > pivot) {
                j--;
            }

            // If we have found a value in the left list which is larger than
            // the pivot element and if we have found a value in the right list
            // which is smaller than the pivot element then we exchange the
            // values.
            // As we are done we can increase i and j
            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }
        }
        // Recursion
        if (low < j)
        	sortUsersByPoint(low, j);
        if (i < high)
        	sortUsersByPoint(i, high);
    }

    private void exchange(int i, int j) {
        User user = this.allUsers.get(i);
        this.allUsers.set(i, this.allUsers.get(j)) ;
        this.allUsers.set(j, user);
    }
}
