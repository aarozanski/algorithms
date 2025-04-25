import java.util.HashMap;

public class TwoSums extends TwoSum {

    public static void main(String[] args) {
        TwoSum solution = new TwoSum();
        int[] result = solution.twoSum(new int[]{2, 7, 11, 15}, 13);
        System.out.println("Indices: " + result[0] + ", " + result[1]);
    }

//    public int [] twoSums ( int [] nums, int target){
//        HashMap <Integer, Integer> map = new HashMap<>();
//
//        for ( int i = 0; i< nums.length; i++){
//          int complement = target - nums[i];
//
//          if (map.containsKey(complement)) {
//              return new int [] {map.get(complement), i};
//          }
//          map.put(nums[i], i);
//        }
//        return new int[0];
//    }
}
