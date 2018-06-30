package shuati.Array;

import java.util.Random;


/**
 * Shuffle a set of numbers without duplicates.

 Example:

 // Init an array with set 1, 2, and 3.
 int[] nums = {1,2,3};
 Solution solution = new Solution(nums);

 // Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
 solution.shuffle();

 // Resets the array back to its original configuration [1,2,3].
 solution.reset();

 // Returns the random shuffling of array [1,2,3].
 solution.shuffle();
 */
public class ShuffleArray {
  private int[] _nums;
  private Random random;

  public ShuffleArray(int[] nums) {
    _nums = nums;
    random = new Random();
  }

  /** Resets the array to its original configuration and return it. */
  public int[] reset() {
    return _nums;
  }

  /** Returns a random shuffling of the array. */
  public int[] shuffle() {
    int[] newInts = _nums.clone();
    for (int i=1; i<_nums.length; i++) {
      int j = random.nextInt(i+1);
      swap(newInts, i, j);
    }
    return newInts;
  }

  private void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}
