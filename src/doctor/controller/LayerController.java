package doctor.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import doctor.model.InferenceTree;
import doctor.model.LayerDeductionGroup;
import doctor.model.Rule;

public class LayerController {

	RuleController ruleController;

	public LayerController() {
		super();
		ruleController = new RuleController();
	}

	// Phân tầng cho các luật, tầng 0 là gốc, cây suy diễn sẽ suy diễn lùi về
	// là, mỗi lần tăng số thứ tự tầng thêm 1.
	public InferenceTree stratifyEventFromRule(ArrayList<String> listIDConclude, ArrayList<Rule> listAllRule,
			Rule rule) {
		// ArrayList<LayerDeductionGroup> listLayerDeductionGroup = new
		// ArrayList<>();
		InferenceTree inferenceTree = new InferenceTree();
		int numLayer = 0;
		int number_remember = 0;
		ArrayList<Rule> myListRule = new ArrayList<>(Arrays.asList(rule));
		LayerDeductionGroup layerDeductionRoot = new LayerDeductionGroup(numLayer, myListRule);
		inferenceTree.getListLayerGroup().add(layerDeductionRoot);
		boolean flag = true;
		while (flag) {
			ArrayList<String> myListIdConclude = new ArrayList<>();
			// lấy tất cả các sự kiện ở phần giả thiết mà chúng là kết luận của
			// một luật nào đó trong cơ sở tri thức
			for (int i = 0; i < myListRule.size(); i++) {
				Rule rule_tmp = myListRule.get(i);
				ArrayList<String> listIDHypothesis = rule_tmp.getListIDHypothesis();
				// danh sách các sự kiện là kết luận của một luật nào đó.
				ArrayList<String> listConclude = ruleController.getIdConclude(listIDConclude, listIDHypothesis);
				for (int j = 0; j < listConclude.size(); j++) {
					if (myListIdConclude.indexOf(listConclude.get(j)) < 0) {
						myListIdConclude.add(listConclude.get(j));
					}
				}
			}
			if (myListIdConclude.size() != 0) {
				numLayer = number_remember + 1;
				myListRule = AddRuleInLayer(inferenceTree, myListIdConclude, listAllRule, numLayer);
			}

			// Nếu số tầng không tăng lên thì hoàn thành phân tầng.
			if (numLayer == number_remember) {
				flag = false;
				break;
			} else {
				number_remember += 1;
			}
		}

		return inferenceTree;
	}

	// Cho vào danh sách các sự kiên kết luận của tầng này , số thứ tự của tầng
	// này, thêm các luật có
	// kết luận là các sự kiện trong danh sách sự kiện kết luận của tầng vào
	// danh sách phân tầng
	public ArrayList<Rule> AddRuleInLayer(InferenceTree inferenceTree, ArrayList<String> listConclude,
			ArrayList<Rule> listAllRule, int numLayer) {
		ArrayList<Rule> myNewListRule = new ArrayList<>();
		LayerDeductionGroup layerDeductionGroup = new LayerDeductionGroup();
		layerDeductionGroup.setNumLayer(numLayer);
		// j: các sự kiện là kết luận của luật nào đó.
		// k: các luật có kết luận là luật này.
		for (int j = 0; j < listConclude.size(); j++) {
			String idConclude = listConclude.get(j);
			ArrayList<Rule> myListLayerRule = ruleController.getRulesFromConclude(listAllRule, idConclude);
			for (int k = 0; k < myListLayerRule.size(); k++) {
				if (myNewListRule.indexOf(myListLayerRule.get(k)) < 0) {
					myNewListRule.add(myListLayerRule.get(k));
				}
			}
		}

		layerDeductionGroup.setListRule(myNewListRule);
		inferenceTree.getListLayerGroup().add(layerDeductionGroup);

		return myNewListRule;
	}

	// loại bỏ các luật dư thừa trong cùng một tầng.
	// Cho vào 2 tập luật, nêu tập luật phía dưới có luật nào mà sự kiện kết
	// luận không nằm trong tập các sự kiện giả thiết ở tập trên thì bị loại bỏ
	public ArrayList<Rule> deleteExcessRule(ArrayList<Rule> listHigher, ArrayList<Rule> listLower) {
		ArrayList<String> listHypothesisHigher = ruleController.getListHypothesis(listHigher);
		ArrayList<Rule> listRuleRemove = new ArrayList<>();
		for (int i = 0; i < listLower.size(); i++) {
			Rule rule = listLower.get(i);
			if (listHypothesisHigher.indexOf(rule.getIdConclude()) < 0) {
				Rule rule_tmp = listLower.remove(listLower.indexOf(rule));
				listRuleRemove.add(rule_tmp);
				i--;
			}
		}
		return listRuleRemove;
	}

