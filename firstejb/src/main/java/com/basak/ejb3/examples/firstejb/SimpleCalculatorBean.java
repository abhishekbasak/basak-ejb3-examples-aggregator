package com.basak.ejb3.examples.firstejb;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local(CalculatorLocalBusiness.class)
public class SimpleCalculatorBean extends CalculatorBeanBase {

}
