package com.liuzhao.nio;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.*;
import java.util.Date;
import java.util.List;

public class FileAttributeViewTest {

    public static void main(String[] args) throws IOException {

        Path testPath = Paths.get("tstNIO.txt");
        BasicFileAttributeView basicView = Files.getFileAttributeView(testPath, BasicFileAttributeView.class);
        BasicFileAttributes basicAttributes = basicView.readAttributes();

        FileTime createTime = basicAttributes.creationTime();
        FileTime modifiedTime = basicAttributes.lastModifiedTime();
        FileTime lastAccessTime = basicAttributes.lastAccessTime();
        Long size = basicAttributes.size();

        System.out.println("Create Time : " + new Date(createTime.toMillis()));
        System.out.println("Modified Time : " + new Date(modifiedTime.toMillis()));
        System.out.println("Last Access Time : " + new Date(lastAccessTime.toMillis()));
        System.out.println("size : " + size);


        FileOwnerAttributeView ownerAttributeView = Files.getFileAttributeView(testPath, FileOwnerAttributeView.class);
        UserPrincipal owner = ownerAttributeView.getOwner();
        System.out.println("the owner is : " + owner);

        UserPrincipal users = FileSystems.getDefault().getUserPrincipalLookupService().lookupPrincipalByName("guest");
        System.out.println(users);

        /*
        UserDefinedFileAttributeView userView = Files.getFileAttributeView(testPath, UserDefinedFileAttributeView.class);
        List<String> attributeNames = userView.list();
        for(String attributeName : attributeNames){
            System.out.println(attributeName);
        }
        */

        PosixFileAttributeView posixFileAttributeView = Files.getFileAttributeView(testPath, PosixFileAttributeView.class);
        PosixFileAttributes posixFileAttributes = posixFileAttributeView.readAttributes();

        System.out.println(posixFileAttributes.owner());
        System.out.println(posixFileAttributes.group());
        System.out.println(posixFileAttributes.permissions());
        System.out.println(posixFileAttributes.fileKey());
        posixFileAttributes.permissions();




    }

}
