package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Micheal on 2018/8/14.
 */
public class Test {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);


        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

    }


    /**
     * 翻转链表
     *
     * @param node
     * @return
     */
    public ListNode reverseList(ListNode node) {
        ListNode pre = null;
        ListNode now = node;
        while (now != null) {
            ListNode next = now.next;
            now.next = pre;

            pre = now;
            now = next;
        }
        return pre;
    }


    public static void print(ListNode listNode) {
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }


    public static ListNode mergeTwoLists(ListNode node1, ListNode node2) {
        if (node1 == null) return node2;
        if (node2 == null) return node1;
        ListNode list0 = null;
        if (node1.val < node2.val) {
            list0 = node1;
            list0.next = mergeTwoLists(node1.next, node2);
        } else {
            list0 = node2;
            list0.next = mergeTwoLists(node1, node2.next);
        }
        return list0;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        ListNode q = head;
        for (int i = 0; i < n; i++) {
            p = p.next;//p先移动
        }
        if (p == null) {
            head = head.next;
            return head;
        }
        while (p.next != null) {
            p = p.next;
            q = q.next;
        }
        q.next = q.next.next;
        return head;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        list.add(root.val);
        result.add(list);
        while (root != null) {
            TreeNode left = root.left;
            TreeNode right = root.right;
        }
        return null;
    }


    public static int maxDepth(TreeNode root) {
        return root == null ? 0 : (1 + Math.max(maxDepth(root.left), maxDepth(root.right)));
    }

    public static void rotate(int[][] matrix) {

        int length = matrix.length;

        // 调换对角元素
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[length - j - 1][length - i - 1];
                matrix[length - j - 1][length - i - 1] = tmp;
            }
        }

        // 调换列元素
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length / 2; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[length - j - 1][i];
                matrix[length - j - 1][i] = tmp;
            }
        }
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums1.length; i++) {
            Integer v = map.get(nums1[i]);
            map.put(nums1[i], v == null ? 1 : (v + 1));
        }
        for (int j = 0; j < nums2.length; j++) {
            // judge whether contains key
            if (map.containsKey(nums2[j]) && map.get(nums2[j]) != 0) {
                list.add(nums2[j]);
                map.put(nums2[j], map.get(nums2[j]) - 1);
            }
        }
        int[] result = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            result[k] = list.get(k);
        }
        return result;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
