package cn.lt.task1;

import java.util.Arrays;
/**
 * @className:MyArrayList
 * @Description:实现数组
 * @author:TAO
 * @Date:2018/7/24 9:04
 */
class MyArrayList<T> implements MyList<T> {
    //数组的元素的个数
    private int size=0;
    private T list[];
    private int capacity;
    private static final int initcapacity=100;

    //定义未给出容量的数组的初始化
    public MyArrayList(){
        this(initcapacity);
    }

    public MyArrayList(int capacity){
        this.capacity=capacity;
        if(capacity>0)
            list=(T [])new Object[capacity];
        else if(capacity==0)
            list=null;
        else
            throw new IllegalArgumentException("数组容量输入有误");
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if(this.size==0)
            return true;
        return false;
    }

    /**
     * 将传入的 element 添加到 List 的尾部
     * @param element
     * @return
     */
    //需要考虑到扩缩性---将数组的容量变大
    @Override
    public void add(T element) {
        if(size<capacity)
            list[size++]=element;
        else{
            grows(size);
            list[size++]=element;
        }
    }

    private void grows(int miniCapacity) {
        capacity  =  miniCapacity * 2;
        list = Arrays.copyOf(list, capacity);
    }

    @Override
    public T get(int index) {
        if(index>=size||index<0)
            throw new IndexOutOfBoundsException("角标越界！");
        return list[index];
    }
        /**
        * 将 List 中下标为 index 的元素替换为 element，并将 index 位上原有的元素返回
        * 如果 index 越界，需要抛出异常
        *  @param index
        * @param element
        * @return
         */
    @Override
    public T set(int index, T element) {
        if(index>=size||index<0)
            throw new IndexOutOfBoundsException("角标越界！");
        T temp=list[index];
        list[index]=element;
        return temp;
    }

    @Override
    public T remove(int index) {
        if(size==0)
            throw new IllegalArgumentException("数组为空");
        if(index>=size||index<0)
            throw new IndexOutOfBoundsException("角标越界！");
        T temp=list[index];
        for(int i=index;i<size;i++)
            list[i]=list[i+1];
        size--;
        return temp;
    }

    //删除所有的元素
    @Override
    public void clear() {
        list=null;
        size=0;
    }

    public String toString(){
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < size; i++) {
            sb.append(list[i].toString() + " ");
        }
        return sb.toString();
    }
}
//test
class Test{
    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList=new MyArrayList<>(5);
        myArrayList.add(8);
        myArrayList.add(7);
        myArrayList.add(6);
        myArrayList.add(5);
        myArrayList.add(4);
        myArrayList.add(3);
        myArrayList.set(2,3);
        System.out.println(myArrayList.toString());

        myArrayList.remove(1);

        System.out.println( myArrayList.get(1));
        System.out.println( myArrayList.size());
    }
}
