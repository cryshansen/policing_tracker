package lab2.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.ObjectError;


import lab2.bll.OffenderManager;
import lab2.entity.Offender;

public class OffenderController {
	private HttpServletRequest request;
	private OffenderManager offenderMgr = new OffenderManager();
	private Offender offender = new Offender();
	private Integer offenderId;
	private String lastName;
	private String firstName;
	private String middleName;
	private String dob;
	private String address;
	private String city;
	private String province;
	private String postalCode;
	private String phone1;
	private String phone2;
	private String sex;
	private String hunterTestCount;
	private String hunterTestDate;
	private String recHuntEligibleFlag;
	private String recHuntEndDate;
	private String recHuntOvRideFl;
	
	private boolean editMode = false;
	private DataModel offenderList = new ListDataModel();
	
	public OffenderController(){
		request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		offenderList.setWrappedData( offenderMgr.getOffenders());
	}
	
	
	public String addNew() {
		offender = new Offender();
		editMode = false;
		return "success";
	}
	
	@SuppressWarnings("unchecked")
	public String addOffender(){
		
		try {
			offenderMgr.addOffender(offender);
			addNew();
			FacesMessage msg = new FacesMessage("Offender information successfully saved.");
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
			FacesContext.getCurrentInstance().addMessage("offenderForm", msg);
		} catch(Exception ex) {
			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage msg = new FacesMessage("There was an error saving the Offender. Exception: " + ex.getMessage());
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage("offenderForm", msg);
			List<ObjectError> allErrors = ((OffenderManager) offenderMgr).getErrors().getAllErrors();
			for(ObjectError err : allErrors) {				
				msg = new FacesMessage( err.getDefaultMessage() );
				msg.setSeverity( FacesMessage.SEVERITY_ERROR );
				context.addMessage(null, msg);
			}
		}
		
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public String updateOffender(){
		String outcome ="null";
		try {
			offenderMgr.updateOffender(offender);
			//addNew();
			FacesMessage msg = new FacesMessage("Offender information successfully saved.");
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
			FacesContext.getCurrentInstance().addMessage("offenderForm", msg);
			editMode = false;
			outcome ="success";
		} catch(Exception ex) {
			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage msg = new FacesMessage("There was an error updating the Offender. Exception: " + ex.getMessage());
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage("offenderForm", msg);
			List<ObjectError> allErrors = ((OffenderManager) offenderMgr).getErrors().getAllErrors();
			for(ObjectError err : allErrors) {				
				msg = new FacesMessage( err.getDefaultMessage() );
				msg.setSeverity( FacesMessage.SEVERITY_ERROR );
				context.addMessage(null, msg);
			}
		}
		
		return outcome;
	}
	public String doSearch() {
		List<Offender> resultSet = offenderMgr.getOffenders();
		offenderList.setWrappedData( resultSet );
		FacesContext context = FacesContext.getCurrentInstance();
		if( resultSet.size() > 0 ) {
			FacesMessage msg = new FacesMessage("Found " + resultSet.size() + " records.");
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
			context.addMessage("searchForm", msg);
		} else {
			FacesMessage msg = new FacesMessage("No records found.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage("searchForm", msg);			
		}

		return null;
	}
	public String editOffender(){
		
		offender= (Offender) offenderList.getRowData();
		editMode = true;
		return "success";
	}
	
	public String reportOffender(){
		offender= (Offender) offenderList.getRowData();
		editMode = true;
		return "success";
	}
	public String deleteOffender(){
		
		String outcome = null;
		Offender offender = (Offender) offenderList.getRowData();
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			offenderMgr.deleteOffender(offender);
			List<Offender> resultSet = offenderMgr.getOffenders();
			offenderList.setWrappedData( resultSet );
			FacesMessage msg = new FacesMessage("Successfully delete payment information.");
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
			context.addMessage("searchForm", msg);
			outcome = "success";
		} catch (Exception ex) {
			FacesMessage msg = new FacesMessage("There was an error in deleting the payment.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage("searchForm", msg);
		}
		return outcome;
		
	}


	public OffenderManager getOffenderMgr() {
		return offenderMgr;
	}


	public void setOffenderMgr(OffenderManager offenderMgr) {
		this.offenderMgr = offenderMgr;
	}


	public Offender getOffender() {
		return offender;
	}


	public void setOffender(Offender offender) {
		this.offender = offender;
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


	public String getMiddleName() {
		return middleName;
	}


	public void setMiddleName(String middleName) {
		this.middleName = middleName;
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


	public String getPhone1() {
		return phone1;
	}


	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}


	public boolean isEditMode() {
		return editMode;
	}


	public void setEditMode(boolean editMode) {
		this.editMode = editMode;
	}


	public DataModel getOffenderList() {
		return offenderList;
	}


	public void setOffenderList(DataModel offenderList) {
		this.offenderList = offenderList;
	}


	public HttpServletRequest getRequest() {
		return request;
	}


	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	public String getPostalCode() {
		return postalCode;
	}


	public void setPostalCode(String postalcode) {
		this.postalCode = postalcode;
	}


	public Integer getOffenderId() {
		return offenderId;
	}


	public void setOffenderId(Integer offenderId) {
		this.offenderId = offenderId;
	}


	public String getPhone2() {
		return phone2;
	}


	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public String getHunterTestCount() {
		return hunterTestCount;
	}


	public void setHunterTestCount(String hunterTestCount) {
		this.hunterTestCount = hunterTestCount;
	}


	public String getHunterTestDate() {
		return hunterTestDate;
	}


	public void setHunterTestDate(String hunterTestDate) {
		this.hunterTestDate = hunterTestDate;
	}


	public String getRecHuntEligibleFlag() {
		return recHuntEligibleFlag;
	}


	public void setRecHuntEligibleFlag(String recHuntEligibleFlag) {
		this.recHuntEligibleFlag = recHuntEligibleFlag;
	}


	public String getRecHuntEndDate() {
		return recHuntEndDate;
	}


	public void setRecHuntEndDate(String recHuntEndDate) {
		this.recHuntEndDate = recHuntEndDate;
	}


	public String getRecHuntOvRideFl() {
		return recHuntOvRideFl;
	}


	public void setRecHuntOvRideFl(String recHuntOvRideFl) {
		this.recHuntOvRideFl = recHuntOvRideFl;
	}

	
}
