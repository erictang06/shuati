package shuati.Matrix;

/**
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
 * find the area of largest rectangle in the histogram.
 */
public class LargestHistogram {

//  https://leetcode.com/problems/largest-rectangle-in-histogram/discuss/28902/5ms-O(n)-Java-solution-explained-(beats-96)

  public int largestRectangleArea(int[] heights) {
    if (heights == null || heights.length == 0) {
      return 0;
    }

    int maxArea = 0;
    for (int i = 0; i < heights.length; i++) {
      int left = i;
      while (left >= 0 && heights[left] >= heights[i]) {
        left--;
      }
      int right = i;
      while (right < heights.length && heights[right] >= heights[i]) {
        right++;
      }
      int curArea = heights[i] * (right - left - 1);
      maxArea = Math.max(curArea, maxArea);
    }

    return maxArea;
  }
}
