package shuati.Ranges;

import java.util.ArrayList;
import java.util.List;


/**
 * Given a sorted integer array where the range of elements are [0, 99] inclusive, return its missing ranges.
 For example, given [0, 1, 3, 50, 75], return [“2”, “4->49”, “51->74”, “76->99”]
 */
public class MissingRange {

  /*
   我们用一个指针prev记录上次range的结尾，一个指针curr记录当前遍历到的数字，如果curr和prev相差大于1，说明一个missing range，
   我们将其加入结果列表中就行了。这题主要是有几个corner case要解决：

   如何处理lower到第一个数，和最后一个数到upper的missing range？
   如何区分range中只有一个数和多个数？
   如何有效的得到missing range的起始和结束值，同时保证不会包含数组中的数字？

   对于第一个问题，我们要做的就是在让for循环多判断两次。想象一下假设数组前有一段连续的负无穷到lower-1，数组后有一段upper+1到正无穷，
   这样是等价与上下界的。本来如果不考虑头尾，那for循环本应是从1到length-1的，但是为了判断头，我们从0开始，
   将下标为0的数和lower-1比较得到第一个range。最后循环到length停止，当下标为length时，我们将当前指针指向upper+1，
   并判断upper+1和数组末尾是否能构成最后一个区间。
   对于第二个问题，我们只要判断这个区间的起止是否一样就行了
   对于第三个问题，我们用prev+1和curr-1来标记这个区间的起止，因为prev和curr都是数组中的数，所以解决了每个区间的边界问题
   */

  /**
   * @param nums
   * @param lower
   * @param upper
   * @return
   */
  public List<String> findMissingRange(int[] nums, int lower, int upper) {
    List<String> list = new ArrayList<>();
    if (nums == null || lower >= upper) {
      return list;
    }

    if (lower < nums[0]) {
      if (nums[0] - lower == 1) {
        list.add(String.valueOf(lower));
      } else {
        list.add(lower + "->" + (nums[0] - 1));
      }
    }
    if (nums[nums.length - 1] < upper) {
      if (upper - nums[nums.length - 1] == 1) {
        list.add(String.valueOf(upper));
      } else {
        list.add((nums[nums.length - 1] + 1) + "->" + upper);
      }
    }
  }
}
