package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashSet;
import java.util.Set;


public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private Set<FileProperty> allFiles = new HashSet<>();

    @Override
    public FileVisitResult visitFile(Path file,
                                     BasicFileAttributes attributes) throws IOException {
        FileProperty fileProperty = new FileProperty(attributes.size(), file.getFileName().toString());
        if (!allFiles.contains(fileProperty)) {
            allFiles.add(fileProperty);
        } else {
            System.out.println(file.getFileName());
        }
        return super.visitFile(file, attributes);
    }
}