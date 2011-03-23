package org.rescore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="YACHTCLASSES")
public class YachtClass implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private String notes;
	private float coefficient;
	private int projectYear, length, width;
	private int displacement;
	private int waterlineLength;
	private int sailAreaDownwind;
	private int sailAreaUpwind;
	
	/** Hibernate requires a public no-arg constructor */
	public YachtClass(){}
	
	@Id
    @GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getNotes() {
		return notes;
	}
	
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	public float getCoefficient() {
		return coefficient;
	}
	
	public void setCoefficient(float coefficient) {
		this.coefficient = coefficient;
	}
	
	public int getProjectYear() {
		return projectYear;
	}
	
	public void setProjectYear(int projectYear) {
		this.projectYear = projectYear;
	}
	
	public int getLength() {
		return length;
	}
	
	public void setLength(int length) {
		this.length = length;
	}
	public int getWidth() {
		return width;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	/** vandentalpa */
	public int getDisplacement() {
		return displacement;
	}
	public void setDisplacement(int displacement) {
		this.displacement = displacement;
	}
	
	/** waterlinijos ilgis */
	public int getWaterlineLength() {
		return waterlineLength;
	}
	
	public void setWaterlineLength(int waterlineLength) {
		this.waterlineLength = waterlineLength;
	}
	
	/** burių plotas plaukiant pavėjui */
	public int getSailAreaDownwind() {
		return sailAreaDownwind;
	}
	
	public void setSailAreaDownwind(int sailAreaDownwind) {
		this.sailAreaDownwind = sailAreaDownwind;
	}
	
	/** burių plotas plaukiant pries vėją */
	public int getSailAreaUpwind() {
		return sailAreaUpwind;
	}
	
	public void setSailAreaUpwind(int sailAreaUpwind) {
		this.sailAreaUpwind = sailAreaUpwind;
	}
}
