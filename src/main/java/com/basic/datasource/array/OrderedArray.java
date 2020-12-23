package com.basic.datasource.array;

/**
 * 有序数组，和无序数组的差别是add, 查询
 * 从小到大排序
 * */
public class OrderedArray<E> extends UnorderedArray<E>{

//    public OrderedArray(int capacity) {
//        super(capacity);
//    }
//
//    public OrderedArray() {
//        super();
//    }

    @Override
    public int remove(int index) {
        rangeCheck(index);
        for (int i = index + 1; i < size; i++){
            elements[i -1] = elements[i];
        }
        elements[size] = null;
        size --;
        // TODO 可以增加缩容处理
        return 1;
    }

    @Override
    public int remove(E element) {
        return remove(indexOf(element));
    }

    @Override
    public E get(int index) {
        return super.get(index);
    }

    @Override
    public int indexOf(E element) {
        if (size <= 0 || null == element){
            return ELEMENT_NPT_FOUND;
        }
        // 其他类型的比较大小？
        for (int i = 0; i < size; i++){
            if (element.equals(elements[i])){
                return i;
            }
        }
        return ELEMENT_NPT_FOUND;
    }
}
