class Data
{
	private int data;
	private Data()
	{
		data++;
		System.out.println("object is constructed");
	}
	public void setdata(int x) /*accessor methods(setdata) and (getdata)*/
	{
		data+=x;
	}
	public int getdata()
	{
		return data;
	}
	//static factory method 
	public static Data createObject()
	{
		Data aa=new Data();
		return aa;
	}
}
public class encapsulation
{
  public static void main(String[] args) {
  	     Data d1=Data.createObject();
  	     d1.setdata(10);
  	     System.out.println("data is "+d1.getdata());
  	     Data d2=Data.createObject();
  	     d2.setdata(12);
  	     System.out.println("data is "+d2.getdata());
  }
}