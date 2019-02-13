package base_level;

import java.util.*;
import java.util.stream.Stream;

public class Collect {
    public static void main(String[] args) {
//        ArrayList
//        LinkedList - двусвязный список
//        Set  HashSet TreeSet
//        Map HashMap TreeMap
        Map<String, Integer> map = new HashMap<>();
        Random rnd = new Random();
        Object o = new Object();
        System.out.println(o);
        String [] data = {"alena", "Oleg", "volga", "IVAN", "jason",
                "alena", "Oleg", "volga", "IVAN", "jason",
                "alena", "Oleg", "volga", "IVAN", "jason",
                "alena", "Oleg", "volga", "IVAN", "jason",
                "uliana", "dorn", "dog", "cat", "Joly"
        };
        for (int i = 0; i < data.length; i++) {
            map.put(data[i], map.getOrDefault(data[i], 0) + 1);
        }
        for (String i : map.keySet()){
            System.out.println(i + " : " + map.get(i));
        }
        System.out.println(map);
    }
}
