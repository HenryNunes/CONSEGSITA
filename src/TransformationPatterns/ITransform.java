package TransformationPatterns;

import Model.Row;

public interface ITransform {
		public Row transform(Row r);
		public boolean hasS();
		public boolean hasI();
		public boolean hasT();
		public boolean hasA();
		public void addValueTransformS(IValueTransform t, int pos);
		public void addValueTransformI(IValueTransform t, int pos);
		public void addValueTransformT(IValueTransform t, int pos);
		public void addValueTransformA(IValueTransform t, int pos);
}
