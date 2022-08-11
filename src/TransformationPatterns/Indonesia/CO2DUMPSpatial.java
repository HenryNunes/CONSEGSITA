package TransformationPatterns.Indonesia;

import TransformationPatterns.IValueTransform;

public class CO2DUMPSpatial implements IValueTransform {
	
	private final int[] columns = {6};
	
	@Override
	public int[] getColumn() {
		return columns;
	}

	@Override
	public String transformValue(String[] s, int nivel) {
		if(nivel == 0) {
			return "deleted;";
		}
		if(nivel == 1) {
			return "Indonesia;";
		}
		if(nivel == 2) {
			return "Depok;";
		}
		if(nivel == 3) {
			return "University of Indonesia;";
		}
		if(nivel == 4) {
			return s[0] + ";";
		}
		
		
		return null;
	}
}
