package leetcodeSep2022;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @Sir Darey
 * 
 * LeetCode Daily Challenge: September 2022, Day 24
 * Problem 113: Path Sum II
 */

class Day24_113_PathSum2 {
    
    List<List<Integer>> result = new ArrayList<>(); 
    List<Integer> temp = new ArrayList<>();
    int targetSum;
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        this.targetSum = targetSum;
        
        if  (root == null)
            return result;
    
        recur (root, 0);
        return result;     
    }
    
    void recur (TreeNode root, int sum) {        
        int currentSum = sum + root.val;
        temp.add(root.val);
        
        if (root.left != null)
            recur(root.left, currentSum);
        if (root.right != null)
            recur(root.right, currentSum);
        if (currentSum == targetSum && root.left==null && root.right == null)
                result.add(new ArrayList<>(temp));
        temp.remove(temp.size()-1);
    }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }