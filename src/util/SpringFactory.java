package lab2.util;

import lab2.dao.OffenderDao;
import lab2.dao.SpeciesDao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;


import lab2.dao.*;

public final class SpringFactory {

	private static ApplicationContext ctx = new ClassPathXmlApplicationContext("lab2-spring-config.xml");
	private static DistrictDao districtDao;
	private static OfficerDao officerDao;
	private static SpeciesDao speciesDao;
	private static OffenderDao offenderDao;
	private static ActDao actDao;
	private static ProsecutionDao prosecutionDao;
	private static ChargesDao chargesDao;
	private static EnforRefCodeDao enforRefDao;
	private static TransactionTemplate transactionTemplate;
	private static PlatformTransactionManager transactionManager;
   	
	public static DistrictDao getDistrictDao() {
 	   
    	if( districtDao == null ) {
    		districtDao = (DistrictDao) ctx.getBean("districtDao");
    	}
    	  	
		return districtDao;
	}
	public static OfficerDao getOfficerDao() {
 	   
    	if( officerDao == null ) {
    		officerDao = (OfficerDao) ctx.getBean("officerDao");
    	}
    	  	
		return officerDao;
	}
	public static OffenderDao getOffenderDao() {
   
    	if( offenderDao == null ) {
    		offenderDao = (OffenderDao) ctx.getBean("offenderDao");
    	}
    	  	
		return offenderDao;
	}
    public static EnforRefCodeDao getEnforRefCodeDao() {
    	   
    	if( enforRefDao == null ) {
    		enforRefDao = (EnforRefCodeDao) ctx.getBean("enforRefCodesDao");
    	}
    	  	
		return enforRefDao;
	}
    public static SpeciesDao getSpeciesDao() {
 	   
    	if( speciesDao == null ) {
    		speciesDao = (SpeciesDao) ctx.getBean("speciesDao");
    	}
    	  	
		return speciesDao;
	}
    public static ActDao getActDao() {
    	   
    	if( actDao == null ) {
    		actDao = (ActDao) ctx.getBean("actDao");
    	}
    	  	
		return actDao;
	}
    public static ProsecutionDao getProsecutionDao() {
		
		if( prosecutionDao == null ) {
			prosecutionDao = (ProsecutionDao) ctx.getBean("prosecutionDao");
		}
		return prosecutionDao;
	}
    
    public static ChargesDao getChargesDao() {
		
		if( chargesDao == null ) {
			chargesDao = (ChargesDao) ctx.getBean("chargesDao");
		}
		return chargesDao;
	}
   
	public static TransactionTemplate getTransactionTemplate(){

	
		if( transactionManager == null ) {
			transactionManager = (PlatformTransactionManager) ctx.getBean("transactionManager");
		}
		
		if( transactionTemplate == null ) {
			transactionTemplate = new TransactionTemplate(transactionManager);			
		}

		return transactionTemplate;
	}

}

