package lab2.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lab2.entity.Species;

public class SpeciesDaoTest {
	
	private ApplicationContext ctx;
	private SpeciesDao speciesDao;
	
	@Before
	public void setUp() throws Exception {
		ctx = new ClassPathXmlApplicationContext("lab2-spring-config.xml");
		speciesDao = (SpeciesDao) ctx.getBean("speciesDao");
	}
	
	@Test
	public void testGetSpeciesByDescription(){
		
		java.util.List<Species> speciesList = speciesDao.getSpeciesByDescription("WOL");
		
		assertNotNull( speciesList );
		assertEquals( 2, speciesList.size() );
		for(Species specie:speciesList){
			System.out.println(specie.getSpecies_ID() +" \t"+ specie.getDescription() );
			}
	}

}
