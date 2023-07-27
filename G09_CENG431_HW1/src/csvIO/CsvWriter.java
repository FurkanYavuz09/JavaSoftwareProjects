package csvIO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvWriter {

	public CsvWriter() {
		
		
	}
	public void writeCsv(String fileName, List<List<String>> content) {
		
		File csvFile = new File(fileName);
		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter(csvFile);
			for (List<String> data : content) {
			    StringBuilder line = new StringBuilder();
			    for (int i = 0; i < data.size(); i++) {
			        line.append(data.get(i));
			        
			        if (i != data.size() - 1) {
			            line.append(',');
			        }
			    
			    }
			    //System.out.println(line);
			    line.append("\n");
			    fileWriter.write(line.toString());
			}
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error while creating a file");
		}
		
	}
}
