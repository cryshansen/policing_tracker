package lab2.dao;


import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.PlatformTransactionManager;

import org.springframework.transaction.support.TransactionTemplate;

import lab2.entity.Charge;
import lab2.entity.District;
import lab2.entity.Offender;
import lab2.entity.Officer;
import lab2.entity.Prosecution;
import lab2.entity.Species;

public class ProsecutionDaoTest {

		
		private ApplicationContext ctx;
		private ProsecutionDao prosecutionDao;
		private TransactionTemplate transactionTemplate;
	    private PlatformTransactionManager transactionManager;
		@Before
		public void setUp() throws Exception {
			ctx = new ClassPathXmlApplicationContext("lab2-spring-config.xml");
			prosecutionDao = (ProsecutionDao) ctx.getBean("prosecutionDao");
			transactionManager = (PlatformTransactionManager) ctx.getBean("transactionManager");
			transactionTemplate = new TransactionTemplate(transactionManager);
		
		}

		@Test
		public void testGetProsecutionByAll(){
			java.util.List<Prosecution> prosecutionList = prosecutionDao.getProsecutionByAll(
					"mark",
					"Zubis",
					"set out/use substance",
					"WA034",	
					2006,
					"12546DB",
					50,
					"myPlace",
					20,
					"Place",
					32,
					"Sam Wu",
					1972);
			assertNotNull( prosecutionList );
			assertEquals( 0, prosecutionList.size() );
			for(Prosecution prosecution: prosecutionList) {
				System.out.println(prosecution.getChargeId() + "\t" + prosecution.getChargerTypeDomainId() +
						"\t" + prosecution.getCircumstanceDetails() +"\t"+ prosecution.getCourtDate() +
						"\t" + prosecution.getDistrictcode() + "\t" + prosecution.getDocketticketNumber() + 
						"\t" + prosecution.getFileyear() + "\t" + prosecution.getInitiatedByDomainID() + 
						"\t" + prosecution.getMax_fine() +"\t"+ prosecution.getMin_fine() +"\t"+ prosecution.getOffenceTmst() +
						"\t" + prosecution.getOffenderId() + "\t" + prosecution.getPenalty() +"\t" + prosecution.getPlaceOfOffence() +
						"\t" + prosecution.getPlaceOfOffence() +"\t"+ prosecution.getPlaceOfTrial() +"\t" + prosecution.getPrevRelatedConv() +
						"\t" + prosecution.getProsecution_id() +"\t" + prosecution.getRegCommunDomainId() + "\t"+ prosecution.getSpecies_id() +
						"\t" + prosecution.getSuspendOffDomainId() +"\t" + prosecution.getTicketTypeDomainId() +"\t"+ prosecution.getViolationTypeDomainId() +
						"\t" + prosecution.getWarrant()
						);
			} 

			
		}
		
		@Test
		public void testAddProsecution(){
			final Prosecution prosecution = new Prosecution();
			Offender offender = new Offender();
			offender.setOffenderId(262);		
			prosecution.setOffenderId(offender);//262
			
			Charge charge = new Charge(90);
//			charge.setCharge_ID(90);
			prosecution.setChargeId(charge);//90

			//			final District district = new District();
			Officer officer = new Officer(17);
//			officer.setOfficer_ID(17);
			prosecution.setOfficer_Id(officer);
			
			Species species = new Species(210);
//			species.setSpecies_ID(210);
			prosecution.setSpecies_id(species);
			
			prosecution.setWarrant("warrant");
			prosecution.setFileyear(2006);
			prosecution.setDocketticketNumber("34DDTN1");
			prosecution.setPrevRelatedConv("Y");
			transactionTemplate.execute(new TransactionCallbackWithoutResult() {

			    protected void doInTransactionWithoutResult(TransactionStatus status) {
			           
			    	prosecutionDao.addProsecution(prosecution);
			        Prosecution prosecution1 = prosecutionDao.getProsecutionByProsecutionId(prosecution.getProsecution_id());

	    			assertEquals(prosecution.getProsecution_id(),prosecution1.getProsecution_id());
	    			assertEquals(prosecution.getOffenderId(), prosecution1.getOffenderId());
	    			assertEquals(prosecution.getChargeId(),prosecution1.getChargeId());
	    	        assertEquals(prosecution.getDistrictcode(),prosecution1.getDistrictcode());
	    	        assertEquals(prosecution.getFileyear(), prosecution1.getFileyear());
	    	        assertEquals(prosecution.getDocketticketNumber(),prosecution1.getDocketticketNumber());
	    	        
	    	        assertEquals(prosecution.getPrevRelatedConv(),prosecution1.getPrevRelatedConv());
	    	        
	    	        assertEquals(prosecution.getWarrant(), prosecution1.getWarrant());
	    	       status.setRollbackOnly();	
		}
			
			
			});
		}
		
