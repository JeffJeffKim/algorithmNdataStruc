package practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapIter {

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 10);
        map.put(2, 20);
        map.put(3, 30);

        for (Integer key : map.keySet()) {
            System.out.println("key : " + key + ", value : " + map.get(key));
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println("key : " + entry.getKey()+ ", value : " + entry.getValue());
        }

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        for (Integer integer : set) {
            
        }
    }
}
