package com.basic.datasource.array;

/**
 * @author guo.feng
 * @create 2020-12-23 19:46
 */
public class Main {

    public static void main(String[] args) {
        UnorderedArray<String> unorderedArray = new UnorderedArray();
        unorderedArray.display();
        System.out.println("-------");
        unorderedArray.add("1");
        unorderedArray.add("2");
        System.out.println("-------");
        unorderedArray.display();
        unorderedArray.add("3");
        unorderedArray.add("4");
        unorderedArray.add("5",1);
        unorderedArray.add("6");
        System.out.println("-------");
        unorderedArray.display();
        System.out.println("-------");
        System.out.println(unorderedArray.indexOf("3"));

    }
}
