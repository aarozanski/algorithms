package Week_14;
import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int k1 = 3;

        System.out.println("Before rotation: " + Arrays.toString(nums1));
        rotate(nums1, k1);
        System.out.println("After rotating " + k1 + " steps: " + Arrays.toString(nums1));

        int[] nums2 = {-1, -100, 3, 99};
        int k2 = 2;

        System.out.println("\nBefore rotation: " + Arrays.toString(nums2));
        rotate(nums2, k2);
        System.out.println("After rotating " + k2 + " steps: " + Arrays.toString(nums2));

        int[] nums3 = {100, 200, 300, 400, 500, 600, 700, 800};
        int k3 = 9;

        System.out.println("\nBefore rotation: " + Arrays.toString(nums3));
        rotate(nums3, k3);
        System.out.println("After rotating " + k3 + " steps: " + Arrays.toString(nums3));
    }

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        reverse(nums, 0, n - 1);     // Step 1: Reverse the whole array
        reverse(nums, 0, k - 1);     // Step 2: Reverse first part
        reverse(nums, k, n - 1);     // Step 3: Reverse second part
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}

