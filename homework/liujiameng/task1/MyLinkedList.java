package com.cc.test.learn;

class MyLinkedList<T> implements MyList<T> {
    private Node head;
    private Node tail;
    private int size;
    class Node {
        private T data;
        private Node next;
        private Node pre;
        public Node () {}
        public Node (T data) {
            this.data = data;
        }
    }
    public MyLinkedList() {
        head = new Node();
        tail = head;
        size = 0;
    }
    @override
    public int size() {
        return size();
    }

    @override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @override
    public void add(T element) {
        Node newnode = new Node(element);
        this.tail.next = newnode;
        newnode.pre = this.tail;
        newnode = tail;
        size++;
    }

    @override
    T get(int index) {
        if (index < 0 || index >= size) {
            throw IllegalArgumentException('下标越界');
        }
        if(index >= size/2) {
            node current = this.getTail();
            move_time = size - index - 1;
            while(move_time > 0) {
                current = current.pre;
                move_time--;
            }
        }
        else {
            node current = this.getHead();
            move_time = index;
            while(move_time >0) {
                current = current.next;
                move_time--;
            }
        }
        return current.data;
    }

    @override
    T set(int index, T element) {
        if(index <0 || index >= size) {
            throw IllegalArgumentException('下标越界');
        }
        else {
            // 如果下标大于size的一半，就从尾节点开始遍历
            if(index >= size/2) {
                node current = this.getTail();
                move_time = size - index - 1;
                while(move_time > 0) {
                    current = current.pre;
                    move_time--;
                }
            }
            else {
                node current = this.getHead();
                move_time = index;
                while(move_time >0) {
                    current = current.next;
                    move_time--;
                }
            }
            current.data = element;
        }
    }


    @override
    T remove(int index) {
        if(index <0 || index >= size) {
            throw IllegalArgumentException('下标越界');
        }
        else {
            if(index >= size/2) {
                node current = tail;
                move_time = size - index - 1;
                while(move_time > 0) {
                    current = current.pre;
                    move_time--;
                }
            }
            else {
                node current = head;
                move_time = index;
                while(move_time >0) {
                    current = current.next;
                    move_time--;
                }
            }
            current.pre.next = current.next;
            current.next.pre = current.pre;
            size--;
        }
    }

    @override
    void clear() {
        for(Node x = head; x != null;) {
            Node nextone = x.next;
            x.data = null;
            x.pre = null;
            x.next = null;
            size--;
            x = nextone;
        }
        head = tail = null;
        size = 0;
    }

    public Node getHead() {
        return this.head;
    }
    public Node getTail() {
        return this.tail;
    }
}

