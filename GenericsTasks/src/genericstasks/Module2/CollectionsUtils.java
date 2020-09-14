package genericstasks.Module2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionsUtils {
    public static <T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static <T> List<? super T> newArrayList() {
        return new ArrayList<T>();
    }

    public static <T> int indexOf(List<? super T> source, T o) {
        return source.indexOf(o);
    }

    public static <T> List<? super T> limit(List<? extends T> source, int size) {
        if (source.size() < size) throw new IllegalArgumentException("\"size\" bigger than size of \"source\"");
        List<? super T> list = new ArrayList<>();
        int counter = 0;
        for (T t : source) {
            if (counter == size) break;
            list.add(t);
            counter++;
        }
        return list;
    }

    public static <T> void add(List<? super T> source, T o) {
        source.add(o);
    }

    public static <T> void removeAll(List<? super T> removeFrom, List<? extends T> c2) {
        removeFrom.removeAll(c2);
    }

    public static <T> boolean containsAll(List<? super T> c1, List<? extends T> c2) {
        return c1.containsAll(c2);
    }

    public static <T> boolean containsAny(List<? super T> c1, List<? extends T> c2) {
        return !Collections.disjoint(c1, c2);
    }

    public static <T extends Comparable<T>> List<? super T> range(List<? extends T> list, T min, T max) {
        List<? super T> rangeList = new ArrayList<>();
        for (T t : list) {
            if (t.compareTo(min) >= 0 && t.compareTo(max) <= 0)
                rangeList.add(t);
        }
        return rangeList;
    }

    public static <T> List<? super T> range(List<? extends T> list, T min, T max, Comparator<T> comparator) {
        List<? super T> rangeList = new ArrayList<>();
        for (T t : list) {
            if (comparator.compare(t, min) >= 0 && comparator.compare(t, max) <= 0)
                rangeList.add(t);
        }
        return rangeList;
    }
}
