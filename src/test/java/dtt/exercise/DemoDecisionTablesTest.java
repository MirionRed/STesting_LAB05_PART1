package dtt.exercise;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class DemoDecisionTablesTest {
	Customer cus = new Customer(0,0,10);
	Customer cusDiscount = new Customer(0);
	@Test
	@Parameters({"false,true, 0,0,0", "false, false, 100, 0,0",
		"false,true,101,10,0","false,false,200,10,0",
		"true,true,100,10,0", "true,true,101,10,0",
		"true,false,100,0,100","true,false,101,0,101"})
	public void testProcessPurchaseValidValues
	(boolean haveCard, boolean chooseDiscount, int amountSpent, int expectedDiscount, int expectedLoyaltyPoints){
		cus.processPurchase(haveCard, chooseDiscount, amountSpent);
		assertEquals(expectedDiscount, cus.getExtraDiscount());
		assertEquals(expectedLoyaltyPoints, cus.getLoyaltyPoints());
	}
	
	@Test(expected=IllegalArgumentException.class)
	@Parameters({"false,true,-1", "false, false,-2", "true,false,-4", "true,true,-3"})
	public void testProcessPurchaseInvalidValues(boolean haveCard, boolean chooseDiscount, int amountSpent){
		cus.processPurchase(haveCard, chooseDiscount, amountSpent);
	}
	
	@Test(expected=IllegalArgumentException.class)
	@Parameters({"true, true, true", "true, true, false"})
	public void testProcessDiscountInvalidValues(
			boolean openLoyaltyAccount, 
			boolean haveLoyaltyAccount, 
			boolean haveCoupon){
		cusDiscount.processDiscount(openLoyaltyAccount, 
				haveLoyaltyAccount, 
				haveCoupon);
	}
	
	@Test
	@Parameters({"true, false, false, 15", 
		"true, false, true, 35",
		"false, true, true, 30",
		"false, false, true, 20",
		"false, true, false, 10",
		"false, false, false, 0"})
	public void testProcessDiscountValidValues(
			boolean openLoyaltyAccount, 
			boolean haveLoyaltyAccount, 
			boolean haveCoupon,
			int expectedResult){
		boolean result = cusDiscount.processDiscount(openLoyaltyAccount, 
				haveLoyaltyAccount, 
				haveCoupon);
		assertEquals(expectedResult, cusDiscount.getDiscount());
	}
	
	
}
