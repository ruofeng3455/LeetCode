package com.basic.datasource;

/**
 * @author guo.feng
 * @create 2020-12-22 18:23
 */
public abstract class AbstractList<E> implements MyList<E>{

    /**
     * 元素的数量
     * */
    protected int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void add(E element) {
        add(element, size);
    }

    @Override
    public boolean contains(E element) {
        return indexOf(element) != ELEMENT_NPT_FOUND;
    }

    /**
     * 检查范围
     * */
    protected void rangeCheck(int index){
        if (index < 0 || index >= size){
            outOfBounds(index);
        }
    }

    /**
     * 添加一个元素时检查
     * */
    protected void rangeCheckForAdd(int index){
        if (index < 0 || index >= size - 1){
            outOfBounds(index);
        }
    }

    /**
     * 越界
     * */
    protected void outOfBounds(int index){
        throw new IndexOutOfBoundsException("Index:" + index + ",Size:" + size);
    }


}
