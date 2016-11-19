package doctor.controller;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import doctor.model.LayerDeduction;
import doctor.model.LayerDeductionGroup;
import doctor.model.Rule;

public class BacSiTuVan {
	public static void main(String[] args) {
		String id1 = "1101";// Tuổi < 12 (Trẻ em)
		String id2 = "1102";// Tuổi >=12 (Người lớn)
		String id3 = "1111";// Nam
		String id4 = "1112";// Nữ
		String id5 = "1201";// Nhiệt độ từ 36,5 C đến 37,5 C
		String id6 = "1202";// Nhiệt độ từ 37 C đến 39 C
		String id7 = "1203";// Nhiệt độ từ 39 C đến 40 C
		String id8 = "1204";// Nhiệt độ > 40 C
		String id9 = "1301";// Nhỏ < 65 lần/ phút (chậm)
		String id10 = "1302";// Từ 65 đến 80 lần/phút (bình thường)
		String id11 = "1303";// > 80 lần/phút (nhanh)
		String id12 = "1401";// Ho thường
		String id13 = "1402";// Ho khan
		String id14 = "1403";// Ho đờm
		String id15 = "1404";// Chảy mũi
		String id16 = "1405";// Đau đầu
		String id17 = "1406";// Buồn nôn
		String id18 = "1407";// Ói mửa
		String id19 = "1408";// Tức ngực
		String id20 = "1409";// Tiêu chảy
		String id21 = "1410";// Hắt hơi
		String id22 = "1411";// Rối loạn ý thức
		String id23 = "1412";// Phát ban
		String id24 = "1413";// Chảy máu dưới da
		String id25 = "1414";// Chảy máu chân răng
		String id26 = "1415";// Đau họng
		String id27 = "1416";// Chảy máu mũi
		String id28 = "1417";// Sưng hạch
		String id29 = "2101";// Bệnh nhân bị cúm A H1N1
		String id30 = "2102";// Bệnh nhân bị cúm A H3N2
		String id31 = "2103";// Bệnh nhân bị cúm A H5N1
		String id32 = "2104";// Bệnh nhân bị cúm B
		String id33 = "2105";// Bệnh nhân bị cảm lạnh
		String id34 = "2106";// Bệnh nhân bị cảm nóng
		String id35 = "2107";// Bệnh nhân bị sốt phát ban
		String id36 = "2108";// Bệnh nhân bị sốt siêu vi
		String id37 = "2109";// Bệnh nhân bị sốt xuất huyết

		String id38 = "1205";// Không sốt
		String id39 = "1206";// Sốt nhẹ
		String id40 = "1207";// Sốt vừa
		String id41 = "1208";// Sốt cao

		ArrayList<String> listID1 = new ArrayList<>(Arrays.asList(id1, id2, id3, id4));
		ArrayList<String> listID2 = new ArrayList<>(Arrays.asList(id5, id6, id7));
		ArrayList<String> listID3 = new ArrayList<>(Arrays.asList(id6, id8, id9));
		ArrayList<String> listID4 = new ArrayList<>(Arrays.asList(id10, id11));
		ArrayList<String> listID5 = new ArrayList<>(Arrays.asList(id12, id13));
		ArrayList<String> listID7 = new ArrayList<>(Arrays.asList(id14, id15));
		ArrayList<String> listID8 = new ArrayList<>(Arrays.asList(id16, id17));
		ArrayList<String> listID9 = new ArrayList<>(Arrays.asList(id18, id19));
		ArrayList<String> listID10 = new ArrayList<>(Arrays.asList(id20, id21));

		Rule rule1 = new Rule("r1", id29, listID1, 0.6);
		Rule rule2 = new Rule("r2", id2, listID2, 0.7);
		Rule rule3 = new Rule("r3", id3, listID3, 0.7);
		Rule rule4 = new Rule("r4", id6, listID4, 0.8);
		Rule rule5 = new Rule("r5", id6, listID5, 0.6);
		Rule rule6 = new Rule("r6", id30, listID5, 0.6);
		Rule rule7 = new Rule("r7", id11, listID7, 0.6);
		Rule rule8 = new Rule("r8", id12, listID8, 0.6);
		Rule rule9 = new Rule("r9", id13, listID9, 0.6);
		Rule rule10 = new Rule("r10", id11, listID10, 0.6);

		ArrayList<Rule> listAllRule = new ArrayList<>(
				Arrays.asList(rule1, rule2, rule3, rule4, rule5, rule6, rule7, rule8, rule9));
		// String idConclude = "2101";
		// ArrayList<Rule> myListRule = getRulesFromConclude(listRule,
		// idConclude);
		// System.out.println(myListRule.size());

		ArrayList<String> listIDConclude = new ArrayList<>(Arrays.asList(id29, id2, id3, id6, id30, id11, id12, id13));
		ArrayList<LayerDeduction> listLayerDeduction = stratifyEventFromRule(listIDConclude, listAllRule, rule1);
		// System.out.println("Test danh sach lay ra: " +
		// listLayerDeduction.size());
		// for (int i = 0; i < listLayerDeduction.size(); i++) {
		// LayerDeduction ld = listLayerDeduction.get(i);
		// System.out.println("Number Layer: " + ld.getNumLayer());
		//
		// Rule rule = ld.getRule();
		// System.out.println("Rule: " + rule.getIdRule());
		//
		// }

		ArrayList<LayerDeductionGroup> listLDS = getGroupRuleForLayer(listLayerDeduction);
		// for (int i = 0; i < listLDS.size(); i++) {
		// LayerDeductionGroup lds = listLDS.get(i);
		// System.out.println("Layer: " + lds.getNumLayer());
		// for (int j = 0; j < lds.getListRule().size(); j++) {
		// System.out.println(lds.getListRule().get(j).getIdRule());
		// }
		// }

		// System.out.println(listTree.size());
		// for(int j = 0; j<listTree.size(); j++){
		// System.out.println("Tree: " + j);
		// ArrayList<LayerDeductionGroup> subTree = listTree.get(j);
		//// System.out.println("Size This Layer Is: " + subTree.size());
		// for (int i = 0; i < subTree.size(); i++) {
		// LayerDeductionGroup lds = subTree.get(i);
		// System.out.println("Layer: " + lds.getNumLayer());
		// for (int k = 0; k < lds.getListRule().size(); k++) {
		//// System.out.println( "Size of this listRule: " +
		// lds.getListRule().size());
		// System.out.println(lds.getListRule().get(k).getIdRule());
		// }
		// }
		// }

		// Collections.sort(listLDS);
		// System.out.println("After sort: ");
		//
		// for (int i = 0; i < listLDS.size(); i++) {
		// LayerDeductionGroup lds = listLDS.get(i);
		//
		// System.out.println("Layer: " + lds.getNumLayer());
		// for (int j = 0; j < lds.getListRule().size(); j++) {
		// System.out.println(lds.getListRule().get(j).getIdRule());
		//
		// }
		// }

		// for(int i =0; i < listAllRule.size(); i++){
		// System.out.println(listAllRule.get(i).getIdConclude());
		// }
		//
		// System.out.println("Sort");
		// Collections.sort(listAllRule);
		// for(int i =0; i < listAllRule.size(); i++){
		// System.out.println(listAllRule.get(i).getIdConclude());
		// }

		// ArrayList<Rule> listMyRule = getRuleHaveSameConclude(listAllRule);
		// System.out.println(listMyRule.size());
		// for(int i =0; i< listMyRule.size(); i++){
		// System.out.println(listMyRule.get(i).getIdRule());
		// }

//		ArrayList<ArrayList<Rule>> listMyRule = divideRuleGroupWhenHaveSameIdConclude(listAllRule);
//		for (int i = 0; i < listMyRule.size(); i++) {
//			ArrayList<Rule> ListRule = listMyRule.get(i);
//			System.out.println("Nhom " + i);
//			for (int j = 0; j < ListRule.size(); j++) {
//				System.out.println(ListRule.get(j).getIdRule());
//			}
//		}
		//
		// ArrayList<Rule> listTest = new ArrayList<>(Arrays.asList(rule1,
		// rule2, rule3, rule4));
		//
		// ArrayList<String> listHypothesis = getListHypothesis(listTest);
		// for(int i = 0; i< listHypothesis.size(); i++){
		// System.out.println(listHypothesis.get(i));
		// }

		// ArrayList<Rule> listHigher = new ArrayList<>(Arrays.asList(rule4));
		// ArrayList<Rule> listLower = new ArrayList<>(Arrays.asList(rule7,
		// rule8, rule9, rule10));
		// deleteExcessRule(listHigher, listLower);
		// for(int i =0; i < listLower.size(); i++){
		// System.out.println(listLower.get(i).getIdRule());
		// }

		// ArrayList<Rule> listRule1 = new ArrayList<>(Arrays.asList(rule1));
		// ArrayList<Rule> listRule2 = new ArrayList<>(Arrays.asList(rule2,
		// rule3));
		// ArrayList<Rule> listRule3 = new ArrayList<>(Arrays.asList(rule4));
		// ArrayList<Rule> listRule4 = new ArrayList<>(Arrays.asList(rule7,
		// rule8, rule9));
		// LayerDeductionGroup lds1 = new LayerDeductionGroup(0, listRule1);
		// LayerDeductionGroup lds2 = new LayerDeductionGroup(1, listRule2);
		// LayerDeductionGroup lds3 = new LayerDeductionGroup(2, listRule3);
		// LayerDeductionGroup lds4 = new LayerDeductionGroup(3, listRule4);
		// ArrayList<LayerDeductionGroup> deductivetree = new
		// ArrayList<>(Arrays.asList(lds1, lds2, lds3, lds4));
		// deleteExcessRuleTree(deductivetree);
		//
		// for (int i = 0; i < deductivetree.size(); i++) {
		// LayerDeductionGroup lds = deductivetree.get(i);
		//
		// System.out.println("Layer: " + lds.getNumLayer());
		// for (int j = 0; j < lds.getListRule().size(); j++) {
		// System.out.println(lds.getListRule().get(j).getIdRule());
		//
		// }
		// }

		ArrayList<ArrayList<LayerDeductionGroup>> listTree = divideRuleTreeWhenSameConcludeLayer(listLDS, 2);

	}

