package com.cc.test.learn;

public class MyArrayList implements MyList{
	//默认长度为10
	private Object[] myArray = new Object[10];
	//当前集合长度
	private int length = 0;
	
	
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
		//集合中元素个数达到数组长度---->扩容
		if (length == myArray.length) {
			Object [] oldArray = myArray;
			//扩容长度默认增加12
			myArray = new Object[length*2];
			//将原来数组元素复制到新数组中
			length = 0;
			for(Object array : oldArray) {
				myArray[length++] = array;
			}	
		} 
		//添加新元素
		myArray[length++] = element;
		
	}

	//检测下标是否合法
	public void checkIndex(int index) {
		if(index >= length || index < 0) {
			try {
				throw new Exception("下标越界");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
	}

	//获得索引值元素
	@Override
	public Object get(int index) {
		checkIndex(index);
		return myArray[index];			
	}

	//按索引位置设置值
	@Override
	public Object set(int index, Object element) {
		Object oldElement = null;   //存放当前索引位置的值
		
		checkIndex(index);    //判断索引是否越界
		 
		oldElement = myArray[index];
		myArray[index] = element;			
		
		return oldElement;
	}

	//按索引位置移除元素
	@Override
	public Object remove(int index) {
		Object oldElement = null;
		
		checkIndex(index);    //判断索引是否越界
		
		oldElement = myArray[index];
		for(int i = index+1; i < length; i++) {
			myArray[i-1] = myArray[i];
		}
		length--;
		
		return oldElement;
	}

	//清空集合
	@Override
	public void clear() {
		myArray = new Object[12];
		length=0;
	}
	
	//打印集合
	public void printList() {
		for(int i = 0; i < length; i++) {
			System.out.println(myArray[i]);
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
//			list.remove(-1);
			for(int i =0;i< 7;i++) {
				list.remove(i);		
			}
			list.printList();
			System.out.println("-----------");
//			list.set(3, "h");
			list.printList();
			System.out.println("-----------");
			list.clear();
			System.out.println(list.isEmpty());
		}

}
