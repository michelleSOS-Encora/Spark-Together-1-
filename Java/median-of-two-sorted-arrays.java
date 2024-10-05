class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int low = 0, high = m;

        while (low <= high) {
            int p1 = (low + high) / 2;
            int p2 = (m + n + 1) / 2 - p1;

            int maxl1 = (p1 == 0) ? Integer.MIN_VALUE : nums1[p1 - 1];
            int minr1 = (p1 == m) ? Integer.MAX_VALUE : nums1[p1];

            int maxl2 = (p2 == 0) ? Integer.MIN_VALUE : nums2[p2 - 1];
            int minr2 = (p2 == n) ? Integer.MAX_VALUE : nums2[p2];

            if (maxl1 <= minr2 && maxl2 <= minr1) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(maxl1, maxl2) + Math.min(minr1, minr2)) / 2.0;
                } else {
                    return Math.max(maxl1, maxl2);
                }
            } else if (maxl1 > minr2) {
                high = p1 - 1;
            } else {
                low = p1 + 1;
            }
        }

        throw new IllegalArgumentException("Arrays are not sorted!");
    }
}
