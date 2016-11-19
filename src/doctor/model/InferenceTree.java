package doctor.model;

import java.io.Serializable;
import java.util.ArrayList;

public class InferenceTree implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<LayerDeductionGroup> listLayerGroup;

	
	
	public InferenceTree() {
		super();
		listLayerGroup = new ArrayList<>();
	}

	public InferenceTree(ArrayList<LayerDeductionGroup> listLayerGroup) {
		super();
		this.listLayerGroup = listLayerGroup;
	}

	public ArrayList<LayerDeductionGroup> getListLayerGroup() {
		return listLayerGroup;
	}

	public void setListLayerGroup(ArrayList<LayerDeductionGroup> listLayerGroup) {
		this.listLayerGroup = listLayerGroup;
	}

	// Hiển thị cây suy diễn
	public void display() {
		for (int i = 0; i < this.listLayerGroup.size(); i++) {
			LayerDeductionGroup lds = this.listLayerGroup.get(i);
			System.out.print("Layer " + lds.getNumLayer() + ": ");
			for (int j = 0; j < lds.getListRule().size(); j++) {
				System.out.print(lds.getListRule().get(j).getIdRule() + " ");
			}
			System.out.println();
		}
	}
}
