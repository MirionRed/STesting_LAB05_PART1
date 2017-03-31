package outdated;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import outdated.OtherMethods;
import outdated.Student;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class OtherMethodsTest {
	OtherMethods om = new OtherMethods();
	
	@Test
	@Parameters({"this is some this lol, this, 2", "errM errM lol errM, errM, 3", "this will not work at all, lol, 0"})
	public void testCountWordInStringValid(String words, String strFind, int expectedResults){
		int result = om.countWordInString(words, strFind);
		assertEquals(expectedResults, result);
	}
	
	@Test (expected = IllegalArgumentException.class )
	public void testCountWordInStringInvalidV1(String words, String stfFind){
		om.countWordInString(null, "lalalal");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testCountWordInStringInvalidV2(String words, String strFind){
		om.countWordInString("lalalalal", null);
	}
	
	private Object[] getParamsForTestFindLargestNumberInArrayValid(){
		return new Object[]{
			new Object[]{new int[]{1,2,3}, 3},
			new Object[]{new int[]{4,5,6}, 6}
		};
	}
	
	@Test
	@Parameters(method = "getParamsForTestFindLargestNumberInArrayValid")
	public void testFindLargestNumberInArrayValid(int[]numArray, int expectedResult){
		int result = om.findLargestNumberInArray(numArray);
		assertEquals(expectedResult, result);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFindLargestNumberInArrayInvalidV1(int[]numArray){
		om.findLargestNumberInArray(new int[0]);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFindLargestNumberInArrayInvalidV2(int[]numArray){
		om.findLargestNumberInArray(null);
	}
	
	private Object[] getParamsForTestFindLargestNumberInArrayInvalid(){
		return new Object[]{
			new Object[]{new String[]{"la","li","lu","le","lo"},1,2},
			new Object[]{new String[]{"this", "is", "something", "new"},3,6.5},
			new Object[]{new String[]{"this", "is", "something", "n"},-3,4},
			new Object[]{new String[]{},3,0}
		};
	}
	
	private Object[] getParamsForTestFindLargestNumberInArrayInvalidV2(){
		return new Object[]{
			new Object[] {new String[] {"cats", null, "dog", "45", "rat"}, 2, 3.33},
		};
	}
	
	@Test
	@Parameters(method = "getParamsForTestFindLargestNumberInArrayInvalid")
	public void testAverageStringLength(String[]strArray, int x, double expectedResult){
		double result = om.averageStringLength(strArray, x);
		assertEquals(expectedResult, result, 0.001);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAverageStringLengthV1(){
		om.averageStringLength(null, 1);
	}
	@Test(expected = NullPointerException.class)
	@Parameters(method = "getParamsForTestFindLargestNumberInArrayInvalidV2")
	public void testAverageStringLengthV2(String[]strArray, int x, double expectedResult){
		double result = om.averageStringLength(strArray, x);
		assertEquals(expectedResult, result, 0.001);
	}
	
	private Object[] getParamsForTestGetStudentAverageValid(){
		Student s1 = new Student("lala", 25);
		Student s2 = new Student("nana", 10);
		Student s3 = new Student("momo", 25);
		Student s4 = new Student("jojo", 22);
		Student s5 = new Student("koko", 21);
		
		return new Object[]{
				new Object[]{new Student[] {s1, s2, s3, s4, s5},
						new String[]{"lala", "momo"}, 25},
				new Object[]{new Student[] {},
						new String[]{"lala", "momo"}, 0},
				new Object[]{new Student[] {s1, s2, s3, s4, s5},
						new String[]{}, 0},
				new Object[]{new Student[] {s1, s2, s3, s4, s5},
						new String[]{"lalala", "momomo"}, 0}
		};
	}
	
	private Object[] getParamsForTestGetStudentAverageValidV1(){
		Student s1 = new Student("lala", 25);
		Student s2 = new Student("nana", 10);
		Student s3 = new Student("momo", 25);
		Student s4 = new Student("jojo", 22);
		Student s5 = new Student("koko", 21);
		
		return new Object[]{
				new Object[]{new Student[] {s1, s2, s3, null, s5},
						new String[]{"lala", "momo", "nana"}, 20},
		};
	}
	
	private Object[] getParamsForTestGetStudentAverageValidV2(){
		Student s1 = new Student("lala", 25);
		Student s2 = new Student("nana", 10);
		Student s3 = new Student("momo", 25);
		Student s4 = new Student("jojo", 22);
		Student s5 = new Student("koko", 21);
		
		return new Object[]{
				new Object[]{new Student[] {s1, s2, s3, s4, s5},
						new String[]{"lala", null, "jojo", "koko"}, 16}
		};
	}
	
	@Test
	@Parameters(method = "getParamsForTestGetStudentAverageValid")
	public void testGetStudentAverageValidV3(Student[] studArray, String[]namesToFind, double expectedResult){
		double result = om.getStudentAverage(studArray, namesToFind);
		assertEquals(expectedResult, result, 0.1);
	}
	@Test (expected = NullPointerException.class)
	@Parameters(method = "getParamsForTestGetStudentAverageValidV1")
	public void testGetStudentAverageInValidV1(Student[] studArray, String[]namesToFind, double expectedResult){
		double result = om.getStudentAverage(studArray, namesToFind);
		assertEquals(expectedResult, result, 0.1);
	}
	@Test (expected = NullPointerException.class)
	@Parameters(method = "getParamsForTestGetStudentAverageValidV2")
	public void testGetStudentAverageInValidV2(Student[] studArray, String[]namesToFind, double expectedResult){
		double result = om.getStudentAverage(studArray, namesToFind);
		assertEquals(expectedResult, result, 0.1);
	}
	@Test (expected = IllegalArgumentException.class)
	public void testGetStudentAverageInValidV4(Student[] studArray, String[]namesToFind, double expectedResult){
		om.getStudentAverage(null, namesToFind);	
	}
	@Test (expected = IllegalArgumentException.class)
	public void testGetStudentAverageInValidV5(Student[] studArray, String[]namesToFind, double expectedResult){
		om.getStudentAverage(studArray, null);	
	}
	
	private Object[] getParamsForTestGetSubStringsValid(){
		return new Object[]{
				new Object[]{new String[] {"lala can eat", "momo can play", "nana something i guess"},
						new int[]{1,1,1}, "can can something"},
				new Object[]{new String[] {},
						new int[]{1,2,3}, ""},
				new Object[] {new String[] {"", "", "" }, 
						new int[] {3, 5, 2}, "" },
				new Object[]{new String[] {},
						new int[]{}, ""},
				new Object[]{new String[] {"lala can eat", "momo can play", "nana something i guess"},
						new int[]{1,8,1}, "can something"},
		};
	}
	
	@Test
	@Parameters(method = "getParamsForTestGetSubStringsValid")
	public void testGetSubStringsValid(String[] strArray, int[] strPos, String expectedResult){
		String result = om.getSubStrings(strArray, strPos);	
		assertEquals(expectedResult, result);
	}
	@Test (expected = IllegalArgumentException.class)
	public void testGetSubStringsInvalidV1(String[] strArray, int[] strPos, String expectedResult){
		om.getSubStrings(null, new int[]{1,8,1});	
	}
	@Test (expected = IllegalArgumentException.class)
	public void testGetSubStringsInvalidV2(String[] strArray, int[] strPos, String expectedResult){
		om.getSubStrings(new String[] {"lala can eat", "momo can play", "nana something i guess"}, null);	
	}
	
	private Object[] getParamsForTestGetSubStringsInvalidV3(){
		return new Object[]{
				new Object[]{new String[] {"lala", "momo", "nana"},
						new int[]{}, ""},
		};
	}
	@Test (expected = ArrayIndexOutOfBoundsException.class)
	@Parameters(method = "getParamsForTestGetSubStringsInvalidV3")
	public void testGetSubStringsInvalidV3(String[] strArray, int[] strPos, String expectedResult){
		om.getSubStrings(strArray, strPos);	
	}
	
	private Object[] getParamsForTestGetSubStringsInvalidV4(){
		return new Object[]{
				new Object[]{new String[] {"lala can eat", null, "nana something i guess"},
						new int[]{1,1,1}, "can can something"},
		};
	}
	@Test (expected = NullPointerException.class)
	@Parameters(method = "getParamsForTestGetSubStringsInvalidV4")
	public void testGetSubStringsInvalidV4(String[] strArray, int[] strPos, String expectedResult){
		om.getSubStrings(strArray, strPos);	
	}
}
