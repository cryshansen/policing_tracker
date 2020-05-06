package lab2.bll;
import java.util.Hashtable;
import java.util.List;

import org.springframework.validation.Errors;


import lab2.dao.OffenderDao;
import lab2.entity.Offender;

public class OffenderManager {
	private Errors errors;
	private static OffenderDao offenderDao = lab2.util.SpringFactory.getOffenderDao();
	
	@SuppressWarnings("unchecked")
	public List<Offender> findOffenderByAll(Hashtable searchTable) {
		return offenderDao.findOffenderByAll(searchTable);
	}
	
	public void addOffender(Offender offender) {
		offenderDao.addOffender(offender);
	}
	@SuppressWarnings("unchecked")
	public java.util.List<Offender> getOffenders(){
		return offenderDao.getOffenders();
		
	}
	public Offender getOffenderByOffenderId(int offenderID) {
		return offenderDao.getOffenderByOffenderId(offenderID);
	}
	public void updateOffender(Offender offender) {
		offenderDao.updateOffender(offender);
	}
	public void deleteOffender(Offender offender) {
		offenderDao.deleteOffender(offender);
	}
	public Errors getErrors(){
		return errors;
	}
}
