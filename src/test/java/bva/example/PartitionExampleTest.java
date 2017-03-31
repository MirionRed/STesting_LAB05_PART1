package bva.example;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class PartitionExampleTest {
	PartitionExample pe = new PartitionExample();
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetGradeInvalidV1(){
		pe.getGrade(-3);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testGetGradeInvalidV2(){
		pe.getGrade(103);
	}
	
	private Object[] paramGetGrade(){
		return new Object[]{
			new Object[]{25,"F"},
			new Object[]{55,"D"},
			new Object[]{65,"C"},
			new Object[]{75,"B"},
			new Object[]{95,"A"}
		};
	}
	
	@Test 
	@Parameters(method = "paramGetGrade")
	public void testGetGradeValidV1(int mark, String expectedResult){
		String result = pe.getGrade(mark);
		assertEquals(expectedResult, result);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCalculatedTaxInvalidV1(){
		pe.calculatedTax(-3);
	}
	
	private Object[] paramCalculatedTax(){
		return new Object[]{
			new Object[]{10000,1000},
			new Object[]{21000,2150},
			new Object[]{41000,5200},
			new Object[]{81000,130300}
		};
	}
	
	@Test 
	@Parameters(method = "paramCalculatedTax")
	public void testGetCalculatedTaxV1(int salary, double expectedResult){
		double result = pe.calculatedTax(salary);
		assertEquals(expectedResult, result, 0.1);
	}
}
