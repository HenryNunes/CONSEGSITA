package TransformationPatterns;

import java.util.LinkedList;
import java.util.List;

import Model.Row;

public class NewCastle implements ITransform {

	private final boolean hasS = true;
	private final boolean hasI = true;
	private final boolean hasT = true;
	private final boolean hasA = true;
	private List<IValueTransform> transformationsS = new LinkedList<>();
	private List<IValueTransform> transformationsI = new LinkedList<>();
	private List<IValueTransform> transformationsT = new LinkedList<>();
	private List<IValueTransform> transformationsA = new LinkedList<>();
	
	public NewCastle() {
		//adicionar aqui as transformacoes
		transformationsS.add(new NewCastleSpatial());
		transformationsT.add(new NewCastleTemporal());
		transformationsA.add(new NewCastleActivity());
	}
	
	public Row transform(Row r, int S, int I, int T, int A) {
		Row response = new Row();

		for(IValueTransform iv : transformationsS) {
			int[] columns = iv.getColumn();
			String[] values = new String[columns.length];
			for(int i = 0; i < columns.length; i++) {
				values[i] = r.getPos(columns[i]);
			}
			String modifiedString = iv.transformValue(values, S);			
			response.addValue(modifiedString);
		}
		
		for(IValueTransform iv : transformationsI) {
			int[] columns = iv.getColumn();
			String[] values = new String[columns.length];
			for(int i = 0; i < columns.length; i++) {
				values[i] = r.getPos(columns[i]);
			}
			String modifiedString = iv.transformValue(values, I);			
			response.addValue(modifiedString);
		}
		
		for(IValueTransform iv : transformationsT) {
			int[] columns = iv.getColumn();
			String[] values = new String[columns.length];
			for(int i = 0; i < columns.length; i++) {
				values[i] = r.getPos(columns[i]);
			}
			String modifiedString = iv.transformValue(values, T);			
			response.addValue(modifiedString);
		}
		
		for(IValueTransform iv : transformationsA) {
			int[] columns = iv.getColumn();
			String[] values = new String[columns.length];
			for(int i = 0; i < columns.length; i++) {
				values[i] = r.getPos(columns[i]);
			}
			String modifiedString = iv.transformValue(values, A);			
			response.addValue(modifiedString);
		}
		return response;
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
