import java.util.*;

class Solution {
    private int[] minVal;
    private int[] maxVal;
    private int[] lazy;
    private int n;

    // Renamed method to match the driver's expectation
    public int longestBalanced(int[] nums) {
        n = nums.length;
        minVal = new int[4 * n];
        maxVal = new int[4 * n];
        lazy = new int[4 * n];
        
        Map<Integer, Integer> lastPos = new HashMap<>();
        int maxLen = 0;

        for (int r = 0; r < n; r++) {
            int x = nums[r];
            int prev = lastPos.getOrDefault(x, -1);
            
            // Even: +1, Odd: -1
            int val = (x % 2 != 0) ? -1 : 1;

            // Update range [prev + 1, r]
            update(1, 0, n - 1, prev + 1, r, val);

            lastPos.put(x, r);

            // Find smallest L such that subarray nums[L...r] is balanced (sum == 0)
            int l = queryFirstZero(1, 0, n - 1, r);

            if (l != -1) {
                maxLen = Math.max(maxLen, r - l + 1);
            }
        }

        return maxLen;
    }

    private void pushUp(int node) {
        minVal[node] = Math.min(minVal[2 * node], minVal[2 * node + 1]);
        maxVal[node] = Math.max(maxVal[2 * node], maxVal[2 * node + 1]);
    }

    private void pushDown(int node) {
        if (lazy[node] != 0) {
            int lz = lazy[node];
            lazy[2 * node] += lz;
            minVal[2 * node] += lz;
            maxVal[2 * node] += lz;
            
            lazy[2 * node + 1] += lz;
            minVal[2 * node + 1] += lz;
            maxVal[2 * node + 1] += lz;
            
            lazy[node] = 0;
        }
    }

    private void update(int node, int start, int end, int l, int r, int val) {
        if (l <= start && end <= r) {
            minVal[node] += val;
            maxVal[node] += val;
            lazy[node] += val;
            return;
        }
        
        pushDown(node);
        int mid = (start + end) / 2;
        if (l <= mid) update(2 * node, start, mid, l, r, val);
        if (r > mid) update(2 * node + 1, mid + 1, end, l, r, val);
        pushUp(node);
    }

    private int queryFirstZero(int node, int start, int end, int limit) {
        // Pruning: if 0 is not in range [min, max], it doesn't exist here
        if (minVal[node] > 0 || maxVal[node] < 0) return -1;

        if (start == end) return (minVal[node] == 0) ? start : -1;

        pushDown(node);
        int mid = (start + end) / 2;
        int res = -1;

        if (limit >= start) res = queryFirstZero(2 * node, start, mid, limit);
        if (res == -1 && limit > mid) res = queryFirstZero(2 * node + 1, mid + 1, end, limit);

        return res;
    }
}