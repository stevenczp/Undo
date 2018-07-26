package cn.lt.task1;

/**
 * @className:MyLinkedList
 * @Description:LinkedList方法
 * @author:TAO
 * @Date:2018/7/24 9:03
 */
class MyLinkedList<T> implements MyList<T> {
    private Node head;  //定义头结点
    private Node tail; //定义尾指针
    private int size;

    //定义结点类型
    public class Node{
        Node next;  //指针域
        T data;     //数据域

        public Node(){}
        public Node(T data){
            this.data=data;
        }
    }
    //初始化构造函数
    public MyLinkedList(){
        head=new Node();
        tail=head;
        size=0;
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
    @Override
    public void add(T element) {
        Node temp=new Node(element);
        tail.next=temp;
        tail=temp;
        size++;
    }

    @Override
    public T get(int index) {
     if(index>=size||index<0)
         throw new IllegalArgumentException("角标越界");
     Node temp=head;
     while(index>=0){
         temp=temp.next;
         index--;
     }
     return temp.data;
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
        if(index<0||index>size)
            throw new IllegalArgumentException("角标越界");
        Node temp=head;
        //找到index下标的元素
        while (index>=0){
            temp=temp.next;
            index--;
        }
        T returnData=temp.data;
        temp.data=element;
        return returnData;
    }

    @Override
    public T remove(int index) {
        if(index<0||index>size)
            throw new IllegalArgumentException("角标越界");
        Node temp=head;
        //找到index下标的元素
        while (index>=0){
            temp=temp.next;
            index--;
        }
        T returnData=temp.data;
        temp.next=temp.next.next;
        return returnData;
    }

    @Override
    public void clear() {
        while(head.next!=null)
            head.next=head.next.next;
    tail=head;
    size=0;
    }

    public Node getHead() {
        return head;
    }
}

class Test1{
    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList=new MyLinkedList<>();
        int []arr=new int[]{1,2,3,4,5,6,8,10};
        for(int i=0;i<arr.length;i++)
            myLinkedList.add(arr[i]);
        MyLinkedList.Node head=myLinkedList.getHead();
        MyLinkedList.Node tmp=head.next;
        while(tmp!=null){
            System.out.printf("%3d",tmp.data);
            tmp=tmp.next;
        }
        myLinkedList.set(2,1);
        System.out.println();
        System.out.println(myLinkedList.get(2));
        System.out.println(myLinkedList.size());
    }
}