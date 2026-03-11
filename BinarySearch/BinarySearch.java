package BinarySearch;

public class BinarySearch {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (target == nums[mid])
                return mid;
            else if (target > nums[mid])
                left++;
            else
                right--;
        }
        return -1;
    }
}
