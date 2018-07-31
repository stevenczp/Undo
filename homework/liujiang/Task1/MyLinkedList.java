package com.cc.test.learn;
/*
 *下标从0开始 
 * */
public class MyLinkedList<T> implements MyList<T> {
	private int size = 0;
	private final Node head = new Node();
	private Node current = head;

	public MyLinkedList() {
	}

	@Override
	public void add(T element) {
		Node temp = new Node();
		temp.setData(element);
		current.setNext(temp);
		temp.setPre(current);
		current = temp;
		++size;
	}

	@Override
	public T get(int index) {
		if (index >= size || index < 0) {
			throw new IllegalArgumentException("指针越界！");
		}
		Node temp = head;
		for(int i=0;i<=index;i++){
			temp = temp.getNext();
		}
		return temp.getData();
	}

	@Override
	public T set(int index, T element) {
		if (index >= size || index < 0) {
			throw new IllegalArgumentException("指针越界！");
		}
		Node temp = head;
		for(int i=0;i<=index;i++){
			temp = temp.getNext();
		}
		T tempData = temp.getData();
		temp.setData(element);
		return tempData;
	}

	@Override
	public T remove(int index) {
		if (size == 0) {
			throw new IllegalArgumentException("list为空！");
		}
		if (index >= size || index < 0) {
			throw new IllegalArgumentException("指针越界！");
		}
		Node temp;
		if(index==size-1){
			temp = current;
			current = current.getPre();
			current.setNext(null);
			temp.setPre(null);
		}else{
			temp = head;
			Node previous;
			for(int i=0;i<=index;i++){
				temp = temp.getNext();
			}
			previous = temp.getPre();
			previous.setNext(temp.getNext());
			temp.getNext().setPre(previous);
			temp.setNext(null);
			temp.setPre(null);
		}
		--size;
		return temp.getData();
	}

	@Override
	public void clear() {
		head.setData(null);
		head.setNext(null);
		head.setPre(null);
		current = head;
		size = 0;
	}
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		Node temp = head;
		for (int i = 0; i < size; i++) {
			temp = temp.getNext();
			sb.append(temp.getData() + " ");
		}
		
		return sb.toString();
	}

	class Node {
		private T data = null;
		private Node pre= null;
		private Node next= null;

		public Node getPre() {
			return pre;
		}

		public void setPre(Node pre) {
			this.pre = pre;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

	}
}
