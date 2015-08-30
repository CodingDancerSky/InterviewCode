package palindromePhrases;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class palindrome {
  public static void main(String[] args) {
    loading l = new loading();
    try {
      List<String> lists = l.loadingFile(); 
      
      for(String s: lists){  
        System.out.println(longestPP(s));
      }      
      
//      System.out.println(longestPP("...a.ba.11.ab>>>ba.")); 
      
//      for(String s: lists){  
//        RangedString longest = new RangedString(s.substring(0, 3), 0, 2);
//        System.out.println(longest.s + "/" + longest.start + "/" + longest.end + "/" + longest.length());
//      }
      
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }  
}

  public static String longestPP(String s) {
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    StringBuffer sb = new StringBuffer();
    int index = 0;
    for(int i = 0; i < s.length(); i++){
      char c = s.charAt(i);
      if(validChar(c)){
        sb.append(Character.toLowerCase(c));
        map.put(index, i);
        index++;
      }
    }
    
//    for(int ss: map.keySet()){
//      System.out.println("key: " + ss + "// value: " + map.get(ss));
//    }
      
    String newS = sb.toString();
//    System.out.println("newString: " + newS);
    int length = newS.length();
    if(newS == null || length == 1)
      return s;
    
    RangedString longest = new RangedString(newS.substring(0, 1), 0, 0);
    RangedString temp = new RangedString(); 
    
    for(int i = 0; i < length; i++){          
      temp = longestPP(newS, i, i);
      if(temp.length() > longest.length()){
//        System.out.println("111111");
        longest = temp;
      }
      
      temp = longestPP(newS, i, i + 1);
      if(temp.length() > longest.length())
        longest = temp;
      
//      System.out.println(longest.s + "/" + i);
      }
    
    int s_start = map.get(longest.start);
    int s_end = map.get(longest.end);
    return s.substring(s_start, s_end + 1);
  }
  
  static boolean validChar(char c){
    if((c >= (int)'0' && c <= (int)'9') || (c >= (int)'a' && c <= (int)'z') || (c >= (int)'A' && c <= (int)'Z'))
      return true;
      else return false;
  }
    
  public static RangedString longestPP(String s, int start, int end) {
    int length = s.length();
    
    while(end < length && start >= 0 && s.charAt(start) == s.charAt(end)){
      start--;
      end++;
    }
    
    RangedString rs = new RangedString(s.substring(start + 1, end), start + 1, end - 1);
    return rs;
  }
}
