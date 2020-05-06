package lab2.controller;

import lab2.bll.*;
import lab2.entity.*;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.*;
import javax.servlet.http.HttpServletRequest;

import java.util.*;

public class EnforRefCodeQueryController {
	private HttpServletRequest request;
	private EnforRefCodeManager enforManager = new EnforRefCodeManager();
	private DataModel violationList = new ListDataModel();
	private DataModel chargeslist = new ListDataModel();
	private DataModel initiatedByList= new ListDataModel();
	private DataModel regCommunList= new ListDataModel();
	private DataModel ticketList= new ListDataModel();
	private DataModel chargeTypeList= new ListDataModel();
	private DataModel suspendList = new ListDataModel();
	private Integer enforRefCodeId;

	private String act;

	
	
	//private List<Charge> chargeslist = new ChargeManager().getCharges();
	
	public EnforRefCodeQueryController() {
		request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		chargeslist.setWrappedData( enforManager.getEnforRefCodes());
		violationList.setWrappedData(enforManager.getAllViolationTypeDomains("Violation_Type"));
		suspendList.setWrappedData(enforManager.getAllViolationTypeDomains("Suspension_Type"));
		initiatedByList.setWrappedData(enforManager.getAllViolationTypeDomains("Initiated_By"));
		regCommunList.setWrappedData(enforManager.getAllViolationTypeDomains("Regulated_Community"));
		ticketList.setWrappedData(enforManager.getAllViolationTypeDomains("Ticket_Type"));
		chargeTypeList.setWrappedData(enforManager.getAllViolationTypeDomains("Charger_Type"));
	}
//here right code to search in dao for the different dropdowns
	public String doSearch() {
		
		Hashtable<String,String> searchTable = new Hashtable<String,String>();
		if( act.trim().length() != 0 ) {
			searchTable.put("act", act);
		}
		
		
		/*List<EnforRefCode> resultSet = enforManager.getEnforRefCodeByEnforRefCode(enforRefCodeId) ;
		chargeslist.setWrappedData( resultSet );			
		FacesMessage msg = new FacesMessage("Found " + resultSet.size() + " records.");
		msg.setSeverity(FacesMessage.SEVERITY_INFO);
		FacesContext.getCurrentInstance().addMessage("searchForm", msg);
*/
		return null;
	}
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public EnforRefCodeManager getEnforManager() {
		return enforManager;
	}
	public void setEnforManager(EnforRefCodeManager enforManager) {
		this.enforManager = enforManager;
	}
	public DataModel getViolationList() {
		return violationList;
	}
	public void setViolationList(DataModel violationList) {
		this.violationList = violationList;
	}
	public DataModel getChargeslist() {
		return chargeslist;
	}
	public void setChargeslist(DataModel chargeslist) {
		this.chargeslist = chargeslist;
	}
	public DataModel getInitiatedByList() {
		return initiatedByList;
	}
	public void setInitiatedByList(DataModel initiatedByList) {
		this.initiatedByList = initiatedByList;
	}
	public DataModel getRegCommunList() {
		return regCommunList;
	}
	public void setRegCommunList(DataModel regCommunList) {
		this.regCommunList = regCommunList;
	}
	public DataModel getTicketList() {
		return ticketList;
	}
	public void setTicketList(DataModel ticketList) {
		this.ticketList = ticketList;
	}
	public DataModel getChargeTypeList() {
		return chargeTypeList;
	}
	public void setChargeTypeList(DataModel chargeTypeList) {
		this.chargeTypeList = chargeTypeList;
	}
	public DataModel getSuspendList() {
		return suspendList;
	}
	public void setSuspendList(DataModel suspendList) {
		this.suspendList = suspendList;
	}
	public Integer getEnforRefCodeId() {
		return enforRefCodeId;
	}
	public void setEnforRefCodeId(Integer enforRefCodeId) {
		this.enforRefCodeId = enforRefCodeId;
	}

	

	
	
}
