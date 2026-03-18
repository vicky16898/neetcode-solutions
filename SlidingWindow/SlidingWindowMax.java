package SlidingWindow;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMax {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];

        int left = 0;
        int counter = 0;
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (dq.size() > 0 && nums[dq.getLast()] < nums[i]) {
                dq.removeLast();
            }
            dq.addLast(i);
            if (left > dq.getFirst())
                dq.removeFirst();
            if (i - left + 1 == k) {
                res[counter] = nums[dq.getFirst()];
                left++;
                counter++;
            }
        }
        return res;
    }
}
