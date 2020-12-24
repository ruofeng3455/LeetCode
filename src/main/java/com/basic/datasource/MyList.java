package com.basic.datasource;

/**
 * @author guo.feng
 * @create 2020-12-22 18:15
 * 自定义集合的接口
 */
public interface MyList<E> {

    // 未找到元素
    int ELEMENT_NPT_FOUND = -1;

    /**
     * 元素个数
     * */
    int size();

    /**
     * 是否为空
     * */
    boolean isEmpty();

    /**
     * 添加一个元素，添加在末尾
     * */
    void add(E element);

    /**
     * 添加一个元素，添加在指定位置
     * */
    void add(E element, int index);

    /**
     * 删除给定index的元素
     * */
    int remove(int index);

    /**
     * 删除某个元素
     * */
    int remove(E element);

    /**
     * 更改index处的元素为新值
     * */
    E set(E element, int index);

    /**
     * 查index处的值
     * */
    E get(int index);

    /**
     * 是否包含
     * */
    boolean contains(E element);

    /**
     * 元素索引
     */
    int indexOf(E element);

    /**
     * 清除所有元素
     * */
    void clearAll();

    void display();



}
