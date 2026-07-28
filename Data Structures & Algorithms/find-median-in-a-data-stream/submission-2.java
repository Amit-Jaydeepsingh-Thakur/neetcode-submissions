class MedianFinder {
    PriorityQueue<Integer> max;
    PriorityQueue<Integer> min;

    public MedianFinder() {
        max = new PriorityQueue<>((a, b) -> (b - a));
        min = new PriorityQueue<>((a, b) -> (a - b));
    }
    
    public void addNum(int num) {

        max.add(num);

        if (max.size() - min.size() > 1 
            || !min.isEmpty() && max.peek() > min.peek()) {
            min.add(max.poll());
        } 
        if (min.size() - max.size() > 1) {
            max.add(min.poll());
        }
    }
    
    public double findMedian() {

        if (min.size() == max.size()) {
            return (double) (min.peek() + max.peek()) / 2.0;
        } else if (min.size() > max.size()) {
            return (double) min.peek();
        } else {
            return (double) max.peek();
        }
        
    }
}
