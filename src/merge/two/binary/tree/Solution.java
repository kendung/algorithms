package merge.two.binary.tree;

/**
 * Created by xudeng on 7/14/17.
 */
public class Solution {

    private TreeNode newRoot = null;

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null){
            return null;
        }
        TreeNode parent = null;
        recursiveMerge(parent, t1, t2, -1);
        return newRoot;
    }

    /**
     *
     * @param parent
     * @param t1
     * @param t2
     * @param child if child = 0, it means left tree merge. If child = 1, it means right tree merge
     *              if child = -1, it means root node of two trees just merge
     */
    public void recursiveMerge(TreeNode parent, TreeNode t1, TreeNode t2, int child){
        if (t1 != null && t2 != null){
            if (child == -1){
                this.newRoot = new TreeNode(t1.val + t2.val);
                parent = this.newRoot;
            }else if (child == 0){
                parent.left = t1;
                t1.val = t1.val + t2.val;
                parent = t1;
            }else if (child == 1){
                parent.right = t1;
                t1.val = t1.val + t2.val;
                parent = t1;
            }
            recursiveMerge(parent, t1.left, t2.left, 0);
            recursiveMerge(parent, t1.right, t2.right, 1);
        }
        if (t1 != null && t2 == null){
            if (child == -1){
                this.newRoot = t1;
                parent = this.newRoot;
            }else if (child == 0){
                parent.left = t1;
            }else if (child == 1){
                parent.right = t1;
            }
        }
        if (t1 == null && t2 != null){
            if (child == -1){
                this.newRoot = t2;
                parent = this.newRoot;
            }else if (child == 0){
                parent.left = t2;
            }else if (child == 1){
                parent.right = t2;
            }
        }
    }
}
