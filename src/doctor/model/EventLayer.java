package doctor.model;

import java.util.ArrayList;

public class EventLayer {
	private int numberLayer;
	private ArrayList<Event> listLayerEvent;
	public EventLayer(int numberLayer, ArrayList<Event> listLayerEvent) {
		super();
		this.numberLayer = numberLayer;
		this.listLayerEvent = listLayerEvent;
	}
	public int getNumberLayer() {
		return numberLayer;
	}
	public void setNumberLayer(int numberLayer) {
		this.numberLayer = numberLayer;
	}
	public ArrayList<Event> getListLayerEvent() {
		return listLayerEvent;
	}
	public void setListLayerEvent(ArrayList<Event> listLayerEvent) {
		this.listLayerEvent = listLayerEvent;
	}
	
	public void display(){
		System.out.print("Layer Event  " + this.numberLayer + ": ");
		for(int i =0; i< this.listLayerEvent.size(); i++){
			System.out.print(this.listLayerEvent.get(i).getID() + " " + this.listLayerEvent.get(i).getCertainFactor() + "; ");
		}
		System.out.println();
	}
}
