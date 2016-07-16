package com.folkol.cli;

import org.apache.tika.Tika;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class TikaCli {
    private static Tika tika = new org.apache.tika.Tika();

    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("usage: tika filename");
            System.out.println("    prints the mimetype of the given file");
            System.out.println("    the filename '-' means stdin");
            System.exit(1);
        }
        String filename = args[0];
        InputStream data = "-".equals(filename) ? System.in : new FileInputStream(new File(filename));
        String type = tika.detect(data);
        System.out.println(type);
    }
}
