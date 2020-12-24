package com.basic.datasource.link;

/**
 * @author guo.feng
 * @create 2020-12-24 22:49
 */
public class Main {

    public static void main(String[] args) {
        link();
    }

    // 单链表
    public static void link(){
        HeadLinkList<String> headLinkList = new HeadLinkList<String>();
        headLinkList.display();
        System.out.println("--------");
        headLinkList.add("1");
        headLinkList.add("2");
        headLinkList.add("3");
        headLinkList.add("4");
        headLinkList.add("5");
        headLinkList.display();
        System.out.println("--------");
        headLinkList.set("23", 1);
        headLinkList.display();
        System.out.println("--------");
        headLinkList.remove("3");
        headLinkList.display();
        System.out.println("--------");

    }

}
