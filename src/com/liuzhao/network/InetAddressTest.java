package com.liuzhao.network;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {

    public static void main(String[] args) throws IOException {

        InetAddress inetAddress = InetAddress.getByName("www.apache.org");
        boolean reachable = inetAddress.isReachable(2000);
        System.out.println("Test1 ip address '' is reachable or not ? " + reachable);
        String hostAddress = inetAddress.getHostAddress();
        System.out.println("target address is " + hostAddress);
        String canonicalHostName = inetAddress.getCanonicalHostName();
        System.out.println("" + canonicalHostName);


        InetAddress localAddress = InetAddress.getLocalHost();
        reachable = localAddress.isReachable(2000);
        System.out.println("Test1 local address is reachable or not ? " + reachable);
        String address = localAddress.getHostAddress();
        System.out.println("local address is " + address);
        canonicalHostName = localAddress.getCanonicalHostName();
        System.out.println("" + canonicalHostName);

    }

}
