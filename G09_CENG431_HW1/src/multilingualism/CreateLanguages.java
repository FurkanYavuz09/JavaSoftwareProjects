package multilingualism;

import java.util.ArrayList;
import java.util.List;
import containers.Unit;
import languages.*;

public class CreateLanguages {

	
	private Language turkish;
	private Language german;
	private Language italian;
	private Language spanish;
	
	private List<List<String>> content = new ArrayList<List<String>>();
	
	public CreateLanguages() {
		
		this.turkish = new Turkish();
		this.italian = new Italian();
		this.spanish = new Spanish();
		this.german =  new German();
		
		this.fillContent();
	}

	
	public List<List<String>> getContent() {
		return content;
	}

	private void fillContent() {
		this.languageToCsv(this.german);
		this.languageToCsv(this.turkish);
		this.languageToCsv(this.italian);
		this.languageToCsv(this.spanish);
	}
	
	private void languageToCsv(Language language) {
		
		
			 List<String> line = new ArrayList<String>();
			 List<Unit> units = language.getUnits();
			 line.add(language.getLanguage());
			 for (int j=0; j<units.size(); j++) {
				 int numberOfQuizzes = units.get(j).getQuizNumber();
				 line.add("Unit "+Integer.toString(j+1));
				 for (int k=0; k<numberOfQuizzes; k++) {
					 
					 line.add("Quiz "+Integer.toString(k+1));
					 line.add(units.get(j).getQuizByNumber(k).getQuestionTypes());
				 }
				 
				 
			 }
			 this.content.add(line);	
	}
	
}

