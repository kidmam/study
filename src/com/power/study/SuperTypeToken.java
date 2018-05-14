package com.power.study;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class SuperTypeToken {

    static <T> T create(Class<T> clazz) throws Exception {
        return clazz.newInstance();
    }

    static class Generic<T> {
        T value;
        void set (T t) { this.value = t; }
        T get() { return value; }
    }

    static class TypeSafeMap {
       Map<Class<?>, Object> map = new HashMap<>();

       <T> void put(Class<?> clazz, T value) {
           map.put(clazz, value);

       }
       <T> T get(Class<T> clazz) {
           return clazz.cast(map.get(clazz));
       }
    }

    static class Sup<T> {
        T value;
    }

    //Nested static class
    /*static class Sub extends Sup<String> {

    }*/



    // type erasure
    // type token
    public static void main(String[] args) throws Exception {
        String o = create(String.class);
        System.out.println(o.getClass());

        Generic<String> i = new Generic<>();
        i.value = "Hello";
        i.set("test");

        TypeSafeMap m = new TypeSafeMap();
        m.put(Integer.class, 1);
        m.put(String.class, "Hello");
        m.put(List.class, Arrays.asList(1,2,3)); //List<Integer>

        System.out.println(m.get(Integer.class));

        Sup<String> sup = new Sup<>();
        sup.value = "Test";

        //-----------------------
        System.out.println(sup.getClass().getDeclaredField("value").getType());
        //-----------------------

        //local class
        class Sub extends Sup<List<String>> {

        }

        //익명 클래스
        //Sub b = new Sup<String>() {}

        Sub b =  new Sub();
        Type t = b.getClass().getGenericSuperclass();

        //Type t1 = (new Sup<List<String>>() {}).getClass().getGenericSuperclass();

        ParameterizedType pType = (ParameterizedType)t;
        System.out.println(pType.getActualTypeArguments()[0]);
    }
}
