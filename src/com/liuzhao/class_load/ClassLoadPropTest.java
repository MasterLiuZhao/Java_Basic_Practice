package com.liuzhao.class_load;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class ClassLoadPropTest {

    public static void main(String[] args) throws IOException {

        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println("系统类加载器: " + systemClassLoader);

        Enumeration<URL> eml = systemClassLoader.getResources("");
        while(eml.hasMoreElements()){
            System.out.println(eml.nextElement());
        }

        ClassLoader extensionClassLoader = systemClassLoader.getParent();
        System.out.println("扩展类加载器: " + extensionClassLoader);
        System.out.println("扩展类加载器的加载路径: " + System.getProperty("java.ext.dirs"));
        System.out.println("扩展类加载器的parent: " + extensionClassLoader.getParent());

    }
}
