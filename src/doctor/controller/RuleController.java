package doctor.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import doctor.model.Rule;

public class RuleController {

	// Từ 1 id của sự kiện, tính ra các luật có kết luận là sự kiện này
	public ArrayList<Rule> getRulesFromConclude(ArrayList<Rule> listAllRule, String idConclude) {
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

	// Cho vào 1 danh sách các sự kiện, đưa ra danh sách các sự kiện là kết luận
	// của 1 luật nào đó.
	public ArrayList<String> getIdConclude(ArrayList<String> listIDConclude, ArrayList<String> listIDHypothesis) {
		ArrayList<String> listMyIdConclude = new ArrayList<>();
		for (int i = 0; i < listIDHypothesis.size(); i++) {
			String temp = listIDHypothesis.get(i);
			if (listIDConclude.indexOf(temp) >= 0 && listMyIdConclude.indexOf(temp) < 0) {
				listMyIdConclude.add(temp);
			}
		}
		return listMyIdConclude;
	}
	
	public ArrayList<String> getAllIdConclude(ArrayList<Rule> listAllRule){
		ArrayList<String> listAllIdConclude = new ArrayList<>();
		
		for(int i =0; i < listAllRule.size(); i++){
			String idConclude = listAllRule.get(i).getIdConclude();
			if(listAllIdConclude.indexOf(idConclude) < 0){
				listAllIdConclude.add(idConclude);
			}
		}
		
		return listAllIdConclude;
	}

	// 2

	// Phân tách các nhóm luật cùng tầng khi có các luật cùng chung kết luận
	public ArrayList<ArrayList<Rule>> divideRuleGroupWhenHaveSameIdConclude(ArrayList<Rule> listRule) {
		ArrayList<ArrayList<Rule>> myListGroupRule = new ArrayList<>();
		ArrayList<Rule> sameConclude = getRuleHaveSameConclude(listRule);
		for (int i = 0; i < sameConclude.size(); i++) {
			listRule.remove(sameConclude.get(i));
		}
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

	// Lấy các luật cùng chung kết luận ở cùng một tầng.
	public ArrayList<Rule> getRuleHaveSameConclude(ArrayList<Rule> listRule) {
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

	// 3
	// lấy tất cả các sự kiện giả thiết trong một danh sách các luật
	public ArrayList<String> getListHypothesis(ArrayList<Rule> listRule) {
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
}
