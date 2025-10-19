import java.util.Arrays;

public class Solution {
    public static int[] searchRange(int[] nums, int target) {
        int[] output = new int[]{-1, -1};
        if (nums == null || nums.length == 0) return output;

        int firstIndex = lowerBound(nums, target);
        if (firstIndex == nums.length || nums[firstIndex] != target) return output;

        int lastIndex = upperBound(nums, target) - 1;
        output[0] = firstIndex;
        output[1] = lastIndex;
        return output;
    }

    public static int lowerBound(int[] nums, int target) {
        int lo = 0, hi = nums.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] >= target) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    } 

    public static int upperBound(int[] nums, int target) {
        int lo = 0, hi = nums.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > target) hi = mid;
            else lo = mid + 1;    
        }
        return lo;
    }

    public static void main(String[] args) {
        int[] test = new int[]{5,7,7,8,8,10};
        System.out.println(Arrays.toString(searchRange(test, 8)));
    }
}
