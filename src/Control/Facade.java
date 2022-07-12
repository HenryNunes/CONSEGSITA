package Control;

import Model.DAO;
import TransformationPatterns.ByPassAll;
import TransformationPatterns.NewCastleV1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

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
	
	public int numberRows = 0;
	public int currentLine = 0;


	public void transform(String src, String dest, String splitter) {
		numberRows = getNumberRows(src);
		DAO dao = new DAO(src, dest, splitter);
		NewCastleV1 motor = new NewCastleV1();
		try {
			while (true) {
				currentLine++;
				dao.writeLine(motor.transform(dao.readLine(), 1, 1, 1, 1));
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

	// criei esse método para atualizar a barra de progresso na interface
	// ao invés de utilizar o statusLinha, já podemos calcular o tamanho do database e a posição atual
	// (ou seja, percentagem concluída de processamento) e retornar um número entre 0 e 1
	// assim só fica necessário atualizar a barra na interface e não fica nenhum cálculo lá (Luana)
    public BigDecimal getProgress() {
		
		return new BigDecimal(currentLine/numberRows);
    }

	public int getNumberRows(String src){
		String command = "wc -l " + src;
		int numberRows = 0;
		try {
			Process process = Runtime.getRuntime().exec(command);
    		BufferedReader in = new BufferedReader(new InputStreamReader(process.getErrorStream()));
 			String arr[] = in.readLine().split(" ", 2);
			numberRows = Integer.parseInt(arr[0]);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return numberRows;
	}
}
