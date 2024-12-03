package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

public class Search {
    public static void main(String[] args) throws IOException, IllegalArgumentException {
        Search.chechForArgs(args);
        Search.chechStartFolder(args[0]);
        Search.chechFileExtension(args[1]);
        Path start = Paths.get(args[0]);
        search(start, path -> path.toFile().getName().endsWith(args[1])).forEach(System.out::println);
    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    private static void chechForArgs(String[] args) throws IllegalArgumentException {
        if (args.length != 2) {
            throw new IllegalArgumentException("Incorrect arguments! For search input "
                    + "start folder and file extension");
        }
    }

    private static void chechStartFolder(String arg) throws IllegalArgumentException {
        if (!Files.isDirectory(Paths.get(arg))) {
            throw new IllegalArgumentException("Incorrect start folder!");
        }
    }

    private static void chechFileExtension(String arg) throws IllegalArgumentException {
        if (!arg.startsWith(".")) {
            throw new IllegalArgumentException("Incorrect file extension!");
        }
    }
}