package TransformationPatterns;

import java.util.LinkedList;
import java.util.List;
import Model.Row;

public class ByPassAll implements ITransform {

	private boolean hasS = false;
	private boolean hasI = false;
	private boolean hasT = false;
	private boolean hasA = false;
	private List<IValueTransform> transformations = new LinkedList<IValueTransform>();
	
	public ByPassAll() {
		//adicionar aqui as transformacoes
		
		
	}
	
	@Override
	public Row transform(Row r) {
		Row resposta = new Row();
		
		for(IValueTransform iv : transformations) {
			int coluna = iv.getColumn();
			String modifiedString = iv.transformValue(r.getPos(coluna));			
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

	@Override
	public void addValueTransformS(IValueTransform t, int pos) {
		transformations.add(t);
		this.hasS = true;
	}

	@Override
	public void addValueTransformI(IValueTransform t, int pos) {
		transformations.add(t);
		this.hasI = true;
	}

	@Override
	public void addValueTransformT(IValueTransform t, int pos) {
		transformations.add(t);
		this.hasT = true;
	}

	@Override
	public void addValueTransformA(IValueTransform t, int pos) {
		transformations.add(t);
		this.hasA = true;
	}

}
