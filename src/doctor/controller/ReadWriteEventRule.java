package doctor.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

import doctor.model.Event;
import doctor.model.Rule;

public class ReadWriteEventRule {
	// Ghi cả một danh sách sự kiện vào file, danh sach này sẽ ghi đè danh sách
	// đang có trong file
	public void writeAllEvent(ArrayList<Event> listEvent) {
		try (PrintWriter writer = new PrintWriter(new FileWriter("event.txt", false), true)) {
			for (int i = 0; i < listEvent.size(); i++) {
				Event e = listEvent.get(i);
				writer.println(e.getID() + "|" + e.getName() + "|0");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Ghi cả một danh sách luật vào file, danh sach này sẽ ghi đè danh sách
	// đang có trong file
	public void writeAllRule(ArrayList<Rule> listRule) {
		try (PrintWriter writer = new PrintWriter(new FileWriter("rule.txt", false), true)) {
			for (int i = 0; i < listRule.size(); i++) {
				Rule rule = listRule.get(i);
				StringBuffer sb = new StringBuffer();
				for (int j = 0; j < rule.getListIDHypothesis().size(); j++) {
					String event = rule.getListIDHypothesis().get(j);
					sb.append("|" + event);
				}
				writer.println(
						rule.getIdRule() + "|" + rule.getIdConclude() + "|" + rule.getCertainFactor() + sb.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Ghi thêm một sự kiện vào file, sự kiện này sẽ ghi thêm vào file, không
	// phải ghi đè
	public void writeOneEvent(Event event) {
		try (PrintWriter writer = new PrintWriter(new FileWriter("event.txt", true), true)) {
			writer.println(event.getID() + "|" + event.getName() + "|0");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Ghi thêm một luật vào file, luật này sẽ ghi thêm vào file, không
	// phải ghi đè
	public void writeOneRule(Rule rule) {
		try (PrintWriter writer = new PrintWriter(new FileWriter("rule.txt", true), true)) {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < rule.getListIDHypothesis().size(); i++) {
				String event = rule.getListIDHypothesis().get(i);
				sb.append("|" + event);
			}
			writer.println(
					rule.getIdRule() + "|" + rule.getIdConclude() + "|" + rule.getCertainFactor() + sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Đọc file event.txt để lấy ra các sự kiện
	public ArrayList<Event> readAllEvent() {
		ArrayList<Event> listAllEvent = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader("event.txt"))) {

			String line;
			StringTokenizer readData;
			while ((line = reader.readLine()) != null) {
				readData = new StringTokenizer(line, "|");
				ArrayList<String> tmp = new ArrayList<>();
				while (readData.hasMoreTokens()) {
					tmp.add(readData.nextToken());
				}
				double certain = Double.parseDouble(tmp.get(2));
				Event ev = new Event(tmp.get(0), tmp.get(1), certain);
				listAllEvent.add(ev);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listAllEvent;
	}

	// Đọc file rule.txt để lấy các luật
	public ArrayList<Rule> readAllRule() {
		ArrayList<Rule> listAllRule = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader("rule.txt"))) {
			String line;
			StringTokenizer readData;
			while ((line = reader.readLine()) != null) {
				readData = new StringTokenizer(line, "|");
				ArrayList<String> tmp = new ArrayList<>();
				while (readData.hasMoreTokens()) {
					tmp.add(readData.nextToken());
				}
				String idRule = tmp.get(0);
				String idConclude = tmp.get(1);
				Double certain = Double.parseDouble(tmp.get(2));
				ArrayList<String> listHypothesis = new ArrayList<>();
				for(int i = 3; i< tmp.size(); i++){
					listHypothesis.add(tmp.get(i));
				}
				Rule rule = new Rule(idRule, idConclude, listHypothesis, certain);
				listAllRule.add(rule);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listAllRule;
	}
	
	//Sửa một sự kiện
	public void updateAnEvent(Event event){
		ArrayList<Event> listAllEvent = readAllEvent();
		for(int i =0; i < listAllEvent.size(); i++){
			if(listAllEvent.get(i).getID().equals(event.getID())){
				listAllEvent.get(i).setName(event.getName());
				listAllEvent.get(i).setCertainFactor(event.getCertainFactor());
				writeAllEvent(listAllEvent);
				return;
			}
		}
		System.out.println("Không có sự kiện này");
	}
	
	//Sửa một luật
	public void updateARule(Rule rule){
		ArrayList<Rule> listAllRule = readAllRule();
		for(int i = 0; i < listAllRule.size(); i++){
			if(listAllRule.get(i).getIdRule().equals(rule.getIdRule())){
				listAllRule.get(i).setIdConclude(rule.getIdConclude());
				listAllRule.get(i).setListIDHypothesis(rule.getListIDHypothesis());
				listAllRule.get(i).setCertainFactor(rule.getCertainFactor());
				writeAllRule(listAllRule);
				return;
			}
		}
		System.out.println("Không có luật này");
	}
	
	//Khi muốn thêm một luật, ta cần biết Id luật tiếp theo là gì, hàm này cho phép tìm luật tiếp theo.
	public String getIdForNewRule(){
		ArrayList<Rule> listAllRule = readAllRule();
		int lastIndex = listAllRule.size() -1;
		String idlast = listAllRule.get(lastIndex).getIdRule();
		String number = idlast.substring(1);
		int next = Integer.parseInt(number) + 1;
		return "r" + next;
	}

}
