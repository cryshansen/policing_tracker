package lab2.entity;
import javax.persistence.*;

import org.hibernate.annotations.AccessType;

//import java.util.Date;

@Entity
@Table(name="enfor_ref_codes")
@AccessType("field")
public class EnforRefCode implements java.io.Serializable{
	@Transient
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	@Column(name="ENFOR_REF_CODE_ID")
	private int enforRefCodeID;
	
	@Column(name="RV_DOMAIN")
	private String rvDomain;
	@Column(name="RV_LOW_VALUE")
	private String rvLowValue;
	@Column(name="RV_HIGH_VALUE", nullable= true)
	private String rvHighValue;
	@Column(name="RV_ABBREVIATION", nullable=true)
	private String rvAbbreviation;
	@Column(name="RV_MEANING", nullable=true)
	private String rvMeaning;
	public EnforRefCode() {
		super();
	}
	public EnforRefCode(int enforRefCodeID) {
		super();
		this.enforRefCodeID = enforRefCodeID;
	}
	public EnforRefCode(int enforRefCodeID, String rvDomain, String rvLowValue,
			String rvHighValue, String rvAbbreviation, String rvMeaning) {
		super();
		this.enforRefCodeID = enforRefCodeID;
		this.rvDomain = rvDomain;
		this.rvLowValue = rvLowValue;
		this.rvHighValue = rvHighValue;
		this.rvAbbreviation = rvAbbreviation;
		this.rvMeaning = rvMeaning;
	}
	public int getEnforRefCodeID() {
		return enforRefCodeID;
	}
	public void setEnforRefCodeID(int enforRefCodeID) {
		this.enforRefCodeID = enforRefCodeID;
	}
	public String getRvDomain() {
		return rvDomain;
	}
	public void setRvDomain(String rvDomain) {
		this.rvDomain = rvDomain;
	}
	public String getRvLowValue() {
		return rvLowValue;
	}
	public void setRvLowValue(String rvLowValue) {
		this.rvLowValue = rvLowValue;
	}
	public String getRvHighValue() {
		return rvHighValue;
	}
	public void setRvHighValue(String rvHighValue) {
		this.rvHighValue = rvHighValue;
	}
	public String getRvAbbreviation() {
		return rvAbbreviation;
	}
	public void setRvAbbreviation(String rvAbbreviation) {
		this.rvAbbreviation = rvAbbreviation;
	}
	public String getRvMeaning() {
		return rvMeaning;
	}
	public void setRvMeaning(String rvMeaning) {
		this.rvMeaning = rvMeaning;
	}
	
	

}
