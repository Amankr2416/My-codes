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
 public class BSTIterator{
        private Stack<TreeNode> stack=new Stack<TreeNode>();
        boolean reverse;
        public  BSTIterator(TreeNode root,boolean isReverse){
            reverse=isReverse;
            pushAll(root);
        }
        public boolean hasNext(){
         return !stack.isEmpty();
        }
        public int next(){
            TreeNode tempnode=stack.pop();
            if(reverse==false) pushAll(tempnode.right);
            else pushAll(tempnode.left);
            return tempnode.val;
        }
        private void pushAll(TreeNode node){
            while(node!=null){
                stack.push(node);
                if(reverse==true){
                    node=node.right;
                }
                else{
                    node=node.left;
                }
            }
        }
    }
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        BSTIterator left = new BSTIterator(root, false); // smallest
        BSTIterator right = new BSTIterator(root, true); // largest

        int i = left.next();
        int j = right.next();

        while (i < j) {
            int sum = i + j;
            if (sum == k) return true;
            else if (sum < k) i = left.next();
            else j = right.next();
        }
        return false;
    }
}
