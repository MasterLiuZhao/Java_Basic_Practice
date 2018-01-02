package com.liuzhao.network.AIO;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;

public class ClientReadHandler implements CompletionHandler<Integer, Object> {
    private Charset charset = Charset.forName("utf-8");
    private ByteBuffer buffer;
    private AsynchronousSocketChannel asynchronousSocketChannel;

    public ClientReadHandler(ByteBuffer buffer, AsynchronousSocketChannel asynchronousSocketChannel) {
        this.buffer = buffer;
        this.asynchronousSocketChannel = asynchronousSocketChannel;
    }

    @Override
    public void completed(Integer result, Object attachment) {
        buffer.flip();
        String content = charset.decode(buffer).toString();

        System.out.println(content);

        buffer.clear();

        asynchronousSocketChannel.read(buffer, null, this);

    }

    @Override
    public void failed(Throwable exc, Object attachment) {
        System.out.println("Can not read data from Socket Channel.");
        System.out.println(exc);
    }
}
