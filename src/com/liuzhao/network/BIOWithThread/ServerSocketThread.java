package com.liuzhao.network.BIOWithThread;

import java.io.*;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ServerSocketThread implements Runnable {
    private Charset charset;
    private Socket socket;
    private ConcurrentLinkedQueue<Socket> clientSockets;

    private InputStream inputStream = null;
    private InputStreamReader inputStreamReader = null;
    private BufferedReader bufferedReader = null;
    private OutputStream outputStream = null;
    private OutputStreamWriter outputStreamWriter = null;
    private BufferedWriter bufferedWriter = null;

    public ServerSocketThread(Charset charset, Socket socket, ConcurrentLinkedQueue<Socket> clientSockets) {
        this.charset = charset;
        this.socket = socket;
        this.clientSockets = clientSockets;
    }

    @Override
    public void run() {

        try {
            inputStream = socket.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream, charset);
            bufferedReader = new BufferedReader(inputStreamReader);

            String content;
            while ((content = bufferedReader.readLine()) != null) {
                System.out.println(content);

                for (Socket clientSocket : clientSockets) {
                    outputStream = clientSocket.getOutputStream();
                    outputStreamWriter = new OutputStreamWriter(outputStream, charset);
                    bufferedWriter = new BufferedWriter(outputStreamWriter);

                    bufferedWriter.write(content + "\n");
                    bufferedWriter.flush();
                }

                if (content.equalsIgnoreCase("exit")) {
                    clientSockets.remove(socket);

                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    if (inputStreamReader != null) {
                        inputStreamReader.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (socket != null) {
                        socket.close();
                    }

                    System.out.println("Finish this socket");
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally this socket");

            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
