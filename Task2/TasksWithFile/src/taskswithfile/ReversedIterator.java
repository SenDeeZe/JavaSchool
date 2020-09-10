package taskswithfile;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ReversedIterator<T> implements Iterable<T> {
    private List<T> dataList;

    public ReversedIterator(List<T> list) {
        this.dataList = list;
    }

    @Override
    public Iterator<T> iterator() {
        final ListIterator<T> iterator = dataList.listIterator(dataList.size());
        return new Iterator<T>() {
            @Override
            public T next() {
                return iterator.previous();
            }

            @Override
            public boolean hasNext() {
                return iterator.hasPrevious();
            }
        };
    }
}
