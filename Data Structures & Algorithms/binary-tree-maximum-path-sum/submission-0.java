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
    int maxSum;

    int solve(TreeNode root) {
        if(root == null)
            return 0;

        int leftSum = solve(root.left);
        int rightSum = solve(root.right);

        int neeche_hi_ans_mil_gaya = leftSum + rightSum + root.val; // 1
        int koi_ek_sum_achha = Math.max(leftSum, rightSum) + root.val; // 2
        int only_root_achha = root.val; // 3
        
        maxSum = Math.max(
            maxSum,
            Math.max(
                neeche_hi_ans_mil_gaya,
                Math.max(koi_ek_sum_achha, only_root_achha)
            )
        );

        return Math.max(koi_ek_sum_achha, only_root_achha); // Most imp, we should ignore if we found good and in below tree
    }

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        solve(root);
        return maxSum;
    }
}
