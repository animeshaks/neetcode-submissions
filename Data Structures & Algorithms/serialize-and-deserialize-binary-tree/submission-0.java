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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> res = new ArrayList<>();
        serializeHelper(root, res);
        return String.join(",", res);
    }

    private void serializeHelper(TreeNode root, List<String> res) {
        if (root == null) {
            res.add("N");
            return;
        }

        res.add(String.valueOf(root.val));
        serializeHelper(root.left, res);
        serializeHelper(root.right, res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        int[] index = {0};

        return deserializeHelper(nodes, index);
    }

    private TreeNode deserializeHelper(String[] nodes, int[] index) {
        String value = nodes[index[0]++];

        if (value.equals("N")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(value));

        root.left = deserializeHelper(nodes, index);
        root.right = deserializeHelper(nodes, index);

        return root;
    }
}
