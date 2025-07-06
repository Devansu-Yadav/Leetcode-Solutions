# question: https://leetcode.com/problems/basic-calculator/
# TC: O(N), SC: O(1)

class Solution(object):
    def calculate(self, s):
        """
        :type s: str
        :rtype: int
        """
        
        curr = res = 0
        sign = 1

        state = []

        for ch in s:
            if ch.isdigit():
                curr = curr * 10 + int(ch)
            elif ch in ['+', '-']:
                res += sign * curr

                sign = 1 if ch == '+' else -1

                curr = 0
            elif ch == '(':
                state.append(res)
                state.append(sign)

                res = 0

                sign = 1
            elif ch == ')':
                res += sign * curr
                res *= state.pop()

                res += state.pop()

                curr = 0
        
        return res + sign * curr



