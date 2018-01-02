package com.liuzhao.network.AIO;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class ServerSocketReadHandler implements CompletionHandler<Integer, Object> {
    private ByteBuffer buffer;
    private Charset charset = Charset.forName("utf-8");
    private AsynchronousSocketChannel asynchronousSocketChannel;

    public ServerSocketReadHandler(ByteBuffer buffer, AsynchronousSocketChannel asynchronousSocketChannel) {
        this.buffer = buffer;
        this.asynchronousSocketChannel = asynchronousSocketChannel;
    }

    @Override
    public void completed(Integer result, Object attachment) {
        buffer.flip();
        String content = charset.decode(buffer).toString();

        System.out.println(content);

        for (AsynchronousSocketChannel asynchronousSocketChannel : Server.asynchronousSocketChannelList) {

            try {
                Future<Integer> writeFuture = asynchronousSocketChannel.write(charset.encode(content));
                writeFuture.get();

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

            buffer.clear();
            asynchronousSocketChannel.read(buffer, null, this);
        }
    }

    @Override
    public void failed(Throwable exc, Object attachment) {
        Server.asynchronousSocketChannelList.remove(asynchronousSocketChannel);
        System.out.println("Can not read data from Socket Channel.");
        System.out.println(exc);
    }
}
