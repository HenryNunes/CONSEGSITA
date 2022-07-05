package TransformationPatterns;

public class ByPass implements IValueTransform {
	//tenho como focar o construtor na interface?
	private int[] column;
	
	public ByPass(int[] column) {
		this.column = column;
	}
	
	
	@Override
	public int[] getColumn() {
		return this.column;
	}

	@Override
	public String transformValue(String[] strings, int nivel) {
		String resposta = "";
		for(String st : strings) {
			resposta = resposta + st;
		}
		return resposta;
	}

}
