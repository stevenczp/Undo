package com.cc.test.learn;

import java.util.Arrays;

/*
 *下标从0开始 
 * */
public class MyArrayList<T> implements MyList<T> {
	private T[] list;
	private int size = 0;
	private static final int initcapacity = 10;
	private int capacity = initcapacity;

	MyArrayList() {
		this(initcapacity);
	}

	MyArrayList(int capacity) {
		this.capacity = capacity;
		if (capacity > 0) {
			list = (T[]) new Object[capacity];
		} else if (capacity == 0) {
			list = null;
		} else {
			throw new IllegalArgumentException("容量输入错误！");
		}
	}

	public void add(T element) {
		if (size < capacity) {
			list[size++] = element;
		} else {// 扩容
			grow(size);
			list[size++] = element;
		}
	}

	@Override
	public T get(int index) {
		if (index >= size || index < 0) {
			throw new IllegalArgumentException("指针越界！");
		}
		return list[index];
	}

	@Override
	public T set(int index, T element) {
		if (index >= size || index < 0) {
			throw new IllegalArgumentException("指针越界！");
		}
		T temp = list[index];
		list[index] = element;
		return temp;
	}

	@Override
	public T remove(int index) {
		if (size == 0) {
			throw new IllegalArgumentException("list为空！");
		}
		if (index >= size || index < 0) {
			throw new IllegalArgumentException("指针越界！");
		}
		T temp = list[index];
		int t = --size;
		for (int i = index; i < t; i++) {
			list[i] = list[i + 1];
			// System.out.println(toString());
		}

		return temp;
	}

	@Override
	public void clear() {
		size = 0;
		capacity = 0;
		list = null;
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

	private void grow(int minCapacity) {
		if (list == null) {
			list = (T[]) new Object[initcapacity];
			capacity = initcapacity;
		} else {
			capacity  =  minCapacity * 2;
			list = Arrays.copyOf(list, capacity);
		}
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < size; i++) {
			sb.append(list[i].toString() + " ");
		}
		return sb.toString();
	}
}
