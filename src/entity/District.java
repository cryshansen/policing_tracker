package lab2.entity;

import javax.persistence.*;

import org.hibernate.annotations.AccessType;

//import java.util.Date;
@Entity
@Table(name="districts")
@AccessType("field")
public class District implements java.io.Serializable{
	@Transient
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	@Column(name="CODE")
	private String code;
	@Column(name="DESCRIPTION")
	private String description;
	public District() {
		super();
	}
	public District(String code) {
		super();
		this.code = code;
	}
	public District(String code, String description) {
		super();
		this.code = code;
		this.description = description;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
		

}