	// loại bỏ các luật dư thừa trong một cây suy diễn
	// cho một cây suy diễn, loại bỏ các sự kiện dư thừa, bắt đầu gốc, xuống
	// từng tầng và loại bỏ theo giải thuật phía trên
	public ArrayList<LayerDeductionGroup> deleteExcessRuleTree(InferenceTree deductiveTree) {
		Collections.sort(deductiveTree.getListLayerGroup());
		ArrayList<LayerDeductionGroup> listLayerRuleRemove = new ArrayList<>();
		int lastIndex = deductiveTree.getListLayerGroup().size() - 1;

		int maxLayer = deductiveTree.getListLayerGroup().get(lastIndex).getNumLayer();
		// System.out.println("Tang cao nhat: " + maxLayer);
		int currentLayer = 0;
		while (currentLayer < maxLayer) {
			ArrayList<Rule> listHigher = deductiveTree.getListLayerGroup().get(currentLayer).getListRule();
			ArrayList<Rule> listLower = deductiveTree.getListLayerGroup().get(currentLayer + 1).getListRule();
			ArrayList<Rule> listRemoveRule = deleteExcessRule(listHigher, listLower);
			currentLayer++;
			LayerDeductionGroup lds = new LayerDeductionGroup(currentLayer, listRemoveRule);
			listLayerRuleRemove.add(lds);
		}
		return listLayerRuleRemove;
	}

	// tách một cây suy diễn thành nhiều cây suy diễn (khi có các luật cùng
	// chung kết luận tại một tầng) và loại bỏ dư thừa trên các cây con.
	public ArrayList<InferenceTree> divideAndEditRuleTree(InferenceTree ruleTree, int numberLayer) {
		ArrayList<InferenceTree> listTree = new ArrayList<>();
		LayerDeductionGroup lds = new LayerDeductionGroup();
		for (int i = 0; i < ruleTree.getListLayerGroup().size(); i++) {
			if (ruleTree.getListLayerGroup().get(i).getNumLayer() == numberLayer) {
				lds = ruleTree.getListLayerGroup().get(i);
			}
		}
		ruleTree.getListLayerGroup().remove(lds);
		// ruleTree.display();

		// Chia nhóm các luật khi có nhiều luật chung kết luận
		ArrayList<ArrayList<Rule>> newListLayerRule = ruleController
				.divideRuleGroupWhenHaveSameIdConclude(lds.getListRule());

		ArrayList<LayerDeductionGroup> listLayerRuleRemove = new ArrayList<>();

		for (int i = 0; i < newListLayerRule.size(); i++) {

			ArrayList<LayerDeductionGroup> listLds = new ArrayList<>();
			listLds.addAll(ruleTree.getListLayerGroup());
			LayerDeductionGroup addLds = new LayerDeductionGroup(numberLayer, newListLayerRule.get(i));
			listLds.add(addLds);
			Collections.sort(listLds);
			mergeArrayList(listLds, listLayerRuleRemove);
			InferenceTree tree_tmp = new InferenceTree(listLds);
			// tree_tmp.display();
//			System.out.println("-------------------");

			listLayerRuleRemove = deleteExcessRuleTree(tree_tmp);
			tree_tmp.setListLayerGroup(listLds);
			listTree.add(tree_tmp);
			tree_tmp.display();

		}

		return listTree;
	}

	//Trộn 2 arrayList
	public void mergeArrayList(ArrayList<LayerDeductionGroup> listReturn, ArrayList<LayerDeductionGroup> listAdd) {
		if (listAdd.size() == 0) {
			return;
		}
		int maxLayer = listAdd.get(listAdd.size() - 1).getNumLayer();
		// System.out.println("Max Layer: " + maxLayer);
		int minLayer = listAdd.get(0).getNumLayer();
		while (minLayer <= maxLayer) {
			// LayerDeductionGroup ldgReturn = listReturn.get(minLayer);
			LayerDeductionGroup ldgAdd = new LayerDeductionGroup();
			for (int i = 0; i < listAdd.size(); i++) {
				LayerDeductionGroup lds = listAdd.get(i);
				if (lds.getNumLayer() == minLayer) {
					ldgAdd = lds;
					break;
				}
			}
			for (int i = 0; i < ldgAdd.getListRule().size(); i++) {
				if (listReturn.get(minLayer).getListRule().indexOf(ldgAdd.getListRule().get(i)) < 0) {
					listReturn.get(minLayer).getListRule().add(ldgAdd.getListRule().get(i));
				}
			}
			minLayer++;

		}

	}
	
	public ArrayList<InferenceTree> dividedAllTree(InferenceTree inferenceTree){
		ArrayList<InferenceTree> listInferenceTree = new ArrayList<>();
		
		
		return listInferenceTree;
	}

}
