package com.liuzhao.network.AIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.charset.Charset;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        Charset charset = Charset.forName("utf-8");
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1",8888);
        ExecutorService pool = Executors.newFixedThreadPool(100);

        AsynchronousChannelGroup asynchronousChannelGroup = AsynchronousChannelGroup.withThreadPool(pool);

        AsynchronousSocketChannel asynchronousSocketChannel = AsynchronousSocketChannel.open(asynchronousChannelGroup);
        //asynchronousSocketChannel.bind(inetSocketAddress);

        asynchronousSocketChannel.connect(inetSocketAddress).get();

        asynchronousSocketChannel.read(buffer, null, new ClientReadHandler(buffer, asynchronousSocketChannel));

        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String temp = scanner.nextLine();
            ByteBuffer content = charset.encode(temp);

            Future<Integer> writeFuture = asynchronousSocketChannel.write(content);
            writeFuture.get();
        }
    }

}
