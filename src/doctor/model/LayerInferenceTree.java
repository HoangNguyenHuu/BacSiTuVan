package doctor.model;

import java.util.ArrayList;

public class LayerInferenceTree {
	private int numberLayer;
	private ArrayList<InferenceTree> listInferenceTree;
	public LayerInferenceTree(int numberLayer, ArrayList<InferenceTree> listInferenceTree) {
		super();
		this.numberLayer = numberLayer;
		this.listInferenceTree = listInferenceTree;
	}
	public int getNumberLayer() {
		return numberLayer;
	}
	public void setNumberLayer(int numberLayer) {
		this.numberLayer = numberLayer;
	}
	public ArrayList<InferenceTree> getListInferenceTree() {
		return listInferenceTree;
	}
	public void setListInferenceTree(ArrayList<InferenceTree> listInferenceTree) {
		this.listInferenceTree = listInferenceTree;
	}
	
	
}
