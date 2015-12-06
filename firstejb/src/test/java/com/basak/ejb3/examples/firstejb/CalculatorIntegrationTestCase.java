package com.basak.ejb3.examples.firstejb;

import java.net.MalformedURLException;
import java.util.logging.Logger;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class CalculatorIntegrationTestCase {

	/**
	 * Logger
	 */
	private static final Logger log = Logger.getLogger(CalculatorIntegrationTestCase.class.getName());

	/**
	 * The EJB 3.x local business view of the CalculatorEJB
	 */
	@EJB(mappedName = "java:app/firstejb/SimpleCalculatorBean")
	private static CalculatorLocalBusiness calcLocalBusiness;
	
	private static CalculatorAssertionDelegate assertionDelegate;
	
	/**
	 * Define the deployment
	 */
	@Deployment
	public static JavaArchive createDeployment() throws MalformedURLException {
		final JavaArchive archive 
			= ShrinkWrap.create(JavaArchive.class, "firstejb.jar")
						.addPackage(CalculatorBeanBase.class.getPackage());
		
		return archive;
	}
	
	/**
	 * Run in container before the test
	 */
	@Before
	public void beforeClass() throws Throwable {
		assertionDelegate = new CalculatorAssertionDelegate();
	}
	
	@Test
	public void testAdditionUsingBusinessReference() throws Throwable {
		log.info("Testing EJB via business reference...");
		assertionDelegate.assertAdditionSuccess(calcLocalBusiness);
	}
}
