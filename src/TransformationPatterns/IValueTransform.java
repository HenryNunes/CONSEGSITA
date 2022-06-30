package TransformationPatterns;

public interface IValueTransform {
	public int getColumn();
	public String transformValue(String s, int nivel);
}
