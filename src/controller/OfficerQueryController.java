package lab2.controller;

import lab2.bll.*;
import lab2.entity.*;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.*;
import javax.servlet.http.HttpServletRequest;

import java.util.*;

public class OfficerQueryController {
	private HttpServletRequest request;
	private OfficerManager officerManager = new OfficerManager();
	private DataModel officerlist = new ListDataModel();
	private Integer officerId;
	private String officer;
	private String badge;
	private String active;
	
	
	//private List<Officer> officerList = new OfficerManager().getOfficers();
	
	public String doSearch() {
		
		Hashtable<String,String> searchTable = new Hashtable<String,String>();
		if( officer.trim().length() != 0 ) {
			searchTable.put("officer", officer);
		}
		if( badge.trim().length() != 0 ) {
			searchTable.put("badge", badge);
		}
		
		
		List<Officer> resultSet = officerManager.findOffenderByOfficerBadge(searchTable);
		officerlist.setWrappedData( resultSet );			
		FacesMessage msg = new FacesMessage("Found " + resultSet.size() + " records.");
		msg.setSeverity(FacesMessage.SEVERITY_INFO);
		FacesContext.getCurrentInstance().addMessage("searchForm", msg);

		return null;
	}

	public OfficerManager getOfficerManager() {
		return officerManager;
	}

	public void setOfficerManager(OfficerManager officerManager) {
		this.officerManager = officerManager;
	}

	public DataModel getOfficerlist() {
		return officerlist;
	}

	public void setOfficerlist(DataModel officerlist) {
		this.officerlist = officerlist;
	}

	public Integer getOfficerId() {
		return officerId;
	}

	public void setOfficerId(Integer officerId) {
		this.officerId = officerId;
	}

	public String getOfficer() {
		return officer;
	}

	public void setOfficer(String officer) {
		this.officer = officer;
	}

	public String getBadge() {
		return badge;
	}

	public void setBadge(String badge) {
		this.badge = badge;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	/*public List<Officer> getOfficerList() {
		return officerList;
	}

	public void setOfficerList(List<Officer> officerList) {
		this.officerList = officerList;
	}*/

	public OfficerQueryController() {
		request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		officerlist.setWrappedData( officerManager.getOfficers());
	}


	
	
}
