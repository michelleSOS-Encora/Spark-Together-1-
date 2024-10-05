class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        cIm={}
        l =0 
        maxl=0 #max length
      #iterates the string length
        for r in range(len(s)):
            if s[r]in cIm and cIm[s[r]]>=l:
                l=cIm[s[r]]+1
            cIm[s[r]]=r
            maxl=max(maxl,r-l+1)
        return maxl
