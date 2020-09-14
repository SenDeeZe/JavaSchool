package genericstasks.Module1;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        CountMap<Integer> map = new CountMapImpl<>();
        map.add(10);
        map.add(10);
        map.add(5);
        map.add(6);
        map.add(5);
        map.add(10);
        System.out.println(map);
        int count = map.getCount(5); // 2
        System.out.println(count);
        System.out.println(map.remove(6));
        System.out.println(map);
        System.out.println(map.size());
        CountMap<Integer> map2 = new CountMapImpl<>();
        map2.add(10);
        map2.add(3);
        map2.add(5);
        map.addAll(map2);
        System.out.println(map);
        Map<Integer, Integer> newMap = map.toMap();
        System.out.println(newMap);
    }
}
