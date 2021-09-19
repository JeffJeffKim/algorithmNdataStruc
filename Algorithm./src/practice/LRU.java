package practice;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRU<K,V> extends LinkedHashMap<K, V> {
	
	private int size;
	
	LRU(int size) {
		super(size, 0.75f, true);
		this.size = size;
	}
	
	protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
		return size() > size;
	}
	
	public static <K,V> LRU<K,V> newInstance(int size) {
		return new LRU<K,V>(size);
	}
	
}

class LRUexec {
	public static void main(String[] args) {
		Map<Integer, Integer> obj = LRU.newInstance(3);
		obj.put(1, 1);
		obj.put(2, 2);
		obj.put(3, 3);
		obj.put(4, 4);
		System.out.println(obj);
		
		@SuppressWarnings("serial")
		var map = new LinkedHashMap<Integer, Integer>(3, 0.75f, true){
			@Override
			protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
				return this.size() > 3;
			}
		};
		
		
		map.put(1, 1);
		map.put(2, 2);
		map.put(3, 3);
		map.put(4, 4);
		System.out.println(map);
	}
	
}