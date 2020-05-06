package lab2.controller;

import lab2.bll.*;
import lab2.entity.*;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.*;
import javax.servlet.http.HttpServletRequest;

import java.util.*;

public class OffenderQueryController {
	private HttpServletRequest request;
	private OffenderManager offenderManager = new OffenderManager();
	private DataModel offenderlist = new ListDataModel();
	private Integer offenderId;
	private String lastName;
	private String firstName;
	private String address;
	private String city;
	private String province;
	private String postalcode;
	private String phone1;
	
	
	
	public OffenderQueryController() {
		request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		offenderlist.setWrappedData( offenderManager.getOffenders());
	}

	public String doSearch() {
		
		Hashtable<String,String> searchTable = new Hashtable<String,String>();
		if( firstName.trim().length() != 0 ) {
			searchTable.put("firstName", firstName);
		}
		if( lastName.trim().length() != 0 ) {
			searchTable.put("lastName", lastName);
		}
				
		List<Offender> resultSet = offenderManager .findOffenderByAll(searchTable);
		offenderlist.setWrappedData( resultSet );			
		FacesMessage msg = new FacesMessage("Found " + resultSet.size() + " records.");
		msg.setSeverity(FacesMessage.SEVERITY_INFO);
		FacesContext.getCurrentInstance().addMessage("searchForm", msg);

		return null;
	}

	public OffenderManager getOffenderManager() {
		return offenderManager;
	}

	public void setOffenderManager(OffenderManager offenderManager) {
		this.offenderManager = offenderManager;
	}

	public DataModel getOffenderlist() {
		return offenderlist;
	}

	public void setOffenderlist(DataModel offenderlist) {
		this.offenderlist = offenderlist;
	}

	public Integer getOffenderId() {
		return offenderId;
	}

	public void setOffenderId(Integer offenderId) {
		this.offenderId = offenderId;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	
	
	
}
