package TransformationPatterns;

public class NewCastleActivityV1 implements IValueTransform {
	
	private int[] columns = {2, 3, 4, 5, 6};
	
	@Override
	public int[] getColumn() {
		return columns;
	}

	@Override
	public String transformValue(String[] s, int nivel) {
		
		
		if(nivel == 0) {
			return "deleted; deleted; deleted; deleted; deleted;";
		}
		if(nivel == 1) {
			String resposta = "";
			for(String sv : s) { //zera 2 numeros a direita
				double number = Double.parseDouble(sv);
				number = Math.round(number / 100) * 100;
				
				resposta = resposta + String.format("%.0f", number) + ";";
			}
			return resposta;
		}
		if(nivel == 2) { //zera o primeiro numero a direita
			String resposta = "";
			for(String sv : s) {
				double number = Double.parseDouble(sv);
				number = Math.round(number / 10) * 10;
				
				resposta = resposta + String.format("%.0f", number) + ";";
			}
			return resposta;
		}
		if(nivel == 3) { //Remove decimais
			String resposta = "";
			for(String sv : s) {
				double number = Double.parseDouble(sv);
				resposta = resposta + String.format("%.0f", number) + ";";
				
			}
			return resposta;
		}
		if(nivel == 4) {
			return s[0] + "; " + s[1] + "; " + s[2] + "; "  + s[3] + "; "  + s[4] + ";" ;
		}
		
		return null;
		
	}
	
	
	
}
