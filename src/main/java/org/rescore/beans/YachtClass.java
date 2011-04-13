package org.rescore.beans;

public class YachtClass extends AbstractModelObject {

	private String name;
	private String notes;
	private float coefficient;
	private int projectYear, length, width;
	private int displacement;
	private int waterlineLength;
	private int sailAreaDownwind;
	private int sailAreaUpwind;
	
	public YachtClass(){}
	
	public YachtClass(String name, String notes, float coefficient,
			int projectYear, int length, int width, int displacement,
			int waterlineLength, int sailAreaDownwind, int sailAreaUpwind) {
		super();
		this.name = name;
		this.notes = notes;
		this.coefficient = coefficient;
		this.projectYear = projectYear;
		this.length = length;
		this.width = width;
		this.displacement = displacement;
		this.waterlineLength = waterlineLength;
		this.sailAreaDownwind = sailAreaDownwind;
		this.sailAreaUpwind = sailAreaUpwind;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		String oldValue = this.name;
		this.name = name;
		firePropertyChange("name", oldValue, name);
	}
	
	public String getNotes() {
		return notes;
	}
	
	public void setNotes(String notes) {
		String oldValue = this.notes;
		this.notes = notes;
		firePropertyChange("notes", oldValue, notes);
	}
	
	public float getCoefficient() {
		return coefficient;
	}
	
	public void setCoefficient(float coefficient) {
		float oldValue = this.coefficient;
		this.coefficient = coefficient;
		firePropertyChange("coefficient", oldValue, coefficient);
	}
	
	public int getProjectYear() {
		return projectYear;
	}
	
	public void setProjectYear(int projectYear) {
		int oldValue = this.projectYear;
		this.projectYear = projectYear;
		firePropertyChange("projectYear", oldValue, projectYear);
	}
	
	public int getLength() {
		return length;
	}
	
	public void setLength(int length) {
		int oldValue = this.length;
		this.length = length;
		firePropertyChange("length", oldValue, length);
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setWidth(int width) {
		int oldValue = this.width;
		this.width = width;
		firePropertyChange("width", oldValue, width);
	}
	
	public int getDisplacement() {
		return displacement;
	}
	
	public void setDisplacement(int displacement) {
		int oldValue = this.displacement;
		this.displacement = displacement;
		firePropertyChange("displacement", oldValue, displacement);
	}
	
	public int getWaterlineLength() {
		return waterlineLength;
	}
	
	public void setWaterlineLength(int waterlineLength) {
		int oldValue = this.waterlineLength;
		this.waterlineLength = waterlineLength;
		firePropertyChange("waterlineLength", oldValue, waterlineLength);
	}
	
	public int getSailAreaDownwind() {
		return sailAreaDownwind;
	}
	
	public void setSailAreaDownwind(int sailAreaDownwind) {
		int oldValue = this.sailAreaDownwind;
		this.sailAreaDownwind = sailAreaDownwind;
		firePropertyChange("sailAreaDownwind", oldValue, sailAreaDownwind);
	}
	
	public int getSailAreaUpwind() {
		return sailAreaUpwind;
	}
	
	public void setSailAreaUpwind(int sailAreaUpwind) {
		int oldValue = this.sailAreaUpwind;
		this.sailAreaUpwind = sailAreaUpwind;
		firePropertyChange("sailAreaUpwind", oldValue, sailAreaUpwind);
	}
	
}
