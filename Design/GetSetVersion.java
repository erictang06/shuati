package shuati.Design;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;


/*
  design a Key/Value data structure that preserves the history of values for any key.
  Must support at least two public methods:
    Set: takes a string key, and any value
    Get: takes a string key, and an optional version identifier.

name: v1, v2, v3, v4...
set("name", "Dave")
set("name", "Ron")

get("name", 1) => "dave"
get("name", 2) => "Ron"

get("name") => "Ron"
 */


public class GetSetVersion {

  private Map<String, List<String>> map = new HashMap<>();
//   private int version; // to re-think

  public static void main (String[] args) {
    System.out.println("Hello Java");

    GetSetVersion my = new GetSetVersion();

    my.set("Name", "Dave");
    my.set("Name", "Ron");

    String name1 = my.get("Name");
    System.out.println("name1: " + name1);

    String name2 = my.get("Name", 1);
    System.out.println("name2: " + name2);

    String name3 = my.get("Title");
    System.out.println("name3: " + name3);



  }

  public GetSetVersion() {
//     map = new HashMap<>();
//     version = 0;
  }

  // map<String, List<String>>: store things

  public void set(String key, String val) {
    List<String> list;
    if (!map.containsKey(key)) {
      list = new ArrayList<>();
    }
    else {
      list = map.get(key);
    }

    list.add(val);
    map.put(key, list);
  }

  public boolean remove(String name, int version) {
    // error handling -- todo

    List<String> list = map.get(name);
    if (version > list.size()) {
      return false;
    }
//
//    String[] arrayString = list.toArray();
//    arrayString[version-1] = "DELETED";


    List<String> list2 = new ArrayList<>();
    for (int i=0; i< version; i++) {
      list2.add(list.get(i));
    }
    list2.add("DELETED");
    for (int i=version; i<list.size(); i++) {
      list2.add(list.get(i));
    }

    map.put(name, list2);
    return true;
  }

  public String get(String name) {
    if (name == null || name.isEmpty()) {
      return name;
    }

    if (!map.containsKey(name)) {
      return null;
    }

    List<String> list = map.get(name);
    return list.get(list.size() - 1);
  }

  public String get(String name, int version) {
    if (name == null || name.isEmpty() || version < 1) {
      return null;
    }

    if (!map.containsKey(name)) {
      return null;
    }

    List<String> list = map.get(name);
    if (version > list.size()) {
      return null;
    }

    return list.get(version-1);
  }

}
