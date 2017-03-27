package my.edu.utar;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class OtherMethodsTest {
	OtherMethods om = new OtherMethods();
	
	@Test(expected = IllegalArgumentException.class)
	@Parameters({",word,","this is this or this,,","this is this or this,this,3"})
	public void testCountWordInString(String words, String strFind, int expectedResults){
		int result = om.countWordInString(words, strFind);
		assertEquals(expectedResults, result);
	}
}
