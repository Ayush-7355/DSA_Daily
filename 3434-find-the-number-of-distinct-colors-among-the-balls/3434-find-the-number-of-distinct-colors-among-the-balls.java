class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Integer> mp = new HashMap<>();
        Map<Integer, Integer> st = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        int dis = 0;

        for (int[] query : queries) {
            int a = query[0];
            int b = query[1];

            // Lazy initialization of elements in the map , toh in place insertion 
            //and check 
            if (!mp.containsKey(a)) {
                mp.put(a, 0);
            }

            if (mp.get(a) == 0) {
                if (!st.containsKey(b) || st.get(b) == 0) {
                    st.put(b, st.getOrDefault(b, 0) + 1);
                    mp.put(a, b);
                    dis++;
                } else {
                    st.put(b, st.getOrDefault(b, 0) + 1);
                    mp.put(a, b);
                }
            } else {
                int prev = mp.get(a);
                st.put(prev, st.get(prev) - 1);
                if (st.get(prev) == 0) {
                    dis--;
                }

                if (!st.containsKey(b) || st.get(b) == 0) {
                    st.put(b, st.getOrDefault(b, 0) + 1);
                    dis++;
                } else {
                    st.put(b, st.getOrDefault(b, 0) + 1);
                }

                mp.put(a, b);
            }

            res.add(dis);
        }

        // Convert ArrayList to int array
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }

        return result;
    }
}
