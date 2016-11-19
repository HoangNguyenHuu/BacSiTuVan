package doctor.controller;

import java.util.ArrayList;

import doctor.model.Event;
import doctor.model.InferenceTree;
import doctor.model.Rule;

public class InferenceTreeController {
	
	private LayerController layerController;
	
	public InferenceTreeController() {
		super();
		this.layerController = new LayerController();
	}


	//Từ một luật và các sự kiện, lấy ra độ tin tưởng cao nhất với sự kiện đó.
	public void getCertainFactor(Rule rule, ArrayList<Event> listEvent, ArrayList<Rule> listAllRule){
		InferenceTree inferenceTree = layerController.stratifyEventFromRule(listAllRule, rule);
		ArrayList<InferenceTree> listInferenceTree= layerController.dividedAllTree(inferenceTree);
		
	}
	
	//Từ một cây suy diễn và một tập sự kiên, lấy ra độ tin cậy tương ứng
	public double getCertainFactorFromOneTree(InferenceTree inferenceTree, ArrayList<Event> listEvent, ArrayList<Rule>listAllRule){
		double certain = 0;
		ArrayList<String> listIDFromEvent = new ArrayList<>();
		for(int i = 0; i< listEvent.size(); i++){
			if(listIDFromEvent.indexOf(listEvent.get(i).getID()) < 0){
				listIDFromEvent.add(listEvent.get(i).getID());
			}
		}
		
		ArrayList<String> listIDPrimaryFromTree = getListPrimaryEventFromInferenceTree(inferenceTree, listAllRule);
		boolean check = checkEventFromTree(listIDPrimaryFromTree, listIDFromEvent);
		if(check == false){
			return 0;
		}
		
		return certain;
	}
	
	//Từ một cây, get các sự kiện không phải là sự kiện kết luận của bất kỳ luật nào, đây chính là các sự kiện sơ cấp từ.
	public ArrayList<String> getListPrimaryEventFromInferenceTree(InferenceTree inferenceTree, ArrayList<Rule> listAllRule){
		ArrayList<String> listPrimaryEvent = new ArrayList<>();
		RuleController ruleController = new RuleController();
		ArrayList<String> listIdConclude = ruleController.getAllIdConclude(listAllRule);
		ArrayList<Rule> listRuleFromTree = new ArrayList<>();
		for(int i = 0; i < inferenceTree.getListLayerGroup().size(); i++){
			listRuleFromTree.addAll(inferenceTree.getListLayerGroup().get(i).getListRule());
		}
		for(int i = 0; i< listRuleFromTree.size(); i++){
			listPrimaryEvent.addAll(listRuleFromTree.get(i).getListIDHypothesis());
		}
		
		for(int i =0; i < listPrimaryEvent.size(); i++){
			if(listIdConclude.indexOf(listPrimaryEvent.get(i)) >= 0){
				listPrimaryEvent.remove(i);
				i--;
			}
		}
		return listPrimaryEvent;
	}
	
	//Check các sự kiện có nằm trong cây suy diễn không
	public boolean checkEventFromTree(ArrayList<String> listPrimaryEvent, ArrayList<String> listEvent){
		for(int i =0; i < listEvent.size(); i++){
			if(listEvent.indexOf(listPrimaryEvent.get(i)) < 0){
				return false;
			}
		}
		return true;
	}
}
