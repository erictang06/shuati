package shuati.Design;

import java.util.LinkedList;
import java.util.Queue;

/*
Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

For example,
MovingAverage m = new MovingAverage(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3
 */
class MovingAverage {
  Queue<Integer> _queue;
  int _size;
  double sum;

  /** Initialize your data structure here. */
  public MovingAverage(int size) {
    _queue = new LinkedList<Integer>();
    _size = size;
    sum = 0;
  }

  public double next(int val) {
    if (_queue.size() >= _size) {
      sum -= _queue.poll();
    }
    _queue.offer(val);
    sum += val;
    return (double)sum/_queue.size();
  }
}