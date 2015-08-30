package fastestRoute;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class loading {
  
  public List<int[]> loadingFile() throws IOException{
    List<int[]> lists = new ArrayList<int[]>();
    try(BufferedReader br = new BufferedReader(new FileReader("src/fastestRoute/3PracticeInput.txt"))) { 
      String line = br.readLine();
      
      while (line != null) {
        StringTokenizer lineTokenizer=new StringTokenizer(line," ");
        
        ArrayList<Integer> l = new ArrayList<Integer>();
        while(lineTokenizer.hasMoreTokens())
        {
         String num = lineTokenizer.nextToken();
         int temp = Integer.parseInt(num);
         l.add(temp);
        }
        
        int length=l.size();
        int[] arr=new int[length];
        for(int i=0;i<length;i++)
        {
         arr[i]=l.get(i);
        }
        
        lists.add(arr);
        line = br.readLine();
      }  
    }     
    
//    for(int[] in: lists){
//      for(int i = 0; i < in.length; i++){
//        System.out.print(in[i] + " / ");
//      }
//      System.out.println();
//    }
    
    return lists;
  }
}
