# Solved (Easy)

class Solution(object):
    def romanToInt(self, s):
        """
        :type s: str
        :rtype: int
        """
        chars = list(s)
        result = 0
        skipOne = False

        for x in range(len(s)):
            if skipOne:
                skipOne = False
                continue
            if chars[x] == 'I':
                if x+1 <= len(chars)-1:
                    if chars[x+1] == 'V':
                        result += 4
                        skipOne = True
                    elif chars[x+1] == "X":
                        result += 9
                        skipOne = True
                    else:
                        result += 1
                else:
                    result += 1

            elif chars[x] == 'V':
                result += 5

            elif chars[x] == 'X':
                if x + 1 <= len(chars) - 1:
                    if chars[x + 1] == 'L':
                        result += 40
                        skipOne = True
                    elif chars[x + 1] == "C":
                        result += 90
                        skipOne = True
                    else:
                        result += 10
                else:
                    result += 10

            elif chars[x] == 'L':
                result += 50

            elif chars[x] == 'C':
                if x + 1 <= len(chars) - 1:
                    if chars[x + 1] == 'D':
                        result += 400
                        skipOne = True
                    elif chars[x + 1] == "M":
                        result += 900
                        skipOne = True
                    else:
                        result += 100
                else:
                    result += 100

            elif chars[x] == 'D':
                result += 500

            elif chars[x] == 'M':
                result += 1000

        return result


s = "MCMXCIV"

print(Solution().romanToInt(s))