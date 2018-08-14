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
        int a1[] = {};
        int a2[] = {1};
        System.out.println(intersect(a1, a2));
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

}
