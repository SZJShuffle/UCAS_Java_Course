import java.util.*;

abstract class Car
{	
	String color;
	int price;
	String power;
	int speed;

	Car(String color,int price,String power,int speed){
		this.color = color;
		this.price = price;
		this.power = power;
		this.speed = speed;
	}
	abstract void startup();
	void brake()
	{
		System.out.println("ready to brake...");
		System.out.println("braking...");
		System.out.println("finished...");
	}
	abstract void drive_type();
	
	abstract void getAttr();
}
class EleCar extends Car
{	
	int battery;
	
	EleCar(String color,int price,String power,int speed,int battery)
	{
		super(color,price,power,speed);
		this.battery = battery;
	}
	
	void startup()
	{
		System.out.println("...by the power of battery...");
		System.out.println("the car is starting up...");
	}
	
	void drive_type()
	{
		System.out.println("by artificial")	;
	}
	
	void getAttr(){
		System.out.println("the color of the car is :"+this.color);
		System.out.println("the price of the car is :"+this.price);
		System.out.println("the power of the car is :"+this.power);
		System.out.println("the speed of the car is :"+this.speed);
		System.out.println("the battery capability of the car is :"+this.battery);
	}
}
class AICar extends Car
{	
	AICar(String color,int price,String power,int speed)
	{
		super(color,price,power,speed);
	}
	
	void startup()
	{
		System.out.println("...by the power of both Gasoline and battery...");
		System.out.println("the car is starting up...");
	}
	
	void drive_type()
	{
		System.out.println("by AI algorithm");
	}
	
	void getAttr(){
		System.out.println("the color of the car is :"+this.color);
		System.out.println("the price of the car is :"+this.price);
		System.out.println("the power of the car is :"+this.power);
		System.out.println("the speed of the car is :"+this.speed);
	}
}


public class HW1
{	
	public static void main(String[] args)
	{	
        EleCar car1 = new EleCar("red",150000,"electric",150,3000);
        EleCar car2 = new EleCar("grey",150000,"electric",150,3000);
        AICar car3 = new AICar("white",350000,"hybrid",200);
        AICar car4 = new AICar("blue",350000,"hybrid",300);
        AICar car5 = new AICar("blue",350000,"hybrid",350);
        
        //System.out.println("byd");
        System.out.println("--------Car Attr--------");
        System.out.println("car1");
        car1.getAttr();
        System.out.println("car2");
        car2.getAttr();
        System.out.println("car3");
        car3.getAttr();
        System.out.println("car4");
        car4.getAttr();
        System.out.println("car5");
        car5.getAttr();
        
        System.out.println("--------Arr--------");
        
        ArrayList arr = new ArrayList();
        arr.add(car1);
        arr.add(car2);
        arr.add(car3);
        arr.add(car4);
        arr.add(car5);
        System.out.println(arr);
        
        System.out.println("--------Iterator--------");
        
        //Iterator iter =arr.Iterator();
        for(Iterator iter =arr.iterator();iter.hasNext();)
            System.out.println(iter.next());
        
	}	
}
