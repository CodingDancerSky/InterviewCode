package findPath;

import java.io.IOException;
import java.util.List;

public class findPathInMap {
  
  public static void main(String[] args) {
    loading l = new loading();
    try {
      List<String> lists = l.loadingFile(); 
      
      String path = lists.remove(0);
      findPath(lists, path);

    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }   
}
  
  public static void printPath(char[][] maze, boolean[][] inPath){
    for(int i = 0; i < maze.length; i++){
      for(int j = 0; j < maze[0].length; j++){
        if(inPath[i][j]){
          System.out.print(maze[i][j]);
        } else System.out.print('.');
      }   
      System.out.println();
    }
  }
  
  static void findPath(List<String> lists, String path){   
    String s1 = lists.get(0);
    int mazeWidth = s1.length();
    int mazeHeight = lists.size();
    
    int index = 0; 
    char[][] maze = new char[mazeHeight][mazeWidth];
    
    while(index < mazeHeight){
      String s = lists.get(index);
     
      maze[index] = s.toCharArray();
      index++;
    }
    
    boolean[][] inPath = new boolean[mazeHeight][mazeWidth];
    
    findPathHelper(maze, path, 0, 0, inPath);
    
    printPath(maze, inPath);
  }

  public static boolean findPathHelper(char[][] maze, String path, int i, int j, boolean[][] inPath) {
    int mazeWidth = maze[0].length;
    int mazeHeight = maze.length;
    
    inPath[i][j] = true;
    
    if(path.length() == 1)
      return true;
    
    if(i == mazeHeight && j == mazeWidth)
      return true;
      
    boolean b1 = false;
    boolean b2 = false;
    boolean b3 = false;
    boolean b4 = false;
    
    if(j > 0 && (!inPath[i][j - 1])){
      if(maze[i][j - 1] == path.charAt(1)){
        b1 = findPathHelper(maze, path.substring(1), i, j - 1, inPath);
        if(!b1){
          inPath[i][j - 1] = false;
        } 
      }
    }
    
    if(i > 0 && !inPath[i - 1][j]){
      if(maze[i - 1][j] == path.charAt(1)){
        b2 = findPathHelper(maze, path.substring(1), i - 1, j, inPath);
      if(!b2){
        inPath[i - 1][j] = false;
        }
      }
    }
    
    if(j < mazeWidth - 1 && !inPath[i][j + 1]){
      if(maze[i][j + 1] == path.charAt(1)){
        b3 = findPathHelper(maze, path.substring(1), i, j + 1, inPath);
        if(!b3){
          inPath[i][j + 1] = false;
        }  
      }
    }
    
    if(i < mazeHeight - 1 && !inPath[i + 1][j]){
      if(maze[i + 1][j] == path.charAt(1)){
        b4 = findPathHelper(maze, path.substring(1), i + 1, j, inPath);
        if(!b4){
          inPath[i + 1][j] = false;
        }
      }
    }
    
    return (b1 || b2 || b3 || b4);
    
//    inPath[i][j] = false;
  } 
}
