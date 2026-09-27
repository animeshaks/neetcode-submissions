/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    List<Integer> visit = new ArrayList<>();

    void inOrder(TreeNode node) {
        if(node == null)
            return;
        
        inOrder(node.left);
        visit.add(node.val);
        inOrder(node.right);
    }

    public int kthSmallest(TreeNode root, int k) {
        inOrder(root);
        return visit.get(k-1);
    }
}
