package indeed;

import java.util.HashMap;
import java.util.Scanner;


public class StringShuffer {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    
    int N = sc.nextInt();
    String s = sc.next();
    int M = sc.nextInt();
    char[] chars = s.toCharArray();
    
    for(int i = 0; i < M; i++){
      int first = sc.nextInt();
      int second = sc.nextInt();
      int time = sc.nextInt();
      
        time = time % (second - first + 1);
        first--;
        second--;
//        HashMap<Integer, String> map = new HashMap<Integer, String>();
        
        for(int j = 0; j < time; j++){
          char c1 = s.charAt(second);
          String s1 = s.substring(0, first);
          String s2 = s.substring(first, second);
          String s3 = s.substring(second+1, N);
//          System.out.println(s1);
//          System.out.println(c1);
//          System.out.println(s2);
//          System.out.println(s3);
          s = s1+c1+s2+s3;
          
        }
        
      }
      
//      String result = "";
//      for(int i = 0; i < N;i++){
//        result += chars[i];
//      }
      
      System.out.println(s);
    }
  }

