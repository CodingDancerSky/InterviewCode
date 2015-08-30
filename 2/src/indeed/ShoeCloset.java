package indeed;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ShoeCloset {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    
    // get the number of pairs of shoes
    int N = sc.nextInt();
    
    // get the shoes distribution
    int[][] shoes = new int[N + 1][2];
    for(int i = 1; i < N + 1; i++) {
      shoes[i][0] = sc.nextInt();
      shoes[i][1] = sc.nextInt();
    }
    
    // sort according to the left shoe
    Arrays.sort(shoes, new Comparator<int[]>() {
      @Override
      public int compare(final int[] entry1, final int[] entry2) {
          final Integer left1 = entry1[0];
          final Integer left2 = entry2[0];
          return left1.compareTo(left2);
      }
  });
    
    System.out.println(minOperations(shoes, N));
  }

  public static int minOperations(int[][] shoes, int N) {
    int sum = 0;
    boolean[] visited = new boolean[N + 1];
    for(int i = 0; i < N + 1; i++) {
      if(!visited[i]) {
        sum++;
        int current = i;
        do {
          visited[current] = true;
          current = shoes[current][1];
        } while(current != i);
      } 
    }
    
    return N - sum;
  }
}
