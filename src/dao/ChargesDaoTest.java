package lab2.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



import lab2.entity.Charge;

public class ChargesDaoTest {
	private ApplicationContext ctx;
	private ChargesDao chargesDao;

	@Before
	public void setUp() throws Exception {
		ctx = new ClassPathXmlApplicationContext("lab2-spring-config.xml");
		chargesDao = (ChargesDao) ctx.getBean("chargesDao");
	}
	
	@Test
	public void testFindChargesByAct() {
		java.util.List<Charge> chargeList = chargesDao.getChargesByAct("WAT");
		//getHibernateTemplate().find(" from entity.Employee where office.officeCode = ?", officeCode);
		assertNotNull( chargeList );
		assertEquals( 6, chargeList.size() );
		for(Charge charge:chargeList){
			System.out.println(charge.getCharge_ID() +" \t"+ charge.getAct_id() + "\t" + charge.getDescription() +
					 "\t" + charge.getExpiry_date() +"\t"+ charge.getSection() + "\t" + charge.getSusp_length() +
					 "\t" + charge.getSusp_offence() +"\t"+charge.getSusp_offence());
			}
	}
	@Test
	public void testGetCharges() {
		List<Charge> chargeList = chargesDao.getCharges();
		assertNotNull(chargeList);
//		assertTrue( chargeList.size() > 0 );
		assertEquals(1248, chargeList.size() );
		for(Charge c : chargeList) {
			System.out.println( c.getCharge_ID() + "\t" + c.getDescription()+ "\t" + c.getAct_id());
		}
	}
	
	
	
	
}
