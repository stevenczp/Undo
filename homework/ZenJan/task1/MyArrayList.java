package com.cc.test.learn;

public class MyArrayList implements MyList{
    private int size;
    private Object[] array;
    //构造方法
    public MyArrayList(int size){
        if(size < 0){
            throw new IndexOutOfBoundsException("数组列表的长度不能为小于0的数");
        }
        array = new Object[size];
    }
    //数组长度
    public int size(){
        return size;
    }
    //数组是否为空
    public boolean isEmpty(){
        if (size > 0)
            return false;
        else
            return true;
    }
    //数组增加元素
    public void add(Object element){
        checkSize();
        array[size] = element;
        size++;
    }
    //根据索引获取数组元素内容
    public Object get(int index){
        if(index > size || index < 0){
            throw new IndexOutOfBoundsException("指定的索引越界，集合大小为:"+size+",您指定的索引大小为:"+index);
        }
        return array[index];
    }
    //根据索引设置数组元素内容
    public Object set(int index, Object element){
        if(index > size || index < 0){
            throw new IndexOutOfBoundsException("指定的索引越界，集合大小为:"+size+",您指定的索引大小为:"+index);
        }
        Object saver;
        saver = array[index];
        array[index] = element;
        return saver;
    }
    //根据索引删除数组元素
    public Object remove(int index){
        if(index > size || index < 0){
            throw new IndexOutOfBoundsException("指定的索引越界，集合大小为:"+size+",您指定的索引大小为:"+index);
        }
        Object saver;
        saver = array[index];
        for (int i = size - index; i > 0; i--){
            array[index] = array[index+1];
        }
        size--;
        return saver;
    }
    //删除数组所有元素
    public void clear(){
        for(int i = 0 ; i < size ; i++){
            array[i] = null;
        }
        size = 0;
    }
    //检查数组长度
    public void checkSize(){
        if(size >= array.length ){
            Object[] newArray = new Object[size*2+1];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
    }
}
