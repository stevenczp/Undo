package com.ds;

import java.util.ArrayList;
import java.util.List;

public class MyArrayList implements MyList {
	
	//定义一个List成员变量
	private List<Object>  list ; 
	
	
    
	public List<Object> getList() {
		return list;
	}

	public void setList(List<Object> list) {
		this.list = list;
	}
	
	//用ArrayList来构造List
	public MyArrayList(ArrayList<Object> arrlist) {
		this.list = arrlist;
	}

	@Override
	public int size() {
		return this.list.size();
	}

	@Override
	public boolean isEmpty() {
		return this.list.isEmpty();
	}

	@Override
	public void add(Object element) {
		this.list.add(element);
	}

	@Override
	public Object get(int index) {
		//若index小于0或大于等于list的长度
		if(index >= this.list.size() || index < 0) {
			return null;
		}
		return this.list.get(index);
	}

	@Override
	public Object set(int index, Object element) {
		//若index小于0或大于list的长度
		if( index > this.list.size() || index <0) {
			return null;
		}else if( index == this.list.size()) {
			//若index等于list长度，则添加element
			this.list.add(element);
			return element;
		}
		//其余条件直接set
		this.list.set(index, element);
		return element;
	}

	@Override
	public Object remove(int index) {
		if( index >= this.list.size() || index < 0) {
			System.err.println("index越界");
			return null;
		}
		Object obj = this.list.get(index);
		this.list.remove(index);
		return obj;
	}

	@Override
	public void clear() {
		//当list为空或size为0时，表示list已为空
		if(this.list == null || this.list.size() == 0) {
			return ;
		}
		this.list = null;

	}

}
