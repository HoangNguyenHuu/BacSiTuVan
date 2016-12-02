package doctor.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Rule implements Comparable<Rule>, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idRule;
	private String IdConclude;
	private ArrayList<String> ListIDHypothesis;
	private double certainFactor;

	public Rule(String idRule, String idConclude, ArrayList<String> listIDHypothesis, double certainFactor) {
		super();
		this.idRule = idRule;
		IdConclude = idConclude;
		ListIDHypothesis = listIDHypothesis;
		this.certainFactor = certainFactor;
	}
	
	
	public String getIdRule() {
		return idRule;
	}



	public void setIdRule(String idRule) {
		this.idRule = idRule;
	}



	public String getIdConclude() {
		return IdConclude;
	}

	public void setIdConclude(String idConclude) {
		IdConclude = idConclude;
	}

	public ArrayList<String> getListIDHypothesis() {
		return ListIDHypothesis;
	}

	public void setListIDHypothesis(ArrayList<String> listIDHypothesis) {
		ListIDHypothesis = listIDHypothesis;
	}

	public double getCertainFactor() {
		return certainFactor;
	}

	public void setCertainFactor(double certainFactor) {
		this.certainFactor = certainFactor;
	}



	@Override
	public int compareTo(Rule o) {
		return this.IdConclude.compareTo(o.IdConclude);
	}
	
	
	
}
