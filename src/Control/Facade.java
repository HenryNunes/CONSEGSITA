package Control;

import Model.DAO;
import Model.Row;
import TransformationPatterns.ITransform;
import TransformationPatterns.NewCastle;

import java.math.BigDecimal;

public class Facade {
	public boolean hasS() {
		return true;
	}
	public boolean hasI() {
		return false;
	}
	public boolean hasT() {
		return true;
	}
	public boolean hasA() {
		return true;
	}

	public void setS(int v) {}
	public void setI(int v) {}
	public void setT(int v) {}
	public void setA(int v) {}
	
	public int numberRows = 0;
	public int currentLine = 0;


	public void transform(String src, String dest, String splitter, int s, int i, int t, int a) {
		DAO dao = new DAO(src, dest, splitter);
		numberRows = dao.getTotalLines();
		ITransform motor = new NewCastle();
		try {
			for (;;) {
				currentLine++;
				Row r = dao.readLine();
 				Row rn = motor.transform(r,s,i,t,a);
				dao.writeLine(rn);
			}
		}
		catch (Exception ex){
			ex.printStackTrace();
		}
		dao.close();
	}

	// criei esse método para atualizar a barra de progresso na interface
	// ao invés de utilizar o statusLinha, já podemos calcular o tamanho do database e a posição atual
	// (ou seja, percentagem concluída de processamento) e retornar um número entre 0 e 1
	// assim só fica necessário atualizar a barra na interface e não fica nenhum cálculo lá (Luana)
    public BigDecimal getProgress() {
		return new BigDecimal(currentLine/numberRows);
    }

}
