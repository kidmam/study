package com.power.designpattern.abstractfactory;

import java.util.Iterator;

public class ListPage extends Page {
    public ListPage(String title, String author) {
        super(title, author);
    }

    @Override
    public String makeHTML() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("<html><head><title>\n");
        buffer.append(title + "</title></head><body>\n");


        Iterator it = content.iterator();
        while (it.hasNext()) {
            Item item = (Item)it.next();
            buffer.append(item.makeHTML());
        }

        buffer.append("</body></html>\n");
        return buffer.toString();
    }
}
