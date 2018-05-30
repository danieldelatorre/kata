package com.project.kata.composite;

import java.io.*;

public class FileSystem {

    private long size=0;

    public long calculateSizeRoute(String route){
        final File folder = new File(route);
        return listFilesForFolder(folder);
    }

    private long listFilesForFolder(final File folder) {
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
                size+=fileEntry.length();
            }
        }

        return size;
    }
}
