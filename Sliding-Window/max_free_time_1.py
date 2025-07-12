# link to problem: https://leetcode.com/problems/reschedule-meetings-for-maximum-free-time-i/description/?envType=daily-question&envId=2025-07-09
# Solution explanation: https://youtu.be/D1byzYlG0Js?si=r3_U49EfYB0lq1TK
# TC: O(n), SC: O(n)

class Solution(object):
    def maxFreeTime(self, eventTime, k, startTime, endTime):
        """
        :type eventTime: int
        :type k: int
        :type startTime: List[int]
        :type endTime: List[int]
        :rtype: int
        """
        if endTime[-1] < eventTime:
            startTime.append(eventTime)
            endTime.append(eventTime)
        
        win_sum = max_sum = 0
        last_end = 0

        dq = collections.deque([])

        for i in range(len(startTime)):
            gap = startTime[i] - last_end
            dq.append(gap)
            win_sum += gap
            max_sum = max(max_sum, win_sum)

            while len(dq) > k:
                win_sum -= dq.popleft()
            
            last_end = endTime[i]
        return max_sum