package Model;

import TransformationPatterns.ITransform;
import TransformationPatterns.NewCastle;

public class Main {

	public static void main(String[] args) { //APenas para teste
		Row r = new Row();
		//G.006;0; 427.84; 0.0; 53.0; 21.26; 0.0;20220630;000426
		r.addValue("G.006");
		r.addValue("0");
		r.addValue("427.84");
		r.addValue("0.0");
		r.addValue("53.0");
		r.addValue("21.26");
		r.addValue("0.0");
		r.addValue("20220630");
		r.addValue("000426");
		
		ITransform trans = new NewCastle();
		Row r2 = trans.transform(r, 3, 2, 4, 0);
		
		System.out.println(r2.getPos(0));
		System.out.println(r2.getPos(1));
		System.out.println(r2.getPos(2));

		
	}

}
