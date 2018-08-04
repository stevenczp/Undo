package com.cc.test.learn;

public class MyArrayList implements MyList {
    private size;
    private T list[];
    private int capacity;
    private static final int DEFAULT_CAPACITY = 20;
    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }
    
    public MyArrayList(int capacity) {
        this.capacity = capacity;
        if(capacity>0) {
            this.list = (T [])new Object[capacity];
        }
        else if (capacity == 0) {
            this.list = null;
        }
        else {
            throw new IllegalArgumentException("数组容量输入有误：" + capacity);
        }
    }
    
    
    public int size() {
        return this.size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public void add(T element) {
        if(size < capacity) {
            this.list[size++] = element;
        }
        else {
            grow(size);
            list[size++] = element;
        }
    }
    
    public void grow(int minCapacity) {
        capacity = minCapacity * 2;
        this.list = Arrays.copyOf(list, capacity);
    }
    
    public T get(int index) {
        if(index >= size || index < 0) {
            throw new IndexOutOfBoundsException("下标越界！");
        }
        return list[index];
    }
    
    public T set(int index, T element) {
        if(index >= size || index < 0) {
            throw new IndexOutOfBoundsException("下标越界！");
        }
        T temp = this.list[index];
        this.list[index] = element;
        return temp;
    }
    
    public T remove(int index) {
        if(size == 0) {
            throw new IllegalArgumentException("数组为空");
        }
        if(index >= size || index < 0) {
            throw new IndexOutOfBoundsException("下标越界！");
        }
        T temp = list[index];
        for (int i = index; i < size; i++) {
            list[i] = list[i+1];
        }
        size--;
        return temp;
    }
    
    public void clear() {
        this.list = null;
        this.size = 0;
    }
    
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < size; i++) {
            sb.append(list[i].toString() + " ");
        }
        return sb.toString();
    }
}
