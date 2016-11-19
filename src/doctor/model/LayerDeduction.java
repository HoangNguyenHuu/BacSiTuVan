package doctor.model;


public class LayerDeduction {
	private int numLayer;
	private Rule rule;
	
	
	
	public LayerDeduction() {
		super();
	}
	public LayerDeduction(int numLayer, Rule rule) {
		super();
		this.numLayer = numLayer;
		this.rule = rule;
	}
	public int getNumLayer() {
		return numLayer;
	}
	public void setNumLayer(int numLayer) {
		this.numLayer = numLayer;
	}
	public Rule getRule() {
		return rule;
	}
	public void setRule(Rule rule) {
		this.rule = rule;
	}
	
	
	
}
