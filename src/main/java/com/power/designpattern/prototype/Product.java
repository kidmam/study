package com.power.designpattern.prototype;

public interface Product extends Cloneable{
    void use(String s);
    Product createClone();
}
