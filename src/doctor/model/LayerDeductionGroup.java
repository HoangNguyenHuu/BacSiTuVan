package doctor.model;

import java.io.Serializable;
import java.util.ArrayList;

public class LayerDeductionGroup implements Comparable<LayerDeductionGroup>, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int numLayer;
	private ArrayList<Rule> listRule;
	
	
	
	public LayerDeductionGroup() {
		super();
	}
	public LayerDeductionGroup(int numLayer, ArrayList<Rule> listRule) {
		super();
		this.numLayer = numLayer;
		this.listRule = listRule;
	}
	public int getNumLayer() {
		return numLayer;
	}
	public void setNumLayer(int numLayer) {
		this.numLayer = numLayer;
	}
	public ArrayList<Rule> getListRule() {
		return listRule;
	}
	public void setListRule(ArrayList<Rule> listRule) {
		this.listRule = listRule;
	}
	@Override
	public int compareTo(LayerDeductionGroup o) {
		// TODO Auto-generated method stub
		if(this.numLayer > o.numLayer){
			return 1;
		}
		return -1;
	}
	
}
