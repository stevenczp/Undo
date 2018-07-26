package test;
/**@author 张天安
 * @data2018/7/26 下午13:43
*/
public class MyArrayList implements MyList
{

	private int size=0;
	private final int initcapacity=10;
	private int capacity=initcapacity;
	private Object[] myArray = new Object[initcapacity];
	@Override
	public int size() 
	{
		return size;
	}

	@Override
	public boolean isEmpty() 
	{	
		return size==0;
	}

	@Override
	public void add(Object element)
	{		
		if (size == myArray.length) 
		{
			Object [] temp = myArray;      //定义一个临时数组，把数组的数据保留下来
			capacity=size*2;
			myArray = new Object[capacity];  //定义一个新数组，容量变为原先的两倍
			size = 0;
		    for(Object array : temp) 
		    {
			      myArray[size++] = array;		
		    }	
		} 
			myArray[size++] = element;     //核心语句，添加元素
	}

	@Override
	public Object get(int index) 
	{    
		
		if(index >= size || index < 0)       //判断数组下标是否符合规范
		{
			try 
			{
				throw new Exception("下标越界");
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		} 
		return myArray[index];
	}

	@Override
	public Object set(int index, Object element) 
	{
		Object temp = null;                 //临时变量，用来保存当前要改变的值
		if(index >= size || index < 0)      //判断数组下标是否符合规范
		{
			try
			{
				throw new Exception("下标越界");
			} 
			catch (Exception e)
			{
				e.printStackTrace();
			}
		} 
		else 
		{
			temp = myArray[index];
			myArray[index] = element;			
		}
		return temp;
	}

	@Override
	public Object remove(int index) 
	{
		Object temp = null;                  //临时变量，用来保存即将要删除的元素
		if(index >= size || index < 0)       //判断数组下标是否符合规范
		{
			try
			{
				throw new Exception("下标越界");
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}               
			temp = myArray[index];
			for(int i = index+1; i < size; i++) 
			{
				myArray[i-1] = myArray[i];
			}
			size--;
		return temp;
	}
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		myArray=null;
		capacity=0;
		size=0;
	}
	
     @Override
	public String toString() 
    {
    	String s="";
		for(int i=0;i<size;i++)
			s=s+myArray[i];
    	 return s;
	}

	public static void main(String[] args)
    {
		MyArrayList mytest =new MyArrayList();
		mytest.add("abc");
		mytest.add("def");
		mytest.add("ghi");
		mytest.add("gkl");
		mytest.add(12);
		mytest.add(34);
		mytest.add(56);
		System.out.println("增加");
		System.out.println(mytest);
		mytest.remove(2);                //删除下标为2的元素
		System.out.println("删除");
		System.out.println(mytest);
		mytest.set(0, 111111);           //把下标为0的元素修改为111111
		System.out.println("修改");
		System.out.println(mytest);
		System.out.println("查询");       //查询下标为0的元素
		System.out.println(mytest.get(0));
	}

}
