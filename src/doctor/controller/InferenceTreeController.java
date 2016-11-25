package doctor.controller;

import java.util.ArrayList;

import doctor.model.Event;
import doctor.model.EventLayer;
import doctor.model.InferenceTree;
import doctor.model.LayerDeductionGroup;
import doctor.model.Rule;

public class InferenceTreeController {

	private LayerController layerController;

	public InferenceTreeController() {
		super();
		this.layerController = new LayerController();
	}

	// Từ một luật và các sự kiện, lấy ra độ tin tưởng cao nhất với sự kiện đó.
	public double getCertainFactor(Rule rule, ArrayList<Event> listEvent, ArrayList<Rule> listAllRule) {
		InferenceTree inferenceTree = layerController.stratifyEventFromRule(listAllRule, rule);
		ArrayList<InferenceTree> listInferenceTree = layerController.dividedAllTree(inferenceTree);
		ArrayList<Double> listCertain = new ArrayList<>();
		for(int i =0; i< listInferenceTree.size(); i++){
			double certain = getCertainFactorFromOneTree(listInferenceTree.get(i), listEvent, listAllRule);
			listCertain.add(certain);
		}
		return getMax(listCertain);
	}
	// Từ một sự kiện kết luận và các sự kiện người dùng nhập vào, lấy ra độ tin tưởng cao nhất với sự kiện đó
	public double getCertainFactorFromIdConclude(String id, ArrayList<Event> listEvent, ArrayList<Rule> listAllRule) {
		InferenceTree inferenceTree = layerController.stratifyEventFromID(listAllRule, id);
		ArrayList<InferenceTree> listInferenceTree = layerController.dividedAllTree(inferenceTree);
		ArrayList<Double> listCertain = new ArrayList<>();
		for(int i =0; i< listInferenceTree.size(); i++){
			double certain = getCertainFactorFromOneTree(listInferenceTree.get(i), listEvent, listAllRule);
			listCertain.add(certain);
		}
		return getMax(listCertain);
	}
	
	// Lấy ra độ chắc chắn lớn nhất khi có nhiều cây suy diễn
	public double getMax(ArrayList<Double> listCertain){
		double max = 0;
		for(int i =0; i < listCertain.size(); i++){
			if(max < listCertain.get(i)){
				max= listCertain.get(i);
			}
		}
		return max;
	}

	// Từ một cây suy diễn và một tập sự kiên, lấy ra độ tin cậy tương ứng
	public double getCertainFactorFromOneTree(InferenceTree inferenceTree, ArrayList<Event> listEvent,
			ArrayList<Rule> listAllRule) {
		double certain = 0;

		ArrayList<Event> listIDPrimaryFromTree = getListPrimaryEventFromInferenceTree(inferenceTree, listAllRule);
		ArrayList<LayerDeductionGroup> listRuleLayerFromTree = inferenceTree.getListLayerGroup();
		boolean check = checkEventFromTree(listIDPrimaryFromTree, listEvent);
		if (check == false) {
			return 0;
		}

		ArrayList<EventLayer> listLayerEvent = stratifyEventFromTree(inferenceTree);
		for (int i = 0; i < listLayerEvent.size(); i++) {
			EventLayer eventLayer = listLayerEvent.get(i);
			addCertainEvent(eventLayer, listEvent);
		}

		int lastEventLayer = listLayerEvent.size() - 1;
		int maxEventLayer = listLayerEvent.get(lastEventLayer).getNumberLayer();

		int lastRuleLayer = listRuleLayerFromTree.size() - 1;
		int maxRuleLayer = listRuleLayerFromTree.get(lastRuleLayer).getNumLayer();
		if ((maxEventLayer - maxRuleLayer) != 1) {
			System.out.println("False");
		}

		while (maxRuleLayer >= 0) {
			CalCertainHigerLayer(listLayerEvent.get(maxEventLayer-1), listLayerEvent.get(maxEventLayer),
					listRuleLayerFromTree.get(maxRuleLayer));
			maxEventLayer--;
			maxRuleLayer--;
		}

//		for (int i = 0; i < listLayerEvent.size(); i++) {
//			listLayerEvent.get(i).display();
//		}

		certain = listLayerEvent.get(0).getListLayerEvent().get(0).getCertainFactor();
		return certain;
	}

	// Từ các sự kiện của tầng dưới, các luật của tầng, tính ra độ tin cậy của
	// các sự kiện ở tầng trên;
	public void CalCertainHigerLayer(EventLayer eventLayerHigh, EventLayer eventLayerLow,
			LayerDeductionGroup layerDeductionGroup) {
//		eventLayerLow.getListLayerEvent();
//		ArrayList<Event> listEventHigh = eventLayerHigh.getListLayerEvent();
		ArrayList<Rule> listRule = layerDeductionGroup.getListRule();
		for (int i = 0; i < listRule.size(); i++) {
			ArrayList<String> listHypothesis = listRule.get(i).getListIDHypothesis();
			double[] listCertain = new double[listHypothesis.size()];
			String idConclude = listRule.get(i).getIdConclude();
			double concludeCertain;
			for (int j = 0; j < listHypothesis.size(); j++) {
				String id = listHypothesis.get(j);
				listCertain[j] = getCertainById(id, eventLayerLow.getListLayerEvent());
			}
			double certainHypothesis = getMin(listCertain);
			// Sự kiện bằng độ tin cậy của giả thiết nhân với độ tin cậy của
			// luật
			concludeCertain = certainHypothesis * listRule.get(i).getCertainFactor();
			concludeCertain = (double)Math.round(concludeCertain*100)/100;
			addCertainById(idConclude, eventLayerHigh.getListLayerEvent(), concludeCertain);
		}
	}

