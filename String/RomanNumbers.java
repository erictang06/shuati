package shuati.String;

import java.util.HashMap;
import java.util.Map;


public class RomanNumbers {

  private Map<Character, Integer> setup() {
    Map<Character, Integer> mapR2I = new HashMap<>();
    mapR2I.put('I', 1);
    mapR2I.put('V', 5);
    mapR2I.put('X', 10);
    mapR2I.put('L', 50);
    mapR2I.put('C', 100);
    mapR2I.put('D', 500);
    mapR2I.put('M', 1000);
    return mapR2I;
  }

  public int romanToInt(String s, Map<Character, Integer> hmap) {
    if (s == null || s.isEmpty()) {
      return 0;
    }

    int len = s.length();
    int result = hmap.get(s.charAt(len - 1));
    for (int i = len - 2; i >= 0; i--) {
      if (hmap.get(i + 1) > hmap.get(i)) {
        result -= hmap.get(s.charAt(i));
      } else {
        result += hmap.get(s.charAt(i));
      }
    }

    return result;
  }

  public String intToRoman(Integer num) {

    int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    StringBuilder res = new StringBuilder();
    int digit = 0;
    while (num > 0) {
      int times = num / nums[digit];
      if (times > 0) {
        num -= times * nums[digit];
        while (times > 0) {
          res.append(symbols[digit]);
          times--;
        }
      }
      digit++;
    }

    return res.toString();
  }
}