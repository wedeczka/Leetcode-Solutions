
import java.util.Arrays;
import java.util.HashMap;

class TwoSum {

    public static void main(String[] args) {
        int[] nums = {3,3};
        System.out.println(Arrays.toString(twoSum(nums, 6)));
        System.out.println(Arrays.toString(twoSumv1(nums, 6)));
        System.out.println(Arrays.toString(twoSumv2(nums, 6)));
    }

    public static int[] twoSum(int[] nums, int target) {
        //The easiest way is to do brute force by using two loops 
        // in this scenario time complexity is O(n^2)
        // The memory complexity is O(1) because only a constant-size array (length 2) is created for the result.
        // No additional data structures are used, and the memory usage does not depend on the input size.
        // Therefore, the space complexity remains constant regardless of the number of elements in the input array.
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; i < j; j--) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }

            }

        }
        return null;
    }

    public static int[] twoSumv1(int[] nums, int target) {
        //Still time complexity O(n^2) but more classic loop way,
        // The memory complexity is O(1) because only a constant-size array (length 2) is created for the result.
        // No additional data structures are used, and the memory usage does not depend on the input size.
        // Therefore, the space complexity remains constant regardless of the number of elements in the input array.
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static int[] twoSumv2(int[] nums, int target) {
        HashMap<Integer, Integer> numbers = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numbers.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (numbers.containsKey(target - nums[i]) && numbers.get(target - nums[i]) != i) {
                // Time complexity is now O(n) because we traverse the array once to build the map and again to check for complements.
                // O(n) + O(n) simplifies to O(n).
                // However, this can still be optimized by combining both steps into a single loop,
                return new int[]{i, numbers.get(target - nums[i])};
            }
        }
        return null;
    }

}