		@Test
		public void testDeleteProsecution(){
			final Prosecution prosecution = new Prosecution();
			final Offender offender = new Offender();
			final Charge charge = new Charge();
		//final District district = new District();
			offender.setOffenderId(262);
			prosecution.setOffenderId(offender);//262
			charge.setCharge_ID(90);
			prosecution.setChargeId(charge);//90
			prosecution.setWarrant("warrant");
			/*district.setCode("");
			prosecution.setDistrictcode(district);//
*/			prosecution.setFileyear(2006);
			prosecution.setDocketticketNumber("VB334D");
			prosecution.setPrevRelatedConv("Y");
			transactionTemplate.execute(new TransactionCallbackWithoutResult() {

			    protected void doInTransactionWithoutResult(TransactionStatus status) {
			           
			    	prosecutionDao.addProsecution(prosecution);
			    	prosecutionDao.deleteProsecution(prosecution);
			    	
			    	assertNull(prosecutionDao.getProsecutionByProsecutionId(prosecution.getProsecution_id()));
		    		status.setRollbackOnly();
			    	
			    	status.setRollbackOnly();	
		}
			
			
			});
		}
		
		@Test
		public void testUpdateProsecution(){
			final Prosecution prosecution = new Prosecution();
			final Offender offender = new Offender();
			final Charge charge = new Charge();
			final Species species = new Species();
			final Officer officer = new Officer();
		//final District district = new District();
			offender.setOffenderId(262);
			prosecution.setOffenderId(offender);//262
			charge.setCharge_ID(90);
			prosecution.setChargeId(charge);//90
			prosecution.setWarrant("warrant");
			/*district.setCode("");
			prosecution.setDistrictcode(district);//
*/			prosecution.setFileyear(2006);
			prosecution.setDocketticketNumber("75DFV84");
			prosecution.setPrevRelatedConv("Y");
			transactionTemplate.execute(new TransactionCallbackWithoutResult() {

			    protected void doInTransactionWithoutResult(TransactionStatus status) {
			           
			    	prosecutionDao.addProsecution(prosecution);
			        
			    	prosecution.setCourtDate(Date.valueOf("2008-02-17"));
		    		prosecution.setPlaceOfOffence("Berlin");
		    		prosecution.setPenalty("75.35");
		    		species.setSpecies_ID(118);
		    		prosecution.setSpecies_id(species);
		    		prosecution.setMax_fine(4900.00);
		    		officer.setOfficer_ID(22);
		    		prosecution.setOfficer_Id(officer);
		    		prosecutionDao.updateProsecution(prosecution);
			    	Prosecution prosecution1 = prosecutionDao.getProsecutionByProsecutionId(prosecution.getProsecution_id());

	    			assertEquals(prosecution.getProsecution_id(),prosecution1.getProsecution_id());
	    			assertEquals(prosecution.getOffenderId(), prosecution1.getOffenderId());
	    			assertEquals(prosecution.getChargeId(),prosecution1.getChargeId());
	    	        assertEquals(prosecution.getDistrictcode(),prosecution1.getDistrictcode());
	    	        assertEquals(prosecution.getFileyear(), prosecution1.getFileyear());
	    	        assertEquals(prosecution.getDocketticketNumber(),prosecution1.getDocketticketNumber());
	    	        
	    	        assertEquals(prosecution.getPrevRelatedConv(),prosecution1.getPrevRelatedConv());
	    	        assertEquals(prosecution.getWarrant(), prosecution1.getWarrant());
	    	       status.setRollbackOnly();	
		}
			
			
			});
		}
}
