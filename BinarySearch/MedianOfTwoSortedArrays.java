package BinarySearch;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] leftArray = null;
        int[] rightArray = null;

        if (nums1.length <= nums2.length) {
            leftArray = nums1;
            rightArray = nums2;
        } else {
            leftArray = nums2;
            rightArray = nums1;
        }
        double res = 0;
        int left = -1;
        int right = leftArray.length - 1;
        int half = (nums1.length + nums2.length) / 2;
        while (left <= right) {
            int mid = left - (left - right) / 2;

            int leftArrayPartition = mid;
            int rightArrayPartition = half - (mid + 1) - 1;

            int leftArrayEnd = leftArrayPartition >= 0 ? leftArray[leftArrayPartition] : Integer.MIN_VALUE;
            int rightArrayEnd = rightArrayPartition >= 0 ? rightArray[rightArrayPartition] : Integer.MIN_VALUE;
            int leftArrayStart = leftArrayPartition + 1 < leftArray.length ? leftArray[leftArrayPartition + 1]
                    : Integer.MAX_VALUE;
            int rightArrayStart = rightArrayPartition + 1 < rightArray.length ? rightArray[rightArrayPartition + 1]
                    : Integer.MAX_VALUE;

            if (leftArrayEnd <= rightArrayStart && rightArrayEnd <= leftArrayStart) {
                if ((nums1.length + nums2.length) % 2 == 0) {
                    res = (Math.max(leftArrayEnd, rightArrayEnd) + Math.min(leftArrayStart, rightArrayStart))
                            / (double) 2;
                } else {
                    res = Math.min(leftArrayStart, rightArrayStart);
                }
                return res;
            } else {
                if (leftArrayEnd > rightArrayStart) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

            }

        }
        return res;
    }
}
