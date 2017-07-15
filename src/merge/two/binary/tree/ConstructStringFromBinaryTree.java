package merge.two.binary.tree;

/**
 * Created by xudeng on 7/15/17.
 */
public class ConstructStringFromBinaryTree {

    private StringBuffer sb = new StringBuffer();

    public String tree2str(TreeNode t) {
        recursive(t);
        return sb.toString();
    }

    public void recursive(TreeNode t){
        if (t != null){
            sb.append(t.val);
            if (t.left != null){
                sb.append("(");
                recursive(t.left);
                sb.append(")");
            }else if (t.right != null){
                sb.append("()");
            }
            // append right
            if (t.right != null){
                sb.append("(");
                recursive(t.right);
                sb.append(")");
            }
        }
    }
}


