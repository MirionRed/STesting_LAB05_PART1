package dtt.exercise;

public class Customer {
	private int loyaltyPoints, extraDiscount, defaultDiscount,discount;
	
	public Customer(int loyaltyPoints, int extraDiscount, int defaultDiscount){
		this.defaultDiscount = defaultDiscount;
		this.extraDiscount = extraDiscount;
		this.loyaltyPoints = loyaltyPoints;
	}
	
	public Customer(int discount){
		this.discount = discount;
	}
	
	public int getLoyaltyPoints(){
		return loyaltyPoints;
	}
	public int getExtraDiscount(){
		return extraDiscount;
	}
	public int getDefaultDiscount(){
		return defaultDiscount;
	}
	public int getDiscount(){
		return discount;
	}
	
	public void processPurchase(boolean haveCard, boolean chooseDiscount, int amountSpent){
		if(amountSpent < 0 )throw new IllegalArgumentException();
		
		if(haveCard)
		{
			if (chooseDiscount)
				extraDiscount = defaultDiscount;
			else 
				loyaltyPoints += amountSpent;
		}else if (amountSpent > 100)
			extraDiscount = defaultDiscount;
	}
	
	public boolean processDiscount(boolean openLoyaltyAccount, 
			boolean haveLoyaltyAccount, 
			boolean haveCoupon){
		if (openLoyaltyAccount == true && haveLoyaltyAccount == true) 
			throw new IllegalArgumentException();
		
		if (openLoyaltyAccount)
			discount += 15;
		if (haveLoyaltyAccount)
			discount += 10;
		if (haveCoupon)
			discount += 20;
		
		if(haveCoupon)
			return false;
		else
			return true;
	}
}
