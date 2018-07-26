package com.cc.test.learn;

/**
 * 继承MyList接口基于数组实现MyLinkedList
 * @author LiDanyang
 * @version 1.0 2018-07-26
 */
public class MyArrayList implements MyList{
	
	private Object[] originalArray = new Object[100];
	private int currentLength;
	
	/**
	 * 检查数组存储是否已满，若满，进行扩容
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
     * 返回List内元素总量
     */
	public int size() 
	{
		return currentLength;
	}

	/**
	 * 判断List是否为空
	 */
	public boolean isEmpty() 
	{
		return currentLength == 0;
	}

	
	/**
	 * 将传入的element添加到List的尾部
	 * @param element
	 */
	public void add(Object element) 
	{
		checkSize();
		originalArray[currentLength] = element;
		currentLength++;
		
	}

	/**
     * 获取 List 下标为 index 的元素（下标从0开始）
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
     * 将 List 中下标为 index 的元素替换为 element，并将 index 位上原有的元素返回
     * 如果 index 越界，需要抛出异常
     * @param index
     * @param element
     */
	public Object set(int index, Object element) 
	{
		if(index < 0 || index > currentLength-1)
		{
			try{
				   throw new Exception("参数非法！");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		Object elementOfList = originalArray[index];
		originalArray[index] = element;
		return elementOfList;
	}

    /**
     *  移除 List 中下标为 index 的元素，并将这个元素返回
     *  如果 index 越界，需要抛出异常
     * @param index
     */
	public Object remove(int index) 
	{
		if(index < 0 || index > currentLength-1)
		{
			try{
				   throw new Exception("参数非法！");
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
	 * 清空List内所有元素
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
