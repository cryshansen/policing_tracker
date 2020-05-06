package lab2.controller;

import lab2.bll.*;
import lab2.entity.*;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.*;
import javax.servlet.http.HttpServletRequest;

import java.util.*;

public class ChargesQueryController {
	private HttpServletRequest request;
	private ChargeManager chargesManager = new ChargeManager();
	private DataModel chargeslist = new ListDataModel();
	private Integer charge_ID;
	private String act_ID;
	private String act;
	private String section;
	private String description;
	
	
	//private List<Charge> chargeslist = new ChargeManager().getCharges();
	
	public ChargesQueryController() {
		request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		chargeslist.setWrappedData( chargesManager.getCharges());
	
	}

	public String doSearch() {
		
		Hashtable<String,String> searchTable = new Hashtable<String,String>();
		if( act.trim().length() != 0 ) {
			searchTable.put("act", act);
		}
		
		
		List<Charge> resultSet = chargesManager.getChargesByAct(act) ;
		chargeslist.setWrappedData( resultSet );			
		FacesMessage msg = new FacesMessage("Found " + resultSet.size() + " records.");
		msg.setSeverity(FacesMessage.SEVERITY_INFO);
		FacesContext.getCurrentInstance().addMessage("searchForm", msg);

		return null;
	}

	public ChargeManager getChargesManager() {
		return chargesManager;
	}

	public void setChargesManager(ChargeManager chargesManager) {
		this.chargesManager = chargesManager;
	}

	public DataModel getChargeslist() {
		return chargeslist;
	}

	public void setChargeslist(DataModel chargeslist) {
		this.chargeslist = chargeslist;
	}

	public Integer getCharge_ID() {
		return charge_ID;
	}

	public void setCharge_ID(Integer chargeId) {
		this.charge_ID = chargeId;
	}

	public String getAct_Id() {
		return act_ID;
	}

	public void setAct_ID(String actId) {
		this.act_ID = actId;
	}

	public String getAct() {
		return act;
	}

	public void setAct(String act) {
		this.act = act;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/*public List<Charge> getChargesList() {
		return chargesList;
	}

	public void setChargesList(List<Charge> chargesList) {
		this.chargesList = chargesList;
	}*/

	
	
}
