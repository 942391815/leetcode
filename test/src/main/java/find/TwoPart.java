package find;

/**
 * Created by Micheal on 2018/9/8.
 */
public class TwoPart {

    public static void main(String[] args) {
        int nums[] = {2,2};
        int[] aa = aa(nums, 2);
        System.out.println(aa[0]+"----------"+aa[1]);
    }

    public static int[] aa(int[] nums, int target) {
        int result[] = {-1, -1};
        int search = search(nums, target);
        int end = search(nums, target);
        if (search != -1) {
            result[0]=search;
            result[1]=end;
            while (search>=0 && nums[search]==target){
                result[0]=search;
                search--;
            }
            while (end<=nums.length-1 && nums[end]==target){
                result[1]=end;
                end++;
            }
        }
        return result;
    }

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


    public static int[] searchRange(int[] nums, int target) {
        int[] aa = {-1, -1};
        int left = 0;
        int right = nums.length - 1;
        int mid = (left + right) / 2;
        while (left < right) {
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }


        return aa;
    }

    public static int search1(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int st = 0, end = nums.length - 1;
        while (st <= end) {
            int mid = st + (end - st) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] >= nums[st]) {
                if (nums[st] <= target && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    st = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[end]) {
                    st = mid + 1;
                } else {
                    end = mid == 0 ? mid : mid - 1;
                }
            }
        }
        return -1;
    }

    public int guessNumber(int n) {
        int t = guess(n);
        if (t == 0) {
            return n;
        }
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int x = guess(mid);
            if (x == 1) {
                left = mid;
            } else if (x == -1) {
                right = mid;
            } else if (x == 0) {
                return mid;
            }
        }
        return right;
    }

    public int guess(int id) {
        return 0;
    }

    public static int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int start = 0;
        int end = x / 2 + 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (mid * mid > x) {
                end = mid - 1;
            } else if (mid * mid < x) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return end;
    }
}
