class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int i = 0, j = 0, area = 0;

        for (i = 0; i < grid.length; i++) {
            for (j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    area = Math.max(area, solve(i, j, grid));
                }
            }
        }

        return area;
    }

    private int solve(int i, int j, int[][] grid) {
        if (grid[i][j] == 0 || grid[i][j] == 2) {
            return 0;
        }

        int ans = 0;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> q = new LinkedList<>();

        grid[i][j] = 2;
        q.add(new int[]{i, j});

        while (!q.isEmpty()) {
            int[] top = q.poll();

            int x = top[0];
            int y = top[1];

            for (int[] dir : dirs) {
                int r = dir[0] + x;
                int c = dir[1] + y;

                if (r < 0 || c < 0 || r >= grid.length 
                    || c >= grid[0].length || grid[r][c] == 0 || grid[r][c] == 2) {
                    continue;
                }

                q.add(new int[]{r, c});
                grid[r][c] = 2;
                ans++;
            }
        }

        return ans + 1;

    }
}
