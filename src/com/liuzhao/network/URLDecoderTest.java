package com.liuzhao.network;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLDecoderTest {

    public static void main(String[] args) throws UnsupportedEncodingException {

        String urlEncoder = URLEncoder.encode("用户名", "UTF-8");
        System.out.println(urlEncoder);

        String urlDecoder = URLDecoder.decode(urlEncoder, "utf-8");
        System.out.println(urlDecoder);

    }

}
