// class Solution {
//     public int trap(int[] height) {
//         int leftMax = height[0];
//         int rightMax = height[height.length - 1];

//         int left = 1;
//         int right = height.length - 2;
//         int water = 0;
//         while (left <= right) {
//             if (leftMax <= rightMax) {
//                 water = water + (leftMax - height[left] > 0 ? (leftMax - height[left]) : 0);
//                 leftMax = Math.max(leftMax, height[left]);
//                 left++;
//             } else {
//                 water = water + (rightMax - height[right] > 0 ? (rightMax - height[right]) : 0);
//                 rightMax = Math.max(rightMax, height[right]);
//                 right--;
//             }
//         }
//         return water;
//     }
// }

public class TrappingRainWater {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int l = 0, r = height.length - 1;
        int leftMax = height[l], rightMax = height[r];
        int res = 0;
        while (l < r) {
            if (leftMax < rightMax) {
                l++;
                leftMax = Math.max(leftMax, height[l]);
                res += leftMax - height[l];
            } else {
                r--;
                rightMax = Math.max(rightMax, height[r]);
                res += rightMax - height[r];
            }
        }
        return res;
    }
}
