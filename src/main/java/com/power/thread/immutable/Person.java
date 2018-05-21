package com.power.thread.immutable;

public final class Person {

    private final String name;
    private final String addrsss;

    public Person(String name, String addrsss) {
        this.name = name;
        this.addrsss = addrsss;
    }

    public String getName() {
        return name;
    }

    public String getAddrsss() {
        return addrsss;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", addrsss='" + addrsss + '\'' +
                '}';
    }
}
