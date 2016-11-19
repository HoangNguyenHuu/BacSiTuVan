package doctor.controller;

import java.util.ArrayList;
import java.util.Arrays;

import doctor.model.InferenceTree;
import doctor.model.LayerDeductionGroup;
//import doctor.model.LayerDeductionGroup;
import doctor.model.Rule;

public class TestDocTor {
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
//		String id29 = "2101";// Bệnh nhân bị cúm A H1N1
		String id30 = "2102";// Bệnh nhân bị cúm A H3N2
		


		ArrayList<String> listID1 = new ArrayList<>(Arrays.asList(id2, id3, id4, id5));
		ArrayList<String> listID2 = new ArrayList<>(Arrays.asList(id6, id7));
		ArrayList<String> listID3 = new ArrayList<>(Arrays.asList(id7, id8, id9));
		ArrayList<String> listID4 = new ArrayList<>(Arrays.asList(id10, id11));
		ArrayList<String> listID5 = new ArrayList<>(Arrays.asList(id12, id13));
		ArrayList<String> listID6 = new ArrayList<>(Arrays.asList(id14, id15));
		ArrayList<String> listID7 = new ArrayList<>(Arrays.asList(id16, id17));
		ArrayList<String> listID8 = new ArrayList<>(Arrays.asList(id18, id19));
		ArrayList<String> listID9 = new ArrayList<>(Arrays.asList(id20, id21));
		ArrayList<String> listID10 = new ArrayList<>(Arrays.asList(id20, id21));
		ArrayList<String> listID11 = new ArrayList<>(Arrays.asList(id22, id23));
		ArrayList<String> listID12 = new ArrayList<>(Arrays.asList(id24, id25));

		Rule rule1 = new Rule("r1", id1, listID1, 0.6);
		Rule rule2 = new Rule("r2", id3, listID2, 0.7);
		Rule rule3 = new Rule("r3", id4, listID3, 0.7);
		Rule rule4 = new Rule("r4", id7, listID4, 0.8);
		Rule rule5 = new Rule("r5", id7, listID5, 0.6);
		Rule rule6 = new Rule("r6", id11, listID6, 0.6);
		Rule rule7 = new Rule("r7", id11, listID7, 0.6);
		Rule rule8 = new Rule("r8", id12, listID8, 0.6);
		Rule rule9 = new Rule("r9", id13, listID9, 0.6);
		Rule rule10 = new Rule("r10", id30, listID10, 0.6);
		Rule rule11 = new Rule("r11", id8, listID11, 0.6);
		Rule rule12 = new Rule("r12", id8, listID12, 0.6);
		

		ArrayList<Rule> listAllRule = new ArrayList<>(
				Arrays.asList(rule1, rule2, rule3, rule4, rule5, rule6, rule7, rule8, rule9, rule10, rule11, rule12));;

		
		RuleController ruleController = new RuleController();
		ArrayList<String> listIDConclude = ruleController.getAllIdConclude(listAllRule);
		
		LayerController layerController= new LayerController();
		
		InferenceTree inferenceTree = layerController.stratifyEventFromRule(listAllRule, rule1);
		inferenceTree.display();
		
		InferenceTreeController inferenceTreeController = new InferenceTreeController();
		
		ArrayList<String> listPrimaryEvent = inferenceTreeController.getListPrimaryEventFromInferenceTree(inferenceTree, listAllRule);
		for(int i =0; i< listPrimaryEvent.size(); i++){
			System.out.println(listPrimaryEvent.get(i));
		}
		
		/*
		 * System.out.println("-------------------------------------------------------------");
		ArrayList<InferenceTree> listTree = layerController.dividedAllTree(inferenceTree);
		for(int i =0; i<listTree.size(); i++){
			listTree.get(i).display();
			System.out.println("-----------------------");
		}
		*/
		
		/*
		 * ArrayList<InferenceTree> testDivide = layerController.divideAndEditRuleTree(inferenceTree, 2);
		for(int i =0; i<testDivide.size(); i++){
			testDivide.get(i).display();
			System.out.println("-----------------------");
		}
		*/
		
//		ArrayList<InferenceTree> testDivide = layerController.dividedAllTreeLayer(inferenceTree, 2);
//		for(int i =0; i<testDivide.size(); i++){
//			testDivide.get(i).display();
//			System.out.println("-----------------------");
//		}
		
		
		/*
		ArrayList<Rule> listRule = ruleController.getRuleHaveSameConclude(inferenceTree.getListLayerGroup().get(3).getListRule());
		for(int i = 0; i < listRule.size(); i++){
			System.out.println(listRule.get(i).getIdRule());
		}*/
		
		/*ArrayList<ArrayList<Rule>> listMyRule = ruleController.divideRuleGroupWhenHaveSameIdConclude(listAllRule);
		for (int i = 0; i < listMyRule.size(); i++) {
			ArrayList<Rule> ListRule = listMyRule.get(i);
			System.out.println("Nhom " + i);
			for (int j = 0; j < ListRule.size(); j++) {
				System.out.println(ListRule.get(j).getIdRule());
			}
		}*/
		
		/*
		 * ArrayList<Rule> listHigher = new ArrayList<>(Arrays.asList(rule4));
		ArrayList<Rule> listLower = new ArrayList<>(Arrays.asList(rule7, rule8, rule9, rule10));
		layerController.deleteExcessRule(listHigher, listLower);
		for (int i = 0; i < listLower.size(); i++) {
			System.out.println(listLower.get(i).getIdRule());
		}*/
		
		/*
		 * ArrayList<Rule> listRule1 = new ArrayList<>(Arrays.asList(rule1));
		ArrayList<Rule> listRule2 = new ArrayList<>(Arrays.asList(rule2, rule3));
		ArrayList<Rule> listRule3 = new ArrayList<>(Arrays.asList(rule4, rule10));
		ArrayList<Rule> listRule4 = new ArrayList<>(Arrays.asList(rule7, rule8, rule9));
		LayerDeductionGroup lds1 = new LayerDeductionGroup(0, listRule1);
		LayerDeductionGroup lds2 = new LayerDeductionGroup(1, listRule2);
		LayerDeductionGroup lds3 = new LayerDeductionGroup(2, listRule3);
		LayerDeductionGroup lds4 = new LayerDeductionGroup(3, listRule4);
		ArrayList<LayerDeductionGroup> deductivetree = new ArrayList<>(Arrays.asList(lds1, lds2, lds3, lds4));
		InferenceTree itTest = new InferenceTree(deductivetree);
		itTest.display();
		layerController.deleteExcessRuleTree(itTest);
		System.out.println("Cat tia");
		itTest.display();
		*/

	}
}
