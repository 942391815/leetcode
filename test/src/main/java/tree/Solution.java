package tree;


import java.util.*;

/**
 * Created by Micheal on 2018/9/10.
 */
public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        TreeNode right_left = new TreeNode(15);
        TreeNode right_right = new TreeNode(7);
        root.left = left;
        root.right = right;
        right.left = right_left;
        right.right = right_right;
//        levelFirst(root);
//        first(root);
//        middle(root);
        after(root);
//        afterRe(root);
//        levelOrder1(root);
//        levelWithNo(root);
//        postorder(root);
    }

    public static void levelWithNo(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        TreeNode last = root;
        TreeNode nlast = root;

        while (!queue.isEmpty()) {
            TreeNode t = queue.poll();
            System.out.print(t.val+"\t");
            if (t.left != null) {
                queue.add(t.left);
                nlast = t.left;
            }
            if (t.right != null) {
                queue.add(t.right);
                nlast = t.right;
            }
            if (last == t) {
                System.out.println();
                last = nlast;
            }
        }
    }

    public static void levelFirst(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        list.add(root);
        while (list.size() > 0) {
            TreeNode peek = list.poll();
            if (peek != null) {
                System.out.println(peek.val);
                list.add(peek.left);
                list.add(peek.right);
            }
        }
    }

    protected static void postorder(TreeNode p) {
        if (p != null) {
            postorder(p.left);
            postorder(p.right);
            System.out.println(p.val);
        }
    }

    public static void afterRe(TreeNode p) {
        if (p != null) {
            after(p.left);
            after(p.right);
            System.out.println(p.val);
        }
    }

    public static void after(TreeNode p) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = p;
        TreeNode pre = p;
        while (node != null || stack.size() > 0) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (stack.size() > 0) {
                TreeNode temp = stack.peek().right;
                if (temp == null || temp == pre) {
                    node = stack.pop();
                    System.out.println(node.val);
                    pre = node;
                    node = null;
                } else {
                    node = temp;
                }
            }
        }

    }

    public static void middle(TreeNode root) {
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode p = root;
        do {
            while (p != null) {
                s.push(p);
                p = p.left;
            }
            p = s.pop();
            System.out.println(p.val);
            if (p.right != null) {
                p = p.right;
            } else {
                p = null;
            }

        } while (!s.isEmpty() || p != null);
    }

    public static void first(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode p = null;
        while (!stack.isEmpty()) {
            p = stack.pop();
            if (p != null) {
                System.out.println(p.val);
                stack.push(p.right);
                stack.push(p.left);
            }
        }
    }


    /**
     * @param root
     */
    public static void levelOrder1(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode1 = (TreeNode) queue.poll();
                if (treeNode1 != null) {
                    System.out.println(treeNode1.val);
                    System.out.println("----------------------------------------------------");
                    queue.add(treeNode1.left);
                    queue.add(treeNode1.right);
                }
            }
        }
    }

    /**
     * 最大深度
     *
     * @param root
     * @return
     */
    public static int maxDeep(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return 1 + Math.max(maxDeep(root.left), maxDeep(root.right));
    }

    /**
     * 层次遍历
     *
     * @param root
     */
    public static void levelOrderOnly(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        list.add(root);
        while (list.size() > 0) {
            TreeNode node = list.poll();
            System.out.println(node.val);
            if (node.left != null) {
                list.add(node.left);
            }
            if (node.right != null) {
                list.add(node.right);
            }
        }
    }
}
