package validatingIP;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class loading {
  
  public List<List<String>> loadingFile() throws IOException{
    List<List<String>> lists = new ArrayList<List<String>>();
    
    try(BufferedReader br = new BufferedReader(new FileReader("src/validatingIP/1PracticeInput.txt"))) { 
      String line = br.readLine();
      
      while (line != null) {
//        System.out.println(line);
        StringTokenizer lineTokenizer=new StringTokenizer(line, " ");
        
        ArrayList<String> list = new ArrayList<String>();
        while(lineTokenizer.hasMoreTokens())
        {
           String ip = lineTokenizer.nextToken();
//           System.out.println(ip);
           list.add(ip);
        }
        lists.add(list);
        
        line = br.readLine();
    }      
    return lists;
  }
 }
}
