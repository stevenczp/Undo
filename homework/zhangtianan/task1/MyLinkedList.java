package test;
/**@author ���찲
 * @data2018/7/26 ����15:21
*/
public class MyLinkedList implements MyList
{ 
	private Node head;                //ͷ���
    private Node tail;                //βָ��
    private int size;                 //������
    private class Node                 //����������
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
       head=new Node();              //����ͷָ��
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
             throw new IllegalArgumentException("�±����");
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
        	 throw new IllegalArgumentException("�±����");
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
        	   throw new IllegalArgumentException("�±����");
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
		System.out.println("����");
		System.out.println(mytest);
		mytest.remove(1);                //ɾ���±�Ϊ1��Ԫ��
		System.out.println("ɾ��");
		System.out.println(mytest);
		mytest.set(0, "wwwwww");           //���±�Ϊ0��Ԫ���޸�Ϊwwwwww
		System.out.println("�޸�");
		System.out.println(mytest);
		System.out.println("��ѯ");       //��ѯ�±�Ϊ0��Ԫ��
		System.out.println(mytest.get(0));
	}
}
