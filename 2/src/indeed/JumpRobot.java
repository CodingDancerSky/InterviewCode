package indeed;

import java.util.HashSet;
import java.util.Scanner;

public class JumpRobot {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    
    // get the number of the jump types
    int N = sc.nextInt();
    
    HashSet<String> points = new HashSet<String>();
    // add the original point
    points.add("0 0");  
    
    for(int i = 0; i < N; i++) {
      int jump = sc.nextInt();
      HashSet<String> next_points = new HashSet<String>();
      
      for(String s: points) {
        String[] ss = s.split(" ");
        int[] point = {Integer.parseInt(ss[0]), Integer.parseInt(ss[1])};
        String[] newPoints = getNew(point, jump);
        for(String news: newPoints) {
          next_points.add(news);
        }
      }
      points.clear();
      points = next_points;
    }
    
    System.out.println(points.size());
    for(String s: points) {
      System.out.println(s);
    }
  }

  public static String[] getNew(int[] point, int jump) {
    String[] result = new String[5];
    result[0] = point[0] +  " " + point[1];
    result[1] = (point[0] - jump) +  " " + point[1];
    result[2] = (point[0] + jump) +  " " + point[1];
    result[3] = point[0] +  " " + (point[1] - jump);
    result[4] = point[0] +  " " + (point[1] + jump);
    return result;
  }

}
