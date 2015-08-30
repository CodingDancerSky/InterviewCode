package indeed;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Construction {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    
    // get the number of islands
    // 1 <= N <= 50
    int N = sc.nextInt();
    // get the number of days
    // 1 <= Q <= 500
    int Q = sc.nextInt();
    
    int[][] connect = new int[N][N];
    
    for(int i = 0; i < Q; i++) {
      String[] line = sc.next().split(" ");
      String operation = line[0];
      int[] bridges = {Integer.parseInt(line[1]), Integer.parseInt(line[2])};
      Arrays.sort(bridges);
      
      if(operation.equals("build")) {
        connect[bridges[0] - 1][bridges[1] - 1] = i + 1;
      }
            
      if(operation.equals("check")) {
        String show = "NO";
        int oldest = dfs(connect, bridges[0], bridges[1]);
        if( oldest > 0) {
          show = "YES " + oldest;
        } 
        
        
        System.out.println(show);
      }
    }
  }

  public static int dfs(int[][] connect, int i, int j) {
    int result = Integer.MIN_VALUE;
    int N = connect.length;
    // the oldest time for i to this bridge
    int[] time = new int[N];
    for(int k = 0; k < N; k++) {
      time[k] = Integer.MAX_VALUE;
    }
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    
    Stack<Integer> current = new Stack<Integer>();
    current.add(i);
    while(!current.isEmpty()) {
      int b = current.pop();
      for(int k = b + 1; k < N; k++) {
        int p = connect[k][b];
        if(p >= 0) {
          if(time[k] > p) {
            time[k] = p;
            if(map.containsKey(k))
              map.put(k, p);
          }
          
          if(k == j)
            result = Math.max(result, time[k]);
            result = Math.max(result, time[b]);
          if(k == i)
            continue;
          current.add(k);
        }
      }
    }
    if(result == Integer.MIN_VALUE)
      return -1;
    else
      return result;
  }
}
