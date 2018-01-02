package com.liuzhao.network.Download;

import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadThread implements Runnable {
    private String path;
    private int startPosition;
    private int currentPartSize;
    private RandomAccessFile currentPartFile;
    private int length;

    public DownloadThread(String path, int startPosition, int currentPartSize, RandomAccessFile currentPartFile) {
        this.path = path;
        this.startPosition = startPosition;
        this.currentPartSize = currentPartSize;
        this.currentPartFile = currentPartFile;
    }

    @Override
    public void run() {

        InputStream inputStream = null;
        try {
            URL url = new URL(this.path);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(5 * 1000);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "image/gif, image/jpeg, image/pjpeg, " +
                    "application/x-shockwave-flash, application/xaml+xml, " +
                    "application/vnd.ms-xpsdocument, application/x-ms-xbap, " +
                    "application/x-ms-application, application/vnd.ms-excel, " +
                    "application/vnd.ms-powerpoint, application/msword, */*");
            connection.setRequestProperty("Accept-Language", "zh-CN");
            connection.setRequestProperty("Charset", "UTF-8");
            connection.setRequestProperty("Connection", "Keep-Alive");

            inputStream = connection.getInputStream();

            inputStream.skip(this.startPosition);
            byte[] buffer = new byte[1024];
            int hasRead = 0;
            while (length < this.currentPartSize && (hasRead = inputStream.read(buffer)) != -1) {
                this.currentPartFile.write(buffer, 0, hasRead);
                length = length + hasRead;
            }

            if (this.currentPartFile != null) {
                this.currentPartFile.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (this.currentPartFile != null) {
                    this.currentPartFile.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public int getLength() {
        return length;
    }

}
