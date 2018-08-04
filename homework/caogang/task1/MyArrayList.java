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
			throw new IllegalArgumentException("�Ƿ�������"+capicity);
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
			//��������(--ÿ������ֻ����1�ĳ��ȣ��ڴ�������ʱЧ�ʵͣ�JDK����1.5������)
			//���ǿ�list ��Ĭ�ϸ�10������ 
			int cap = (array.length==0 ? 10 : size + (size >> 1));
			Object[] arrayAdd = new Object[cap];
			//copy���� ����
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
			throw new IndexOutOfBoundsException("����"+index+"Խ��");
		}
	}

	@Override
	public Object remove(int index) {
		//index�Ƿ�Խ��
		if(index>=0 && index<size) {
			//copy���� ����(--��������ײ����� ֱ����ԭ�������ƶ�Ԫ�أ�size - 1)
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
			throw new IndexOutOfBoundsException("����"+index+"Խ��");
		}
	}

	@Override
	public void clear() {
		for (int i = 0; i < size; i++) {
			array[i] = null;
		}
		size = 0;
	}
	//���list��Ԫ�ع��ɵ��ַ���
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
