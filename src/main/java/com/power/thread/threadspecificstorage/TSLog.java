package com.power.thread.threadspecificstorage;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TSLog {

    private  PrintWriter writer = null;

    public TSLog(String name) {
        try {
            writer = new PrintWriter(new FileWriter("log.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void println(String s) {
        writer.println(s);
    }

    public void close() {
        writer.print("======== End of Lof ==========");
        writer.close();
    }
}
