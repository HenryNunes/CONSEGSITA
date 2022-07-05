package TransformationPatterns;

import Model.Row;

public interface ITransform {
		public Row transform(Row r, int S, int I, int T, int A);
		public boolean hasS();
		public boolean hasI();
		public boolean hasT();
		public boolean hasA();
}
