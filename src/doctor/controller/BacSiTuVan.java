package doctor.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import doctor.model.Event;
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
		String id6 = "1202";// Nhiệt độ từ 37,5 C đến 38,5 C
		String id7 = "1203";// Nhiệt độ từ 38,5 C đến 39 C
		String id8 = "1204";// Nhiệt độ từ 39 đến 40 C
		String id9 = "1205"; // Nhiệt độ lớn hơn 40 C
		String id10 = "1206"; // Thân nhiệt bình thường
		String id11 = "1207"; // Sốt nhẹ
		String id12 = "1208"; // Sốt vừa
		String id13 = "1209"; // Sốt cao
		String id14 = "1210";// Sốt rất cao

		String id15 = "1301";// Nhỏ < 65 lần/ phút (chậm)
		String id16 = "1302";// Từ 65 đến 80 lần/phút (bình thường)
		String id17 = "1303";// > 80 lần/phút (nhanh)
		String id18 = "1304";// nhịp tim chậm
		String id19 = "1305"; // nhịp tim bình thường
		String id20 = "1306"; // nhịp tim nhanh

		String id21 = "1401";// Ho thường
		String id22 = "1402";// Ho khan
		String id23 = "1403";// Ho đờm
		String id24 = "1404";// Chảy mũi
		String id25 = "1405";// Đau đầu
		String id26 = "1406";// Buồn nôn
		String id27 = "1407";// Ói mửa
		String id28 = "1408";// Tức ngực
		String id29 = "1409";// Tiêu chảy
		String id30 = "1410";// Hắt hơi
		String id31 = "1411";// Rối loạn ý thức
		String id32 = "1412";// Phát ban
		String id33 = "1413";// Chảy máu dưới da
		String id34 = "1414";// Chảy máu chân răng
		String id35 = "1415";// Đau họng
		String id36 = "1416";// Chảy máu mũi
		String id37 = "1417";// Sưng hạch

		String id38 = "2101";// Bệnh nhân bị cúm A H1N1
		String id39 = "2102";// Bệnh nhân bị cúm A H3N2
		String id40 = "2103";// Bệnh nhân bị cúm A H5N1
		String id41 = "2104";// Bệnh nhân bị cúm B
		String id42 = "2105";// Bệnh nhân bị cảm lạnh
		String id43 = "2106";// Bệnh nhân bị cảm nóng
		String id44 = "2107";// Bệnh nhân bị sốt phát ban
		String id45 = "2108";// Bệnh nhân bị sốt siêu vi
		String id46 = "2109";// Bệnh nhân bị sốt xuất huyết

		String id47 = "3101"; // Thuốc cho người lớn bị H1N1
		String id48 = "3102"; // Thuốc cho trẻ em bị H1N1
		String id49 = "3103"; // Thuốc cho người lớn bị H5N1
		String id50 = "3104"; // Thuốc cho trẻ em bị H5N1
		String id51 = "3105"; // Thuốc cho người bị H3N2
		String id52 = "3106"; // Thuốc cho người bị cúm B
		String id53 = "3107"; // Thuốc cho người bị cảm lạnh
		String id54 = "3108"; // Thuốc cho người bị cảm nóng
		String id55 = "3109"; // Thuốc cho người lớn bị sốt phát ban
		String id56 = "3110"; // Thuốc cho trẻ em bị sốt phát ban
		String id57 = "3111"; // Thuốc cho người lớn bị sốt siêu vi
		String id58 = "3112"; // Thuốc cho trẻ em bị sốt siêu vi
		String id59 = "3113"; // Thuốc cho người bị sốt xuất huyết.

		String id60 = "4101"; // Lời khuyên cho người bị cúm A, cúm B
		String id61 = "4102"; // Lời khuyên cho người bị cảm lạnh
		String id62 = "4103"; // Lời khuyên cho người bị cảm nóng
		String id63 = "4104"; // Lời khuyên cho người bị sốt phát ban
		String id64 = "4105"; // Lời khuyên cho người bị sốt siêu vi
		String id65 = "4106"; // Lời khuyên cho người bị sốt xuất huyết
		
		
		Event ev1 = new Event(id1,"Trẻ em", 1);
		Event ev2 = new Event(id2,"Người lớn", 1);
		Event ev3 = new Event(id3,"Nam", 1);
		Event ev4 = new Event(id4,"Nữ", 1);
		Event ev5 = new Event(id5,"Nhiệt độ từ 36,5 đến 37,5", 1);
		Event ev6 = new Event(id6,"Nhiệt độ từ 37,5 đến 38,5", 1);
		Event ev7 = new Event(id7,"Nhiệt độ từ 38,5 đến 39", 1);
		Event ev8 = new Event(id8,"Nhiệt độ từ 39 đến 40", 1);
		Event ev9 = new Event(id9,"Nhiệt độ >40", 1);
		Event ev10 = new Event(id10,"Thân nhiệt bình thường", 1);
		Event ev11 = new Event(id11,"Sốt nhẹ", 1);
		Event ev12 = new Event(id12,"Sốt vừa", 1);
		Event ev13 = new Event(id13,"Sốt cao", 1);
		Event ev14 = new Event(id14,"Sốt rất cao", 1);
		Event ev15 = new Event(id15,"Nhịp tim nhỏ hơn 65 lần/phút", 1);
		Event ev16 = new Event(id16,"Nhịp tim từ 65 đến 80 lần/phút", 1);
		Event ev17 = new Event(id17,"Nhịp tim > 80 lần/phút", 1);
		Event ev18 = new Event(id18,"Nhịp tim chậm", 1);
		Event ev19 = new Event(id19,"Nhịp tim bình thường", 1);
		Event ev20 = new Event(id20,"Nhịp tim nhanh", 1);
		Event ev21 = new Event(id21,"Ho thường", 1);
		Event ev22 = new Event(id22,"Ho khan", 1);
		Event ev23 = new Event(id23,"Ho đờm", 1);
		Event ev24 = new Event(id24,"Chảy mũi", 1);
		Event ev25 = new Event(id25,"Đau đầu", 1);
		Event ev26 = new Event(id26,"Buồn nôn", 1);
		Event ev27 = new Event(id27,"Ói mửa", 1);
		Event ev28 = new Event(id28,"Tức ngực", 1);
		Event ev29 = new Event(id29,"Tiêu chảy", 1);
		Event ev30 = new Event(id30,"Hắt hơi", 1);
		Event ev31 = new Event(id31,"Rối loạn ý thức", 1);
		Event ev32 = new Event(id32,"Phát ban", 1);
		Event ev33 = new Event(id33,"Chảy máu dưới da", 1);
		Event ev34 = new Event(id34,"Chảy máu chân răng", 1);
		Event ev35 = new Event(id35,"Đau họng", 1);
		Event ev36 = new Event(id36,"Chảy máu mũi", 1);
		Event ev37 = new Event(id37,"Sưng hạch", 1);
		

		ArrayList<String> listID1 = new ArrayList<>(Arrays.asList(id5));
		ArrayList<String> listID2 = new ArrayList<>(Arrays.asList(id6));
		ArrayList<String> listID3 = new ArrayList<>(Arrays.asList(id7));
		ArrayList<String> listID4 = new ArrayList<>(Arrays.asList(id8));
		ArrayList<String> listID5 = new ArrayList<>(Arrays.asList(id9));
		ArrayList<String> listID6 = new ArrayList<>(Arrays.asList(id15));
		ArrayList<String> listID7 = new ArrayList<>(Arrays.asList(id16));
		ArrayList<String> listID8 = new ArrayList<>(Arrays.asList(id17));
		ArrayList<String> listID9 = new ArrayList<>(Arrays.asList(id12, id22));
		ArrayList<String> listID10 = new ArrayList<>(Arrays.asList(id12, id22, id24));
		ArrayList<String> listID11 = new ArrayList<>(Arrays.asList(id12, id22, id25));
		ArrayList<String> listID12 = new ArrayList<>(Arrays.asList(id12, id22, id24, id25));
		ArrayList<String> listID13 = new ArrayList<>(Arrays.asList(id12, id23));
		ArrayList<String> listID14 = new ArrayList<>(Arrays.asList(id12, id23, id24));
		ArrayList<String> listID15 = new ArrayList<>(Arrays.asList(id12, id23, id25));
		ArrayList<String> listID16 = new ArrayList<>(Arrays.asList(id12, id23, id24, id25));
		ArrayList<String> listID17 = new ArrayList<>(Arrays.asList(id12, id23, id29));
		ArrayList<String> listID18 = new ArrayList<>(Arrays.asList(id12, id23, id24, id29));
		ArrayList<String> listID19 = new ArrayList<>(Arrays.asList(id12, id23, id24, id25, id29));
		ArrayList<String> listID20 = new ArrayList<>(Arrays.asList(id13, id21));
		ArrayList<String> listID21 = new ArrayList<>(Arrays.asList(id13, id21, id26));
		ArrayList<String> listID22 = new ArrayList<>(Arrays.asList(id13, id21, id28));
		ArrayList<String> listID23 = new ArrayList<>(Arrays.asList(id13, id21, id20));
		ArrayList<String> listID24 = new ArrayList<>(Arrays.asList(id13, id21, id26, id20));
		ArrayList<String> listID25 = new ArrayList<>(Arrays.asList(id13, id21, id28, id20));
		ArrayList<String> listID26 = new ArrayList<>(Arrays.asList(id13, id21, id26, id28));
		ArrayList<String> listID27 = new ArrayList<>(Arrays.asList(id13, id21, id26, id28, id20));
		ArrayList<String> listID28 = new ArrayList<>(Arrays.asList(id14, id21, id26, id28));
		ArrayList<String> listID29 = new ArrayList<>(Arrays.asList(id11));
		ArrayList<String> listID30 = new ArrayList<>(Arrays.asList(id10, id21));
		ArrayList<String> listID31 = new ArrayList<>(Arrays.asList(id10, id21, id30));
		ArrayList<String> listID32 = new ArrayList<>(Arrays.asList(id11, id21));
		ArrayList<String> listID33 = new ArrayList<>(Arrays.asList(id11, id21, id30));
		ArrayList<String> listID34 = new ArrayList<>(Arrays.asList(id14, id25));
		ArrayList<String> listID35 = new ArrayList<>(Arrays.asList(id14, id20));
		ArrayList<String> listID36 = new ArrayList<>(Arrays.asList(id14, id31));
		ArrayList<String> listID37 = new ArrayList<>(Arrays.asList(id14, id25, id20));
		ArrayList<String> listID38 = new ArrayList<>(Arrays.asList(id14, id20, id31));
		ArrayList<String> listID39 = new ArrayList<>(Arrays.asList(id14, id25, id31));
		ArrayList<String> listID40 = new ArrayList<>(Arrays.asList(id14, id25, id20, id31));
		ArrayList<String> listID41 = new ArrayList<>(Arrays.asList(id14, id24, id32, id37));
		ArrayList<String> listID42 = new ArrayList<>(Arrays.asList(id14, id24, id32));
		ArrayList<String> listID43 = new ArrayList<>(Arrays.asList(id14, id32, id37));
		ArrayList<String> listID44 = new ArrayList<>(Arrays.asList(id14, id32));
		ArrayList<String> listID45 = new ArrayList<>(Arrays.asList(id12, id24, id25, id27, id29));
		ArrayList<String> listID46 = new ArrayList<>(Arrays.asList(id12, id25, id27, id29));
		ArrayList<String> listID47 = new ArrayList<>(Arrays.asList(id12, id25, id27));
		ArrayList<String> listID48 = new ArrayList<>(Arrays.asList(id12, id25, id29));
		ArrayList<String> listID49 = new ArrayList<>(Arrays.asList(id13, id25, id33, id34, id37));
		ArrayList<String> listID50 = new ArrayList<>(Arrays.asList(id13, id25, id33));
		ArrayList<String> listID51 = new ArrayList<>(Arrays.asList(id13, id25, id34));
		ArrayList<String> listID52 = new ArrayList<>(Arrays.asList(id13, id25, id37));

		Rule rule1 = new Rule("r1", id10, listID1, 0.9);
		Rule rule2 = new Rule("r2", id11, listID2, 0.9);
		Rule rule3 = new Rule("r3", id12, listID3, 0.9);
		Rule rule4 = new Rule("r4", id13, listID4, 0.9);
		Rule rule5 = new Rule("r5", id14, listID5, 0.9);
		Rule rule6 = new Rule("r6", id12, listID2, 0.8);
		Rule rule7 = new Rule("r7", id12, listID4, 0.6);
		Rule rule8 = new Rule("r8", id13, listID5, 0.5);
		Rule rule9 = new Rule("r9", id18, listID6, 0.9);
		Rule rule10 = new Rule("r10", id19, listID7, 0.9);
		Rule rule11 = new Rule("r11", id20, listID8, 0.9);
		Rule rule12 = new Rule("r12", id19, listID8, 0.6);
		Rule rule13 = new Rule("r13", id38, listID9, 0.6);
		Rule rule14 = new Rule("r14", id38, listID10, 0.7);
		Rule rule15 = new Rule("r15", id38, listID11, 0.7);
		Rule rule16 = new Rule("r16", id38, listID12, 0.8);
		Rule rule17 = new Rule("r17", id39, listID13, 0.6);
		Rule rule18 = new Rule("r18", id39, listID14, 0.7);
		Rule rule19 = new Rule("r19", id39, listID15, 0.7);
		Rule rule20 = new Rule("r20", id39, listID16, 0.8);
		Rule rule21 = new Rule("r21", id39, listID17, 0.8);
		Rule rule22 = new Rule("r22", id39, listID18, 0.85);
		Rule rule23 = new Rule("r23", id39, listID19, 0.9);
		Rule rule24 = new Rule("r24", id40, listID20, 0.6);
		Rule rule25 = new Rule("r25", id40, listID21, 0.7);
		Rule rule26 = new Rule("r26", id40, listID22, 0.7);
		Rule rule27 = new Rule("r27", id40, listID23, 0.7);
		Rule rule28 = new Rule("r28", id40, listID24, 0.8);
		Rule rule29 = new Rule("r29", id40, listID25, 0.8);
		Rule rule30 = new Rule("r30", id40, listID26, 0.8);
		Rule rule31 = new Rule("r31", id40, listID27, 0.9);
		Rule rule32 = new Rule("r32", id40, listID28, 0.8);
		Rule rule33 = new Rule("r33", id41, listID29, 0.6);
		Rule rule34 = new Rule("r34", id42, listID30, 0.6);
		Rule rule35 = new Rule("r35", id42, listID31, 0.7);
		Rule rule36 = new Rule("r36", id42, listID32, 0.6);
		Rule rule37 = new Rule("r37", id42, listID33, 0.7);
		Rule rule38 = new Rule("r38", id43, listID34, 0.6);
		Rule rule39 = new Rule("r39", id43, listID35, 0.5);
		Rule rule40 = new Rule("r40", id43, listID36, 0.7);
		Rule rule41 = new Rule("r41", id43, listID37, 0.7);
		Rule rule42 = new Rule("r42", id43, listID38, 0.8);
		Rule rule43 = new Rule("r43", id43, listID39, 0.8);
		Rule rule44 = new Rule("r44", id43, listID40, 0.9);
		Rule rule45 = new Rule("r45", id44, listID41, 0.9);
		Rule rule46 = new Rule("r46", id44, listID42, 0.8);
		Rule rule47 = new Rule("r47", id44, listID43, 0.8);
		Rule rule48 = new Rule("r48", id44, listID44, 0.7);
		Rule rule49 = new Rule("r49", id45, listID45, 0.9);
		Rule rule50 = new Rule("r50", id45, listID46, 0.85);
		Rule rule51 = new Rule("r51", id45, listID47, 0.8);
		Rule rule52 = new Rule("r52", id45, listID48, 0.8);
		Rule rule53 = new Rule("r53", id46, listID49, 0.9);
		Rule rule54 = new Rule("r54", id46, listID50, 0.8);
		Rule rule55 = new Rule("r55", id46, listID51, 0.8);
		Rule rule56 = new Rule("r56", id46, listID52, 0.8);

		ArrayList<Rule> listAllRule = new ArrayList<>(Arrays.asList(rule1, rule2, rule3, rule4, rule5, rule6, rule7,
				rule8, rule9, rule10, rule11, rule12, rule13, rule14, rule15, rule16, rule17, rule18, rule19, rule20,
				rule21, rule22, rule23, rule24, rule25, rule26, rule27, rule28, rule29, rule30, rule31, rule32, rule33,
				rule34, rule35, rule36, rule37, rule38, rule39, rule40, rule41, rule42, rule43, rule44, rule45, rule46,
				rule47, rule48, rule49, rule50, rule51, rule52, rule53, rule54, rule55, rule56));
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

		// ArrayList<ArrayList<Rule>> listMyRule =
		// divideRuleGroupWhenHaveSameIdConclude(listAllRule);
		// for (int i = 0; i < listMyRule.size(); i++) {
		// ArrayList<Rule> ListRule = listMyRule.get(i);
		// System.out.println("Nhom " + i);
		// for (int j = 0; j < ListRule.size(); j++) {
		// System.out.println(ListRule.get(j).getIdRule());
		// }
		// }
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
			for (int j = 0; j < ruleTree.size(); j++) {
				tree_tmp.add(ruleTree.get(j));
			}
			LayerDeductionGroup addLds = new LayerDeductionGroup(numberLayer, newListLayerRule.get(i));
			tree_tmp.add(addLds);
			listTree.add(tree_tmp);
		}

		for (int i = 0; i < listTree.size(); i++) {
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
		// System.out.println("Tang cao nhat: " + maxLayer);
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

	// Hiển thị cây suy diễn
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
