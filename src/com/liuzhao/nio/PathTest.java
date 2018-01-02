package com.liuzhao.nio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest {

    public static void main(String[] args) {
        Path path = Paths.get(".");
        System.out.println(path);
        System.out.println(path.getNameCount());
        System.out.println(path.getFileName());
        System.out.println("the root of Path : " + path.getRoot());

        Path absolutePath = path.toAbsolutePath();
        System.out.println("AbsolutePath : " + absolutePath);
        System.out.println("The root of Absolute Path : " + absolutePath.getRoot());
        System.out.println("absolutePath 里面包含的路径的数量 : " + absolutePath.getNameCount());
        System.out.println(absolutePath.getName(3));

        Path customeath = Paths.get("/", "usr", "local");
        System.out.println(customeath);
    }

}
