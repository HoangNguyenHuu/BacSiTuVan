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
	
}
