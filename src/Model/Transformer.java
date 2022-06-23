package Model;

import TransformationPatterns.ITransform;

public class Transformer {
	private ITransform transformer;
	
	public Transformer(ITransform t) {
		this.transformer = t;
	}
	
	public Row transform(Row r) {
		return this.transformer.transform(r);
	}
	
}
