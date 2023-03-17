package other._0295;

import java.util.PriorityQueue;

class MedianFinder {
    private PriorityQueue<Integer> large;
    private PriorityQueue<Integer> small;
    public MedianFinder() {
        large = new PriorityQueue<>();
        small = new PriorityQueue<>((a, b) -> {
            return b - a;
        });
    }
    public double findMedian() {
        if (large.size() < small.size()) {
            return small.peek();
        }
        else if (large.size() > small.size()) {
            return large.peek();
        }
        return (large.peek() + small.peek()) / 2.0;
    }
    public void addNum(int num) {
        if (small.size() >= large.size()) {
            small.offer(num);
            large.offer(small.poll());
        }
        else {
            large.offer(num);
            small.offer(large.poll());
        }
    }
}