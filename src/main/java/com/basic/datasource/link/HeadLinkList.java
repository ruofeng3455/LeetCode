package com.basic.datasource.link;

import com.basic.datasource.AbstractList;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author guo.feng
 * @create 2020-12-24 22:09
 * 不使用哨兵模式
 */
public class HeadLinkList<E> extends AbstractList<E> {

    private Node<E> head;

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
        Node<E> tmp = head;
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
        if (index == 0){
            head = new Node<E>(element, head);
        }else {
            nodeAtIndex(index - 1).next = new Node<E>(element, null);
        }
        size ++;
    }

    @Override
    public int remove(int index) {
        rangeCheck(index);
        Node<E> nodePre = nodeAtIndex(index - 1);
        Node<E> nodeNext = nodePre.next.next;
        nodePre.next = nodeNext;
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
        if (isEmpty()){
            return ELEMENT_NPT_FOUND;
        }
        Node<E> tmp = head;
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

//        public Node(E data, Node<E> next) {
//            this.data = data;
//            this.next = next;
//        }
    }
}
