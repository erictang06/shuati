package shuati.Array;

import shuati.data.structure.Point;
import java.util.HashMap;
import java.util.Map;

/**
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 */
public class MaxPointOn2DSpace {
  // https://leetcode.com/problems/max-points-on-a-line/discuss/47098/Accepted-Java-solution-easy-to-understand.
  // the idea is to iterate every point
  // for each point, if other points on the other end have same slope, they are on the sample line
  // using a hashmap of <slope aka double, count aka integer> to store the # of points
  public int maxPoints(Point[] points) {
    if (points.length <= 0) {
      return 0;
    }
    if (points.length <= 2) {
      return points.length;
    }
    int result = 0;
    for (int i = 0; i < points.length; i++) {
      Map<Double, Integer> hm = new HashMap<>();
      int samex = 1;
      int samep = 0;
      for (int j = 0; j < points.length; j++) {
        if (j != i) {
          if ((points[j].x == points[i].x) && (points[j].y == points[i].y)) {
            samep++;
          }
          if (points[j].x == points[i].x) {
            samex++;
            continue;
          }
          double k = (double) (points[j].y - points[i].y) / (double) (points[j].x - points[i].x);
          if (hm.containsKey(k)) {
            hm.put(k, hm.get(k) + 1);
          } else {
            hm.put(k, 2);
          }
          result = Math.max(result, hm.get(k) + samep);
        }
      }
      result = Math.max(result, samex);
    }
    return result;
  }
}
