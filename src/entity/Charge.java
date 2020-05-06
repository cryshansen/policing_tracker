package lab2.entity;
import java.util.Date;


//import java.sql.Date;
import javax.persistence.*;

import org.hibernate.annotations.AccessType;

@Entity
@Table(name="charges")
@AccessType("field")
public class Charge implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	private int charge_ID;
	@ManyToOne
    @JoinColumn(name="ACT_ID")
	private Act act_id;
	@Column(name="SECTION")
	private String section;
	@Column(name="DESCRIPTION")
	private String description;
	@Column(name="EXPIRY_DATE", nullable = true)
	private Date expiry_date;
	@Column(name="SUSP_OFFENCE",nullable = true)
	private String susp_offence;
	@Column(name="SUSP_LENGTH", nullable = true)
	private Integer susp_length;
	
	
	
	public Charge() {
		super();
	}


	public Charge(int charge_id) {
		super();
		this.charge_ID = charge_id;
	}


	public Charge(int charge_ID, Act act_id, String section,
			String description, Date expiry_date, String susp_offence,
			Integer susp_length) {
		super();
		this.charge_ID = charge_ID;
		this.act_id = act_id;
		this.section = section;
		this.description = description;
		this.expiry_date = expiry_date;
		this.susp_offence = susp_offence;
		this.susp_length = susp_length;
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


	public Date getExpiry_date() {
		return expiry_date;
	}


	public void setExpiry_date(Date expiry_date) {
		this.expiry_date = expiry_date;
	}


	public String getSusp_offence() {
		return susp_offence;
	}


	public void setSusp_offence(String susp_offence) {
		this.susp_offence = susp_offence;
	}


	public Integer getSusp_length() {
		return susp_length;
	}


	public void setSusp_length(Integer susp_length) {
		this.susp_length = susp_length;
	}





	public Act getAct_id() {
		return act_id;
	}


	public void setAct_id(Act act_id) {
		this.act_id = act_id;
	}


	public int getCharge_ID() {
		return charge_ID;
	}


	public void setCharge_ID(int charge_ID) {
		this.charge_ID = charge_ID;
	}
	
	
	
}
