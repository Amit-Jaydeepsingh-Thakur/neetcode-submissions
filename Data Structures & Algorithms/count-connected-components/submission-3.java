class Solution {
    public int countComponents(int n, int[][] edges) {
        int i = 0, j = 0, ans = 0;
        int[] parent = new int[n];
        int[] size = new int[n];

        for (i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int[] edge : edges) {
            union(edge[0], edge[1], parent, size);
        }

        Set<Integer> set = new HashSet<>();

        for (i = 0; i < n; i++) {
            set.add(findParent(i, parent));
        }

        return set.size();
    }

    private int findParent(int node, int[] parent) {
        if (node == parent[node]) {
            return node;
        }

        return parent[node] = findParent(parent[node], parent);
    }

    private void union(int u, int v, int[] parent, int[] size) {
        int up = findParent(u, parent);
        int vp = findParent(v, parent);

        if (up == vp) {
            return;
        }

        if (size[up] > size[vp]) {
            size[up] += size[vp];
            parent[vp] = up;
        } else {
            size[vp] += size[up];
            parent[up] = vp;
        }
    }
}
