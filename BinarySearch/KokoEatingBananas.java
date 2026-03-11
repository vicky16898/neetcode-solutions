package BinarySearch;

public abstract class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < piles.length; i++) {
            max = Math.max(max, piles[i]);
        }

        int left = 1;
        int right = max;

        while (left <= right) {
            int mid = left - (left - right) / 2;

            double time = 0;
            for (int p : piles) {
                time = time + Math.ceil(p / (double) mid);
            }
            if (time <= h) {
                min = Math.min(min, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return min;
    }
}
