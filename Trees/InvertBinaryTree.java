class Solution {
    public TreeNode invertTree(TreeNode root) {

        // DFS Approach

        if (root == null) {
            return root;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}

// time: O(n) since each node visited once
// space: O(n) since x function calls will be placed on the stack
// due to recursion (x being height of tree)