/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int room = 1, i = 0, j = 0;
        intervals.sort((a, b) -> (a.start - b.start));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (Interval e : intervals) {
           if (!pq.isEmpty() && pq.peek() <= e.start) {
            pq.poll();
           }

           pq.add(e.end);
        }

        // Interval top = pq.poll();

        // while (!pq.isEmpty()) {
        //     if (!pq.isEmpty() && pq.peek() <= p)
        // }

        return pq.size();

    }
}
