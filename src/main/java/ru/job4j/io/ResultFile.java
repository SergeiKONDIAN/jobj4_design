package ru.job4j.io;

import java.io.FileOutputStream;

public class ResultFile {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("data/result.txt")) {
            int[][] rsl = new int[10][10];
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    rsl[i][j] = (i + 1) * (j + 1);
                    String str = Integer.toString(rsl[i][j]);
                    out.write(str.getBytes());
                    out.write((" ".repeat(3 - str.length())).getBytes());
                }
                out.write(System.lineSeparator().getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
