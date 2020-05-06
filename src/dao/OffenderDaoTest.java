package lab2.dao;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import lab2.entity.Offender;


import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;


public class OffenderDaoTest {

	private ApplicationContext ctx;
	private OffenderDao offenderDao;
    private TransactionTemplate transactionTemplate;
    private PlatformTransactionManager transactionManager;
	
	@Before
	public void setUp() throws Exception {
		ctx = new ClassPathXmlApplicationContext("lab2-spring-config.xml");
		offenderDao = (OffenderDao) ctx.getBean("offenderDao");
		transactionManager = (PlatformTransactionManager) ctx.getBean("transactionManager");
		transactionTemplate = new TransactionTemplate(transactionManager);
	}
	
	@Test
	public void testGetOffenders() {
		List<Offender> offenderList = offenderDao.getOffenders();
		assertTrue( offenderList.size() > 0 );
		assertEquals(91, offenderList.size() );
		for(Offender offender : offenderList) {
			System.out.println( offender.getFirstName() + "\t" + offender.getLastName() );
		}
	}

	@Test
	public void testGetOffender() {
    
        Offender offender = offenderDao.getOffenderByOffenderId(200);
        assertEquals("Labrune", offender.getLastName() );
        assertEquals("Janine", offender.getFirstName() );
        assertEquals("67, rue des Cinquante Otages", offender.getAddress());
        assertEquals("Nantes", offender.getCity() );
        assertEquals("44000",  offender.getPostalCode());
        assertEquals("40.67.88.88", offender.getPhone1());
        assertEquals("40.67.89.89", offender.getPhone2());
        assertEquals("M", offender.getSex());
        assertEquals("Y", offender.getRecHuntOverRideFlag());
	}
	
	@Test
	public void testAddOffender() {
    	final Offender offender1 = new Offender();
		offender1.setFirstName("firstName1");
		offender1.setLastName("lastName1");
		offender1.setSex("F");
		offender1.setRecHuntOverRideFlag("N");
		/*final Calendar dob = Calendar.getInstance();
		dob.set(1950, 12, 15);
		offender1.setDob( dob.getTime() );
		*/
    	transactionTemplate.execute(new TransactionCallbackWithoutResult() {

		    protected void doInTransactionWithoutResult(TransactionStatus status) {
		        offenderDao.addOffender(offender1);
		        Offender offender2 = offenderDao.getOffenderByOffenderId( offender1.getOffenderId() ); 
		        assertEquals( offender1.getOffenderId(), offender2.getOffenderId() );
		        assertEquals( offender1.getFirstName(), offender2.getFirstName() );
		        assertEquals( offender1.getLastName(), offender2.getLastName() );
		        assertEquals( offender1.getSex(), offender2.getSex() );
		        assertEquals( offender1.getRecHuntOverRideFlag(), offender2.getRecHuntOverRideFlag() );
		        assertEquals( offender1.getDob(), offender2.getDob() );
	
		        status.setRollbackOnly();
		    }
		    
		});
	}
	
	@Test
	public void testUpdateOffender() {
		final Offender offender = new Offender();
		offender.setLastName("Blare");
		offender.setSex("M");
		offender.setRecHuntOverRideFlag("N");
		
		
    	transactionTemplate.execute(new TransactionCallbackWithoutResult() {

		    protected void doInTransactionWithoutResult(TransactionStatus status) {
		    	offenderDao.addOffender(offender);
		        offender.setFirstName("Buddy");
				offender.setMiddleName("middle");
				offender.setDob(null);
				offender.setAddress("Beach Road");
				offender.setCity("Beach Bay");
				offender.setProvince("Alberta");
				offender.setPostalCode("T8G 7D9");
				offender.setPhone1("780-123-4567");
				offender.setPhone2("780-120-3456");
				offender.setHunterTestCount(12343);
				offender.setHunderTestDate(null);
				offender.setRecHuntEligibleFlag("Y");
				offender.setRecHuntEndDate(null);
				offenderDao.updateOffender(offender);
		        Offender offender2 = offenderDao.getOffenderByOffenderId(offender.getOffenderId() );
		        assertEquals( offender.getOffenderId(), offender2.getOffenderId() );
		        assertEquals( offender.getCity(), offender2.getCity() );
		        assertEquals( offender.getPhone1(), offender2.getPhone1() );
		        assertEquals( offender.getAddress(), offender2.getAddress() );
		        assertEquals( offender.getCity(), offender2.getCity() );

		      
		        
		        status.setRollbackOnly();
		    }
		    
		});
	}
	
	@Test
	public void testDeleteOffenderWithNoChildRecords() {
				
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {

		    protected void doInTransactionWithoutResult(TransactionStatus status) {
		    	Offender offender = new Offender();	
		    	offender.setLastName("Blare");
				offender.setSex("M");
				offender.setRecHuntOverRideFlag("N");
				
		        offenderDao.addOffender(offender);
		        
				offenderDao.deleteOffender(offender);
		        assertNull( offenderDao.getOffenderByOffenderId( offender.getOffenderId()));
		        
		        status.setRollbackOnly();
		    }
		    
		});
	}
	
	@Test
	public void testGetRowCount() {
		Long rowCount = offenderDao.getRowCount();
		assertEquals( 91, rowCount );
	}
	
	
}
