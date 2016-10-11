package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.rules.ExpectedException;
import org.junit.Rule;
import org.junit.Test;

public class CalculatorTest {
	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(5, Calculator.add("1,4"));
	}

	@Test
	public void testManyNumbers() {
		assertEquals(100, Calculator.add("77,3,15,1,2,2"));
	}

	@Test
	public void testNewline() {
		assertEquals(6, Calculator.add("1\n2,3"));
	}

  	
    @Test(expected = Exception.class)
	public void testNegatives()  {
		Calculator.add("-1,-3,2");
		throw new IllegalArgumentException();
	}
}