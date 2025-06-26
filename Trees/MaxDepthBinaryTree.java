class Solution {
    public int maxDepth (TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}

// time: O(n)
// space: O(n)

// BFS / iterative approach
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int depth = 0;

        while (!q.isEmpty()) {

            int levelSize = q.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode current = q.poll();

                if (current.left != null) {
                    q.offer(current.left);
                }

                if (current.right != null) {
                    q.offer(current.right);
                }
            }
            depth++;
        }
        return depth;
    }
}