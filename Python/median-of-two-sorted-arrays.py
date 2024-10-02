from typing import List
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        combined = nums1.extend(nums2)
        nums1 = sorted(nums1)
        size = len(nums1)
        isOdd = size % 2 != 0
        return nums1[int(size/2)] if isOdd else (nums1[int(size/2)] + nums1[int(size/2) - 1])/2 