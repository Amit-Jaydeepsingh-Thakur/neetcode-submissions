class Solution {
    public int minimumEffortPath(int[][] heights) {
        int i = 0, j = 0;
        int[][] dirs = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        int[][] dist = new int[heights.length][heights[0].length];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[2] - b[2]));

        for (i = 0 ; i < heights.length; i++) {
            for (j = 0; j < heights[0].length; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        dist[0][0] = 0;

        pq.add(new int[]{0, 0, 0});

        while (!pq.isEmpty()) {
            int[] top = pq.poll();

            int x = top[0];
            int y = top[1];
            int effort = top[2];

            if (x == heights.length - 1 && y == heights[0].length - 1) {
                return effort;
            }

            for (int[] dir : dirs) {
                int r = x + dir[0];
                int c = y + dir[1];

                if (r < 0 || c < 0 || r >= heights.length || c >= heights[0].length) {
                    continue;
                }

                int newEffort = Math.abs(heights[r][c] - heights[x][y]);
                int comp = Math.max(newEffort, effort);

                if (comp < dist[r][c]) {
                    dist[r][c] = comp;
                    pq.add(new int[]{r, c, comp});
                }
            }
        }


        return 0;
    }
}