package com.cc.test.learn;

/**
 * �̳�MyList�ӿڻ��ڵ�����ʵ��MyLinkedList
 * @author LiDanyang
 * @version 1.0 2018-07-25
 */
public class MyLinkedList implements MyList {
	
	private int size;//������Ԫ������
	private Node head;//ͷָ��
	private Node current;//��ǰ������
	

	
	/**
	 * ����һ��˽���ڲ�������ʵ�ֵ�����Ľ��	 	 
	 */	
	private class Node
	{
		private Object obj;//������
		private Node next;//ָ����
		
		
		//ͷ���Ĺ��췽��
		public Node(Node nextval)
		{
			this.next = nextval;
		}
		
		
		//��ͷ���Ĺ��췽��
		public Node(Object element, Node nextval)
		{
			this.obj = element;
			this.next = nextval;
		}
		
		
		//����β�����ӽ��
		public void addNode(Node newNode) 
		{
			if (this.next == null) 
			{
				this.next = newNode;
			} 
			else 
			{
				this.next.addNode(newNode);
			}
		}

	}
	
	
	
	/**
	 * ��ʼ��һ��������
	 */
	public MyLinkedList()
	{
		this.head = current = new Node(null);
		this.size = 0;
	}
	
	
	/**
	 * ����List��Ԫ������
	 */
	public int size()
	{
		return size;
	}
	
	
	/**
	 * �ж�List�Ƿ�Ϊ��
	 */
	public boolean isEmpty()
	{
		return size == 0;
	}
	
	
	/**
	 * �������element��ӵ�List��β��
	 * @param element
	 */
	public void add(Object element)
	{
		if(element == null)
		{
			return;
		}
		Node newNode = new Node(element,null);
		if(head == null)
		{
			head = newNode;
		}
		else
		{
			head.addNode(newNode);
		}
		size++;
		
	}

	
	/**
	 * ��ȡList���±�Ϊindex��Ԫ�أ��±��0��ʼ��
	 * @param index
	 */
	public Object get(int index)
	{
		if(index < 0 || index > size-1)
		{
			return null;
		}
		else 
		{
			current = head.next;
			int i = 0;
			while(i < index)
			{
				current = current.next;
			}
			return current.obj;
		}

	}
		
	
	/**
     * �� List ���±�Ϊ index ��Ԫ���滻Ϊ element������ index λ��ԭ�е�Ԫ�ط���
     * ��� index Խ�磬��Ҫ�׳��쳣
     * @param index
     * @param element
     */
	public Object set(int index, Object element)
	{
		if(index < 0 || index > size-1)
		{
			try{
				   throw new Exception("�����Ƿ���");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		Object elementOfList;
		get(index);
		elementOfList = current.obj;
		current.obj = element;
		return elementOfList;
	}

    /**
     *  �Ƴ� List ���±�Ϊ index ��Ԫ�أ��������Ԫ�ط���
     *  ��� index Խ�磬��Ҫ�׳��쳣
     * @param index
     */
	public Object remove(int index)
	{
		if(index < 0 || index > size-1)
		{
			try{
				   throw new Exception("�����Ƿ���");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		Object elementOfList;
		get(index);
		elementOfList = current.obj;
		get(index-1);
		current.next.next = current.next;
		size--;
		return elementOfList;			
	}
	
	
	/**
     * ��� List ������Ԫ��
     */
	public void clear()
	{
		this.size = 0;
		this.head = null;
	}
}
