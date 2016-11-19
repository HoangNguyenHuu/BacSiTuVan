package doctor.model;

import java.io.Serializable;

public class Event implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ID;
	private String name;
	private double certainFactor;
	
	public Event(String iD, String name, double certainFactor) {
		super();
		ID = iD;
		this.name = name;
		this.certainFactor = certainFactor;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getCertainFactor() {
		return certainFactor;
	}
	public void setCertainFactor(double certainFactor) {
		this.certainFactor = certainFactor;
	}
	
	
}
