package com.basic.datasource.array;

/**
 * @author guo.feng
 * @create 2020-12-23 19:46
 */
public class Main {

    public static void main(String[] args) {
        DynamicArray<String> dynamicArray = new DynamicArray();
        dynamicArray.display();
        System.out.println("-------");
        dynamicArray.add("1");
        dynamicArray.add("2");
        System.out.println("-------");
        dynamicArray.display();
        dynamicArray.add("3");
        dynamicArray.add("4");
        dynamicArray.add("5",1);
        dynamicArray.add("6");
        System.out.println("-------");
        dynamicArray.display();
        System.out.println("-------");
        System.out.println(dynamicArray.indexOf("3"));

    }
}
