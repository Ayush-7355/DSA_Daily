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
class Solution{
    public TreeNode constructMaximumBinaryTree(int[] nums){
        return build(nums,0,nums.length-1);
    }
    private TreeNode build(int[] nums,int l,int n){
        if(l>n) return null;

        int maxIndex=l;
        for(int i=l;i<=n;i++){
            if(nums[i]>nums[maxIndex]){
                maxIndex=i;
            }
        }

        TreeNode root=new TreeNode(nums[maxIndex]);

        root.left=build(nums,l,maxIndex-1);
        root.right=build(nums,maxIndex+1,n);

        return root;
    }
}