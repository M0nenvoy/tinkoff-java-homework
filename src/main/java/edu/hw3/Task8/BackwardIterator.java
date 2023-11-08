package edu.hw3.Task8;

import java.util.Iterator;
import java.util.List;

public class BackwardIterator<T> implements Iterator<T> {
    private int elementNumber;
    private final List<T> list;

    public BackwardIterator(List<T> list) {
        if (list == null) {
            throw new IllegalArgumentException("Коллекция не может быть null");
        }

        this.list = list;
        this.elementNumber = 0;
    }

    @Override
    public boolean hasNext() {
        return (elementNumber < list.size());
    }

    @Override
    public T next() {
        return list.get(list.size() - (elementNumber++) - 1);
    }
}
