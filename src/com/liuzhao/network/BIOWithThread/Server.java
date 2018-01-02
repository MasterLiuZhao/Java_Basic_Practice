package com.liuzhao.network.BIOWithThread;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    public static void main(String[] args) throws IOException {

        Charset charset = Charset.forName("UTF-8");
        ExecutorService pool = Executors.newFixedThreadPool(100);
        ServerSocket serverSocket = null;
        Socket socket = null;
        ConcurrentLinkedQueue<Socket> clientSockets = new ConcurrentLinkedQueue<>();

        /*
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        OutputStream outputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedWriter bufferedWriter = null;
        */

        try {
            serverSocket = new ServerSocket(8888);

            while (true) {

                socket = serverSocket.accept();

                InetAddress inetAddress = socket.getInetAddress();
                System.out.println(inetAddress.getHostAddress());
                System.out.println(inetAddress.getHostName());
                System.out.println(socket.getPort());

                clientSockets.add(socket);

                ServerSocketThread thread = new ServerSocketThread(charset, socket, clientSockets);
                pool.submit(thread);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }

    }

}
