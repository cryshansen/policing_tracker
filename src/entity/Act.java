package lab2.entity;

import javax.persistence.*;

import org.hibernate.annotations.AccessType;

import java.util.Date;
@Entity
@Table(name="acts")
@AccessType("field")
public class Act implements java.io.Serializable{
	@Transient
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	private int act_id;
	@Column(name="ACT")
	private String act;
	@Column(name="DESCRIPTION",nullable = true)
	private String description;
	@Column(name="EXPIRY_DATE",nullable = true)
	private Date expiryDate;
	
	
	public Act() {
		super();
	}





	public String getAct() {
		return act;
	}


	public void setAct(String act) {
		this.act = act;
	}




	public int getAct_id() {
		return act_id;
	}





	public void setAct_id(int act_id) {
		this.act_id = act_id;
	}





	public String getDescription() {
		return description;
	}





	public void setDescription(String description) {
		this.description = description;
	}





	public Date getExpiryDate() {
		return expiryDate;
	}


	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	

}
