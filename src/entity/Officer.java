package lab2.entity;
import javax.persistence.*;

import org.hibernate.annotations.AccessType;

//import java.util.Date;
@Entity
@Table(name="officers")
@AccessType("field")
public class Officer implements java.io.Serializable{
	@Transient
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	@Column(name="OFFICER_ID")
	private int officer_ID;
	@Column(name="BADGE")
	private int badge;
	@Column(name="OFFICER")
	private String officer;
	@Column(name="ACTIVE")
	private String active;
	public Officer() {
		super();
	}
	public Officer(int officer_ID) {
		super();
		this.officer_ID = officer_ID;
	}
	public Officer(int officer_ID, int badge, String officer, String active) {
		super();
		this.officer_ID = officer_ID;
		this.badge = badge;
		this.officer = officer;
		this.active = active;
	}
	public int getOfficer_ID() {
		return officer_ID;
	}
	public void setOfficer_ID(int officer_ID) {
		this.officer_ID = officer_ID;
	}
	public int getBadge() {
		return badge;
	}
	public void setBadge(int badge) {
		this.badge = badge;
	}
	public String getOfficer() {
		return officer;
	}
	public void setOfficer(String officer) {
		this.officer = officer;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	
	
}
