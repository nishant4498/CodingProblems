package General;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * This class is used for sorting hash map based on both keys and values.
 */
public class SortHashMap {
	
	public static <K extends Comparable<K>, V extends Comparable<V>> Map<K,V> sortMapByKey(Map<K,V> map){
		List<K> keys = new ArrayList<>(map.keySet());
		Collections.sort(keys);
		
		Map<K,V> sortedMap = new LinkedHashMap<>();
		for(K key : keys){
			sortedMap.put(key, map.get(key));
		}
		return sortedMap;
	}
	
	public static <K extends Comparable<K>, V extends Comparable<V>> Map<K,V> sortMapByValue(Map<K,V> map){
		List<Entry<K,V>> entries = new ArrayList<>(map.entrySet());
		Collections.sort(entries , new Comparator<Map.Entry<K, V>>() {
			@Override
			public int compare(Entry<K,V> o1, Entry<K,V> o2){
				return o1.getValue().compareTo(o2.getValue());
			}
		});
		
		Map<K,V> sortedMap = new LinkedHashMap<>();
		
		for(Entry<K,V> entry : entries){
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		
		return sortedMap;
	}
	
	
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("Nishant", 1);
		map.put("Anirban", 2);
		map.put("Suresh", 3);
		map.put("Vipin", 4);
		printMap(map);
		System.out.println();
		printMap(sortMapByKey(map));
		
		System.out.println();
		printMap(sortMapByValue(map));
	}
	
	public static <K,V> void printMap(Map<K,V> map){
		for(K key : map.keySet()){
			System.out.println(key + " " + map.get(key));
		}
	}
}
