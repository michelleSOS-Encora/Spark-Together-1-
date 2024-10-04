
import re

class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        # Convert string p using regex because it applies the conditions provided
        regex = re.compile(f'^{p}$')
        # Get a boolean if exists a match with the string s
        isMatch = True if regex.match(s) else False 
        return isMatch