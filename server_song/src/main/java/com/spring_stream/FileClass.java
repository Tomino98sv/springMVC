package com.spring_stream;

import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class FileClass {

    private String path;

    public FileClass(String path) {
        this.path =path;
    }

    public InputStream getFile() {
        File f = new File(path);
        System.out.println(f.getPath());
        InputStream targetStream = null;
        try {
            targetStream = new FileInputStream(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return targetStream;
    }

    public Resource prepareResponse(InputStream filePointer) {
        final InputStream inputStream = filePointer;
        return new InputStreamResource(inputStream);
    }
}
