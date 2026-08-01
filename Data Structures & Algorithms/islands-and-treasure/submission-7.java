class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int i = 0, j = 0;

        for (i = 0; i < grid.length; i++) {
            for (j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == Integer.MAX_VALUE) {
                    solve(i, j, grid);
                }
            }
        }
    }

    private void solve(int i, int j, int[][] grid) {

        // if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
        //     return;
        // }

        int size = 0;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        q.add(new int[]{i, j, 0});
        vis[i][j] = true;

        while (!q.isEmpty()) {
            int[] top = q.poll();
            int x = top[0];
            int y = top[1];
            int dist = top[2];

            if (grid[x][y] == 0) {
                grid[i][j] = dist;
                return;
            }

            for (int[] dir : dirs) {
                int r = dir[0] + x;
                int c = dir[1] + y;

                if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == -1 || vis[r][c] == true) {
                continue;
            }

                q.add(new int[]{r, c, dist + 1});
                vis[r][c] = true;
            }            
        }
    }
}
