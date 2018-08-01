package undo.task1;

import java.util.Arrays;

public class MyArrayList<T> implements MyList<T>{

    //try to write series
    private static final long  serialVersionUID=1L;

    //set the default capacity
    private static final int DEFAULT_CAPACITY = 10;

    private T[] list;
    private int capacity;
    private int size;

    //set a 0 element list
    private static final Object[] EMPTY_ELEMENTDATA = {};

    //default constructor
   public MyArrayList(){
       this(DEFAULT_CAPACITY);
   }

   public MyArrayList(int initialcapatity){
       this.capacity=initialcapatity;
       if(initialcapatity>0)
           this.list=(T[])(new Object[initialcapatity]);
       else if(initialcapatity==0)
           list=(T[])EMPTY_ELEMENTDATA;
       else
           throw new IllegalArgumentException("Illegalcapacity"+initialcapatity);
   }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    /**
     * 将传入的 element 添加到 List 的尾部
     * @param element
     * @return
     */
    //we need to think about the capacity
    @Override
    public void add(T element) {
        if(size>=capacity)
            list=grow();
        list[size++]=element;
    }

    private T[] grow() {
        return Arrays.copyOf(list, 2*size);
    }

    /**
     * 获取 List 下标为 index 的元素（下标从0开始）
     * @param index
     * @return
     */

    @Override
    public T get(int index) {
        checkForIndex(index);
        return list[index];
    }

    private void checkForIndex(int index) {
        if(index<0||index>size)
            throw new IllegalArgumentException("IllegalIndex"+index);
    }

    /**
     * 将 List 中下标为 index 的元素替换为 element，并将 index 位上原有的元素返回
     * 如果 index 越界，需要抛出异常
     * @param index
     * @param element
     * @return
     */

    @Override
    public T set(int index, T element) {
        checkForIndex(index);
        T temp=list[index];
        list[index]=element;
        return temp;
    }

    /**
     *  移除 List 中下标为 index 的元素，并将这个元素返回
     *  如果 index 越界，需要抛出异常
     * @param index
     * @return
     */

    @Override
    public T remove(int index) {
        checkForIndex(index);
        T temp=list[index];
        for(int i=index;i<size-1;i++)
            list[i]=list[i+1];
        size--;
        return temp;
    }

    @Override
    public void clear() {
        capacity=0;
        size=0;
        list=null;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < size; i++) {
            sb.append(list[i].toString() + " ");
        }
        return sb.toString();
    }
}
//class Test{
//    public static void main(String[] args) {
//        MyArrayList<Integer> myArrayList=new MyArrayList<>(5);
//        myArrayList.add(8);
//        myArrayList.add(7);
//        myArrayList.add(6);
//        myArrayList.add(5);
//        myArrayList.add(4);
//        myArrayList.add(3);
//        System.out.println(myArrayList.toString());
//        System.out.println(myArrayList.size());
//        myArrayList.set(2,3);
//        System.out.println(myArrayList.toString());
//
//        myArrayList.remove(1);
//
//        System.out.println( myArrayList.get(1));
//        System.out.println( myArrayList.size());
//    }
//}