	public static ArrayList<ArrayList<LayerDeductionGroup>> divideRuleTreeWhenSameConcludeLayer(
			ArrayList<LayerDeductionGroup> ruleTree, int numberLayer) {
		ArrayList<ArrayList<LayerDeductionGroup>> listTree = new ArrayList<>();
		LayerDeductionGroup lds = new LayerDeductionGroup();
		for (int i = 0; i < ruleTree.size(); i++) {
			if (ruleTree.get(i).getNumLayer() == numberLayer) {
				lds = ruleTree.get(i);
			}
		}
		ruleTree.remove(lds);
		ArrayList<ArrayList<Rule>> newListLayerRule = divideRuleGroupWhenHaveSameIdConclude(lds.getListRule());
		for (int i = 0; i < newListLayerRule.size(); i++) {
			ArrayList<LayerDeductionGroup> tree_tmp = new ArrayList<>();
			for(int j = 0; j< ruleTree.size(); j++){
				tree_tmp.add(ruleTree.get(j));
			}
			LayerDeductionGroup addLds = new LayerDeductionGroup(numberLayer, newListLayerRule.get(i));
			tree_tmp.add(addLds);
			listTree.add(tree_tmp);
		}
		
		for(int i =0; i < listTree.size(); i++){
			ArrayList<LayerDeductionGroup> tree_element = listTree.get(i);
			System.out.println("--------------");
			deleteExcessRuleTree(tree_element);
			display(tree_element);
		}

		return listTree;
	}

