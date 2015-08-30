package searchCharm;

import java.io.IOException;
import java.util.List;

public class token {
  public static void main(String[] args) {
    loading l = new loading();
    
    try {
     List<String> lists = l.loadingFile();
     
     String token = lists.get(0).toLowerCase();
     int complete = 0;
     int prefix = 0;
     boolean first = false;
     String firstToken = null;
     
     for(int i = 1; i < lists.size(); i++){
       String s = lists.get(i);
       String s_lowKeys = s.toLowerCase();
       
       if(s_lowKeys.equals(token)){
         complete++;
         if(!first)
           firstToken = s;
         first = true;
       }
       
       if(s_lowKeys.startsWith(token)){
         prefix++;
         System.out.println(s);
         if(!first)
           firstToken = s;
         first = true;
       }
     }
     
     System.out.println("~~~~~~~~~~~~~~");
     System.out.println(complete);
     System.out.println(prefix);
     System.out.println(firstToken);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }   
  }
}
