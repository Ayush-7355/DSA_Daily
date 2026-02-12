class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];

            for (int j = i; j < n; j++) {
                freq[s.charAt(j) - 'a']++;

                int countNonZero = 0;
                int value = 0;
                boolean balanced = true;

                for (int f : freq) {
                    if (f > 0) {
                        if (value == 0) {
                            value = f;
                        } else if (value != f) {
                            balanced = false;
                            break;
                        }
                        countNonZero++;
                    }
                }

                if (balanced && countNonZero > 0) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }
}
