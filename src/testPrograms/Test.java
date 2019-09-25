package testPrograms;

public class Test {
    public static void main(String[] args) {
        System.out.println(twoSum(new int[] { 3, 2, 4 }, 6));
    }

    public static int[] twoSum(int[] nums, int target) {
        int i, j;
        for (i = 0; i < nums.length; i++) {
            for (j = 0; j < nums.length; j++) {
                if (nums[i] + nums[j] == target && i != j) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] { 0, 0 };
    }
}