package com.liuzhao.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class FileChannelTest {

    public static void main(String[] args) {
        File file = new File("tstNIO.txt");
        FileChannel fileChannelInput = null;
        try {

            fileChannelInput = new FileInputStream(file).getChannel();

            MappedByteBuffer buffer = fileChannelInput.map(FileChannel.MapMode.READ_ONLY, 0, file.length());

            Charset charset = Charset.forName("UTF-8");
            CharsetDecoder charsetDecoder = charset.newDecoder();
            CharBuffer charBuffer = charsetDecoder.decode(buffer);

            System.out.println(charBuffer);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
