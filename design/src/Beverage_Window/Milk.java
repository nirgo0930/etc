package Beverage_Window;

public class Milk extends CondimentDecorator
{
	private Beverage beverage;
	
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
