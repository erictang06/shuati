package shuati.Array;

/**
 *
 Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order,
 not the kth distinct element.

 Example 1:
 Input: [3,2,1,5,6,4] and k = 2
 Output: 5
 Example 2:

 Input: [3,2,3,1,2,4,5,5,6] and k = 4
 Output: 4
 Note:
 You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
public class FindKthLargestInUnassortedArray {
//  https://leetcode.com/problems/kth-largest-element-in-an-array/discuss/60312/AC-Clean-QuickSelect-Java-solution-avg.-O(n)-time

  public int findKthLargest(int[] a, int k) {
    int n = a.length;
    int p = quickSelect(a, 0, n - 1, n - k + 1);
    return a[p];
  }

  // return the index of the kth smallest number
  int quickSelect(int[] a, int lo, int hi, int k) {
    // use quick sort's idea
    // put nums that are <= pivot to the left
    // put nums that are  > pivot to the right
    int i = lo, j = hi, pivot = a[hi];
    while (i < j) {
      if (a[i] > pivot) {
        swap(a, i, j - 1);
        j--;
      } else {
        i++;
      }
    }
    swap(a, i, hi);

    // count the nums that are <= pivot from lo
    int m = i - lo + 1;

    // pivot is the one!
    if (m == k) {
      return i;
    } // pivot is too big, so it must be on the left
    else if (m > k) {
      return quickSelect(a, lo, i - 1, k);
    } // pivot is too small, so it must be on the right
    else {
      return quickSelect(a, i + 1, hi, k - m);
    }
  }

  void swap(int[] a, int i, int j) {
    int tmp = a[i];
    a[i] = a[j];
    a[j] = tmp;
  }
}