	// loại bỏ các luật dư thừa trong một cây suy diễn
	public static void deleteExcessRuleTree(ArrayList<LayerDeductionGroup> deductiveTree) {
		Collections.sort(deductiveTree);
		int maxLayer = deductiveTree.get(deductiveTree.size() - 1).getNumLayer();
//		System.out.println("Tang cao nhat: " + maxLayer);
		int currentLayer = 0;
		while (currentLayer < maxLayer) {
			ArrayList<Rule> listHigher = deductiveTree.get(currentLayer).getListRule();
			ArrayList<Rule> listLower = deductiveTree.get(currentLayer + 1).getListRule();
			deleteExcessRule(listHigher, listLower);
			currentLayer++;
		}

	}
	// loại bỏ các luật dư thừa trong cùng một tầng.
		public static void deleteExcessRule(ArrayList<Rule> listHigher, ArrayList<Rule> listLower) {
			ArrayList<String> listHypothesisHigher = getListHypothesis(listHigher);
			for (int i = 0; i < listLower.size(); i++) {
				Rule rule = listLower.get(i);
				if (listHypothesisHigher.indexOf(rule.getIdConclude()) < 0) {
					listLower.remove(listLower.indexOf(rule));
					i--;
				}
			}
		}


	

	// Nhóm các luật cùng 1 tầng vào một arrayList
	public static ArrayList<LayerDeductionGroup> getGroupRuleForLayer(ArrayList<LayerDeduction> listLayerDeduction) {
		ArrayList<LayerDeductionGroup> listLayerDeductionGroup = new ArrayList<>();
		LayerDeduction ld = listLayerDeduction.get(listLayerDeduction.size() - 1);
		int maxNum = ld.getNumLayer();
		int currentLayer = 0;
		int length = listLayerDeduction.size();
		while (currentLayer <= maxNum) {
			ArrayList<Rule> listRule = new ArrayList<>();
			for (int i = 0; i < length; i++) {
				if (listLayerDeduction.get(i).getNumLayer() == currentLayer) {
					listRule.add(listLayerDeduction.get(i).getRule());
				}
			}
			LayerDeductionGroup ldg = new LayerDeductionGroup(currentLayer, listRule);
			listLayerDeductionGroup.add(ldg);
			currentLayer++;
		}
		return listLayerDeductionGroup;

	}

	
	//Hiển thị cây suy diễn
	public static void display(ArrayList<LayerDeductionGroup> tree) {
		for (int i = 0; i < tree.size(); i++) {
			LayerDeductionGroup lds = tree.get(i);
			System.out.print("Layer " + lds.getNumLayer() + ": ");
			for (int j = 0; j < lds.getListRule().size(); j++) {
				System.out.print(lds.getListRule().get(j).getIdRule());
			}
			System.out.println();
		}
	}

