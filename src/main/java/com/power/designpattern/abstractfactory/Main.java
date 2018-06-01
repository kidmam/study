package com.power.designpattern.abstractfactory;

public class Main {

    public static void main(String[] args) {
        Factory factory = Factory.getFactory("com.power.designpattern.abstractfactory.ListFactory");

        Link joins  = factory.craeteLink("중앙일보", "http://www.joins.com");
        Link chosun = factory.craeteLink("조선일보", "http://www.chosun.com");

        Tray trayNews = factory.createTray("신문");
        trayNews.add(joins);
        trayNews.add(chosun);

        Page page = factory.createPage("LinkPage", "영진닷컴");
        page.add(trayNews);
        page.output();
    }
}
