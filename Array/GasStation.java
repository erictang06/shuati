package shuati.Array;

/**
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

 You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1).
 You begin the journey with an empty tank at one of the gas stations.

 Return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1.

 Note:

 If there exists a solution, it is guaranteed to be unique.
 Both input arrays are non-empty and have the same length.
 Each element in the input arrays is a non-negative integer.
 */
public class GasStation {
  // https://leetcode.com/problems/gas-station/discuss/42568/Share-some-of-my-ideas.
  /*
  If car starts at A and can not reach B. Any station between A and B
can not reach B.(B is the first station that A can not reach.)
If the total number of gas is bigger than the total number of cost. There must be a solution.
(Should I prove them?)

   */
  public int canCompleteCircuit(int[] gas, int[] cost) {
    int start = 0, total = 0, tank = 0;

    //if car fails at 'start', record the next station
    for (int i = 0; i < gas.length; i++) {
      tank += gas[i] - cost[i];
      if (tank < 0) {
        start = i + 1; //move starting position forward
        total += tank; //add the negative tank value to total
        tank = 0; //reset tank
      }
    }
    //negative total + positive tank should be 0 or more, if so we can do a round trip and return start
    return (total + tank < 0) ? -1 : start;
  }
}
