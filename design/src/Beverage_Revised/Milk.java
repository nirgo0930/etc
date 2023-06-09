package Beverage_Revised;

public class Milk extends CondimentDecorator
{
	public Milk(Beverage beverage)
	{
		this.beverage = beverage;
	}
	
	public String getDescription()
	{
		return beverage.getDescription() + ", Milk"; 
	}
	
	public double cost()
	{
		return 0.10 + beverage.cost();
	}
}
