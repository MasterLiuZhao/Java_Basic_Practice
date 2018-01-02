package com.liuzhao.class_load;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CompileClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class clazz = null;
        String temp = name.replace(".", "/");
        String javaFilename = temp + ".java";
        String classFilename = temp + ".class";

        File javaFile = new File(javaFilename);
        File classFile = new File(classFilename);

        //if (javaFile.exists() && (!classFile.exists() || javaFile.lastModified() > classFile.lastModified())) {

        System.out.println("My_CompileClassLoader: Start to compile " + javaFile + "...");

        try {
            Process process = Runtime.getRuntime().exec("javac " + javaFile);

            process.waitFor();

            int result = process.exitValue();
            if (result != 0) {
                throw new ClassNotFoundException("Can not Compile : " + javaFilename);
            }

            if (classFile.exists()) {
                System.out.println(classFile.getPath());
                byte[] raw = this.getBytes(classFilename);
                clazz = this.defineClass(name, raw, 0, raw.length);
            } else {
                throw new ClassNotFoundException("Can not find class file: " + classFilename);
            }

            if (clazz == null) {
                throw new ClassNotFoundException(name);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //}

        return clazz;
    }

    private byte[] getBytes(String filename) throws IOException {
        File file = new File(filename);
        long fileLength = file.length();
        byte[] raw = new byte[(int) fileLength];
        FileInputStream fileInputStream = null;

        try {
            fileInputStream = new FileInputStream(file);
            int r = fileInputStream.read(raw);
            if (r != fileLength) {
                throw new IOException("Can't read whole byte from " + filename);
            }

            if (fileInputStream != null) {
                fileInputStream.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                fileInputStream.close();
            }
        }

        return raw;
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        CompileClassLoader compileClassLoader = new CompileClassLoader();
        Class<?> clazz = compileClassLoader.loadClass("Hello");

        //Method main = clazz.getMethod("main", (new String[0]).getClass());
        //main.invoke(null, args);

        Object object = clazz.newInstance();
        Method test = clazz.getMethod("test", String.class);
        test.invoke(object, "");

        //Thread.sleep(99999);
    }
}
