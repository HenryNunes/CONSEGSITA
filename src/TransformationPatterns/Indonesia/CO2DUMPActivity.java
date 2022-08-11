package TransformationPatterns.Indonesia;

import TransformationPatterns.IValueTransform;

public class CO2DUMPActivity implements IValueTransform{
	private final int[] columns = {2, 3, 4, 5};
	
	@Override
	public int[] getColumn() {
		return columns;
	}

	@Override
	public String transformValue(String[] s, int nivel) {
		StringBuilder response = new StringBuilder();
		if(nivel == 0) {
			return "deleted; deleted; deleted; deleted; deleted;";
		}
		if(nivel == 1) {
			for(String sv : s) { //zera 2 numeros a direita
				double number = Double.parseDouble(sv);
				number = Math.round(number / 100) * 100;
				
				response.append(String.format("%.0f", number)).append(";");
			}
			return response.toString();
		}
		if(nivel == 2) { //zera o primeiro numero a direita
			for(String sv : s) {
				double number = Double.parseDouble(sv);
				number = Math.round(number / 10) * 10;
				
				response.append(String.format("%.0f", number)).append(";");
			}
			return response.toString();
		}
		if(nivel == 3) { //Remove decimais
			for(String sv : s) {
				double number = Double.parseDouble(sv);
				response.append(String.format("%.0f", number)).append(";");
				
			}
			return response.toString();
		}
		if(nivel == 4) {
			return s[0] + "; " + s[1] + "; " + s[2] + "; "  + s[3] + "; ";
		}
		return null;
	}
}
