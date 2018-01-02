package com.liuzhao.network.Download;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DownloadUtil {
    private String path;
    private String targetFile;
    private int threadNumber;
    private int fileSize;
    private List<Thread> threadList = new ArrayList<>();

    public DownloadUtil(String path, String targetFile, int threadNumber) {
        this.path = path;
        this.targetFile = targetFile;
        this.threadNumber = threadNumber;
    }

    public void download() throws IOException {
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

        this.fileSize = connection.getContentLength();
        System.out.println(fileSize);

        connection.disconnect();

        int currentPartSize = this.fileSize / threadNumber + 1;
        RandomAccessFile randomAccessFile = new RandomAccessFile(this.targetFile, "rw");
        randomAccessFile.setLength(this.fileSize);
        randomAccessFile.close();

        for (int i = 0; i < this.threadNumber; i++) {
            int startPosition = i * currentPartSize;
            RandomAccessFile currentPartFile = new RandomAccessFile(this.targetFile, "rw");
            currentPartFile.seek(startPosition);

            DownloadThread downloadThread = new DownloadThread(this.path, startPosition, currentPartSize, currentPartFile);
            Thread thread = new Thread(downloadThread);
            thread.start();

            this.threadList.add(thread);
        }
    }

    public double getCompleteRate() {
        int sumSize = 0;
        for (int i = 0; i < this.threadNumber; i++) {

        }

        return 0;
    }
}
