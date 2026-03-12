package SlidingWindow;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        int left = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            max = Math.max(max, prices[i] - prices[left]);
            if (prices[i] < prices[left])
                left = i;
        }
        return max;
    }
}
