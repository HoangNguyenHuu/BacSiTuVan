package doctor.controller;

import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("abc");
		list.add("ade");
		list.add("ame");
		
		list.remove("ade");
		System.out.println(list.indexOf("ame"));
	}
}
