package indeed;

import java.util.Scanner;

public class Loudspeakers {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    
    // get the diameter
    int[] d_square = new int[3];
    for(int i = 0; i < 3; i++) {
      d_square[i] = sc.nextInt() ^ 2;
    }
    
    // get the number of audiences
    int N = sc.nextInt();
    
    // get the points of audiences
    int[][] audiences = new int[N][2];
    for(int i = 0; i < N; i++) {
      audiences[i][0] = sc.nextInt();
      audiences[i][1] = sc.nextInt();
    }
    
    // get the max number of audiences that the s can cover
    System.out.println(maxAudiences(d_square, N, audiences));
  }

  public static int maxAudiences(int[] d_square, int N, int[][] audiences) {
    int max_audiences = 0;
    
    int[][] s = new int[3][2];
    // first speaker
    for(; s[0][0] < 10; s[0][0]++) {
      for(; s[0][1] < 10; s[0][1]++) {
        
        // second speaker
        for(; s[1][0] < 10; s[1][0]++) {
          for(; s[1][1] < 10; s[1][1]++) {
            if (s[0][0] == s[1][0] && s[0][1] == s[1][1]) 
              continue;
            
            // third speaker
            for(; s[2][0] < 10; s[2][0]++) {
              for(; s[2][1] < 10; s[2][1]++) {
                if ((s[0][0] == s[2][0] && s[0][1] == s[2][1]) || 
                    (s[1][0] == s[2][0] && s[1][1] == s[2][1])) 
                  continue;
                
                // get the number of audiences that 3 s cover
                int total = cover(s, d_square, N, audiences);
                max_audiences = Math.max(max_audiences, total);
              }
            }
          }
        }
      }
    }
    
    return max_audiences;
  }

  public static int cover(int[][] s, int[] d_square, int N, int[][] audiences) {
    int total = 0;
    
    for(int i = 0; i < N; i++) {
      int[] point = audiences[i];
      for(int j = 0; j < 3; j++) {
        if(distance(point, s[j]) <= d_square[j]) {
          total++;
          break;
        }
      }
    }
    return total;
  }

  public static double distance(int[] point1, int[] point2) {
    return Math.pow(point1[0] - point2[0], 2) + Math.pow(point1[0] - point2[1], 2);
  }
}
