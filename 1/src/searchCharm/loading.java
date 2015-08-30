package searchCharm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class loading {
  
  public List<String> loadingFile() throws IOException{
    List<String> strings = new ArrayList<String>();
    
    try(BufferedReader br = new BufferedReader(new FileReader("src/searchCharm/3PracticeInput.txt"))) { 
      String token = br.readLine();
      
      strings.add(token);
      
      String string = br.readLine();
      string = br.readLine();
      
      StringTokenizer lineTokenizer=new StringTokenizer(string, " ");
        
      while(lineTokenizer.hasMoreTokens())
      {
         String s = lineTokenizer.nextToken();
//           System.out.println(ip);
         s = s.replaceAll("[^A-Za-z]", "");
//         System.out.println(s);
         strings.add(s);
      }
       
      return strings;  
  }
 }
}