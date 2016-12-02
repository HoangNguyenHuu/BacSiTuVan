package doctor.controller;

import java.util.ArrayList;
import java.util.Arrays;

import doctor.model.Event;
import doctor.model.Rule;

public class BacSiTuVan {
	public static void main(String[] args) {

		ReadWriteEventRule readWriteEventRule = new ReadWriteEventRule();
		ArrayList<Event> listAllEvent = readWriteEventRule.readAllEvent();
		ArrayList<Rule> listAllRule = readWriteEventRule.readAllRule();
		/*
		 * Test chẩn đoán bệnh: với đầu vào là list các sự kiện của bệnh nhân,
		 * ta có đầu ra là bệnh của bệnh nhân. Sau đó, thêm bệnh được chẩn đoán
		 * ra ở trên vào list sự kiện của bệnh nhân, từ list sự kiện này tìm ra
		 * được thuốc và lời khuyên
		 */
		Event evTest1 = new Event("1205", 0.8);
		Event evTest2 = new Event("1405", 0.8);
		Event evTest3 = new Event("1303", 0.8);
		Event evTest4 = new Event("1411", 0.8);
		Event evTest5 = new Event("1410", 0.8);
		Event evTest6 = new Event("1101", 1.0);
		Event evTest7 = new Event("1111", 1.0);
		ArrayList<Event> listEventTest = new ArrayList<>(
				Arrays.asList(evTest1, evTest2, evTest3, evTest4, evTest5, evTest6, evTest7));
		InferenceTreeController inferenceTreeController = new InferenceTreeController(listAllRule, listAllEvent);
		Event result = inferenceTreeController.getDisease(listEventTest);
		listEventTest.add(result);
		System.out.println("Bệnh: " + result.getName());
		Event medicine = inferenceTreeController.getMedicine(listEventTest);
		listEventTest.add(medicine);
		System.out.println("Thuốc: " + medicine.getName());
		Event advice = inferenceTreeController.getAdvice(listEventTest);
		System.out.println("Lời khuyên: " + advice.getName());

		
//		ArrayList<String> listID1 = new ArrayList<>(Arrays.asList("1405"));
		
		/*
		 * Test update sự kiện và luật
		 */
//		Event evupdate = new Event("1209", "Sốt cao", 0);
//		readWriteEventRule.updateAnEvent(evupdate);
//		Rule ruleUpdate = new Rule("r23", "H3N2", listID1, 0.0);
//		readWriteEventRule.updateARule(ruleUpdate);
		
		/*
		 * Test thêm luật
		 */
//		String nextRule = readWriteEventRule.getIdForNewRule();
//		Rule ruleTest = new Rule(nextRule, "test", listID1, 0.9);
//		readWriteEventRule.writeOneRule(ruleTest);
	}
}
