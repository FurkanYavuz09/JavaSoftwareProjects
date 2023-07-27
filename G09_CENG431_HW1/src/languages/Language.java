package languages;

import java.util.ArrayList;
import java.util.List;
import containers.Unit;
import random.RandomNumberGenerator;

public abstract class Language {

		private String language;
		private List<Unit> units = new ArrayList<Unit>(); // adding generics
		private RandomNumberGenerator random = new RandomNumberGenerator();
		
		public Language(String language) {
			this.createUnits(60, 100);
			this.language = language;
		}
		  
		public void createUnits(int min, int max){
		    int unitNum  =this.random.generateInt(min, max);
		    for (int i=0; i<unitNum; i++) {
		    	this.units.add(new Unit());
		    	 
		    }
		}
		
		public String getLanguage() {
			return language;
		}

		public void setLanguage(String language) {
			this.language = language;
		}

		public List<Unit> getUnits() {
			return units;
		}

		public void setUnits(List<Unit> units) {
			this.units = units;
		}

		
}
