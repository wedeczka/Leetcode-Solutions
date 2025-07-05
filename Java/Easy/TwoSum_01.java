
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

class TwoSum_01 {

    public static void main(String[] args) {
        int[] nums = {3,3};
        System.out.println(Arrays.toString(twoSum(nums, 6)));
        System.out.println(Arrays.toString(twoSumv1(nums, 6)));
        System.out.println(Arrays.toString(twoSumv2(nums, 6)));
        System.out.println(Arrays.toString(twoSumv3(nums, 6)));
        System.out.println(Arrays.toString(twoSumv3Upgraded(nums, 6)));
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
        //Another solution for this problem is using two pointers (on the start of the array and second on the another end)
        //First we need to sort our array

        // Instead of sorting the original array, we build a new array of pairs [value, original index] , without that is impossible to get the right answer, it means 
        //that we actually can give the right position of the COPY array but it will be marked as wrong answer
        int[][] pairs = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            pairs[i][0] = nums[i]; // value
            pairs[i][1] = i;       // original index
            //
            // |value|index| if there is 4 values we have a matrix 4x2, if there is 100 values we have a matrix 100x2 always |value|original index|
        }
        //It thats O(n) time and memory complexity (in this solution it is needed!)

        //sort is O(nlogn) because it uses quickSort with medium between integers so it it always O(nlogn) complexity     
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[0]));

        int pointerRight = pairs.length - 1;
        for (int i = 0; i < pairs.length;) {
            int help = pairs[i][0] + pairs[pointerRight][0];
            if (help == target) {
                return new int[]{pairs[i][1], pairs[pointerRight][1]};
                //is the two numbers equals the target is the end we find what we wanted
            } else if (help > target) {
                pointerRight--;
                //if the sum is higher than the target thats means we have to add smaller numbers so we decrement right pointer to take smaller numbers
            } else {
                i++;
                // if the sum is lower than the target thats means we have to add higher numbers so we increment left pointer to take higher numbers
            }
        }
        return null;
        //So in the end we have O(n) + O(nlogn) so the time complexity is O(nlogn) better that use of brute force but worse than HashMap
    }

    public static int[] twoSumv3(int[] nums, int target) {
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

    public static int[] twoSumv3Upgraded(int[] nums, int target) {
        //the same solution as the twoSumv2 but with less memory used
        HashMap<Integer, Integer> numbers = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int help = target - nums[i];
            if (numbers.containsKey(help)) {
                return new int[]{numbers.get(help), i};
            }
            numbers.put(nums[i], i);
        }
        return null;
    }

}
