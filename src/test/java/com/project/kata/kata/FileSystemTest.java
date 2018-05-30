package com.project.kata.kata;

import com.project.kata.composite.FileSystem;
import org.junit.Test;

public class FileSystemTest {

    @Test
    public void getSizeFromPath(){
        FileSystem fileSystem =new FileSystem();
        long value=fileSystem.calculateSizeRoute("/home/dani/Android");
        System.out.println(value);

    }
}
