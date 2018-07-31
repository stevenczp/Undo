package com.cc.test.learn;


public class MyArrayList implements MyList{

	private int size;
	private static final Object[] EMPTY= {};
	private Object[] array; 
	
	public MyArrayList() {
		this.array = EMPTY;
	}
	
	public MyArrayList(int capicity) {
		if (capicity > 0) {
			this.array = new Object[capicity];
		} else if (capicity == 0) {
			this.array = EMPTY;
		} else {
			throw new IllegalArgumentException("非法容量："+capicity);
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
		if(size < array.length) {
			array[size++] = element;
		}else {
			//容量已满
			Object[] arrayAdd = new Object[size+1];
			//copy数组 扩容
			for (int i = 0; i < array.length; i++) {
				arrayAdd[i] = array[i];
			}
			arrayAdd[size++] = element;
			array = arrayAdd;
		}
	}

	@Override
	public Object get(int index) {
		return array[index];
	}

	@Override
	public Object set(int index, Object element) {
		if(index>=0 && index<size) {
			Object replacedEle = array[index];
			array[index] = element;
			return replacedEle;
		}else {
			throw new IndexOutOfBoundsException("索引"+index+"越界");
		}
	}

	@Override
	public Object remove(int index) {
		//index是否越界
		if(index>=0 && index<size) {
			//copy数组 缩容
			Object replacedEle = array[index];
			Object[] array2 = new Object[size-1];
			int k = 0;
			for (int i = 0; i < size; i++) {
				if (i!=index) {
					array2[k++] = array[i];
				}
			}
			array = array2;
			size--;
			return replacedEle;
		}else {
			throw new IndexOutOfBoundsException("索引"+index+"越界");
		}
	}

	@Override
	public void clear() {
		for (int i = 0; i < size; i++) {
			array[i] = null;
		}
		size = 0;
	}
	//输出list中元素构成的字符串
	public String toString() {
		String out = "[ ";
		for (int i = 0; i < size; i++) {
			out += array[i]+" ";
		}
		out += "]";
		return out;
	}

}