	// public static void devideRuleTree(ArrayList<LayerDeductionGroup>
	// deductiveTree) {
	// ArrayList<ArrayList<LayerDeductionGroup>> listTree = new
	// ArrayList<>(Arrays.asList(deductiveTree));
	// deleteExcessRuleTree(deductiveTree);
	// int numberTree = listTree.size();
	//
	// boolean flag = true;
	// while (flag) {
	// for (int i = 0; i < listTree.size(); i++) {
	// ArrayList<LayerDeductionGroup> lds = listTree.get(i);
	// deleteExcessRuleTree(lds);
	//
	// }
	// }
	//
	// }

	
	

	// Phân tầng cho các luật, tầng 0 là gốc, cây suy diễn sẽ suy diễn lùi về
	// là, mỗi lần tăng số thứ tự tầng thêm 1.
	public static ArrayList<LayerDeduction> stratifyEventFromRule(ArrayList<String> listIDConclude,
			ArrayList<Rule> listAllRule, Rule rule) {
		ArrayList<LayerDeduction> listLayerDeduction = new ArrayList<>();
		int numLayer = 0;
		int number_remember = 0;
		ArrayList<Rule> myListRule = new ArrayList<>(Arrays.asList(rule));
		LayerDeduction layerDeduction = new LayerDeduction(numLayer, rule);
		listLayerDeduction.add(layerDeduction);
		boolean flag = true;
		while (flag) {
			ArrayList<String> myListIdConclude = new ArrayList<>();
			for (int i = 0; i < myListRule.size(); i++) {
				Rule rule_tmp = myListRule.get(i);
				ArrayList<String> listIDHypothesis = rule_tmp.getListIDHypothesis();
				// danh sách các sự kiện là kết luận của một luật nào đó.
				ArrayList<String> listConclude = getIdConclude(listIDConclude, listIDHypothesis);
				for (int j = 0; j < listConclude.size(); j++) {
					if (myListIdConclude.indexOf(listConclude.get(j)) < 0) {
						myListIdConclude.add(listConclude.get(j));
					}
				}

			}
			if (myListIdConclude.size() != 0) {
				numLayer = number_remember + 1;
				myListRule = AddRuleInLayer(listLayerDeduction, myListIdConclude, listAllRule, numLayer);
			}

			// Nếu số tầng không tăng lên thì hoàn thành phân tầng.
			if (numLayer == number_remember) {
				flag = false;
				break;
			} else {
				number_remember += 1;
			}
		}

		return listLayerDeduction;
	}

