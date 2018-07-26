package com.cc.test.learn;

public class MyLinkedList implements MyList{
    private Node firstNode;
    private Node lastNode;
    private int size;
    //定义结点结构
    private class Node{
        Node prev;
        Object data;
        Node next;
        Node(Node prev, Object data, Node next){
            this.prev = prev;
            this.data = data;
            this.next = next;
        }
    }
    //根据索引访问结点
    private Node node(int index) {
        if(index > size || index < 0){
            throw new IndexOutOfBoundsException("指定的索引越界，集合大小为:"+size+",您指定的索引大小为:"+index);
        }
        Node node = firstNode;
        if (node != null) {
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        }
        return node;
    }
    //构造方法
    public MyLinkedList() {
    }
    //链表长度
    public int size(){
        return size;
    }
    //链表是否为空
    public boolean isEmpty(){
        if (size > 0)
            return false;
        else
            return true;
    }
    //增加结点
    public void add(Object element){
        Node newNode = new Node(lastNode, element, null);
        if (firstNode == null)
            firstNode = lastNode = newNode;
        else {
            lastNode.next = newNode;
            lastNode = newNode;
        }
        size++;
    }
    //根据索引获取结点的内容
    public Object get(int index){
        if(index > size || index < 0){
            throw new IndexOutOfBoundsException("指定的索引越界，集合大小为:"+size+",您指定的索引大小为:"+index);
        }
        Node temp = node(index);
        return temp.data;
    }
    //根据索引设置结点
    public Object set(int index, Object element){
        if(index > size || index < 0){
            throw new IndexOutOfBoundsException("指定的索引越界，集合大小为:"+size+",您指定的索引大小为:"+index);
        }
        Node temp = node(index);
        if (temp != firstNode && temp != lastNode){
            Node newNode = new Node(temp.prev, element, temp.next);
            node(index + 1).prev = newNode;
            node(index - 1).next = newNode;
        }
        if (temp == firstNode){
            Node newNode = new Node(null, element, null);
            firstNode = newNode;
        }
        if (temp == lastNode){
            Node newNode = new Node(temp.prev, element, null);
            node(index - 1).next = newNode;
            lastNode = newNode;
        }
        return temp.data;
    }
    //根据索引删除结点
    public Object remove(int index){
        if(index > size || index < 0){
            throw new IndexOutOfBoundsException("指定的索引越界，集合大小为:"+size+",您指定的索引大小为:"+index);
        }
        Node temp = node(index);
        if (temp != firstNode && temp != lastNode){
            node(index + 1).prev = temp.prev;
            node(index - 1).next = temp.next;
        }
        if (temp == firstNode){
            firstNode = null;
        }
        if (temp == lastNode){
            node(index - 1).next = null;
            lastNode = node(index - 1);
        }
        size--;
        return temp.data;
    }
    //清空list
    public void clear(){
        for (Node temp = firstNode; temp != null;) {
            Node next = temp.next;
            temp.prev = null;
            temp.data = null;
            temp.next = null;
            temp = next;
        }
        size = 0;
    }
}
