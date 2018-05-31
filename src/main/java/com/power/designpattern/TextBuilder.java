package com.power.designpattern;

public class TextBuilder extends Builder {
    private StringBuffer buffer = new StringBuffer();

    @Override
    public void makeTitle(String title) {
        buffer.append("====================");
        buffer.append("==" + title + "==");
        buffer.append("\n");
    }

    @Override
    public void makeString(String str) {
        buffer.append("====================");
        buffer.append("==" + str + "==");
        buffer.append("\n");
    }

    @Override
    public void makeItems(String[] items) {
        for ( String item: items) {
            buffer.append(item);
        }
    }

    @Override
    public void close() {
        buffer.append("==================");
    }

    public String getResult() {
        return buffer.toString();
    }
}
