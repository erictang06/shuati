package shuati.Array;

import static java.lang.Math.*;


public class MedianOfTwoSortedArray {
  // https://leetcode.com/problems/median-of-two-sorted-arrays/discuss/2471/Very-concise-O(log(min(MN)))-iterative-solution-with-detailed-explanation

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int len1 = nums1.length;
    int len2 = nums2.length;

    if (len1 < len2) {
      return findMedianSortedArrays(nums2, nums1);  // Make sure A2 is the shorter one.
    }

    int lo = 0, hi = len2 * 2;
    while (lo <= hi) {
      int mid2 = (lo + hi) / 2;   // Try Cut 2
      int mid1 = len1 + len2 - mid2;  // Calculate Cut 1 accordingly

      double L1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[(mid1 - 1) / 2];  // Get L1, R1, L2, R2 respectively
      double L2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[(mid2 - 1) / 2];
      double R1 = (mid1 == len1 * 2) ? Integer.MAX_VALUE : nums1[(mid1) / 2];
      double R2 = (mid2 == len2 * 2) ? Integer.MAX_VALUE : nums2[(mid2) / 2];

      if (L1 > R2) {
        lo = mid2 + 1;    // A1's lower half is too big; need to move C1 left (C2 right)
      } else if (L2 > R1) {
        hi = mid2 - 1;  // A2's lower half too big; need to move C2 left.
      } else {
        return (max(L1, L2) + min(R1, R2)) / 2;  // Otherwise, that's the right cut.
      }
    }
    return -1;
  }

// https://leetcode.com/problems/median-of-two-sorted-arrays/discuss/2499/Share-my-simple-O(log(m+n))-solution-for-your-reference

  public double findMedianSortedArraysV2(int[] nums1, int[] nums2) {
    int n = nums1.length;
    int m = nums2.length;
    int left = (n + m + 1) / 2;
    int right = (n + m + 2) / 2;
    return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
  }

  private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
    int len1 = end1 - start1 + 1;
    int len2 = end2 - start2 + 1;
    if (len1 > len2) return getKth(nums2, start2, end2, nums1, start1, end1, k);
    if (len1 == 0) return nums2[start2 + k - 1];
    if (k == 1) return Integer.min(nums1[start1], nums2[start2]);

    int i = start1 + Integer.min(len1, k / 2) - 1;
    int j = start2 + Integer.min(len2, k / 2) - 1;
    //Eliminate half of the elements from one of the smaller arrays
    if (nums1[i] > nums2[j]) {
      return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
    }
    else {
      return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
    }
  }

}
