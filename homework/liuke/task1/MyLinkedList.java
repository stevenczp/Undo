package com.cc.test.learn;



public class MyLinkedList implements MyList{
	
	//链表集合首个元素
	private Node first = null;
	//链表集合最后一个元素
	private Node last = null;
	//链表集合长度
	private int length = 0;
	
	//链表集合节点
	private static class Node {
		Object item;   //节点值
		Node next;     //节点指针
		Node prev;     //前驱指针,后记指针
		
		
		Node(Node prev, Object element, Node next){
			this.item = element;
			this.next = next;
			this.prev = prev;
		}
	}
	

	//返回集合长度
	@Override
	public int size() {
		return length;
	}

	//判断集合是否为空
	@Override
	public boolean isEmpty() {
		if (length == 0) {
			return true;
		} else {
			return false;			
		}
	}

	//给集合添加一个元素
	@Override
	public void add(Object element) {
		
		if (this.isEmpty()) {
			//集合为空
			first = last = new Node(last, element, first);
			first.prev = last;
			last.next = first;
			length++;
		} else {
			Node newNode = new Node(last, element, first);
			last.next = newNode;
			first.prev = newNode;
			last = newNode;
			length++;
		}
	}
	
	
	//判断索引是否越界
	public void checkIndex(int index) {
		
		if(index >= length || index < 0) {
			try {
				throw new Exception("下标越界");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public Node findNodeByIndex(int index) {
		checkIndex(index);    //判断索引是否越界
		if (index > length/2) {
			Node node = last;
			for(int i = length-1; i > index; i--) {
				node = node.prev;
			}
			return node;
			
		} else {
	
			Node node = first;
			for(int i = 0; i < index; i++) {
				node = node.next;
			}
			return node;
		}
		
	}
	
	
	

	//获得索引值元素
	@Override
	public Object get(int index) {
//		checkIndex(index);    //判断索引是否越界
		Node node = findNodeByIndex(index);
		return node.item; //遍历到当前索引位置
	}
	
	//按索引位置设置值
	@Override
	public Object set(int index, Object element) {
//		checkIndex(index);    //判断索引是否越界
		
		Node node = findNodeByIndex(index); //遍历到当前索引位置
		
		Object oldValue = node.item;
		node.item = element;
		return oldValue;
	}
	

	
	
	//按索引位置移除元素
	@Override
	public Object remove(int index) {
//		checkIndex(index);    //判断索引是否越界
		
		Node node = findNodeByIndex(index); //遍历到当前索引位置
		
		if (node == first) {
			first = node.next;
		} else if (node == last) {
			last = node.prev;
		}
	
		Object oldValue = node.item;
		node.next.prev = node.prev;
		node.prev.next = node.next;
		
		length--;
		return oldValue;
	}
	
	//清空集合
	@Override
	public void clear() {
		first = last = null;
		Node current = first;
		while(current != last) {
			current = current.next;
			first = null;
			first = current;
		}
		length = 0;
	}
	
	//打印集合
	public void printList() {
		Node n = first;
		for (int i = 0; i< length; i++) {
			System.out.println(n.item);
			n = n.next;
		}
	}
	
	//测试
	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		list.add("a");		
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		list.add("f");
		list.add("g");
		list.printList();
		System.out.println("-----------");
		System.out.println(list.get(2));
		System.out.println("-----------");
//		list.remove(-1);
		for(int i = 6;i >= 0;i--) {
			list.remove(i);		
		}
		list.printList();
		System.out.println("-----------");
//		list.set(3, "h");
		list.printList();
		System.out.println("-----------");
		list.clear();
		System.out.println(list.isEmpty());
	}
}