	// Cho vào danh sách các sự kiên kết luận, số thứ tầng, thêm các luật có kết
	// luận là các sự kiện trong danh sách vào danh sách phân tầng
	public static ArrayList<Rule> AddRuleInLayer(ArrayList<LayerDeduction> listLayerDeduction,
			ArrayList<String> listConclude, ArrayList<Rule> listAllRule, int numLayer) {
		ArrayList<Rule> myNewListRule = new ArrayList<>();
		// j: các sự kiện là kết luận của luật nào đó.
		// k: các luật có kết luận là luật này.
		for (int j = 0; j < listConclude.size(); j++) {
			String idConclude = listConclude.get(j);
			ArrayList<Rule> myListLayerRule = getRulesFromConclude(listAllRule, idConclude);
			for (int k = 0; k < myListLayerRule.size(); k++) {
				LayerDeduction myLayer = new LayerDeduction(numLayer, myListLayerRule.get(k));
				listLayerDeduction.add(myLayer);
				if (myNewListRule.indexOf(myListLayerRule.get(k)) < 0) {
					myNewListRule.add(myListLayerRule.get(k));
				}
			}
		}
		return myNewListRule;
	}
	
	// Từ 1 id của sự kiện, tính ra các luật có kết luận là sự kiện này
		public static ArrayList<Rule> getRulesFromConclude(ArrayList<Rule> listAllRule, String idConclude) {
			ArrayList<Rule> listConcludeRule = new ArrayList<>();
			int length = listAllRule.size();
			for (int i = 0; i < length; i++) {
				Rule rule = listAllRule.get(i);
				if (rule.getIdConclude() == idConclude && listConcludeRule.indexOf(rule) < 0) {
					listConcludeRule.add(rule);
				}
			}

			return listConcludeRule;
		}
	
	
	// get list all hypothesis of a list rule
		public static ArrayList<String> getListHypothesis(ArrayList<Rule> listRule) {
			ArrayList<String> listHypothesis = new ArrayList<>();
			for (int i = 0; i < listRule.size(); i++) {
				Rule rule = listRule.get(i);
				for (int j = 0; j < rule.getListIDHypothesis().size(); j++) {
					if (listHypothesis.indexOf(rule.getListIDHypothesis().get(j)) < 0) {
						listHypothesis.add(rule.getListIDHypothesis().get(j));
					}
				}
			}
			return listHypothesis;
		}

	// Cho vào 1 danh sách các sự kiện, đưa ra danh sách các sự kiện là kết luận
	// của 1 luật nào đó.
	public static ArrayList<String> getIdConclude(ArrayList<String> listIDConclude,
			ArrayList<String> listIDHypothesis) {
		ArrayList<String> listMyIdConclude = new ArrayList<>();
		for (int i = 0; i < listIDHypothesis.size(); i++) {
			String temp = listIDHypothesis.get(i);
			if (listIDConclude.indexOf(temp) >= 0 && listMyIdConclude.indexOf(temp) < 0) {
				listMyIdConclude.add(temp);
			}
		}
		return listMyIdConclude;
	}
	
	// Lấy các luật cùng chung kết luận ở cùng một tầng.
		public static ArrayList<Rule> getRuleHaveSameConclude(ArrayList<Rule> listRule) {
			Collections.sort(listRule);
			int length = listRule.size();
			for (int i = 0; i < length - 1; i++) {
				Rule rule = listRule.get(i);
				ArrayList<Rule> listSameConclude = new ArrayList<>(Arrays.asList(rule));
				for (int j = i + 1; j < length; j++) {
					Rule rule2 = listRule.get(j);
					if (rule2.getIdConclude() == rule.getIdConclude()) {
						listSameConclude.add(rule2);
						continue;
					} else {
						break;
					}
				}
				if (listSameConclude.size() > 1) {
					return listSameConclude;
				}
			}
			return new ArrayList<Rule>();
		}

		// Phân tách các nhóm luật cùng tầng khi có các luật cùng chung kết luận
		public static ArrayList<ArrayList<Rule>> divideRuleGroupWhenHaveSameIdConclude(ArrayList<Rule> listRule) {
			ArrayList<ArrayList<Rule>> myListGroupRule = new ArrayList<>();
			ArrayList<Rule> sameConclude = getRuleHaveSameConclude(listRule);
			for (int i = 0; i < sameConclude.size(); i++) {
				listRule.remove(sameConclude.get(i));
			}
			// System.out.println("ListRule after remove");
			// for (int j = 0; j < listRule.size(); j++) {
			// System.out.println(listRule.get(j).getIdRule());
			// }

			for (int i = 0; i < sameConclude.size(); i++) {
				ArrayList<Rule> listRule_temp = new ArrayList<>();
				for (int j = 0; j < listRule.size(); j++) {
					listRule_temp.add(listRule.get(j));
				}
				listRule_temp.add(sameConclude.get(i));
				myListGroupRule.add(listRule_temp);
			}

			return myListGroupRule;
		}
}
