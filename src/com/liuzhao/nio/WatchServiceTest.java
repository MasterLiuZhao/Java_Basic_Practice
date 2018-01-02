package com.liuzhao.nio;

import java.io.IOException;
import java.nio.file.*;

public class WatchServiceTest {

    public static void main(String[] args) throws IOException, InterruptedException {

        WatchService watchService = FileSystems.getDefault().newWatchService();

        Paths.get("/Users/liuzhao/").register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);

        while (true) {
            WatchKey watchKey = watchService.take();
            for (WatchEvent event : watchKey.pollEvents()) {
                System.out.println(event.context() + " " + event.kind());
            }

            boolean valid = watchKey.reset();
            if (!valid) {
                break;
            }
        }

    }

}
