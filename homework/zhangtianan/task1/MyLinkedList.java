package test;
/**@author 张天安
 * @data2018/7/26 下午15:21
*/
public class MyLinkedList implements MyList
{ 
	private Node head;                //头结点
    private Node tail;                //尾指针
    private int size;                 //链表长度
    private class Node                 //定义结点类型
    {                
       Node next;   
       Object data;     
       public Node()
       {}
       public Node(Object data)
       {
        this.data=data;
       }
     }
    public MyLinkedList()
    {
       head=new Node();              //定义头指针
       tail=head;
       size=0;
    }
    
    @Override
    public int size()
    {
       return size;
    }

    @Override
    public boolean isEmpty() 
    {
       return size==0;
    }
    
    @Override
    public void add(Object element)
    {
       Node temp=new Node(element);
       tail.next=temp;
       tail=temp;
       size++;
     }
    
     @Override
     public Object get(int index)
     {
        if(index>=size||index<0)
        {
             throw new IllegalArgumentException("下标出错");
        }
          Node temp=head;
          int i=0;
          while(i<=index)
          {
             temp=temp.next;
             i++;
          }
          return temp.data;
    }
     
     @Override
     public Object set(int index, Object element) 
     {
        if(index<0||index>size)
         {
        	 throw new IllegalArgumentException("下标出错");
         }
            Node temp=head;
            int i=0;
            while (i<=index)
            {
               temp=temp.next;
               i++;
            }
               Object a=temp.data;
               temp.data=element;
               return a;
      }

     @Override
     public Object remove(int index) 
     {
           if(index<0||index>size)
           {
        	   throw new IllegalArgumentException("下标出错");
           }
               Node temp=head;
               int i=0;
           while (i<index)
           {
              temp=temp.next;
              i++;
           }
              Object a=temp.next.data;
              temp.next=temp.next.next;
              return a;
     }
     
     @Override
     public void clear() 
     {
           while(head.next!=null)
           {
        	   head.next=head.next.next;
           }
           tail=head;
           size=0;
     }
         
	@Override
	public String toString() 
	{
		String s="";
		Node temp= head.next;
		while(temp!=null)
		{
			s=s+temp.data;
			temp=temp.next;
		}
		return s;
	}

	public static void main(String[] args) 
	{
		MyLinkedList mytest =new MyLinkedList();
		mytest.add(111);
		mytest.add(222);
		mytest.add(333);
		mytest.add(444);
		mytest.add(555);
		mytest.add(666);
		mytest.add("abc");
		mytest.add("def");
		System.out.println("增加");
		System.out.println(mytest);
		mytest.remove(1);                //删除下标为1的元素
		System.out.println("删除");
		System.out.println(mytest);
		mytest.set(0, "wwwwww");           //把下标为0的元素修改为wwwwww
		System.out.println("修改");
		System.out.println(mytest);
		System.out.println("查询");       //查询下标为0的元素
		System.out.println(mytest.get(0));
	}
}
