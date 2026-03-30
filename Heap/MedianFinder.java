package Heap;

import java.util.PriorityQueue;

class MedianFinder {
    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;

    public MedianFinder() {
        small = new PriorityQueue<>((a, b) -> b - a);
        large = new PriorityQueue<>((a, b) -> a - b);
    }

    public void addNum(int num) {
        if (large.size() != 0 && large.peek() < num) {
            large.offer(num);
        } else {
            small.offer(num);
        }
        int diff = Math.abs(large.size() - small.size());
        if (diff > 1) {
            if (large.size() > small.size())
                small.offer(large.remove());
            else
                large.offer(small.remove());
        }
    }

    public double findMedian() {
        if (large.size() > small.size()) {
            return large.peek();
        } else if (small.size() > large.size())
            return small.peek();
        else
            return (large.peek() + small.peek()) / (double) 2;
    }
}
