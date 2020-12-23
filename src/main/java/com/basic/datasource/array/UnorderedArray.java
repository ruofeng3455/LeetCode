package com.basic.datasource.array;


import com.basic.datasource.AbstractList;

/**
 * @author guo.feng
 * @create 2020-12-22 18:50
 * 一个可以动态扩容的数组集合
 */
public class UnorderedArray<E> extends AbstractList<E> {

    // 数据
    protected E[] elements;

    // 默认长度
    private static final int DEFAULT_SIZE = 4;

    public UnorderedArray(int capacity) {
        elements = (E[]) new Object[capacity];
    }

    public UnorderedArray() {
        this(DEFAULT_SIZE);
    }

    @Override
    public void add(E element, int index) {
        ensureCapacity(size + 1);
        // index处的数据替换
        if (index >= size){
            elements[size] = element;
        }else {
            elements[size] = elements[index];
            elements[index] = element;
        }
        size ++;
    }

    @Override
    public int remove(int index) {
        rangeCheck(index);
        if (index >= size - 1){
            elements[--size] = null;
        }else {
            elements[index] = elements[size - 1];
            elements[--size] = null;
        }
       // TODO 可以增加缩容处理
        return 1;
    }

    @Override
    public int remove(E element) {
        return remove(indexOf(element));
    }

    @Override
    public E set(E element, int index) {
        rangeCheckForAdd(index);
        elements[index] = element;
        return element;
    }

    @Override
    public E get(int index) {
        rangeCheck(index);
        return elements[index];
    }

    @Override
    public boolean contains(E element) {
        return super.contains(element);
    }

    @Override
    public int indexOf(E element) {
        if (size <= 0 || null == element){
            return ELEMENT_NPT_FOUND;
        }
        //直接遍历查找吧
        for (int i = 0; i < size; i++){
            if (element.equals(elements[i])) return i;
        }
        return ELEMENT_NPT_FOUND;
    }

    @Override
    public void clearAll() {
        for (int i = 0; i < size; i++){
            elements[i] = null;
        }
    }

    @Override
    protected void rangeCheck(int index) {
        super.rangeCheck(index);
    }

    @Override
    protected void rangeCheckForAdd(int index) {
        super.rangeCheckForAdd(index);
    }

    @Override
    protected void outOfBounds(int index) {
        super.outOfBounds(index);
    }

    /**
     * 不够时动态扩容
     * @param capacity 保证有的容量
     * */
    protected void ensureCapacity(int capacity){
        if (elements.length >= capacity) return;
        // 不够则扩容为2倍，主要都是2的倍数
        E[] newElements = (E[]) new Object[elements.length << 1];
        for (int i = 0; i < elements.length; i ++){
            newElements[i] = elements[i];
        }
        elements = newElements;
        System.out.println("扩容啦！");
    }

    /**
     * 展示所有
     * */
    public void display(){
        for (int i = 0; i < size; i++){
            System.out.println(elements[i]);
        }
    }


}
