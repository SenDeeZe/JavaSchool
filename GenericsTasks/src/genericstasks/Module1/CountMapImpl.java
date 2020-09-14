package genericstasks.Module1;

import java.util.HashMap;
import java.util.Map;

public class CountMapImpl<T> implements CountMap<T> {
    public HashMap<T, Integer> h = new HashMap<>();

    @Override
    public void add(T o) {
        h.put(o, h.getOrDefault(o, 0) + 1);
    }

    @Override
    public int getCount(T o) {
        return h.getOrDefault(o, 0);
    }

    @Override
    public int remove(T o) {
        int counter = 0;
        if (h.get(o) != 0) {
            counter = h.get(o);
            h.remove(o);
        }
        return counter;
    }

    @Override
    public int size() {
        return h.size();
    }

    @Override
    public void addAll(CountMap<? extends T> source) {
        for (T t : source.toMap().keySet()) {
            if (h.containsKey(t))
                h.put(t, h.get(t) + 1);
            else
                h.put(t, 1);
        }
    }

    @Override
    public Map<T, Integer> toMap() {
        return h;
    }

    @Override
    public void toMap(Map<? super T, Integer> destination) {
        destination.putAll(h);
    }

    @Override
    public String toString() {
        return h.toString();
    }
}
