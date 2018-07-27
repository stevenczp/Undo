package com.ds;

public class MyLinkedList implements MyList {
	
	//节点属性
	private Object object;
	
	//下一个元素
	private MyLinkedList next;
	
	
	
	
	public MyLinkedList getNext() {
		return next;
	}

	public void setNext(MyLinkedList next) {
		this.next = next;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public MyLinkedList(MyLinkedList next, Object object) {
		super();
		this.next = next;
		this.object = object;
	}

	@Override
	public int size() {
		//如果当前类为空
		if(this == null) {
			return 0;
		}else {
			//遍历链表
			int count = 1;
			MyLinkedList node = this;
			while(node.next != null) {
				count ++;
				node = node.next;
			}
			return count;
		}
		
		
		
	}

	@Override
	public boolean isEmpty() {
		//当前节点的object和next属性为空时返回null
		if(this.object == null && this.next == null) {
			return true;
		}
		return false;
	}

	@Override
	public void add(Object element) {
		//若链表非空
		if(! this.isEmpty()) {
			//构建一个节点变量指向当前节点
			MyLinkedList node = this;
			//循环找到最后一个节点
			while( node.next != null) {
				node = node.next;
			}
			//添加一个新节点，新节点的next为空
			node.next = new MyLinkedList(null, element);
			return ;
		}
		//当前节点为空，set属性就完成了add
		this.next = null;
		this.object = element;

	}

	@Override
	public Object get(int index) {
		//若index小于0或当前首节点为空，则返回null
		if(index < 0 || this.isEmpty()) {
			return null;
		}
		int count = 0;
		MyLinkedList node = this;
		//遍历链表
		while(count < index) {
			node = node.next;
			count ++;
			//若当前遍历的node已为空，则返回null
			if(node == null)
				return null;
		}
		//返回得到的object属性
		return node.getObject();
	}

	@Override
	public Object set(int index, Object element) {
		if(index < 0 ) {
			return null;
		}
		int count = 0;
		MyLinkedList node = this;
		//遍历链表
		while(count < index) {
			node = node.next;
			count++;
			//若当前遍历的node已为空，表示index大于链表长度，则返回null
			if( node == null) {
				return null;
			}
		}
		node.setObject(element);
		return element;
	}

	@Override
	public Object remove(int index) {
		MyLinkedList node = this.next;
		//当index小于0或当前链表为空，则返回null
		if(index < 0 || this.isEmpty() ) {
			return null;
		}else if( index == 0) {
			//若index等于0，让this指向下一个元素，返回下一个元素的object
			this.setObject(node.object);
			this.setNext(node.next);
			return node.object;
		}else {
			//令node重新指向首节点，以找到对应index标号节点的前一个节点，便于删除
			node = this;
			int count = 1;
			while (count < index) {
				node = node.next;
				count ++;
				if(node == null) {
					return null;
				}
			}
			Object object = node.getObject();
			node.next = node.next.next;
			return object;	
			
		}
		
	}

	@Override
	public void clear() {
		//两个属性直接为空，运行结束jvm会回收该变量
		this.setNext(null);
		this.setObject(null);

	}

}
