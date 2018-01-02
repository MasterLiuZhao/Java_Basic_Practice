package com.liuzhao.network.BIO;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

public class Server {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = null;
        Socket socket = null;

        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        OutputStream outputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedWriter bufferedWriter = null;

        try {
            serverSocket = new ServerSocket(8888);

            while (true) {

                socket = serverSocket.accept();

                InetAddress inetAddress = socket.getInetAddress();
                System.out.println(inetAddress.getHostAddress());
                System.out.println(inetAddress.getHostName());
                System.out.println(socket.getPort());

                inputStream = socket.getInputStream();
                inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
                bufferedReader = new BufferedReader(inputStreamReader);
                String content;
                while ((content = bufferedReader.readLine()) != null) {
                    System.out.println("Finish bufferedReader.readLine()");

                    System.out.println(content);
                }

                /*
                outputStream = socket.getOutputStream();
                outputStreamWriter = new OutputStreamWriter(outputStream, Charset.forName("UTF-8"));
                bufferedWriter = new BufferedWriter(outputStreamWriter);

                bufferedWriter.write("小弟你连上了！！！！");
                bufferedWriter.write("我给你关了，");
                bufferedWriter.flush();
                */

                if (inputStream != null) {
                    inputStream.close();
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                if (outputStreamWriter != null) {
                    outputStreamWriter.close();
                }
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
                if (socket != null) {
                    socket.close();
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
            if (outputStreamWriter != null) {
                outputStreamWriter.close();
            }
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
            if (socket != null) {
                socket.close();
            }

        }


    }

}
