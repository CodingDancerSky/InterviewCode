package indeed;

import java.util.HashMap;
import java.util.Scanner;

public class Ball {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    
    // get the number of operations that are included in one set
    // 1 <= N <= 50
    int N = sc.nextInt();
    // get the number of sets
    // 1 <= K <= 10^9
    int K = sc.nextInt();
    
    int[] balls = {0, 1, 2, 3, 4, 5, 6, 7, 8};
    // get the operations
    int[][] changes = new int[N][2];
    for(int i = 0; i < N; i++) {
      changes[i][0] = sc.nextInt();
      changes[i][1] = sc.nextInt();
    }
    
    HashMap<Integer, String> map = new HashMap<Integer, String>();
    map.put(0, getOrder(balls));
    int i = 0;
    for(; i < K; i++) {
      balls = shuffle(balls, changes);
      if(restart(balls)) {
        System.out.println(map.get(K % (i + 1)));
        break;
      } else {
        map.put(i + 1, getOrder(balls));
      }
    }
    
    if(i == K)
      System.out.println(getOrder(balls));
  }

  public static String getOrder(int[] balls) {
    String result = "";
    for(int j = 1; j < 8; j++) {
      result += balls[j] + " ";
    }
    result += balls[8];
    return result;
  }

  public static boolean restart(int[] balls) {
    for(int i = 0; i < 9; i++) {
      if(balls[i] != i)
        return false;
    }
    return true;
  }

  public static int[] shuffle(int[] balls, int[][] changes) {
    for(int i = 0; i < changes.length; i++) {
      int[] c = changes[i];
      int temp = balls[c[0]];
      balls[c[0]] = balls[c[1]];
      balls[c[1]] = temp;
    }
    
    return balls;
  }
}
