package inheriance;

public class HelloWorld {
	private String message1;
	private String message2;
	
	public void setMessage1(String message)
	{
		this.message1 = message;
	}
	public void setMessage2(String message)
	{
		this.message2 = message;
	}
	
	public void getMessage1()
	{
		System.out.println("World message 1: "+ message1);
	}
	
	public void getMessage2()
	{
		System.out.println("World message 2: "+ message2);
	}
}
