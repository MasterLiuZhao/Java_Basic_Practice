package com.liuzhao.network.BIOWithThread;

import java.io.*;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException, InterruptedException {

        Charset charset = Charset.forName("utf-8");
        Socket socket = null;

        OutputStream outputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedWriter bufferedWriter = null;
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;

        try {
            socket = new Socket("127.0.0.1", 8888);

            ClientSocketThread readThread = new ClientSocketThread(charset, socket);
            readThread.start();

            outputStream = socket.getOutputStream();
            outputStreamWriter = new OutputStreamWriter(outputStream, Charset.forName("utf-8"));
            bufferedWriter = new BufferedWriter(outputStreamWriter);

            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextLine()) {
                String content = scanner.nextLine();
                bufferedWriter.write(content + "\n");
                bufferedWriter.flush();
            }

            /*
            outputStream = socket.getOutputStream();
            outputStreamWriter = new OutputStreamWriter(outputStream, Charset.forName("utf-8"));
            bufferedWriter = new BufferedWriter(outputStreamWriter);

            bufferedWriter.write("Hello, 大哥，我有没有连上啊？\n");
            bufferedWriter.flush();
            Thread.sleep(9000);
            //bufferedWriter.newLine();
            bufferedWriter.write("连上了给我说声。\n");
            bufferedWriter.flush();


            inputStream = socket.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream, Charset.forName("utf-8"));
            bufferedReader = new BufferedReader(inputStreamReader);
            String content;
            while ((content = bufferedReader.readLine()) != null) {
                System.out.println(content);
            }


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
            */
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            /*

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
            */
        }
    }
}
