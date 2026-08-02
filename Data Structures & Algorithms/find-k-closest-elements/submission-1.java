class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int i = 0, j = 0;
        List<Integer> list = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }

            return Integer.compare(a[0], b[0]);
        });
        
        for (int ele : arr) {
            pq.add(new int[]{Math.abs(ele - x), ele});
        }

        while (!pq.isEmpty() && k > 0) {
            list.add(pq.poll()[1]);
            k--;
        }

        Collections.sort(list);

        return list;

    }
}