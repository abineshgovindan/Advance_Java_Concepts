package org.example.PathAPI;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;



public class Main {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("d:/blink/hello.txt");
//        System.out.println(path); //d:\blink\hello.txt
//        Path pathWithoutSlash's = Path.of("d:","blink").resolve("hello.txt");
//        System.out.println(pathWithoutSlash's); //d:\blink\hello.txt
//
//        //Java11 > version
//        Path older version = Paths.get("d:/blink/hello.txt");
//        System.out.println(older version);//d:\blink\hello.txt
        //To get patent dir
        System.out.println(path.getParent());
        //Check the File  exists or not
        boolean fileStatus = Files.exists(path);
        System.out.println("Exists -> " + fileStatus); //Exists -> false
        //get the last modified date of a file
        try {
            FileTime lastModifiedTime = Files.getLastModifiedTime(path);
            System.out.println(lastModifiedTime);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // create files and directories
        Path NewFileDir = Files.createDirectories(path.getParent().resolve("exp/new/dir"));
        System.out.println("directories path ->" + NewFileDir); //directories path ->d:\blink\exp\new\dir
        //Delete the file if it exists
        boolean fileExists = Files.exists(NewFileDir.resolve("HelloWorld.txt"));
        if(fileExists){
            Files.delete(NewFileDir.resolve("HelloGuys.txt"));
            System.out.println("Deleted the file");

        }

        Path FileDir = Files.createFile(NewFileDir.resolve("HelloGuys.txt"));
        System.out.println( "file path ->" + FileDir);//file path ->d:\blink\exp\new\dir\HelloWorld.txt
        //Writing to the file
        Files.writeString(FileDir, "Hello Guys!");

        //Reading the file
        String fileData = Files.readString(FileDir);
        System.out.println("The File data \n" + fileData);
//        The File data
//        Hello Guys!

        //List the files in the dir
        var files = Files.list(NewFileDir);
        files.forEach(System.out::println);

        //Memory File System

    }
}
