class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int i = 0, j = 0, size = 0, level = 0;
        Queue<String> q = new LinkedList<>();
        Set<String> vis = new HashSet<>();

        vis.add(beginWord);
        q.add(beginWord);

        while (!q.isEmpty()) {
            size = q.size();

            for (int k = 1; k <= size; k++) {
                String top = q.poll();

                if (top.equals(endWord)) {
                    return level + 1;
                }

                // if (vis.contains(top)) {
                //     continue;
                // }

                char[] arr = top.toCharArray();

                for (i = 0; i < arr.length; i++) {
                    char org = arr[i];
                    
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        arr[i] = ch;

                        String updated = new String(arr);

                        if (wordList.contains(updated) && !vis.contains(updated)) {
                            vis.add(updated);
                            q.add(updated);
                        }
                    }

                    arr[i] = org;
                }

            }

            level++;
        }

        return 0;
    }
}
