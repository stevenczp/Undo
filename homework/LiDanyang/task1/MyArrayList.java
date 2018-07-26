package com.cc.test.learn;

/**
 * �̳�MyList�ӿڻ�������ʵ��MyLinkedList
 * @author LiDanyang
 * @version 1.0 2018-07-26
 */
public class MyArrayList implements MyList{
	
	private Object[] originalArray = new Object[100];
	private int currentLength;
	
	/**
	 * �������洢�Ƿ���������������������
	 */
	public void checkSize()
	{
		if(currentLength == originalArray.length)
		{
			Object[] newArray= new Object[originalArray.length*2];
			for(int i = 0;i < currentLength;i++)
			{
				newArray[i] = originalArray[i];
			}
			originalArray = newArray;
		}
	}

    /**
     * ����List��Ԫ������
     */
	public int size() 
	{
		return currentLength;
	}

	/**
	 * �ж�List�Ƿ�Ϊ��
	 */
	public boolean isEmpty() 
	{
		return currentLength == 0;
	}

	
	/**
	 * �������element��ӵ�List��β��
	 * @param element
	 */
	public void add(Object element) 
	{
		checkSize();
		originalArray[currentLength] = element;
		currentLength++;
		
	}

	/**
     * ��ȡ List �±�Ϊ index ��Ԫ�أ��±��0��ʼ��
     * @param index
     */
	public Object get(int index) 
	{
		if(index < 0 || index > currentLength-1)
		{
			return null;
		}
		else 
		{
			return originalArray[index];
		}
	
	}

	/**
     * �� List ���±�Ϊ index ��Ԫ���滻Ϊ element������ index λ��ԭ�е�Ԫ�ط���
     * ��� index Խ�磬��Ҫ�׳��쳣
     * @param index
     * @param element
     */
	public Object set(int index, Object element) 
	{
		if(index < 0 || index > currentLength-1)
		{
			try{
				   throw new Exception("�����Ƿ���");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		Object elementOfList = originalArray[index];
		originalArray[index] = element;
		return elementOfList;
	}

    /**
     *  �Ƴ� List ���±�Ϊ index ��Ԫ�أ��������Ԫ�ط���
     *  ��� index Խ�磬��Ҫ�׳��쳣
     * @param index
     */
	public Object remove(int index) 
	{
		if(index < 0 || index > currentLength-1)
		{
			try{
				   throw new Exception("�����Ƿ���");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		Object elementOfList = originalArray[index];
		for(int i = index;i < currentLength;i++)
		{
			originalArray[i] = originalArray[i+1];
		}
		return elementOfList;
		
	}

	/**
	 * ���List������Ԫ��
	 */
	public void clear() 
	{
		for(int i = 0;i < currentLength;i++)
		{
			originalArray[i] = null;
		}
		currentLength = 0;
		
	}

}
