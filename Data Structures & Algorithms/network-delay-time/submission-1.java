class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int i = 0, j = 0, ans = Integer.MAX_VALUE;
        Map<Integer, List<int[]>> map = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        int[] dist = new int[n + 1];

        for (i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        for (int[] time : times) {
            int src = time[0];
            int dest = time[1];
            int t = time[2];

            map.computeIfAbsent(src, m -> new ArrayList<>()).add(new int[]{dest, t});
        }

        dist[k] = 0;

        pq.add(new int[]{k, 0});

        while (!pq.isEmpty()) {
            int[] top = pq.poll();

            int node = top[0];
            int t = top[1];

            if (map.containsKey(node)) {
                for (int[] ele : map.get(node)) {
                    int dest = ele[0];
                    int cost = ele[1];

                    if (t + cost < dist[dest]) {

                        System.out.println((t + cost) + " " + dist[dest]);
                        dist[dest] = t + cost;
                        pq.add(new int[]{dest, dist[dest]});
                    }
                }
            }
        }

        ans = 0;
        for (i = 1; i < dist.length; i++) {
            // if (i == k) {
            //     continue;
            // }
            System.out.println(dist[i] + " " + ans);
            ans = Math.max(ans, dist[i]);
        }

        return (ans == Integer.MAX_VALUE) ? -1 : ans;
         
    }
}
