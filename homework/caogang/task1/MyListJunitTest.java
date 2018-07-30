package com.cc.test.learn;


import org.junit.jupiter.api.Test;

public class MyListJunitTest {
	
	//MyArrayList≤‚ ‘
	@Test
	public void arrayListTest() {
		MyArrayList arrayList = new MyArrayList();
		//add
		arrayList.add("a");
		arrayList.add("b");
		arrayList.add("c");
		System.out.println(arrayList.toString()+" size:"+arrayList.size()+" isEmpty?:"+arrayList.isEmpty());
		//remove
		arrayList.remove(1);
		System.out.println(arrayList.toString());
		//set
		Object setEle = arrayList.set(0, "g");
		System.out.println(setEle);
		System.out.println(arrayList.toString());
		//get
		Object getEle = arrayList.get(0);
		System.out.println(getEle);
		//clear
		arrayList.clear();
		System.out.println(arrayList.toString()+" size:"+arrayList.size()+" isEmpty?:"+arrayList.isEmpty());
		
		
		MyArrayList arrayList2 = new MyArrayList(2);
		arrayList2.add("a");
		arrayList2.add("b");
		arrayList2.add("c");
		//‘ΩΩÁ“Ï≥£
		/*
		arrayList2.get(3);
		arrayList2.set(3, "a");
		
		System.out.println(arrayList2.toString()+" size:"+arrayList2.size()+" isEmpty?:"+arrayList2.isEmpty());
		
		*/
	}
	
	
	//MyLinkedList≤‚ ‘
	@Test
	public void linkedListTest() {
		MyLinkedList linkedList = new MyLinkedList();
		//add
		linkedList.add("0");
		linkedList.add("1");
		linkedList.add("2");
		linkedList.add("3");
		linkedList.add("4");
		linkedList.add("5");
		System.out.println(linkedList.toString()+" size:"+linkedList.size()+" isEmpty?:"+linkedList.isEmpty());
		//remove
		linkedList.remove(0);
		System.out.println(linkedList.toString());
		//set
		Object setEle = linkedList.set(3, "6");
		System.out.println(setEle);
		System.out.println(linkedList.toString());
		//get
		Object getEle = linkedList.get(4);
		System.out.println(getEle);
		//clear
		linkedList.clear();
		System.out.println(linkedList.toString()+" size:"+linkedList.size()+" isEmpty?:"+linkedList.isEmpty());
	}
}
