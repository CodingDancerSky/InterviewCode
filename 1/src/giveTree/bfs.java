package giveTree;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class bfs {
  public static void main(String[] args) {
    loading l = new loading();
    try {
      List<int[]> lists = l.loadingFile(); 
      
      int[] inorder = lists.get(0);
      int[] postorder = lists.get(1);
      TreeNode root = buildTree(inorder, postorder);
      if(root == null){
        System.out.println("InvalidInput");
      } else System.out.println(levelOrder(root));
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }    
  }
  
  public static TreeNode buildTree(int[] inorder, int[] postorder) {
    int in = inorder.length;
    int post = postorder.length;
    
    if(in != post || in == 0)
        return null;
    
    HashMap<Integer, Integer> inorderMap = new HashMap<Integer, Integer>();
    for(int i = 0; i < in; i++){
      inorderMap.put(inorder[i], i);
    }
    
    return buildTree(inorderMap, postorder, 0, in - 1, post - 1);
}

  static TreeNode buildTree(HashMap<Integer, Integer> inorderMap, int[] postorder, int start, int end, int index) {
    
    if(end < start || index < 0)
        return null;
    
    TreeNode root = new TreeNode(postorder[index]);
    if(start == end)
      return root;
      
    int r = inorderMap.get(postorder[index]);
    
    root.left = buildTree(inorderMap, postorder, start, r - 1, index - 1- (end - r));
    root.right = buildTree(inorderMap, postorder, r + 1, end, index - 1 );
    
    return root;
}
  
  public static List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> lists = new ArrayList<List<Integer>>();
    if(root == null)
        return lists;

    levelOrder(root, lists, 0);
    
    return lists;
}

static void levelOrder(TreeNode root, List<List<Integer>> lists, int level) {
    if(root == null)
       return;
       
    List<Integer> list = null;
    
    if(lists.size() == level){
      list = new ArrayList<Integer>();
      lists.add(list);
    } else {
        list = lists.get(level);
    }
    
    list.add(root.val);
    
    levelOrder(root.left, lists, level + 1);
    levelOrder(root.right, lists, level + 1);     
}
}
