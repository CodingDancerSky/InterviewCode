package indeed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class SumTotal {
  
  private static ArrayList<Integer> list = new ArrayList<Integer>();

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    
    // get the number of numbers
    // 1 <= N <= 16
    int N = sc.nextInt();
    int[] nums = new int[N];
    boolean[] visited = new boolean[N];
    
    // −100 <= Ai <= 100
    List<Integer> rest = new ArrayList<Integer>();
    for(int i = 0; i < N; i++) {
      int n = sc.nextInt();
      int p = sc.nextInt();
      if(p < 0)
        rest.add(n);
      else {
        nums[p - 1] = n;
        visited[p - 1] = true;
      }
    }
    
    int[] candidates = new int[rest.size()];
    for(int i = 0; i < rest.size(); i++) {
      candidates[i] = rest.get(i);
    }
    // get all permutation of the uncertainty numbers
    List<List<Integer>> permutations = permuteUnique(candidates);
    
    int max = Integer.MIN_VALUE;
    for(List<Integer> list: permutations) {
      int total = 0;
      int[] new_nums = nums;
      int index = 0;
      for(int i = 0; i < N; i++){
        if(!visited[i])
          new_nums[i] = list.get(index++);
      }
      
      for(int i = 0; i < N - 1; i++) {
        total += new_nums[i] * new_nums[i + 1];
      }
      max = Math.max(max, total);
    }
    System.out.println(max);
  }
  
  public static List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> lists = new ArrayList<List<Integer>>();
    
    Arrays.sort(nums);
    for(int num: nums)
      list.add(num);
    
    getPermutation(lists, 0);
    return lists;
  }

  public static void getPermutation(List<List<Integer>> lists, int index) {
    if(index >= list.size() - 1) {
      lists.add((ArrayList<Integer>)list.clone());
      return;
    }
    
    Integer last = null;
    for(int i = list.size() - index; i > 0; i--) {
      if(list.get(index) != last)
        getPermutation(lists, index + 1);
      list.add(last = list.remove(index));
    }
  }
}
