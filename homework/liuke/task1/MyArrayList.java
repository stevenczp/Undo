package com.cc.test.learn;

public class MyArrayList implements MyList{
	//Ĭ�ϳ���Ϊ10
	private Object[] myArray = new Object[10];
	//��ǰ���ϳ���
	private int length = 0;
	
	
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
		//������Ԫ�ظ����ﵽ���鳤��---->����
		if (length == myArray.length) {
			Object [] oldArray = myArray;
			//���ݳ���Ĭ������12
			myArray = new Object[length*2];
			//��ԭ������Ԫ�ظ��Ƶ���������
			length = 0;
			for(Object array : oldArray) {
				myArray[length++] = array;
			}	
		} 
		//�����Ԫ��
		myArray[length++] = element;
		
	}

	//����±��Ƿ�Ϸ�
	public void checkIndex(int index) {
		if(index >= length || index < 0) {
			try {
				throw new Exception("�±�Խ��");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
	}

	//�������ֵԪ��
	@Override
	public Object get(int index) {
		checkIndex(index);
		return myArray[index];			
	}

	//������λ������ֵ
	@Override
	public Object set(int index, Object element) {
		Object oldElement = null;   //��ŵ�ǰ����λ�õ�ֵ
		
		checkIndex(index);    //�ж������Ƿ�Խ��
		 
		oldElement = myArray[index];
		myArray[index] = element;			
		
		return oldElement;
	}

	//������λ���Ƴ�Ԫ��
	@Override
	public Object remove(int index) {
		Object oldElement = null;
		
		checkIndex(index);    //�ж������Ƿ�Խ��
		
		oldElement = myArray[index];
		for(int i = index+1; i < length; i++) {
			myArray[i-1] = myArray[i];
		}
		length--;
		
		return oldElement;
	}

	//��ռ���
	@Override
	public void clear() {
		myArray = new Object[12];
		length=0;
	}
	
	//��ӡ����
	public void printList() {
		for(int i = 0; i < length; i++) {
			System.out.println(myArray[i]);
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
