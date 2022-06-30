package Model;

import TransformationPatterns.ITransform;

public class Transformer {
	private ITransform transformer;
	
	public Transformer(ITransform t) {
		this.transformer = t;
	}
	
	public Row transform(Row r, int S, int I, int T, int A) {
		return this.transformer.transform(r, S, I, T, A);
	}
	
}
