package com.liuzhao.nio;

import java.nio.CharBuffer;

public class BufferTest {
    public static void main(String[] args){
        CharBuffer buffer = CharBuffer.allocate(8);

        System.out.println("position = " + buffer.position());
        System.out.println("limit = " + buffer.limit());
        System.out.println("capacity = " + buffer.capacity());

        buffer.put('a');
        buffer.put('b');
        buffer.put('c');
        buffer.put('d');

        System.out.println("after put 4 elements. position = " + buffer.position());

        buffer.flip();

        System.out.println("after execute flip() method.");

        System.out.println("position = " + buffer.position());
        System.out.println("limit = " + buffer.limit());
        System.out.println("capacity = " + buffer.capacity());

        System.out.println(buffer.get());
        System.out.println(buffer.get(3));

        buffer.clear();

        System.out.println("after execute clear() method.");

        System.out.println("position = " + buffer.position());
        System.out.println("limit = " + buffer.limit());
        System.out.println("capacity = " + buffer.capacity());

        System.out.println(buffer.get());
        System.out.println(buffer.get(3));

        System.out.println("print CharBuffer directly.");
        System.out.println(buffer);

    }
}
