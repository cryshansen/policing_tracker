package lab2.entity;

import javax.persistence.*;

import org.hibernate.annotations.AccessType;

import java.util.Date;

@Entity
@Table(name="offenders")
@AccessType("field")
public class Offender implements java.io.Serializable {

	@Transient
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	@Column(name="offender_ID")
	private int offenderId;
	
	@Column(name="LAST_NAME")
	private String lastName;	
	@Column(name="FIRST_NAME", nullable=true)
	private String firstName;
	@Column(name="MIDDLE_NAME", nullable=true)
	private String middleName;
	@Column(nullable=true)
	private String dob;
	@Column(nullable=true)
	private String address;
	@Column(nullable=true)
	private String city;
	@Column(name="PROV", nullable=true)
	private String province;
	@Column(name="POSTAL_CODE", nullable=true)
	private String postalCode;
	@Column(nullable=true)
	private String phone1;
	@Column(nullable=true)
	private String phone2;
	private String sex;
	@Column(name="HUNTER_TEST_COUNT", nullable=true)
	private Integer hunterTestCount;	
	@Column(name="HUNTER_TEST_DATE", nullable=true)
	private Date hunderTestDate;
	@Column(name="REC_HUNT_ELIGIBLE_FLAG", nullable=true)
	private String recHuntEligibleFlag;
	@Column(name="REC_HUNT_ENDDATE", nullable=true)
	private Date recHuntEndDate;
	@Column(name="REC_HUNT_OVRIDE_FLAG")	
	private String recHuntOverRideFlag;
	
	public Offender() {
	
	}

	public Offender(int offenderId) {
		this.offenderId = offenderId;
	}
	
	public Offender(int offenderId, String lastName, String firstName,
			String middleName, String dob, String address, String city,
			String province, String postalCode, String phone1, String phone2,
			String sex, Integer hunterTestCount, Date hunderTestDate,
			String recHuntEligibleFlag, Date recHuntEndDate,
			String recHuntOverRideFlag) {

		this.offenderId = offenderId;
		this.lastName = lastName;
		this.firstName = firstName;
		this.middleName = middleName;
		this.dob = dob;
		this.address = address;
		this.city = city;
		this.province = province;
		this.postalCode = postalCode;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.sex = sex;
		this.hunterTestCount = hunterTestCount;
		this.hunderTestDate = hunderTestDate;
		this.recHuntEligibleFlag = recHuntEligibleFlag;
		this.recHuntEndDate = recHuntEndDate;
		this.recHuntOverRideFlag = recHuntOverRideFlag;
	}
	public int getOffenderId() {
		return offenderId;
	}
	public void setOffenderId(int offenderId) {
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
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
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
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getPhone1() {
		return phone1;
	}
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
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
	public Integer getHunterTestCount() {
		return hunterTestCount;
	}
	public void setHunterTestCount(Integer hunterTestCount) {
		this.hunterTestCount = hunterTestCount;
	}
	public Date getHunderTestDate() {
		return hunderTestDate;
	}
	public void setHunderTestDate(Date hunderTestDate) {
		this.hunderTestDate = hunderTestDate;
	}
	public String getRecHuntEligibleFlag() {
		return recHuntEligibleFlag;
	}
	public void setRecHuntEligibleFlag(String recHuntEligibleFlag) {
		this.recHuntEligibleFlag = recHuntEligibleFlag;
	}
	public Date getRecHuntEndDate() {
		return recHuntEndDate;
	}
	public void setRecHuntEndDate(Date recHuntEndDate) {
		this.recHuntEndDate = recHuntEndDate;
	}
	public String getRecHuntOverRideFlag() {
		return recHuntOverRideFlag;
	}
	public void setRecHuntOverRideFlag(String recHuntOverRideFlag) {
		this.recHuntOverRideFlag = recHuntOverRideFlag;
	}
	

	
}
