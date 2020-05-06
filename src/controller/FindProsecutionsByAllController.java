package lab2.controller;


import java.util.Hashtable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;



import lab2.bll.EnforRefCodeManager;
import lab2.bll.ProsecutionManager;
import lab2.entity.Charge;
import lab2.entity.EnforRefCode;
import lab2.entity.Offender;
import lab2.entity.Officer;
import lab2.entity.Prosecution;

public class FindProsecutionsByAllController {

		private String offirstName = "";
		private String oflastName = "";
		private String offenderId1;
		private String description = "";
		private String section = "";
		private String chargesId;
		private String fileyear;
		private String docketTicketNumber;
		private String selectChargerTypeDomainId;
		private String placeOfOffence = "";
		private String selectTicketTypeDomainId;
		private String placeOfTrial = "";
		private String selectInitiatedByDomainId;
		private String Officer = "";
		private String badge;
		private String officerId1;
		private EnforRefCodeManager enforManager = new EnforRefCodeManager();
		private List<EnforRefCode> initiatedByList = enforManager.getAllViolationTypeDomains("Initiated_By");
		private List<EnforRefCode> violationList = enforManager.getAllViolationTypeDomains("Violation_Type");
		private List<EnforRefCode> regCommunList= enforManager.getAllViolationTypeDomains("Regulated_Community");
		private List<EnforRefCode> ticketList= enforManager.getAllViolationTypeDomains("Ticket_Type");
		private List<EnforRefCode> chargeTypeList= enforManager.getAllViolationTypeDomains("Charger_Type");
		private List<EnforRefCode> suspendList = enforManager.getAllViolationTypeDomains("Suspension_Type");

		
		private ProsecutionManager prosecutionManager = new ProsecutionManager();
//		private ProductLineManager productLineManager = new ProductLineManager();
		private DataModel prosecutionsList = new ListDataModel();
		private Prosecution prosecution = new Prosecution();
		private Offender offender = new Offender();
		private Charge charge = new Charge();
		private Officer officer = new Officer();

		public FindProsecutionsByAllController() {

		}
//insert prosecutionController working code from school here.
		public String findProseuctionsByAll() {
			String outcome = "success";
			java.util.Hashtable<String, String> searchTable = new java.util.Hashtable<String, String>();
			if( offenderId1 != null && offenderId1.trim().length() != 0 ) {
				searchTable.put("offenderId", offenderId1);
			}
			if( docketTicketNumber != null && !docketTicketNumber.trim().equals("") ) {
				searchTable.put("docketticketNumber", docketTicketNumber);
			}
			
			if( fileyear != null && !fileyear.trim().equals("") ) {
				searchTable.put("fileyear", fileyear);
			}
			
			if( selectChargerTypeDomainId !=null && !selectChargerTypeDomainId.trim().equals("") ) {
				searchTable.put("ChargerTypeDomainId", selectChargerTypeDomainId);
			}
			if( selectChargerTypeDomainId !=null && !selectChargerTypeDomainId.trim().equals("") ) {
				searchTable.put("ChargerTypeDomainId", selectChargerTypeDomainId);
			}
			if( selectChargerTypeDomainId !=null && !selectChargerTypeDomainId.trim().equals("") ) {
				searchTable.put("ChargerTypeDomainId", selectChargerTypeDomainId);
			}
			if( selectChargerTypeDomainId !=null && !selectChargerTypeDomainId.trim().equals("") ) {
				searchTable.put("ChargerTypeDomainId", selectChargerTypeDomainId);
			}
			//something wrong with this code not useing the datamodel here and thats a mistake
			java.util.List<lab2.entity.Prosecution> prosecutionsList = prosecutionManager.findProseuctionsByAll(searchTable);
			if( prosecutionsList.size() == 0 ) {
				FacesMessage msg = new FacesMessage("No prosecutions found.");
				msg.setSeverity( FacesMessage.SEVERITY_WARN );
				FacesContext.getCurrentInstance().addMessage("searchForm", msg);
			} else {
				FacesMessage msg = new FacesMessage("Found " + prosecutionsList.size() + " prosecutions.");
				msg.setSeverity( FacesMessage.SEVERITY_INFO );
				FacesContext.getCurrentInstance().addMessage("searchForm", msg);
			}
			System.out.println("There are " + prosecutionsList.size() );
			return outcome;
		}
		

		
	}



