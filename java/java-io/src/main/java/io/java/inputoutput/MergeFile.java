package io.java.inputoutput;

import java.io.*;
import java.util.Vector;

public class MergeFile {

    public static void main(String[] args) throws IOException {

        Vector<FileInputStream> vector = new Vector<>();

        vector.add(new FileInputStream("d:\\1.txt"));
        vector.add(new FileInputStream("d:\\2.txt"));
        vector.add(new FileInputStream("d:\\3.txt"));


        SequenceInputStream sis = new SequenceInputStream(vector.elements());

        FileOutputStream fout = new FileOutputStream("d:\\4.txt");

        byte[] buffer = new byte[1024];

        int len = 0;

        while ((len = sis.read(buffer)) != -1){
            fout.write(buffer, 0 ,len);
        }

        fout.close();
        sis.close();
    }
}
