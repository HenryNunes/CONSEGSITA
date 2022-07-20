package Model;

import java.util.LinkedList;
import java.util.List;

public class Row {
	private int columns = 0;
	private final List<Value> values;
	
	public Row() {
		values = new LinkedList<>();
	}
	
	public void addValue(String s) {
		this.columns++;
		values.add(new Value(s));
	}
	
	public String getPos(int pos) {
		//fiquei com preguica de colocar um exception para valores fora da lista
		return this.values.get(pos).getValue();
	}
	public int getColumns() {
		return columns;
	}
}
