package palindromePhrases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class loading {
  
  public List<String> loadingFile() throws IOException{
    List<String> strings = new ArrayList<String>();
    
    try(BufferedReader br = new BufferedReader(new FileReader("src/palindromePhrases/1PracticeInput.txt"))) { 
      String line = br.readLine();
  
      while (line != null) {
        strings.add(line);
        line = br.readLine();
      }
      
    }      
    return strings;
  }
}
