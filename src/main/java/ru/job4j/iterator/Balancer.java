package ru.job4j.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Balancer {
    public static void split(List<ArrayList<Integer>> nodes, Iterator<Integer> source) {
        if (source.hasNext() & !nodes.isEmpty()) {
            CyclicIterator<ArrayList<Integer>> nodeIterator = new CyclicIterator<>(nodes);
            while (source.hasNext()) {
                nodeIterator.next().add(source.next());
            }
        }
    }
}