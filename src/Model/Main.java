package Model;

import TransformationPatterns.ITransform;
import TransformationPatterns.NewCastle;
import TransformationPatterns.Indonesia.CO2DUMP;

public class Main {

	public static void main(String[] args) { //APenas para teste
		Row r = new Row();
		//G.006;0; 427.84; 0.0; 53.0; 21.26; 0.0;20220630;000426
		r.addValue("6642641");
		r.addValue("1533365453");
		r.addValue("347");
		r.addValue("-100.0");
		r.addValue("63.8");
		r.addValue("24");
		r.addValue("0");

		
		ITransform trans = new CO2DUMP();
		Row r2 = trans.transform(r, 4, 1, 3, 1);
		
		for(int i = 0; i < r2.getColumns(); i++) {
			System.out.print(r2.getPos(i));
		}
		System.out.print("\n");
	}
}
