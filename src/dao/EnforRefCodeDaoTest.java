package lab2.dao;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import lab2.entity.*;


import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

public class EnforRefCodeDaoTest {

	private ApplicationContext ctx;
	private EnforRefCodeDao enforDao;
    private TransactionTemplate transactionTemplate;
    private PlatformTransactionManager transactionManager;
	
	@Before
	public void setUp() throws Exception {
		ctx = new ClassPathXmlApplicationContext("lab2-spring-config.xml");
		enforDao = (EnforRefCodeDao) ctx.getBean("enforRefCodesDao");
		transactionManager = (PlatformTransactionManager) ctx.getBean("transactionManager");
		transactionTemplate = new TransactionTemplate(transactionManager);
	}
	
	
	@Test
	public void testgetAllViolationTypeDomains() { 
		java.util.List<EnforRefCode> suspenceList = enforDao.getAllViolationTypeDomains("Suspension_Type");
		assertNotNull( suspenceList );
		assertEquals( 6, suspenceList.size() );
		for(EnforRefCode enforRefCode:suspenceList){
			System.out.println(enforRefCode.getEnforRefCodeID() +" \t"+ enforRefCode.getRvLowValue() + "\t" + enforRefCode.getRvMeaning());
			}
	}
}
