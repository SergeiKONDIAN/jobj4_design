package ru.job4j.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Balancer {
    public static void split(List<ArrayList<Integer>> nodes, Iterator<Integer> source) {
        if (source.hasNext() & !nodes.isEmpty()) {
            int nodesIndex = 0;
            while (source.hasNext()) {
                nodes.get(nodesIndex % nodes.size()).add(source.next());
                nodesIndex++;
            }
        }
    }
}