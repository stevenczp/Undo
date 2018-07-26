package com.cc.test.learn;

/**
 * 继承MyList接口基于单链表实现MyLinkedList
 * @author LiDanyang
 * @version 1.0 2018-07-25
 */
public class MyLinkedList implements MyList {
	
	private int size;//链表内元素总量
	private Node head;//头指针
	private Node current;//当前结点对象
	

	
	/**
	 * 构造一个私有内部类用于实现单链表的结点	 	 
	 */	
	private class Node
	{
		private Object obj;//数据域
		private Node next;//指针域
		
		
		//头结点的构造方法
		public Node(Node nextval)
		{
			this.next = nextval;
		}
		
		
		//非头结点的构造方法
		public Node(Object element, Node nextval)
		{
			this.obj = element;
			this.next = nextval;
		}
		
		
		//链表尾部增加结点
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
	 * 初始化一个空链表
	 */
	public MyLinkedList()
	{
		this.head = current = new Node(null);
		this.size = 0;
	}
	
	
	/**
	 * 返回List内元素总量
	 */
	public int size()
	{
		return size;
	}
	
	
	/**
	 * 判断List是否为空
	 */
	public boolean isEmpty()
	{
		return size == 0;
	}
	
	
	/**
	 * 将传入的element添加到List的尾部
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
	 * 获取List中下标为index的元素（下标从0开始）
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
     * 将 List 中下标为 index 的元素替换为 element，并将 index 位上原有的元素返回
     * 如果 index 越界，需要抛出异常
     * @param index
     * @param element
     */
	public Object set(int index, Object element)
	{
		if(index < 0 || index > size-1)
		{
			try{
				   throw new Exception("参数非法！");
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
     *  移除 List 中下标为 index 的元素，并将这个元素返回
     *  如果 index 越界，需要抛出异常
     * @param index
     */
	public Object remove(int index)
	{
		if(index < 0 || index > size-1)
		{
			try{
				   throw new Exception("参数非法！");
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
     * 清空 List 内所有元素
     */
	public void clear()
	{
		this.size = 0;
		this.head = null;
	}
}
