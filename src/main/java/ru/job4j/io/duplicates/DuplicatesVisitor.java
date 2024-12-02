package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private Set<FileProperty> allFiles = new HashSet<>();
    private static List<Path> rsl = new ArrayList<>();

    @Override
    public FileVisitResult visitFile(Path file,
                                     BasicFileAttributes attributes) throws IOException {
        FileProperty fileProperty = new FileProperty(attributes.size(), file.getFileName().toString());
        if (!allFiles.contains(fileProperty)) {
            allFiles.add(fileProperty);
        } else {
            rsl.add(file.getFileName());
        }
        return super.visitFile(file, attributes);
    }

    public static void printSearchResult() {
        for (Path file : rsl) {
            System.out.println(file);
        }
    }
}