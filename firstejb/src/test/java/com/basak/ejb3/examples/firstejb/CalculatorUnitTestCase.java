package com.basak.ejb3.examples.firstejb;

import java.util.logging.Logger;

import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.TestCase;

public class CalculatorUnitTestCase {
	
	/**
	 * Logger
	 */
	private static final Logger log = Logger.getLogger(CalculatorUnitTestCase.class.getName());

	private static CalculatorCommonBusiness calc;

	@BeforeClass
	public static void beforeClass() {
		calc = new SimpleCalculatorBean();
	}

	@Test
	public void testAddition() {
		// Initialize
		final int[] arguments = new int[] { 3, 7, 2 };
		final int expectedSum = 12;

		// Add
		final int actualSum = calc.add(arguments);

		// Test
		TestCase.assertEquals("Addition did not return the expected result", expectedSum, actualSum);

		// Log
		final StringBuffer sb = new StringBuffer();
		sb.append("Obtained expected result, ");
		sb.append(actualSum);
		sb.append(", from arguments: ");
		for (final int arg : arguments) {
			sb.append(arg);
			sb.append(" ");
		}
		log.info(sb.toString());
	}
}
