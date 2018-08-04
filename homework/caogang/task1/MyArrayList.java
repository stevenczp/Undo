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
			//容量已满(--每次扩容只增长1的长度，在大量插入时效率低，JDK里是1.5倍扩容)
			//若是空list 则默认给10的容量 
			int cap = (array.length==0 ? 10 : size + (size >> 1));
			Object[] arrayAdd = new Object[cap];
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
			//copy数组 缩容(--不需更换底层数组 直接在原数组里移动元素，size - 1)
			Object replacedEle = array[index];
			//Object[] array2 = new Object[size-1];
			int k = 0;
			for (int i = 0; i < size; i++) {
				if (i!=index) {
					array[k++] = array[i];
				}
			}
			//array = array2;
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
	
	public Object[] toArray() {
		return array;
	}

}
