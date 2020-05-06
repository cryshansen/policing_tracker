package lab2.entity;

import java.sql.Date;
import javax.persistence.*;

import org.hibernate.annotations.AccessType;

@Entity
@Table(name="prosecutions")
@AccessType("field")
public class Prosecution implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
		
//this is generated key field
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	@Column(name="PROSECUTION_ID")
	private int prosecution_id;
	
	@ManyToOne
    @JoinColumn(name="offd_ID")
	private Offender offenderId;
	
	@ManyToOne
    @JoinColumn(name="cha_ID")
	private Charge chargeId;
	
	@ManyToOne
    @JoinColumn(name="district_code",nullable=true)
    private District districtcode;
	
	@Column(name="FILE_YEAR")
	private Integer fileyear;
	@Column(name="DOCKETTICKET_NUMBER", unique=true)
	private String docketticketNumber;
	
	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE}, optional=true )//this relationship is optional check that reference is valid
    @JoinColumn(name="charger_Type_Domain_Id",nullable=true)//mysql column name caps dont matter
	private EnforRefCode chargerTypeDomainId;// a prosecution has a charger type in enfroRef code refers to whole object that contains all fields or properties
	
	@Column(name="PREV_RELATED_CONV")
	private String prevRelatedConv;
	
	@ManyToOne
	@JoinColumn(name="suspend_Off_Domain_Id", nullable=true)//foriegn key dont have to specify
	private EnforRefCode suspendOffDomainId;
	
	@Column(name="OFFENCE_TMST", nullable=true)
	private Date offenceTmst;
	
	@ManyToOne
	@JoinColumn(name="violation_Type_Domain_Id", nullable=true)
	private EnforRefCode violationTypeDomainId;
	
	@Column(name="COURT_DATE", nullable=true)
	private Date courtDate;
	@Column(name="PLACE_OF_OFFENCE", nullable=true)
	private String placeOfOffence;
	@Column(name="CIRCUMSTANCE_DETAILS", nullable=true)
	private String circumstanceDetails;
	
	@ManyToOne
	@JoinColumn(name="ticket_Type_Domain_Id", nullable=true)//this is mysql columnname
	private EnforRefCode ticketTypeDomainId;
	
	@Column(name="PLACE_OF_TRIAL", nullable=true)
	private String placeOfTrial;
	
	@ManyToOne
	@JoinColumn(name="Reg_Commun_Domain_Id", nullable=true)//this is mysql columnname
	private EnforRefCode regCommunDomainId;
	@Column(name="MIN_FINE", nullable=true)
	private Double min_fine;
	@Column(name="MAX_FINE", nullable=true)
	private Double max_fine;
	@Column(name="PENALTY", nullable=true)
	private String penalty;
	
	@ManyToOne
	@JoinColumn(name="initiated_By_Domain_ID", nullable=true)//this is mysql columnname
	private EnforRefCode initiatedByDomainID;
	
	@ManyToOne
	@JoinColumn(name="OFFICER_ID", nullable=true)
	private Officer officer_Id;
	@Column(name="WARRANT")
	private String warrant;
	@Column(name="PENALTY_FEE", nullable=true)
	private Double penalty_fee;
	
	@ManyToOne
    @JoinColumn(name="species_ID", nullable=true)
	private Species species_id;
	
	
	public Prosecution() {
		super();
	}


	public Prosecution(int prosecution_id) {
		super();
		this.prosecution_id = prosecution_id;
	}


	

	public Prosecution(int prosecution_id, Offender offenderId,
			Charge chargeId, District districtcode, Integer fileyear,
			String docketticketNumber, EnforRefCode chargerTypeDomainId,
			String prevRelatedConv, EnforRefCode suspendOffDomainId,
			Date offenceTmst, EnforRefCode violationTypeDomainId,
			Date courtDate, String placeOfOffence, String circumstanceDetails,
			EnforRefCode ticketTypeDomainId, String placeOfTrial,
			EnforRefCode regCommunDomainId, Double min_fine, Double max_fine,
			String penalty, EnforRefCode initiatedByDomainID,
			Officer officer_Id, String warrant, Double penalty_fee,
			Species species_id) {
		super();
		this.prosecution_id = prosecution_id;
		this.offenderId = offenderId;
		this.chargeId = chargeId;
		this.districtcode = districtcode;
		this.fileyear = fileyear;
		this.docketticketNumber = docketticketNumber;
		this.chargerTypeDomainId = chargerTypeDomainId;
		this.prevRelatedConv = prevRelatedConv;
		this.suspendOffDomainId = suspendOffDomainId;
		this.offenceTmst = offenceTmst;
		this.violationTypeDomainId = violationTypeDomainId;
		this.courtDate = courtDate;
		this.placeOfOffence = placeOfOffence;
		this.circumstanceDetails = circumstanceDetails;
		this.ticketTypeDomainId = ticketTypeDomainId;
		this.placeOfTrial = placeOfTrial;
		this.regCommunDomainId = regCommunDomainId;
		this.min_fine = min_fine;
		this.max_fine = max_fine;
		this.penalty = penalty;
		this.initiatedByDomainID = initiatedByDomainID;
		this.officer_Id = officer_Id;
		this.warrant = warrant;
		this.penalty_fee = penalty_fee;
		this.species_id = species_id;
	}


	
	public int getProsecution_id() {
		return prosecution_id;
	}


	public void setProsecution_id(int prosecution_id) {
		this.prosecution_id = prosecution_id;
	}


	public Offender getOffenderId() {
		return offenderId;
	}


	public void setOffenderId(Offender offenderId) {
		this.offenderId = offenderId;
	}


	public Charge getChargeId() {
		return chargeId;
	}


	public void setChargeId(Charge chargeId) {
		this.chargeId = chargeId;
	}


	public District getDistrictcode() {
		return districtcode;
	}


	public void setDistrictcode(District districtcode) {
		this.districtcode = districtcode;
	}


	public Integer getFileyear() {
		return fileyear;
	}


	public void setFileyear(Integer fileyear) {
		this.fileyear = fileyear;
	}


	public String getDocketticketNumber() {
		return docketticketNumber;
	}


	public void setDocketticketNumber(String docketticketNumber) {
		this.docketticketNumber = docketticketNumber;
	}


	public EnforRefCode getChargerTypeDomainId() {
		return chargerTypeDomainId;
	}


	public void setChargerTypeDomainId(EnforRefCode chargerTypeDomainId) {
		this.chargerTypeDomainId = chargerTypeDomainId;
	}


	public String getPrevRelatedConv() {
		return prevRelatedConv;
	}


	public void setPrevRelatedConv(String prevRelatedConv) {
		this.prevRelatedConv = prevRelatedConv;
	}


	public EnforRefCode getSuspendOffDomainId() {
		return suspendOffDomainId;
	}


	public void setSuspendOffDomainId(EnforRefCode suspendOffDomainId) {
		this.suspendOffDomainId = suspendOffDomainId;
	}


	public Date getOffenceTmst() {
		return offenceTmst;
	}


	public void setOffenceTmst(Date offenceTmst) {
		this.offenceTmst = offenceTmst;
	}


	public EnforRefCode getViolationTypeDomainId() {
		return violationTypeDomainId;
	}


	public void setViolationTypeDomainId(EnforRefCode violationTypeDomainId) {
		this.violationTypeDomainId = violationTypeDomainId;
	}


	public Date getCourtDate() {
		return courtDate;
	}


	public void setCourtDate(Date courtDate) {
		this.courtDate = courtDate;
	}


	public String getPlaceOfOffence() {
		return placeOfOffence;
	}


	public void setPlaceOfOffence(String placeOfOffence) {
		this.placeOfOffence = placeOfOffence;
	}


	public String getCircumstanceDetails() {
		return circumstanceDetails;
	}


	public void setCircumstanceDetails(String circumstanceDetails) {
		this.circumstanceDetails = circumstanceDetails;
	}


	public EnforRefCode getTicketTypeDomainId() {
		return ticketTypeDomainId;
	}


	public void setTicketTypeDomainId(EnforRefCode ticketTypeDomainId) {
		this.ticketTypeDomainId = ticketTypeDomainId;
	}


	public String getPlaceOfTrial() {
		return placeOfTrial;
	}


	public void setPlaceOfTrial(String placeOfTrial) {
		this.placeOfTrial = placeOfTrial;
	}


	public EnforRefCode getRegCommunDomainId() {
		return regCommunDomainId;
	}


	public void setRegCommunDomainId(EnforRefCode regCommunDomainId) {
		this.regCommunDomainId = regCommunDomainId;
	}


	public Double getMin_fine() {
		return min_fine;
	}


	public void setMin_fine(Double min_fine) {
		this.min_fine = min_fine;
	}


	public Double getMax_fine() {
		return max_fine;
	}


	public void setMax_fine(Double max_fine) {
		this.max_fine = max_fine;
	}


	public String getPenalty() {
		return penalty;
	}


	public void setPenalty(String penalty) {
		this.penalty = penalty;
	}


	public EnforRefCode getInitiatedByDomainID() {
		return initiatedByDomainID;
	}


	public void setInitiatedByDomainID(EnforRefCode initiatedByDomainID) {
		this.initiatedByDomainID = initiatedByDomainID;
	}


	public Officer getOfficer_Id() {
		return officer_Id;
	}


	public void setOfficer_Id(Officer officer_Id) {
		this.officer_Id = officer_Id;
	}


	public String getWarrant() {
		return warrant;
	}


	public void setWarrant(String warrant) {
		this.warrant = warrant;
	}


	public Double getPenalty_fee() {
		return penalty_fee;
	}


	public void setPenalty_fee(Double penalty_fee) {
		this.penalty_fee = penalty_fee;
	}


	public Species getSpecies_id() {
		return species_id;
	}


	public void setSpecies_id(Species species_id) {
		this.species_id = species_id;
	}


	public static long getSerialVersionUID() {
		return serialVersionUID;
	}


	
	
}//end class
