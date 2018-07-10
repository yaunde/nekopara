package io.java.inputoutput;

import java.io.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

public class SplitFile {

    public static void main(String[] args) {

    }


    public static void splitFile(String inFileName, String outFileName) {

        try (FileInputStream fin = new FileInputStream(inFileName);) {

            FileOutputStream fout = null;

            byte[] buffer = new byte[1024 * 1024 * 4];

            int len = 0, count = 0;

            while ((len = fin.read(buffer)) != -1) {
                fout = new FileOutputStream(outFileName + "_" + (count++) + ".part");
                fout.write(buffer, 0, len);
                fout.close();
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void mergeFile(String outFilePath) {
        List<FileInputStream> fileList = new ArrayList<>();

        FileOutputStream fout = null;

        SequenceInputStream sis = null;
        try {
            // TODO
            for (int i = 0; i < 3; i++) {
                fileList.add(new FileInputStream(""));
            }

            final Iterator<FileInputStream> iterator = fileList.iterator();

            Enumeration<FileInputStream> enumeration = new Enumeration<FileInputStream>() {
                @Override
                public boolean hasMoreElements() {
                    return iterator.hasNext();
                }

                @Override
                public FileInputStream nextElement() {
                    return iterator.next();
                }
            };


            // 合并流
            sis = new SequenceInputStream(enumeration);

            // 输出流
            fout = new FileOutputStream(outFilePath);

            byte[] buffer = new byte[1024*1024];

            int len = 0;

            while ((len = sis.read(buffer)) != -1) {
                fout.write(buffer,0,len);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fout != null) {
                try {
                    fout.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (sis != null) {
                try {
                    sis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
