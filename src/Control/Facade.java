package Control;

import Model.DAO;
import TransformationPatterns.ByPassAll;

public class Facade {
	public boolean hasS() {
		return true;
	}
	public boolean hasI() {
		return true;
	}
	public boolean hasT() {
		return true;
	}
	public boolean hasA() {
		return false;
	}
	
	
	public void setS(int v) {
		return;
	}
	public void setI(int v) {
		return;
	}
	public void setT(int v) {
		return;
	}
	public void setA(int v) {
		return;
	}
	
	public void transform(String src, String dest, String separador) {

		DAO dao = new DAO(src, dest, separador);
		ByPassAll byPassAll = new ByPassAll();
		try {
			while (true) {
				dao.writeLine(byPassAll.transform(dao.readLine(), 1, 1, 1, 1));
			}
		}
		catch (Exception ex){
			ex.printStackTrace();
		}
		dao.close();
	}
	
	public int statusLinha() {
		return 0;
	}
}
