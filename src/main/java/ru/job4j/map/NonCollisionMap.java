package ru.job4j.map;

import java.util.*;

public class NonCollisionMap<K, V> implements SimpleMap<K, V> {
    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;
    private int count = 0;
    private int modCount = 0;
    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        boolean rsl = false;
        if ((double) count / capacity >= LOAD_FACTOR) {
            expand();
        }
        int i = getIndex(key);
        if (table[i] == null) {
            table[i] = new MapEntry(key, value);
            rsl = true;
            count++;
            modCount++;
        }
        return rsl;
    }

    @Override
    public V get(K key) {
        V rsl = null;
        int i = getIndex(key);
        if (checkedIndex(key)) {
            rsl = table[i].value;
        }
        return rsl;
    }

    @Override
    public boolean remove(K key) {
        boolean rsl = false;
        int i = getIndex(key);
        if (checkedIndex(key)) {
            table[i] = null;
            rsl = true;
            count--;
            modCount++;
        }
        return rsl;
    }

    @Override
    public Iterator<K> iterator() throws NoSuchElementException, ConcurrentModificationException {
        return new Iterator<K>() {
            private int expectedModCount = modCount;
            private int index;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                while (index < table.length && table[index] == null) {
                    index++;
                }
                return index < table.length;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[index++].key;
            }
        };
    }

    private int hash(int hashCode) {
        return hashCode ^ (hashCode >>> 16);
    }

    private int indexFor(int hash) {
        return hash & (table.length - 1);
    }

    private int getIndex(K key) {
        int hash = hash(Objects.hashCode(key));
        return indexFor(hash);
    }

    private boolean checkedIndex(K key) {
        int i = getIndex(key);
        return table[i] != null
                && Objects.hashCode(table[i].key) == Objects.hashCode(key)
                && Objects.equals(table[i].key, key);
    }

    private void expand() {
        MapEntry<K, V>[] oldTable = table;
        capacity *= 2;
        table = new MapEntry[capacity];
        count = 0;
        for (MapEntry<K, V> mapEntry : oldTable) {
            if (mapEntry != null) {
                put(mapEntry.key, mapEntry.value);
            }
        }
    }

    private static class MapEntry<K, V> {
        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        NonCollisionMap map = new NonCollisionMap();
        System.out.println("Assert that map.hash(0) is equal to 0: \t"
                + (map.hash(0) == 0 ? "true" : "false"));
        System.out.println("Assert that map.hash(65535) is equal to 65535: \t"
                + (map.hash(65535) == 65535 ? "true" : "false"));
        System.out.println("Assert that map.hash(65536) is equal to 65537: \t"
                + (map.hash(65536) == 65537 ? "true" : "false"));
        System.out.println("Assert that map.indexFor(0) is equal to 0: \t"
                + (map.indexFor(0) == 0 ? "true" : "false"));
        System.out.println("Assert that map.indexFor(7) is equal to 7: \t"
                + (map.indexFor(7) == 7 ? "true" : "false"));
        System.out.println("Assert that map.indexFor(8) is equal to 0: \t"
                + (map.indexFor(8) == 0 ? "true" : "false"));
    }
}