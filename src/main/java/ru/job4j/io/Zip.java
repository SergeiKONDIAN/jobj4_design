package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import static ru.job4j.io.Search.search;

public class Zip {

    public void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (Path source : sources) {
                zip.putNextEntry(new ZipEntry(source.toString()));
                try (BufferedInputStream output = new BufferedInputStream(new FileInputStream(source.toFile()))) {
                    zip.write(output.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.toString()));
            try (BufferedInputStream output = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(output.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void zipArgsValidation(ArgsName zipArgs) {
        Path directoryToZip = Path.of(zipArgs.get("d"));
        String excludeFileExtension = zipArgs.get("e");
        String zipName = zipArgs.get("o");
        if (!(Files.exists(directoryToZip))) {
            throw new IllegalArgumentException("Error: Directory for zipping doesn't exists");
        }
        if (!excludeFileExtension.startsWith(".")) {
            throw new IllegalArgumentException("Error: This argument '-e' "
                    + "doesn't start with a '.' character");
        }
        if (!zipName.endsWith(".zip")) {
            throw new IllegalArgumentException("Error: Output archive file extension should be only '.zip'!");
        }
    }

    public static void main(String[] args) throws IOException {
        Zip zip = new Zip();
        zip.packSingleFile(
                new File("./pom.xml"),
                new File("./pom.zip")
        );
        ArgsName zipArgs = ArgsName.of(args);
        zipArgsValidation(zipArgs);
        Path directoryToZip = Paths.get(zipArgs.get("d"));
        String zipName = zipArgs.get("o");
        String excludeFilesExtension = zipArgs.get("e");
        List<Path> sources = search(directoryToZip, path -> !path.toFile().getName().endsWith(excludeFilesExtension));
        Zip zipFiles = new Zip();
        zipFiles.packFiles(sources, new File(zipName));
    }
}