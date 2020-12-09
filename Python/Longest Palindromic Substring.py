#Solved
class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """

        longest = [s[0], 1]

        endIndex = len(s)-1

        for x in range(endIndex): #endIndex +1 -1 because at last index best we can do is length 1.
            if (endIndex - x) + 1 <= longest[1]:
                print(longest[1])
                return longest[0]
            for y in range(endIndex - x): #same logic as above
                left = x
                right = endIndex - y

                subS = s[left:right+1]
                subInversed = subS[::-1]

                if subS == subInversed:
                    length = (right - left)+1
                    if length > longest[1]:
                        longest = [subS, length]

        print(longest[1])
        return longest[0]



string = "ababb"
print(Solution().longestPalindrome(string))