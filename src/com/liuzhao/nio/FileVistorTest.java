package com.liuzhao.nio;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class FileVistorTest {

    public static void main(String[] args) throws IOException {

        Files.walkFileTree(Paths.get("/Users/liuzhao/"), new SimpleFileVisitor<Path>() {

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println("visit " + file + " file");

                if (file.endsWith("tstNIO.txt")) {
                    System.out.println("We have got what we want.");
                    return FileVisitResult.TERMINATE;
                }

                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                System.out.println("visit " + dir + " folder");
                return FileVisitResult.CONTINUE;
            }
        });

    }

}
