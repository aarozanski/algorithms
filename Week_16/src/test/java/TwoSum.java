import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] twoSum( int [] nums, int target) {
        Map <Integer, Integer> numbersMap = new HashMap<>();

        for ( int i = 0 ; i < nums.length; i++) {
            int complement = target - nums[i];

            if (numbersMap.containsKey(complement)) {
                return new int [] {numbersMap.get(complement), i };
            }
            numbersMap.put(nums[i], i);
        }

        // in case there is no solution, though the problem statement says there will be one
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int [] numbers1 = { 2, 7, 11 , 15};
        int targetSum1 = 9;
        int [] result1 = twoSum(numbers1, targetSum1);
        System.out.println("[" + result1[0] + ", " + result1[1] + "]");

        int [] numbers2 = { 3, 2 , 4};
        int targetSum2 = 6;
        int [] result2 = twoSum(numbers2, targetSum2);
        System.out.println("[" + result1[0] + ", " + result1[1] + "]");

        int [] numbers3 = { 3, 3};
        int targetSum3 = 6;
        int [] result3 = twoSum(numbers3, targetSum3);
        System.out.println("[" + result1[0] + ", " + result1[1] + "]");

        int [] numbers4 = { 4, 3};
        int targetSum4 = 7;
        int [] result4 = twoSum(numbers4, targetSum4);
        System.out.println("[" + result1[0] + ", " + result1[1] + "]");
    }
}
