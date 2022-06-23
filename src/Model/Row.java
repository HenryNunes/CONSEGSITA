package Model;

import java.util.LinkedList;
import java.util.List;

public class Row {
	private static int linhas = 0;
	private int colunas = 0;
	private List<Value> values;
	
	public Row() {
		values = new LinkedList<Value>();	
	}
	
	public boolean addValue(String s) {
		Row.linhas++;
		this.colunas++;
		return values.add(new Value(s));
	}
	
	public String getPos(int pos) {
		//fiquei com preguica de colocar um exception para valores fora da lista
		return this.values.get(pos).getValue();
	}
	public int getLinha() {
		return linhas;
	}
	public int getColunas() {
		return colunas;
	}
}
