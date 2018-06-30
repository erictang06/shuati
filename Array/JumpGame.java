package shuati.Array;

import java.util.ArrayList;
import java.util.List;


public class JumpGame {
  /**
   * Given an array of non-negative integers, you are initially positioned at the first index of the array.
   Each element in the array represents your maximum jump length at that position.
   Determine if you are able to reach the last index.
   Example 1:
   Input: [2,3,1,1,4]
   Output: true
   Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
   */

  public boolean canJump(int[] nums) {
    // f(i) = max{f(i-1), i+f(i)}
    int len = nums.length;
    int i = 0;
    for (int maxReach = 0; i < len && i <= maxReach; i++) {
      maxReach = Math.max(maxReach, i + nums[i]);
    }

    return i == len;
  }

  // jump 2
  // Your goal is to reach the last index in the minimum number of jumps.
  /*
  I try to change this problem to a BFS problem, where nodes in level i are all the nodes that can be reached in i-1th jump.
  for example. 2 3 1 1 4 , is
      2||
      3 1||
      1 4 ||
  clearly, the minimum jump of 4 is 2 since 4 is in level 3. my ac code.
   */

  int jump2(int A[], int n) {
    if (n < 2) {
      return 0;
    }
    int level = 0, currentMax = 0, i = 0, nextMax = 0;

    while (currentMax - i + 1 > 0) {    //nodes count of current level>0
      level++;
      for (; i <= currentMax; i++) {  //traverse current level , and update the max reach of next level
        nextMax = Math.max(nextMax, A[i] + i);
        if (nextMax >= n - 1) {
          return level;   // if last element is in level+1,  then the min jump=level
        }
      }
      currentMax = nextMax;
    }

    return 0;
  }
}
