package doctor.controller;

import java.util.ArrayList;

import doctor.model.Event;

public class EventController {
	ArrayList<Event> listAllEvent;

	public EventController(ArrayList<Event> listAllEvent) {
		super();
		this.listAllEvent = listAllEvent;
	}
	
	public ArrayList<Event> getListDisease(){
		ArrayList<Event> listDisease = new ArrayList<>();
		for(int i = 0; i<listAllEvent.size(); i++){
			Event tmp = listAllEvent.get(i);
			if(tmp.getID().charAt(0) == '2'){
				listDisease.add(tmp);
			}
		}
		return listDisease;
	}
	
	public ArrayList<Event> getListMedicine(){
		ArrayList<Event> listMedicine = new ArrayList<>();
		for(int i = 0; i<listAllEvent.size(); i++){
			Event tmp = listAllEvent.get(i);
			if(tmp.getID().charAt(0) == '3'){
				listMedicine.add(tmp);
			}
		}
		return listMedicine;
	}
	
	public ArrayList<Event> getListAdvice(){
		ArrayList<Event> listAdvice = new ArrayList<>();
		for(int i = 0; i<listAllEvent.size(); i++){
			Event tmp = listAllEvent.get(i);
			if(tmp.getID().charAt(0) == '4'){
				listAdvice.add(tmp);
			}
		}
		return listAdvice;
	}

	public ArrayList<Event> getListAllEvent() {
		return listAllEvent;
	}

	public void setListAllEvent(ArrayList<Event> listAllEvent) {
		this.listAllEvent = listAllEvent;
	}
	
	
}
