package com.liuzhao.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

public class DoPostTest {

    public static void main(String[] args) throws IOException {

        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        try {
            URL url = new URL("http://www.apache.org/");
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("Accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setDoInput(true);
            connection.setDoOutput(true);

            //connection.connect();

            Map<String, List<String>> headerFields = connection.getHeaderFields();
            for (String key : headerFields.keySet()) {
                List<String> values = headerFields.get(key);
                System.out.println(key + " " + values);
            }

            inputStream = connection.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            bufferedReader = new BufferedReader(inputStreamReader);

            String content;
            while ((content = bufferedReader.readLine()) != null) {
                System.out.println(content);
            }

            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

}
