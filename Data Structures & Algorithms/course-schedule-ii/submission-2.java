class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int i = 0, j = 0, cnt = 0;
        Queue<Integer> q = new LinkedList<>();
        int[] indegree = new int[numCourses];
        int[] ans = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] arr : prerequisites) {
            int a = arr[0];
            int b = arr[1];

            indegree[a]++;
            map.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
        }

        for (i = 0 ; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
                cnt++;
                ans[j++] = i;
            }
        }

        while (!q.isEmpty()) {
            int top = q.poll();

            if (map.containsKey(top)) {
                for (Integer n : map.get(top)) {
                    indegree[n]--;

                    if (indegree[n] == 0) {
                        q.add(n);
                        cnt++;
                        ans[j++] = n;
                    }
                }
            }
        }

        if (cnt == 0 || cnt < numCourses) {
            return new int[0];
        }

        return ans;
    }
}
