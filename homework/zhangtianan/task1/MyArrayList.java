package test;
/**@author ���찲
 * @data2018/7/26 ����13:43
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
			Object [] temp = myArray;      //����һ����ʱ���飬����������ݱ�������
			capacity=size*2;
			myArray = new Object[capacity];  //����һ�������飬������Ϊԭ�ȵ�����
			size = 0;
		    for(Object array : temp) 
		    {
			      myArray[size++] = array;		
		    }	
		} 
			myArray[size++] = element;     //������䣬���Ԫ��
	}

	@Override
	public Object get(int index) 
	{    
		
		if(index >= size || index < 0)       //�ж������±��Ƿ���Ϲ淶
		{
			try 
			{
				throw new Exception("�±�Խ��");
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
		Object temp = null;                 //��ʱ�������������浱ǰҪ�ı��ֵ
		if(index >= size || index < 0)      //�ж������±��Ƿ���Ϲ淶
		{
			try
			{
				throw new Exception("�±�Խ��");
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
		Object temp = null;                  //��ʱ�������������漴��Ҫɾ����Ԫ��
		if(index >= size || index < 0)       //�ж������±��Ƿ���Ϲ淶
		{
			try
			{
				throw new Exception("�±�Խ��");
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
		System.out.println("����");
		System.out.println(mytest);
		mytest.remove(2);                //ɾ���±�Ϊ2��Ԫ��
		System.out.println("ɾ��");
		System.out.println(mytest);
		mytest.set(0, 111111);           //���±�Ϊ0��Ԫ���޸�Ϊ111111
		System.out.println("�޸�");
		System.out.println(mytest);
		System.out.println("��ѯ");       //��ѯ�±�Ϊ0��Ԫ��
		System.out.println(mytest.get(0));
	}

}
