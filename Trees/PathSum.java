class Solution {
    public static boolean pathSum(TreeNode node, int target) {
        // edge case
        if (node == null) {
            return false;
        }

        if (target - node.val == 0 && node.left == null && node.right == null) {
            return true;
        }

        return pathSum(node.left, target - node.val) || pathSum(node.right, target - node.val);
    }
}

// time: O(n)
// space: O(n)

/*
given: binary tree and target sum

return true if there's a root-to-leaf path
such that the sum of the values equals the target

     5
   4     8                9
 11    13  4
7  2
target = 22

return true

tree
DFS since going root-to-leaf
recursion

edge case:
if node == null then return false;




if (target - node.val == 0 && (node.left == null || node.right == null)) {
return true

return pathSum(node.left, target - node.val) || pathSum(node.right - node.val);
*/