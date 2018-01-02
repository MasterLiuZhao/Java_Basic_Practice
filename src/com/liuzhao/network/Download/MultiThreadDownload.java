package com.liuzhao.network.Download;

import java.io.IOException;

public class MultiThreadDownload {

    public static void main(String[] args) throws IOException {
        DownloadUtil downloadUtil = new DownloadUtil("http://www.apache.org/img/asf_logo.png", "test.png", 3);
        downloadUtil.download();
    }

}
