package BinarySearch;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] top = null;
        int[] bottom = null;

        if (nums1.length <= nums2.length) {
            bottom = nums1;
            top = nums2;
        } else {
            bottom = nums2;
            top = nums1;
        }

        int left = -1;
        int right = bottom.length - 1;
        int half = (top.length + bottom.length) / 2;
        while (true) {
            int bottomPartition = (left + right) / 2;

            int topPartition = half - (bottomPartition + 1) - 1;

            int bottomLeft = (bottomPartition >= 0) ? bottom[bottomPartition] : Integer.MIN_VALUE;
            int bottomRight = (bottomPartition + 1 < bottom.length) ? bottom[bottomPartition + 1] : Integer.MAX_VALUE;

            int topLeft = (topPartition >= 0) ? top[topPartition] : Integer.MIN_VALUE;
            int topRight = (topPartition + 1 < top.length) ? top[topPartition + 1] : Integer.MAX_VALUE;

            if (topLeft <= bottomRight && bottomLeft <= topRight) {
                double res = 0;
                if ((bottom.length + top.length) % 2 == 0) {
                    res = (Math.max(bottomLeft, topLeft) + Math.min(bottomRight, topRight)) / (double) 2;
                } else {
                    res = Math.min(bottomRight, topRight);
                }
                return res;
            } else {
                if (topLeft > bottomRight) {
                    left = bottomPartition + 1;
                }

                if (bottomLeft > topRight) {
                    right = bottomPartition - 1;
                }
            }

        }
    }
}
