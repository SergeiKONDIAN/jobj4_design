package ru.job4j.io;

import java.io.*;

public class Analysis {
    public void unavailable(String source, String target) {
        try (BufferedReader input = new BufferedReader(new FileReader(source));
             PrintWriter output = new PrintWriter(new FileOutputStream(target))) {
            String line;
            StringBuilder sb = new StringBuilder();
            boolean periodBeginningFound = false;
            while ((line = input.readLine()) != null) {
                if (!periodBeginningFound & (line.contains("400") || line.contains("500"))) {
                    sb.append(line, 4, line.length());
                    sb.append(";");
                    periodBeginningFound = true;
                    continue;
                }
                if (periodBeginningFound & (!line.contains("400") && !line.contains("500"))) {
                    sb.append(line, 4, line.length());
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