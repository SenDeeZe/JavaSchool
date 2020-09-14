package genericstasks.Module2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Number> list = new ArrayList<>();
        list.add(0.2);
        list.add(6.5f);
        list.add(3);
        list.add(-7);
        list.add(0.49);

        System.out.println(CollectionsUtils.range(list, 0, 4, new Comparator<Number>() {
            @Override
            public int compare(Number o1, Number o2) {
                Double x = o1.doubleValue();
                Double y= o2.doubleValue();
                return x.compareTo(y);
            }
        }));
        List<Number> list2 = new ArrayList<>();
        list2.add(0.2);
        list2.add(1000);
        System.out.println(CollectionsUtils.containsAny(list,list2));
        System.out.println(CollectionsUtils.containsAll(list,list2));
    }
}
