package TransformationPatterns;

import java.util.LinkedList;
import java.util.List;

import Model.Row;

public class NewCastleV1 implements ITransform {

	private boolean hasS = true;
	private boolean hasI = true;
	private boolean hasT = true;
	private boolean hasA = true;
	private List<IValueTransform> transformationsS = new LinkedList<IValueTransform>();
	private List<IValueTransform> transformationsI = new LinkedList<IValueTransform>();
	private List<IValueTransform> transformationsT = new LinkedList<IValueTransform>();
	private List<IValueTransform> transformationsA = new LinkedList<IValueTransform>();
	
	public NewCastleV1() {
		//adicionar aqui as transformacoes
		transformationsS.add(new NewCastleSpatialV1());
		transformationsT.add(new NewCastleV1Temporal());
		transformationsA.add(new NewCastleActivityV1());
	}
	
	public Row transform(Row r, int S, int I, int T, int A) {
		Row resposta = new Row();
		
		for(IValueTransform iv : transformationsS) {
			int[] colunas = iv.getColumn();
			String[] values = new String[colunas.length];
			for(int i = 0; i < colunas.length; i++) {
				values[i] = r.getPos(colunas[i]);
			}
			String modifiedString = iv.transformValue(values, S);			
			resposta.addValue(modifiedString);
		}
		
		for(IValueTransform iv : transformationsI) {
			int[] colunas = iv.getColumn();
			String[] values = new String[colunas.length];
			for(int i = 0; i < colunas.length; i++) {
				values[i] = r.getPos(colunas[i]);
			}
			String modifiedString = iv.transformValue(values, I);			
			resposta.addValue(modifiedString);
		}
		
		for(IValueTransform iv : transformationsT) {
			int[] colunas = iv.getColumn();
			String[] values = new String[colunas.length];
			for(int i = 0; i < colunas.length; i++) {
				values[i] = r.getPos(colunas[i]);
			}
			String modifiedString = iv.transformValue(values, T);			
			resposta.addValue(modifiedString);
		}
		
		for(IValueTransform iv : transformationsA) {
			int[] colunas = iv.getColumn();
			String[] values = new String[colunas.length];
			for(int i = 0; i < colunas.length; i++) {
				values[i] = r.getPos(colunas[i]);
			}
			String modifiedString = iv.transformValue(values, A);			
			resposta.addValue(modifiedString);
		}
		
		return resposta;
	}

	@Override
	public boolean hasS() {
		return hasS;
	}

	@Override
	public boolean hasI() {
		return hasI;
	}

	@Override
	public boolean hasT() {
		return hasT;
	}

	@Override
	public boolean hasA() {
		return hasA;
	}

}
