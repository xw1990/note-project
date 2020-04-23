package tree;

import java.util.LinkedList;
import java.util.List;

/**
 * Description:
 *
 * @author liuwuchao
 * @date 2020/4/23-3:53 PM
 */
public class TreeOrder {
    public static void main(String[] args) {

    }




    public static void levelOrder(TreeNode root) {
        TreeNode node;
        List<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (q.size() != 0){
            node = ((LinkedList<TreeNode>) q).pop();
            System.out.println(node.val);
            if (node.left != null){
                q.add(node.left);
            }
            if (node.right != null){
                q.add(node.right);
            }
        }
    }

}
