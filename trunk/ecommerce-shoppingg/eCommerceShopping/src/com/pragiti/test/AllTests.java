package com.pragiti.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CartDAOImpltest.class, CustomerDAOImpltest.class,
		TransactionDAOImpltest.class })
public class AllTests {

}
