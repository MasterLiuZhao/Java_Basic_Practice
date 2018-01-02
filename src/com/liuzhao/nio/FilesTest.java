package com.liuzhao.nio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FilesTest {

    public static void main(String[] args) throws IOException {

        Files.copy(Paths.get("tstNIO.txt"), new FileOutputStream("a.txt"));

        boolean hiddenFile = Files.isHidden(Paths.get("a.txt"));
        System.out.println("Is a.txt a hidden file? " + hiddenFile);

        List<String> lines = Files.readAllLines(Paths.get("tstNIO.txt"));
        //System.out.println(lines);

        long size = Files.size(Paths.get("tstNIO.txt"));
        System.out.println("the size of tstNIO.txt is " + size);


        byte[] bytes = Files.readAllBytes(Paths.get("tstNIO.txt"));
        String content = new String(bytes);
        //System.out.println(content);

        Charset charset = Charset.forName("utf-8");
        CharsetDecoder charsetDecoder = charset.newDecoder();
        CharBuffer charBuffer = charsetDecoder.decode(ByteBuffer.wrap(bytes));
        System.out.println(charBuffer.toString());

        List<String> newContent = new ArrayList<>();
        newContent.add("增加新的内容。。");
        newContent.add("测试编码的不同。");

        Files.write(Paths.get("tstNIO.txt"), newContent, Charset.forName("utf-8"));

        Stream folders = Files.list(Paths.get("/Users/liuzhao/"));
        folders.forEach(path -> System.out.println(path));

        Files.lines(Paths.get("tstNIO.txt")).forEach(line -> System.out.println(line));

        FileStore fileStore = Files.getFileStore(Paths.get("/Users/liuzhao/"));
        long totalSpace = fileStore.getTotalSpace();
        long usableSpace = fileStore.getUsableSpace();
        System.out.println("The total space in /Users/liuzhao has : " + totalSpace);
        System.out.println("The unused space in /Users/liuzhao has : " + usableSpace);

    }

}
