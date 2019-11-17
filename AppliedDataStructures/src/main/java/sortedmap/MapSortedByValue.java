package sortedmap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapSortedByValue implements Comparator<String> {

  Map<String, Double> base;

  public MapSortedByValue(Map<String, Double> base) {
    this.base = base;
  }

  public int compare(String a, String b) {
    if (base.get(a) >= base.get(b)) {
      return -1;
    } else {
      return 1;
    }
  }

  public static void main(String[] args) {
    HashMap<String, Double> map = new HashMap<>();
    MapSortedByValue comparator = new MapSortedByValue(map);
    TreeMap<String, Double> treeMap = new TreeMap<>(comparator);

    map.put("A", 99.5);
    map.put("B", 67.4);
    map.put("C", 67.4);
    map.put("D", 67.5);

    System.out.println("Unsorted map: " + map);
    treeMap.putAll(map);
    System.out.println("Sorted map: " + treeMap);
  }
}
