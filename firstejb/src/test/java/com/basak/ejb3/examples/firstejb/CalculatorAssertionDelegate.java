package com.basak.ejb3.examples.firstejb;

import java.util.logging.Logger;

import junit.framework.TestCase;

public class CalculatorAssertionDelegate {

	/**
	 * Logger
	 */
	private static final Logger log = Logger.getLogger(CalculatorAssertionDelegate.class.getName());

	void assertAdditionSuccess(final CalculatorCommonBusiness calc) {

		// Initialize
		final int[] arguments = new int[] { 2, 3, 5 };
		final int expectedSum = 10;

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
