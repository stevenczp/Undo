package com.cc.test.learn;


public class MyLinkedList implements MyList {

	private int size;
	private Node first;
	private Node last;
	
	static class Node{
		Node pre;
		Node next;
		Object data;
		
		Node() {
			
		}
		
		Node(Node pre, Object data, Node next){
			this.pre = pre;
			this.data = data;
			this.next = next;
		}
	}
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size==0;
	}

	@Override
	public void add(Object element) {
		Node prelast = last;
		Node addNode = new Node(prelast, element, null);
		last = addNode;
		//list为空 特殊情况
		if (prelast==null) {
			first = addNode;
		}else {
			prelast.next = addNode;
		}
		
		size++;

	}

	@Override
	public Object get(int index) {
		if (index>=0 && index<size) {
			Node getNode = first;
			for (int i = 0; i < index; i++) {
				getNode = getNode.next;
			}
			return getNode.data;
		} else {
			throw new IndexOutOfBoundsException("索引"+index+"越界");
		}
	}

	@Override
	public Object set(int index, Object element) {
		if (index>=0 && index<size) {
			Node setNode = first;
			for (int i = 0; i < index; i++) {
				setNode = setNode.next;
			}
			Object replacedEle = setNode.data;
			setNode.data = element;
			return replacedEle;
		} else {
			throw new IndexOutOfBoundsException("索引"+index+"越界");
		}
	}

	@Override
	public Object remove(int index) {
		if (index>=0 && index<size) {
			Node removeNode = first;
			for (int i = 0; i < index; i++) {
				removeNode = removeNode.next;
			}
			Object removeData = removeNode.data;
			//删除节点 为 首/尾节点的特殊情况(-----不能else if 若只剩一个节点 则  既是  first又是 last)
			if (removeNode == first) {
				first = removeNode.next;
				//first.pre = null;
			} else {
				removeNode.pre.next = removeNode.next;
			}
			
			if (removeNode == last) {
				last = removeNode.pre;
				//last.next = null;
			} else {
				removeNode.next.pre = removeNode.pre;
			}
			
//			removeNode.next.pre = removeNode.pre;
//			removeNode.pre.next = removeNode.next;
			removeNode.pre = null;
			removeNode.next = null;
			removeNode.data = null;
		
			size--;
			return removeData;
		} else {
			throw new IndexOutOfBoundsException("索引"+index+"越界");
		}
	}

	@Override
	public void clear() {
		Node clearNode = first;
		for (int i = 0; i < size && clearNode!=null; i++) {
			Node clearNext = clearNode.next;//-----加入 clearNode!=null的判断 去除 空指针错误
			clearNode.pre = null;
			clearNode.data = null;
			clearNode.next = null;
			clearNode = clearNext;
		}
		
		first = last = null;
		size = 0;
	}
	
	//输出list中元素构成的字符串
		public String toString() {
			Node outNode = first;
			String out = "[ ";
			for (int i = 0; i < size; i++) {
				out += outNode.data+" ";
				outNode = outNode.next;
			}
			out += "]";
			return out;
		}

}
