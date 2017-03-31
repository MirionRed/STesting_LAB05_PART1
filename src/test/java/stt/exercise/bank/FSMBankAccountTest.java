package stt.exercise.bank;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class FSMBankAccountTest {
	/*
	@Test
	@Parameters({
		"addMoney, 0, 0, -500, empty, 0, 0, present",
		"addMoney, 100, 0, -500, empty, 0, 100, present",
		"withdrawMoney, 0, 0, -500, empty, 0, 0, present"
	})
	public void testEmptyState(AccountEvents eventToDo, int amount,
			int overdraftLimit, int currentBalance, AccountStates currentState,
			int expectedOverDraftLimit, int expectedCurrentBalance,
			AccountStates expectedCurrentState){
		FSMBankAccount fba = new FSMBankAccount(
				-500,0,AccountStates.empty);
		fba.processEvent(eventToDo, amount);
		assertEquals(expectedCurrentState, fba.getCurrentState());
		assertEquals(expectedCurrentBalance, fba.getCurrentBalance());
		assertEquals(expectedOverDraftLimit, fba.getOverdraftLimit());
	}
	*/
	@Test
	@Parameters({
		"addMoney, 100, -500, 100, present",
		"withdrawMoney, 100, -500, -100, overdrawn"
	})
	public void testEmptyState(AccountEvents eventToDo, int amount,
			int expectedOverDraftLimit, int expectedCurrentBalance,
			AccountStates expectedCurrentState){
		FSMBankAccount fba = new FSMBankAccount(
				-500,0,AccountStates.empty);
		fba.processEvent(eventToDo, amount);
		assertEquals(expectedCurrentState, fba.getCurrentState());
		assertEquals(expectedCurrentBalance, fba.getCurrentBalance());
		assertEquals(expectedOverDraftLimit, fba.getOverdraftLimit());
	}
	
	@Test
	@Parameters({
		"addMoney, 100, -500, 400, present",
		"withdrawMoney, 900, -500, -500, overdraft",
		"withdrawMoney, 400, -500, -100, overdrawn",
		"withdrawMoney, 300, -500, 0, empty",
		"withdrawMoney, 100, -500, 200, present",
		"withdrawMoney, 800, -500, -500, overdraft"
	})
	public void testPresentState(AccountEvents eventToDo, int amount,
			int expectedOverDraftLimit, int expectedCurrentBalance,
			AccountStates expectedCurrentState){
		FSMBankAccount fba = new FSMBankAccount(
				-500,300,AccountStates.present);
		fba.processEvent(eventToDo, amount);
		assertEquals(expectedCurrentState, fba.getCurrentState());
		assertEquals(expectedCurrentBalance, fba.getCurrentBalance());
		assertEquals(expectedOverDraftLimit, fba.getOverdraftLimit());
	}
	
	@Test
	@Parameters({
		"addMoney, 400, -500, 100, present",
		"addMoney, 300, -500, 0, empty",
		"addMoney, 100, -500, -200, overdrawn",
		"withdrawMoney, 800, -500, -500, overdraft",
		"withdrawMoney, 100, -500, -400, overdrawn",
		"withdrawMoney, 200, -500, -500, overdraft"
	})
	public void testOverdrawnState(AccountEvents eventToDo, int amount,
			int expectedOverDraftLimit, int expectedCurrentBalance,
			AccountStates expectedCurrentState){
		FSMBankAccount fba = new FSMBankAccount(
				-500,-300,AccountStates.overdrawn);
		fba.processEvent(eventToDo, amount);
		assertEquals(expectedCurrentState, fba.getCurrentState());
		assertEquals(expectedCurrentBalance, fba.getCurrentBalance());
		assertEquals(expectedOverDraftLimit, fba.getOverdraftLimit());
	}
	
	@Test
	@Parameters({
		"addMoney, 600, -500, 100, present",
		"addMoney, 300, -500, -200, overdrawn",
		"withdrawMoney, 800, -500, -500, overdraft"
	})
	public void testOverdraftState(AccountEvents eventToDo, int amount,
			int expectedOverDraftLimit, int expectedCurrentBalance,
			AccountStates expectedCurrentState){
		FSMBankAccount fba = new FSMBankAccount(
				-500,-500,AccountStates.overdraft);
		fba.processEvent(eventToDo, amount);
		assertEquals(expectedCurrentState, fba.getCurrentState());
		assertEquals(expectedCurrentBalance, fba.getCurrentBalance());
		assertEquals(expectedOverDraftLimit, fba.getOverdraftLimit());
	}
	
	@Test(expected = IllegalArgumentException.class)
	@Parameters({
		"addMoney, 500, -500, -500, overdraft",
		"withdrawMoney, 300, -500, -200, empty",
	})
	public void testInvalidValue(AccountEvents eventToDo, int amount,
			int overdraftLimit, int currentBalance, AccountStates currentState){
		FSMBankAccount fba = new FSMBankAccount(
				overdraftLimit,currentBalance,currentState);
		fba.processEvent(eventToDo, amount);
	}
}
