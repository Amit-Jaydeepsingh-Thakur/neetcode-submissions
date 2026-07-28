class Solution {
    public int orangesRotting(int[][] grid) {
        int i = 0, j = 0, mins = 0, fresh = 0, rotten = 0;
        Queue<int[]> q = new LinkedList<>();
        //int[][] vis = new int[n][m];
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (i = 0; i < grid.length; i++) {
            for (j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                } else if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
            }
        }

        if (fresh == 0) {
            return 0;
        }

        while (!q.isEmpty()) {
            int size = q.size();

            for (i = 1; i <= size; i++) {
                int[] top = q.poll();
                int x = top[0];
                int y = top[1];

                for (int[] dir : dirs) {
                    int r = x + dir[0];
                    int c = y + dir[1];

                    if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length
                        || grid[r][c] == 0 || grid[r][c] == 2) {
                            continue;
                        }
                    
                    grid[r][c] = 2;
                    fresh--;
                    q.add(new int[]{r, c});
                }
            }

            mins++;
        }

        return (fresh == 0) ? mins - 1 : -1;
        
    }
}
