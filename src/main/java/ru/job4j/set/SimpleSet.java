package ru.job4j.set;

import ru.job4j.collection.SimpleArrayList;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<T> implements Set<T> {

    private SimpleArrayList<T> set = new SimpleArrayList<>(0);

    @Override
    public boolean add(T value) {
        boolean duplicate = false;
        for (T t : set) {
            if (Objects.equals(t, value)) {
                duplicate = true;
                break;
            }
        }
        if (!duplicate) {
            set.add(value);
        }
        return !duplicate;
    }

    @Override
    public boolean contains(T value) {
        boolean containsValue = false;
        for (T t : set) {
            if (Objects.equals(t, value))  {
                containsValue = true;
                break;
            }
        }
        return containsValue;
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }
}