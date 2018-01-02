package com.liuzhao.network.AIO;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class ServerSocketAcceptHandler implements CompletionHandler<AsynchronousSocketChannel, Object> {
    private AsynchronousServerSocketChannel asynchronousServerSocketChannel;

    public ServerSocketAcceptHandler(AsynchronousServerSocketChannel asynchronousServerSocketChannel) {
        this.asynchronousServerSocketChannel = asynchronousServerSocketChannel;
    }

    @Override
    public void completed(AsynchronousSocketChannel result, Object attachment) {
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        Server.asynchronousSocketChannelList.add(result);

        asynchronousServerSocketChannel.accept(null, this);

        result.read(buffer, null, new ServerSocketReadHandler(buffer, result));
    }

    @Override
    public void failed(Throwable exc, Object attachment) {
        System.out.println("Can not connect to this AsynchronousSocketChannel.");
        System.out.println(exc);
    }
}
