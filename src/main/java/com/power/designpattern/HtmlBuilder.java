package com.power.designpattern;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class HtmlBuilder extends Builder {
    private String fileName;
    private PrintWriter writer;

    @Override
    public void makeTitle(String title) {
        fileName = title + ".html";

        try {
            writer = new PrintWriter(new FileWriter(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        writer.println("<html>");
    }

    @Override
    public void makeString(String str) {
        writer.println(str);
    }

    @Override
    public void makeItems(String[] items) {
        for ( String item: items) {
            writer.println(item);
        }
    }

    @Override
    public void close() {
        writer.println("</html>");
        writer.close();
    }

    public String getResult() {
        return fileName;
    }
}
