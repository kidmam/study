package com.power.thread.threadspecificstorage;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Log {

    /*private static PrintWriter writer = null;

    static {
        try {
            writer = new PrintWriter(new FileWriter("log.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void println(String s) {
        writer.println(s);
    }

    public static void close() {
        writer.print("======== End of Lof ==========");
        writer.close();
    }*/

    private static final ThreadLocal tsLogCollection = new ThreadLocal();

    public static void println(String s) {
        getTSLog().println(s);
    }

    public static void close() {
        getTSLog().close();;
    }

    private static TSLog getTSLog() {
        TSLog tsLog = (TSLog) tsLogCollection.get();

        if (tsLog == null) {
            tsLog = new TSLog(Thread.currentThread().getName() + " - log.txt");
            tsLogCollection.set(tsLog);
        }
        return tsLog;
    }
}
