function findMedianSortedArrays(nums1: number[], nums2: number[]): number {
    const combinedSort = [...nums1, ...nums2].sort((a, b) => a - b);
    const size = combinedSort.length;
    const isOdd:boolean = combinedSort.length % 2 !== 0;
    const median:number = isOdd ? combinedSort[Math.round(size/2 - 1)]: (combinedSort[size/2 - 1] + combinedSort[size/2])/2;
    return median;
};