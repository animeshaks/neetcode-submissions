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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;

        if(root == p || root == q) 
            return root;
        
        // Left side se leftN nikalo
        TreeNode leftN = lowestCommonAncestor(root.left, p, q);

        // Right side se leftN nikalo
        TreeNode rightN = lowestCommonAncestor(root.right, p, q);

        if(leftN != null && rightN != null)
            return root;

        if(leftN != null)
            return leftN;

        return rightN;
    }
}
