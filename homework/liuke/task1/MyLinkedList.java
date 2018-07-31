package com.cc.test.learn;



public class MyLinkedList implements MyList{
	
	//�������׸�Ԫ��
	private Node first = null;
	//���������һ��Ԫ��
	private Node last = null;
	//�����ϳ���
	private int length = 0;
	
	//�����Ͻڵ�
	private static class Node {
		Object item;   //�ڵ�ֵ
		Node next;     //�ڵ�ָ��
		Node prev;     //ǰ��ָ��,���ָ��
		
		
		Node(Node prev, Object element, Node next){
			this.item = element;
			this.next = next;
			this.prev = prev;
		}
	}
	

	//���ؼ��ϳ���
	@Override
	public int size() {
		return length;
	}

	//�жϼ����Ƿ�Ϊ��
	@Override
	public boolean isEmpty() {
		if (length == 0) {
			return true;
		} else {
			return false;			
		}
	}

	//���������һ��Ԫ��
	@Override
	public void add(Object element) {
		
		if (this.isEmpty()) {
			//����Ϊ��
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
	
	
	//�ж������Ƿ�Խ��
	public void checkIndex(int index) {
		
		if(index >= length || index < 0) {
			try {
				throw new Exception("�±�Խ��");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public Node findNodeByIndex(int index) {
		checkIndex(index);    //�ж������Ƿ�Խ��
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
	
	
	

	//�������ֵԪ��
	@Override
	public Object get(int index) {
//		checkIndex(index);    //�ж������Ƿ�Խ��
		Node node = findNodeByIndex(index);
		return node.item; //��������ǰ����λ��
	}
	
	//������λ������ֵ
	@Override
	public Object set(int index, Object element) {
//		checkIndex(index);    //�ж������Ƿ�Խ��
		
		Node node = findNodeByIndex(index); //��������ǰ����λ��
		
		Object oldValue = node.item;
		node.item = element;
		return oldValue;
	}
	

	
	
	//������λ���Ƴ�Ԫ��
	@Override
	public Object remove(int index) {
//		checkIndex(index);    //�ж������Ƿ�Խ��
		
		Node node = findNodeByIndex(index); //��������ǰ����λ��
		
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
	
	//��ռ���
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
	
	//��ӡ����
	public void printList() {
		Node n = first;
		for (int i = 0; i< length; i++) {
			System.out.println(n.item);
			n = n.next;
		}
	}
	
	//����
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
