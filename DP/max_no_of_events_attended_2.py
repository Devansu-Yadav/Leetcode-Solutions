# link to problem: https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended-ii/description/?envType=daily-question&envId=2025-07-08
# TC: Using plain Recursion and binary search: O(2^n * log(n))
# TC: Using DP and binary search: O(n*k*log(n)), SC: O(n*k)

class Solution(object):
    def maxValue(self, events, k):
        """
        :type events: List[List[int]]
        :type k: int
        :rtype: int
        """
        n = len(events)
        dp = [[-1 for i in range(k + 1)] for j in range(n)]
        sorted_events = sorted(events, key=lambda event: (event[0], event[1]))
        print(sorted_events)

        return self.helper(sorted_events, dp, 0, n, k)
    
    def helper(self, events, dp, pos, n, k):
        if(pos >= n or k == 0):
            return 0

        if(dp[pos][k] > -1):
            return dp[pos][k]

        next_pos = self.search_next_event(events, pos, n)
        select = events[pos][2] + self.helper(events, dp, next_pos, n, k-1)
        reject = self.helper(events, dp, pos + 1, n, k)
        dp[pos][k] = max(select, reject)

        return dp[pos][k]
    
    def search_next_event(self, events, pos, n):
        end_day = events[pos][1]
        pos+=1

        while(pos < n):
            mid = pos + (n - pos) / 2

            if(events[mid][0] > end_day):
                n = mid
            else:
                pos = mid + 1
        return n

        