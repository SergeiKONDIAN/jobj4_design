package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        while (elemInArray() && emptyRow()) {
            row++;
            column = 0;
        }
        return elemInArray();
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        if (!elemInRow() || singleElem()) {
            int rsl = data[row][column];
            row++;
            column = 0;
            return rsl;
        }
       return  data[row][column++];
    }

    private boolean singleElem() {
        if (data[row].length == 1) {
            column = 0;
            return true;
        }
        return false;
    }

    public boolean emptyRow() {
         return data[row].length <= 0;
    }

    public boolean elemInArray() {
        return row < data.length;
    }

    public boolean elemInRow() {
         return column < data[row].length - 1;
    }
}