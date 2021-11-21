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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, postorder, postorder.length-1);
    }
    
    public TreeNode build(int[] inorder, int[] postorder,int stt) {
        if(inorder.length == 0)
            return null;
        if(inorder.length == 1)
            return new TreeNode(inorder[0]);
        int idx = -1;
        int rootVal = 0;
        while(idx < 0 && stt > 0) {
            rootVal = postorder[stt];
            idx = get(inorder, rootVal);
            stt--;
        }
        TreeNode node = new TreeNode(rootVal);
        node.left = build(Arrays.copyOfRange(inorder, 0, idx), postorder, stt);
        if(idx+1 < inorder.length)
            node.right = build(Arrays.copyOfRange(inorder, idx+1, inorder.length), postorder, stt);
        return node;
    }
    
    public int get(int[] arr,int value) {
        int k=-1;
        for(int i=0;i<arr.length;i++){

            if(arr[i]==value){
                k=i;
                break;
            }
        }
        return k;
    }
    /*
    Time complexity : O(n^2)
    Space complexity : O(logn)
    */
}