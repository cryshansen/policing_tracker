package lab2.bll;
import java.util.Hashtable;
import java.util.List;

import org.springframework.validation.Errors;

import lab2.dao.ProsecutionDao;
import lab2.entity.Offender;
import lab2.entity.Prosecution;

public class ProsecutionManager {
	private Errors errors;
	private static ProsecutionDao prosecutionDao= lab2.util.SpringFactory.getProsecutionDao();
	
	@SuppressWarnings("unchecked")
	public java.util.List<Prosecution> getProsecutions(){
		return prosecutionDao.getProsecutions();
		
	}
	
	public java.util.List<Prosecution> findProseuctionsByAll(Hashtable searchTable){
		return prosecutionDao.findProseuctionsByAll(searchTable);
	}
	public Prosecution getProsecutionByProsecutionId(int prosecutionId){
		return prosecutionDao.getProsecutionByProsecutionId(prosecutionId);
	}
	public void addProsecution(Prosecution prosecution){
		prosecutionDao.addProsecution(prosecution);
	}
	public void updateProsecution(Prosecution prosecution){
		prosecutionDao.updateProsecution(prosecution);
	}
	public void deleteProsecution(Prosecution prosecution){
		prosecutionDao.deleteProsecution(prosecution);
	}

	public Errors getErrors() {
		return errors;
	}
	
	/*
	public java.util.List<Prosecution> getProsecutionByAll(
			String FirstName,
			String LastName,
			String description,
			String Section,	
			Integer file_year,
			String Docket_Ticket_Number,
			Integer ChargerType,
			String Place_Of_Offence,
			Integer TicketType,
			String	Place_Of_Trial,
			Integer InitiatedBy,
			String Officer,
			Integer Badge){
		return prosecutionDao.getProsecutionByAll(FirstName, LastName, description, Section, file_year, Docket_Ticket_Number, ChargerType, Place_Of_Offence, TicketType, Place_Of_Trial, InitiatedBy, Officer, Badge);
		
	}*/

}
