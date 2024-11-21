package ru.job4j.io;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Config {

    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) throws IllegalArgumentException {
        this.path = path;
    }

    public void load() {
        try (BufferedReader input = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = input.readLine()) != null) {
                if (!line.isBlank() && !line.startsWith("#")) {
                    String[] keyValue = line.split("=", 2);
                    if (keyValue.length != 2) {
                        throw new IllegalArgumentException();
                    }
                    String key = keyValue[0];
                    String value = keyValue[1];
                    if (key.isBlank() || value.isBlank()) {
                        throw new IllegalArgumentException();
                    } else {
                        values.put(key, value);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
     }

    public String value(String key) {
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner output = new StringJoiner(System.lineSeparator());
        try (BufferedReader reader = new BufferedReader(new FileReader(this.path))) {
            reader.lines().forEach(output::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Config("data/app.properties"));
    }

}