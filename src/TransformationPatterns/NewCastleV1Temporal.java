package TransformationPatterns;

public class NewCastleV1Temporal implements IValueTransform {

	private int[] columns = {7, 8};
	
	@Override
	public int[] getColumn() {
		return columns;
	}

	@Override
	public String transformValue(String[] s, int nivel) {
		if(nivel == 0) {
			return "deleted; deleted; ";
		}
		if(nivel == 1) {
			return s[0].substring(0, 6) + "; deleted; "; //retorna mês
		}
		if(nivel == 2) {
			return s[0] + "; deleted; "; //retorna apenas a data
		}
		if(nivel == 3) {
			return s[0] + "; "+ s[1].substring(0,1) + "0000; "; //remove segundos e minutos
		}
		if(nivel == 4) {
			//System.out.println(s);
			return s[0] + "; " + s[1] + "; ";
		}
		return null;
	}

}
