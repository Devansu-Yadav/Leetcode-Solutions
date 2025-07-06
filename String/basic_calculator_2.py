# question: https://leetcode.com/problems/basic-calculator-ii/
# TC: O(N), SC: O(1)

class Solution(object):
    def calculate(self, s):
        """
        :type s: str
        :rtype: int
        """
        i = 0

        curr = 0
        prev = 0
        out = 0

        curr_op = '+'

        while i < len(s):
            char = s[i]

            if char.isdigit():
                while i < len(s) and s[i].isdigit():
                    curr = curr * 10 + int(s[i])
                    i+=1
                
                i-=1

                if curr_op == '+':
                    out += curr

                    prev = curr
                elif curr_op == '-':
                    out -= curr

                    prev = -curr
                elif curr_op == '*':
                    out -= prev
                    out += prev * curr

                    prev = prev * curr
                else:
                    out -= prev
                    out += int(float(prev) / curr)
                    
                    prev = int(float(prev) / curr)

                curr = 0
            elif char != ' ':
                curr_op = char
            
            i+=1
        return out