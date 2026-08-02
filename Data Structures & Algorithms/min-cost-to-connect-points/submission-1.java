class Solution {
    public int minCostConnectPoints(int[][] points) {
        int i = 0, j = 0, n = points.length, ans = 0;
        int[] parent = new int[n];
        int[] size = new int[n];

        for (i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        List<int[]> list = new ArrayList<>();

        for (i = 0; i < points.length; i++) {
            for (j = i + 1; j < points.length; j++) {
                int dist = Math.abs(points[i][0] - points[j][0]) + 
                            Math.abs(points[i][1] - points[j][1]);

                list.add(new int[]{i, j, dist});
            }
        }

        Collections.sort(list, (a, b) -> (a[2] - b[2]));

        for (int[] edge : list) {
            if (union(edge[0], edge[1], parent, size)) {
                ans += edge[2];
            }
        }

        return ans;
    }

    private int findParent(int node, int[] parent) {
        if (node == parent[node]) {
            return node;
        }

        return parent[node] = findParent(parent[node], parent);
    }

    private boolean union(int u, int v, int[] parent, int[] size) {
        int up = findParent(u, parent);
        int vp = findParent(v, parent);

        if (up == vp) {
            return false;
        }

        if (size[up] < size[vp]) {
            size[vp] += size[up];
            parent[up] = vp;
        } else {
            size[up] += size[vp];
            parent[vp] = up;
        }

        return true;
    }
}
