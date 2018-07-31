package com.ds;

import java.util.ArrayList;

import org.junit.Test;

/**
 * 测试类
 * @author 朱立松
 *
 */
public class TestCase {
	
	@Test
	public void testMyLinkedList() {
		MyList linkedList = new MyLinkedList(null, 1);
		System.out.println("初始化时linkedList是否为空:" + linkedList.isEmpty());
		System.out.println("此时linkedList的容量为：" + linkedList.size());
		linkedList.add(2);
		linkedList.add(3);
		linkedList.add(4);
		linkedList.add(5);
		System.out.println("添加若干元素后，此时linkedList长度为:" +linkedList.size());
		System.out.println("此时linkedList第二个元素为：" + linkedList.get(1));
		//删除第二个元素
		linkedList.remove(1);
		System.out.println("移除第二个元素后，此时linkedList长度为:" +linkedList.size());
		System.out.println("此时linkedList第二个元素为：" + linkedList.get(1));
//		linkedList.add(1);
//		linkedList.add(1);
//		linkedList.add(1);
		//更新第二个元素
		linkedList.set(1, 6);
		System.out.println("更新第二个元素，此时linkedList长度为:" +linkedList.size());
		System.out.println("此时linkedList第二个元素为：" + linkedList.get(1));
			
		
		//清除
		linkedList.clear();
		System.out.println("清空linkedList， linkedList是否为空:" + linkedList.isEmpty());
		System.out.println("此时linkedList的容量为：" + linkedList.size());
	}
	
	
	@Test
	public void testMyArrayList() {
		MyList arrayList= new MyArrayList(new ArrayList<Object>());
		System.out.println("初始化时arrayList是否为空:" + arrayList.isEmpty());
		System.out.println("此时ArrayList的容量为：" + arrayList.size());
		arrayList.add(0);
		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(3);
		arrayList.add(4);
		arrayList.add(5);
		System.out.println("添加若干元素后，此时arrayList长度为:" +arrayList.size());
		System.out.println("此时arrayList第三个元素为：" + arrayList.get(2));
		
		arrayList.remove(2);
		System.out.println("移除第三个元素后，此时arrayList长度为:" +arrayList.size());
		System.out.println("此时arrayList第三个元素为：" + arrayList.get(2));
		
		//更新第三个元素
		arrayList.set(2, 6);
		System.out.println("更新第三个元素，此时arrayList长度为:" +arrayList.size());
		System.out.println("此时arrayList第三个元素为：" + arrayList.get(2));
		
		arrayList.clear();
		System.out.println("清空arrayList， arrayList是否为空:" + arrayList.isEmpty());
		System.out.println("此时ArrayList的容量为：" + arrayList.size());
		
		
		
		
	}
	
	
	
	


}
