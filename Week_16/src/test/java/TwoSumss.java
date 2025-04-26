import java.util.HashMap;

public class TwoSumss {


    public static void main(String[] args) {
        TwoSumss sums = new TwoSumss();
        int [] result = sums.twoSums(new int[] {3,5,7,9,8}, 17);
        System.out.println("Indices: " + result[0] + " : " + result[1]);

    }

    public int [] twoSums(int [] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for ( int i = 0; i < nums.length; i ++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)){
                return new int [] {map.get(complement), i};
            }
            map.put(nums[i], i);
        }

        return new int[0];
    }

}