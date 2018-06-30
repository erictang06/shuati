package shuati.Design;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * Design a data structure that supports all following operations in average O(1) time.

 insert(val): Inserts an item val to the set if not already present.
 remove(val): Removes an item val from the set if present.
 getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
 */
public class InsertDeleteGetRandomO1 {
  ArrayList<Integer> _list;
  HashMap<Integer, Integer> _map;
  java.util.Random rand = new java.util.Random();

  /** Initialize your data structure here. */
  public InsertDeleteGetRandomO1() {
    _list = new ArrayList<>();
    _map = new HashMap<>();
  }

  /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
  public boolean insert(int val) {
    boolean contain = _map.containsKey(val);
    if ( contain ) return false;
    _map.put( val, _list.size());
    _list.add(val);
    return true;
  }

  /** Removes a value from the set. Returns true if the set contained the specified element. */
  public boolean remove(int val) {
    boolean contain = _map.containsKey(val);
    if ( ! contain ) return false;
    int loc = _map.get(val);
    if (loc < _list.size() - 1 ) { // not the last one than swap the last one with this val
      int lastone = _list.get(_list.size() - 1 );
      _list.set( loc , lastone );
      _map.put(lastone, loc);
    }
    _map.remove(val);
    _list.remove(_list.size() - 1);
    return true;
  }

  /** Get a random element from the set. */
  public int getRandom() {
    return _list.get( rand.nextInt(_list.size()) );
  }

}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */