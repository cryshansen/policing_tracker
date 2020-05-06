package lab2.controller;


import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;


import org.springframework.validation.ObjectError;

import lab2.entity.*;
import lab2.bll.ProsecutionManager;
import lab2.bll.EnforRefCodeManager;
import lab2.bll.SpeciesManager;

public class ProsecutionController {
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
	private ProsecutionManager prosecutionMgr = new ProsecutionManager();
	private EnforRefCodeManager enforManager = new EnforRefCodeManager();
	private SpeciesManager speciesManager = new SpeciesManager();
	private Prosecution prosecution = new Prosecution();
	private boolean editMode = false;
	private DataModel prosecutionList = new ListDataModel();
	
	
	private List<EnforRefCode> initiatedByList = enforManager.getAllViolationTypeDomains("Initiated_By");
	private List<EnforRefCode> violationList = enforManager.getAllViolationTypeDomains("Violation_Type");
	private List<EnforRefCode> regCommunList= enforManager.getAllViolationTypeDomains("Regulated_Community");
	private List<EnforRefCode> ticketList= enforManager.getAllViolationTypeDomains("Ticket_Type");
	private List<EnforRefCode> chargeTypeList= enforManager.getAllViolationTypeDomains("Charger_Type");
	private List<EnforRefCode> suspendList = enforManager.getAllViolationTypeDomains("Suspension_Type");
	private List<Species> speciesList = speciesManager.getSpecies();

	public ProsecutionController(){
		
		prosecutionList.setWrappedData( prosecutionMgr.getProsecutions());
	}

	public String editProsecution(){
		prosecution= (Prosecution) prosecutionList.getRowData();
		editMode = true;
		return "success";
	}
	public String reportProsecution(){
		prosecution= (Prosecution) prosecutionList.getRowData();
		editMode = true;
		return "success";
	}
	public String addNew() {
		prosecution = new Prosecution();
		editMode = false;
		return "success";
	}
	@SuppressWarnings("unchecked")
	public String deleteProsecution() {
		String outcome = null;
		Prosecution prosecution = (Prosecution) prosecutionList.getRowData();
		FacesContext context = FacesContext.getCurrentInstance();
		try{
		prosecutionMgr.deleteProsecution(prosecution);
		FacesMessage msg = new FacesMessage("Prosecution information successfully deleted.");
		msg.setSeverity(FacesMessage.SEVERITY_INFO);
		context.addMessage("prosecutionListing", msg);
		prosecutionList.setWrappedData( prosecutionMgr.getProsecutions());
		editMode = false;
	} catch(Exception ex) {
		FacesMessage msg = new FacesMessage("There was an error in deleting the payment.");
		msg.setSeverity(FacesMessage.SEVERITY_ERROR);
		context.addMessage("searchForm", msg);
		}
	return outcome;
}

		
	@SuppressWarnings("unchecked")
	public String addProsecution(){
		String outcome="success";
	
		try {
		prosecutionMgr.addProsecution(prosecution);
		//addNew();
		FacesMessage msg = new FacesMessage("Prosecution information successfully saved.");
		msg.setSeverity(FacesMessage.SEVERITY_INFO);
		FacesContext.getCurrentInstance().addMessage("prosecutionForm", msg);
		prosecutionList.setWrappedData( prosecutionMgr.getProsecutions());
		editMode = false;
		
	} catch(Exception ex) {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage msg = new FacesMessage("There was an error saving the prosecution. Exception: " + ex.getMessage());
		msg.setSeverity(FacesMessage.SEVERITY_ERROR);
		context.addMessage("prosecutionForm", msg);
		List<ObjectError> allErrors = ((ProsecutionManager) prosecutionMgr).getErrors().getAllErrors();
		outcome=null;
		for(ObjectError err : allErrors) {				
			msg = new FacesMessage( err.getDefaultMessage() );
			msg.setSeverity( FacesMessage.SEVERITY_ERROR );
			context.addMessage(null, msg);
		}
	}
	
	return outcome;
}
	@SuppressWarnings("unchecked")
	public String updateProsecution(){
		String outcome="success";
		
		try {
		prosecutionMgr.updateProsecution(prosecution);
		//addNew();
		FacesMessage msg = new FacesMessage("Prosecution information successfully saved.");
		msg.setSeverity(FacesMessage.SEVERITY_INFO);
		FacesContext.getCurrentInstance().addMessage("prosecutionForm", msg);
		prosecutionList.setWrappedData( prosecutionMgr.getProsecutions());
		editMode = false;
		
	} catch(Exception ex) {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage msg = new FacesMessage("There was an error updating the prosecution. Exception: " + ex.getMessage());
		msg.setSeverity(FacesMessage.SEVERITY_ERROR);
		context.addMessage("prosecutionForm", msg);
		List<ObjectError> allErrors = ((ProsecutionManager) prosecutionMgr).getErrors().getAllErrors();
		outcome=null;
		for(ObjectError err : allErrors) {				
			msg = new FacesMessage( err.getDefaultMessage() );
			msg.setSeverity( FacesMessage.SEVERITY_ERROR );
			context.addMessage(null, msg);
		}
	}
	
	return outcome;
}
public String doSearch() {
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
	List<lab2.entity.Prosecution> resultSet = prosecutionMgr.findProseuctionsByAll(searchTable);
	prosecutionList.setWrappedData(resultSet);
	if( prosecutionList.getRowCount() == 0 ) {
		FacesMessage msg = new FacesMessage("No prosecutions found.");
		msg.setSeverity( FacesMessage.SEVERITY_WARN );
		FacesContext.getCurrentInstance().addMessage("searchForm", msg);
	} else {
		FacesMessage msg = new FacesMessage("Found " + prosecutionList.getRowCount() + " prosecutions.");
		msg.setSeverity( FacesMessage.SEVERITY_INFO );
		FacesContext.getCurrentInstance().addMessage("searchForm", msg);
	}
	System.out.println("There are " + prosecutionList.getRowCount() );
	return outcome;
}


	


	public String getOffirstName() {
		return offirstName;
	}
	public void setOffirstName(String offirstName) {
		this.offirstName = offirstName;
	}
	public String getOflastName() {
		return oflastName;
	}
	public void setOflastName(String oflastName) {
		this.oflastName = oflastName;
	}
	public String getOffenderId1() {
		return offenderId1;
	}
	public void setOffenderId1(String offenderId1) {
		this.offenderId1 = offenderId1;
	}
	public String getChargesId() {
		return chargesId;
	}
	public void setChargesId(String chargesId) {
		this.chargesId = chargesId;
	}
	public String getFileyear() {
		return fileyear;
	}
	public void setFileyear(String fileyear) {
		this.fileyear = fileyear;
	}
	public String getDocketTicketNumber() {
		return docketTicketNumber;
	}
	public void setDocketTicketNumber(String docketTicketNumber) {
		this.docketTicketNumber = docketTicketNumber;
	}
	public String getSelectChargerTypeDomainId() {
		return selectChargerTypeDomainId;
	}
	public void setSelectChargerTypeDomainId(String selectChargerTypeDomainId) {
		this.selectChargerTypeDomainId = selectChargerTypeDomainId;
	}
	public String getPlaceOfOffence() {
		return placeOfOffence;
	}
	public void setPlaceOfOffence(String placeOfOffence) {
		this.placeOfOffence = placeOfOffence;
	}
	public String getSelectTicketTypeDomainId() {
		return selectTicketTypeDomainId;
	}
	public void setSelectTicketTypeDomainId(String selectTicketTypeDomainId) {
		this.selectTicketTypeDomainId = selectTicketTypeDomainId;
	}
	public String getPlaceOfTrial() {
		return placeOfTrial;
	}
	public void setPlaceOfTrial(String placeOfTrial) {
		this.placeOfTrial = placeOfTrial;
	}
	public String getSelectInitiatedByDomainId() {
		return selectInitiatedByDomainId;
	}
	public void setSelectInitiatedByDomainId(String selectInitiatedByDomainId) {
		this.selectInitiatedByDomainId = selectInitiatedByDomainId;
	}
	public String getOfficer() {
		return Officer;
	}
	public void setOfficer(String officer) {
		Officer = officer;
	}
	public String getOfficerId1() {
		return officerId1;
	}
	public void setOfficerId1(String officerId1) {
		this.officerId1 = officerId1;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getBadge() {
		return badge;
	}
	public void setBadge(String badge) {
		this.badge = badge;
	}
	
	public ProsecutionManager getProsecutionMgr() {
		return prosecutionMgr;
	}
	public void setProsecutionMgr(ProsecutionManager prosecutionMgr) {
		this.prosecutionMgr = prosecutionMgr;
	}
	public Prosecution getProsecution() {
		return prosecution;
	}
	public void setProsecution(Prosecution prosecution) {
		this.prosecution = prosecution;
	}
	public boolean isEditMode() {
		return editMode;
	}
	public void setEditMode(boolean editMode) {
		this.editMode = editMode;
	}
	public DataModel getProsecutionList() {
		return prosecutionList;
	}
	public void setProsecutionList(DataModel prosecutionList) {
		this.prosecutionList = prosecutionList;
	}


	public EnforRefCodeManager getEnforManager() {
		return enforManager;
	}


	public void setEnforManager(EnforRefCodeManager enforManager) {
		this.enforManager = enforManager;
	}


	public List<EnforRefCode> getInitiatedByList() {
		return initiatedByList;
	}


	public void setInitiatedByList(List<EnforRefCode> initiatedByList) {
		this.initiatedByList = initiatedByList;
	}


	public List<EnforRefCode> getViolationList() {
		return violationList;
	}


	public void setViolationList(List<EnforRefCode> violationList) {
		this.violationList = violationList;
	}


	public List<EnforRefCode> getRegCommunList() {
		return regCommunList;
	}


	public void setRegCommunList(List<EnforRefCode> regCommunList) {
		this.regCommunList = regCommunList;
	}


	public List<EnforRefCode> getTicketList() {
		return ticketList;
	}


	public void setTicketList(List<EnforRefCode> ticketList) {
		this.ticketList = ticketList;
	}


	public List<EnforRefCode> getChargeTypeList() {
		return chargeTypeList;
	}


	public void setChargeTypeList(List<EnforRefCode> chargeTypeList) {
		this.chargeTypeList = chargeTypeList;
	}


	public List<EnforRefCode> getSuspendList() {
		return suspendList;
	}


	public void setSuspendList(List<EnforRefCode> suspendList) {
		this.suspendList = suspendList;
	}

	
	public SpeciesManager getSpeciesManager() {
		return speciesManager;
	}


	public void setSpeciesManager(SpeciesManager speciesManager) {
		this.speciesManager = speciesManager;
	}


	public List<Species> getSpeciesList() {
		return speciesList;
	}


	public void setSpeciesList(List<Species> speciesList) {
		this.speciesList = speciesList;
	}
}