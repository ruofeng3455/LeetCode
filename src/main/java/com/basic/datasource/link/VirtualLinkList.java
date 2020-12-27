package com.basic.datasource.link;

import com.basic.datasource.AbstractList;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author guo.feng
 * @create 2020-12-24 23:06
 * 哨兵模式，增加虚拟头节点的
 */
public class VirtualLinkList<E> extends AbstractList<E> {

    private Node<E> head;

    public VirtualLinkList() {
        head = new Node<E>(null, null);
    }

    @Override
    /**
     * 插入到尾部
     * */
    public void add(E element) {
        add(element, size);
    }

    /**
     * 返回index处的元素
     * */
    private Node<E> nodeAtIndex(int index){
        rangeCheck(index);
        Node<E> tmp = head.next;
        for (int i = 0; i < index; i ++){
            tmp = tmp.next;
        }
        return tmp;
    }

    @Override
    protected void rangeCheckForAdd(int index) {
        if (index < 0 || index >= size + 1 || size >= Integer.MAX_VALUE - 1){
            outOfBounds(index);
        }
    }


    @Override
    public void add(E element, int index) {
        rangeCheckForAdd(index);
        Node<E> pre = (index == 0 ? head : nodeAtIndex(index));
        pre.next = new Node<E>(element, pre.next);
        size ++;
    }

    @Override
    public int remove(int index) {
        rangeCheck(index);
        Node<E> nodePre = index == 0 ? head : nodeAtIndex(index - 1);
        Node<E> nodeNext = nodePre.next.next;
        nodePre.next = nodeNext;
        size --;
        return 1;
    }

    @Override
    public int remove(E element) {
        int index = indexOf(element);
        if (index == ELEMENT_NPT_FOUND){
            return ELEMENT_NPT_FOUND;
        }
        return remove(index);
    }

    @Override
    public E set(E element, int index) {
        rangeCheck(index);
        Node<E> nodeAtIndex = nodeAtIndex(index);
        nodeAtIndex.data = element;
        return nodeAtIndex.data;
    }

    @Override
    public E get(int index) {
        rangeCheck(index);
        Node<E> nodeAtIndex = nodeAtIndex(index);
        return nodeAtIndex.data;
    }

    @Override
    public int indexOf(E element) {
        Node<E> tmp = head.next;
        for (int i = 0; i < size; i ++){
            if (tmp.data.equals(element)){
                return i;
            }
            tmp = tmp.next;
        }
        return ELEMENT_NPT_FOUND;
    }

    @Override
    public void clearAll() {
        if (size > 0){
            head.next = null;
        }
    }

    @Override
    public void display() {
        if (size <= 0){
            System.out.println("[]");
        }else {
            Node<E> first = head;
            while (first.next != null){
                System.out.println(first.data);
                first = first.next;
            }
            System.out.println(first.data);
        }
    }

    @Data
    @AllArgsConstructor
    public class Node<E>{
        private E data;
        private Node<E> next;

    }
}
