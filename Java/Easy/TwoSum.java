import java.util.Arrays;

// Your First Program

class TwoSum {

    public static void main(String[] args) {
        int[] nums = {3,3};
        //twoSum(nums,9);
    System.out.println(Arrays.toString(twoSum(nums, 6)));
    }

    public static int[] twoSum(int[] nums, int target)  {
        //The easiest way is to do brute force by using two loops 
        // in this scenario the complexity is O(n^2)
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            for (int j = nums.length - 1; i < j; j--) {
                if (temp + nums[j] == target) {
                    return new int[]{i,j};
                }

            }

        }
        return null;
    }
}