	// Tìm giá trị nhỏ nhất trong một mẳng, ứng dụng khi có luật AND, ta phải
	// tìm ra sự kiện có độ chắc chắn nhỏ nhất
	public double getMin(double[] listEventCertain) {
		double min =1 ;
		if (listEventCertain.length > 0) {
			min = listEventCertain[0];
		}
		for (int i = 1; i < listEventCertain.length; i++) {
			if (listEventCertain[i] < min) {
				min = listEventCertain[i];
			}
		}
		return min;

	}

	// Thêm độ chắc chắn cho sự kiện với id đã biết trong một tập các sự kiện.
	public void addCertainById(String id, ArrayList<Event> listEvent, double certain) {
		for (int i = 0; i < listEvent.size(); i++) {
			if (listEvent.get(i).getID().equals(id)) {
				listEvent.get(i).setCertainFactor(certain);
			}
		}
	}

	// Thêm độ chắc chắn cho sự kiện event trong cây suy diễn
	public void addCertainEvent(EventLayer eventLayer, ArrayList<Event> listEvent) {
		for (int i = 0; i < eventLayer.getListLayerEvent().size(); i++) {
			String id = eventLayer.getListLayerEvent().get(i).getID();
			double certain = getCertainById(id, listEvent);
			eventLayer.getListLayerEvent().get(i).setCertainFactor(certain);
		}
	}

	// Lấy độ chắc chắn của một sự kiện bằng id của nó.
	public double getCertainById(String id, ArrayList<Event> listEvent) {
		for (int i = 0; i < listEvent.size(); i++) {
			if (listEvent.get(i).getID().equals(id)) {
				return listEvent.get(i).getCertainFactor();
			}
		}
		return 0;
	}

	// Phân tầng sự kiện cho cây suy diễn
	public ArrayList<EventLayer> stratifyEventFromTree(InferenceTree inferenceTree) {
		ArrayList<EventLayer> listEventLayer = new ArrayList<>();
		RuleController ruleController = new RuleController();
		ArrayList<LayerDeductionGroup> listLayerRule = inferenceTree.getListLayerGroup();
		LayerDeductionGroup ldgRoot = listLayerRule.get(0);
		String IDRoot = ldgRoot.getListRule().get(0).getIdConclude();
		Event evRoot = new Event(IDRoot);
		ArrayList<Event> listEventRoot = new ArrayList<>();
		listEventRoot.add(evRoot);
		EventLayer evlRoot = new EventLayer(0, listEventRoot);
		listEventLayer.add(evlRoot);
		for (int i = 0; i < listLayerRule.size(); i++) {
			int numberLayer = i + 1;
			ArrayList<Event> listEventThisLayer = new ArrayList<>();
			ArrayList<Rule> listRuleForThisLayer = listLayerRule.get(i).getListRule();
			ArrayList<String> listIDForThisLayer = ruleController.getListHypothesis(listRuleForThisLayer);

			for (int j = 0; j < listIDForThisLayer.size(); j++) {
				String id = listIDForThisLayer.get(j);
				// System.out.println(id);
				Event evThisLayer = new Event(id);
				listEventThisLayer.add(evThisLayer);
			}
			EventLayer evlThisLayer = new EventLayer(numberLayer, listEventThisLayer);
			listEventLayer.add(evlThisLayer);
		}
		return listEventLayer;
	}

	// Từ một cây, get các sự kiện không phải là sự kiện kết luận của bất kỳ
	// luật nào, đây chính là các sự kiện sơ cấp từ.
	public ArrayList<Event> getListPrimaryEventFromInferenceTree(InferenceTree inferenceTree,
			ArrayList<Rule> listAllRule) {
		ArrayList<Event> listPrimaryEvent = new ArrayList<>();
		RuleController ruleController = new RuleController();
		ArrayList<String> listIdConclude = ruleController.getAllIdConclude(listAllRule);
		ArrayList<Rule> listRuleFromTree = new ArrayList<>();
		for (int i = 0; i < inferenceTree.getListLayerGroup().size(); i++) {
			listRuleFromTree.addAll(inferenceTree.getListLayerGroup().get(i).getListRule());
		}
		for (int i = 0; i < listRuleFromTree.size(); i++) {
			ArrayList<String> listId = listRuleFromTree.get(i).getListIDHypothesis();
			for (int j = 0; j < listId.size(); j++) {
				Event ev = new Event(listId.get(j));
				listPrimaryEvent.add(ev);
			}
		}

		for (int i = 0; i < listPrimaryEvent.size(); i++) {
			if (listIdConclude.indexOf(listPrimaryEvent.get(i).getID()) >= 0) {
				listPrimaryEvent.remove(i);
				i--;
			}
		}
		return listPrimaryEvent;
	}

	// Check các sự kiện có nằm trong cây suy diễn không
	public boolean checkEventFromTree(ArrayList<Event> listPrimaryEvent, ArrayList<Event> listEvent) {
		ArrayList<String> listIdEvent = new ArrayList<>();
		for (int i = 0; i < listEvent.size(); i++) {
			listIdEvent.add(listEvent.get(i).getID());
		}

		ArrayList<String> listIdPrimary = new ArrayList<>();
		for (int i = 0; i < listPrimaryEvent.size(); i++) {
			listIdPrimary.add(listPrimaryEvent.get(i).getID());
		}
		for (int i = 0; i < listIdPrimary.size(); i++) {
			if (listIdEvent.indexOf(listIdPrimary.get(i)) < 0) {
//				System.out.println(listIdPrimary.get(i));
				return false;
			}
		}
		return true;
	}
}
