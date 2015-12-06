package com.basak.ejb3.examples.firstejb;

import java.util.logging.Logger;

public class CalculatorBeanBase implements CalculatorCommonBusiness {

	private static final Logger log = Logger.getLogger(CalculatorBeanBase.class.getName());
	
	@Override
	public int add(int... arguments) {
		// Initialize
		final StringBuffer sb = new StringBuffer();
		sb.append("Adding arguments: ");
		int result = 0;

		// Add all arguments
		for (final int arg : arguments) {
			result += arg;
			sb.append(arg);
			sb.append(" ");
		}

		// Return
		log.info(sb.toString());
		log.info("Result: " + result);
		return result;
	}

}
