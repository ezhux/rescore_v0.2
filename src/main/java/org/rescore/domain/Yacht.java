package org.rescore.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="YACHTS")
public class Yacht implements java.io.Serializable  {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private String sailNumber;
	private YachtClass yachtClass;
	private Integer buildYear;
	private String captain;
	private String owner;
	private String sponsors;
	private String notes;
	
	/** Hibernate requires a public no-arg constructor */
	public Yacht(){}

	@Id
    @GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Yacht(String name, String sailNumber){
		this.name = name;
		this.sailNumber = sailNumber;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSailNumber() {
		return sailNumber;
	}

	public void setSailNumber(String sailNumber) {
		this.sailNumber = sailNumber;
	}

	@ManyToOne
	@JoinColumn(name="yachtClass")
	public YachtClass getYachtClass() {
		return yachtClass;
	}

	public void setYachtClass(YachtClass yachtClass) {
		this.yachtClass = yachtClass;
	}

	public Integer getBuildYear() {
		return buildYear;
	}

	public void setBuildYear(Integer buildYear) {
		this.buildYear = buildYear;
	}

	public String getCaptain() {
		return captain;
	}

	public void setCaptain(String captain) {
		this.captain = captain;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getSponsors() {
		return sponsors;
	}

	public void setSponsors(String sponsors) {
		this.sponsors = sponsors;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	

	
}
