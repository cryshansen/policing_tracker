package lab2.entity;
import javax.persistence.*;

import org.hibernate.annotations.AccessType;



@Entity
@Table(name="species")
@AccessType("field")
public class Species implements java.io.Serializable{
	@Transient
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	
	private int species_ID;
	@Column(name="DESCRIPTION")
	private String description;
	public Species() {
		super();
	}
	public Species(int species_ID) {
		super();
		this.species_ID = species_ID;
	}
	public Species(int species_ID, String description) {
		super();
		this.species_ID = species_ID;
		this.description = description;
	}
	public int getSpecies_ID() {
		return species_ID;
	}
	public void setSpecies_ID(int species_ID) {
		this.species_ID = species_ID;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	

}
