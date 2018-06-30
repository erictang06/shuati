package shuati.Bits;

/**
 * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.

 Return the quotient after dividing dividend by divisor.

 The integer division should truncate toward zero.
 */
public class DivideTwoIntegers {
  // trick here is that if we use (dividend - divisor), it is going to be O(N)
  // 那么有没有办法优化呢？ 这个我们就得使用位运算。我们知道任何一个整数可以表示成以2的幂为底的一组基的线性组合，
  // 即num=a_0*2^0+a_1*2^1+a_2*2^2+...+a_n*2^n。基于以上这个公式以及左移一位相当于乘以2，我们先让除数左移直到大于被除数之前得到一个最大的基。
  // 然后接下来我们每次尝试减去这个基，如果可以则结果增加加2^k,然后基继续右移迭代，直到基为0为止。因为这个方法的迭代次数是按2的幂直到超过结果，
  // 所以时间复杂度为O(logn)。

  public int divide(int dividend, int divisor) {
    boolean isNeg = false;
    if (dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0) {
      isNeg = true;
    }
    int res = 0;
    if (dividend == Integer.MIN_VALUE) {
      dividend += Math.abs(divisor);
      if (divisor == -1) {
        return Integer.MAX_VALUE;
      }
      res++;
    }
    if (divisor == Integer.MIN_VALUE) {
      return res;
    }
    dividend = Math.abs(dividend);
    divisor = Math.abs(divisor);
    int digit = 0;
    while (divisor <= (dividend >> 1)) {
      divisor <<= 1;
      digit++;
    }
    while (digit >= 0) {
      if (dividend >= divisor) {
        res += 1 << digit;
        dividend -= divisor;
      }
      divisor >>= 1;
      digit--;
    }
    return isNeg ? -res : res;
  }
}
