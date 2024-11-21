package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class LogFilter {
    private final String file;

    public LogFilter(String file) {
        this.file = file;
    }

    public List<String> filter() {
        List<String> rsl = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(this.file))) {
            rsl = in.lines()
                    .filter(s -> s.matches(".+ 404 .+"))
                    .toList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsl;
    }

    public static void main(String[] args) {
        LogFilter logFilter = new LogFilter("data/log.txt");
        List<String> log = logFilter.filter();
        for (String s : log) {
            System.out.println(s);
        }
    }
}