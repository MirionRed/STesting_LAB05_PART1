package outdated;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import outdated.AnotherExample;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class AnotherExampleTest {
	
	AnotherExample ae = new AnotherExample();
	
	@Test
	@Parameters({"cat mouse horse,10,", ",2,", "cat dog horse,3,horse",
		"mouse house boat,4,mouse house", "cat dog,-5,cat dog"})
	public void testCombineStringsValidValues(String words, int x, String
	expectedResult) {
		String result = ae.combineStrings(words, x);
		assertEquals(expectedResult, result);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testCombineStringsInvalidValuesV1() {
		ae.combineStrings(null, 5);
	}
}
