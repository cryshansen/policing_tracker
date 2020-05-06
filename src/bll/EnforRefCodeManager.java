package lab2.bll;

import java.util.Hashtable;
import java.util.List;
import lab2.entity.EnforRefCode;
import lab2.dao.EnforRefCodeDao;;
public class EnforRefCodeManager {
	private static EnforRefCodeDao enforRefCodeDao = lab2.util.SpringFactory.getEnforRefCodeDao();
	
	public java.util.List<EnforRefCode> getEnforRefCodes(){
		return enforRefCodeDao.getEnforRefCodes();
	}
	//need a command to get all chargerTypes where clause in dao
	//need a bean to get all TicketTypes where clause in dao
	//need a bean for the InitiatedBy where clause
	public java.util.List<EnforRefCode> getByAll(java.util.Hashtable<String,String> searchTable){
		return enforRefCodeDao.getByAll(searchTable);
	}
	public java.util.List<EnforRefCode> getAllViolationTypeDomains(String rv_Domain){
		return enforRefCodeDao.getAllViolationTypeDomains(rv_Domain);
	}
	
	public EnforRefCode getEnforRefCodeByEnforRefCode(int enforRefCodeId){
		return enforRefCodeDao.getEnforRefCodeByEnforRefCode(enforRefCodeId);
	}
	
	public void addEnforRefCode(EnforRefCode enforRefCode){
		enforRefCodeDao.addEnforRefCode(enforRefCode);
	}
	public void updateEnforRefCode(EnforRefCode enforRefCode){
		enforRefCodeDao.updateEnforRefCode(enforRefCode);
	}

	public void deleteEnforRefCode(EnforRefCode enforRefCode){
		enforRefCodeDao.deleteEnforRefCode(enforRefCode);
	}
}
