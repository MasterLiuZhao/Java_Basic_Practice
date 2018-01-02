package com.liuzhao.network.AIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public static List<AsynchronousSocketChannel> asynchronousSocketChannelList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        InetSocketAddress inetSocketAddress = new InetSocketAddress(8888);

        ExecutorService pool = Executors.newFixedThreadPool(100);

        AsynchronousChannelGroup asynchronousChannelGroup = AsynchronousChannelGroup.withThreadPool(pool);

        AsynchronousServerSocketChannel asynchronousServerSocketChannel = AsynchronousServerSocketChannel.open(asynchronousChannelGroup);
        asynchronousServerSocketChannel.bind(inetSocketAddress);

        asynchronousServerSocketChannel.accept(null, new ServerSocketAcceptHandler(asynchronousServerSocketChannel));

        while(true){

        }
    }

}
