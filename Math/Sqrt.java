package shuati.Math;

/**
 * Implement int sqrt(int x).

 Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

 Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
 */
public class Sqrt {
  public int sqrt(int n) {
    if (n == 0 || n == 1) {
      return n;
    }

    int left = 1;
    int right = Integer.MAX_VALUE;
    while (true) {
      int mid = left + (right - left) / 2;
      if (mid > n / mid) {
        right = mid - 1;
      } else {
        if (mid + 1 > n / (mid + 1)) {
          return mid;
        } else {
          left = mid - 1;
        }
      }
    }
  }
}
