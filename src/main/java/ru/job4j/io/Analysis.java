package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Analysis {
    public void unavailable(String source, String target) {
        List<String> rsl = new ArrayList<>();
        try (BufferedReader input = new BufferedReader(new FileReader(source));
             PrintWriter output = new PrintWriter(new FileOutputStream(target))) {
            List<String> list = new ArrayList<>();
            String line;
            while ((line = input.readLine()) != null) {
                list.add(line);
            }
            StringBuilder sb = new StringBuilder();
            boolean periodBeginningFound = false;
            for (String str : list) {
                if (!periodBeginningFound & (str.contains("400") || str.contains("500"))) {
                    sb.append(str, 4, str.length());
                    sb.append(";");
                    periodBeginningFound = true;
                    continue;
                }
                if (periodBeginningFound & (!str.contains("400") && !str.contains("500"))) {
                    sb.append(str, 4, str.length());
                    output.write(sb.toString());
                    output.write(System.lineSeparator());
                    sb = new StringBuilder();
                    periodBeginningFound = false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        public static void main(String[] args) {
        Analysis analysis = new Analysis();
        analysis.unavailable("data/server.log", "data/target.csv");
    }
}