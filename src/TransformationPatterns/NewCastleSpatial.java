package TransformationPatterns;

import java.util.TreeMap;

public class NewCastleSpatial implements IValueTransform {

	private final int[] columns = {0,1};
	
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
			return "USB" + "; " + "deleted; "; 
		}
		if(nivel == 2) {
			TreeMap<String, String> tree_map = new TreeMap<>();
			
			tree_map.put("G.006", "Ground Floor");
			tree_map.put("G.007", "Ground Floor");
			tree_map.put("G.009", "Ground Floor");
			tree_map.put("G.010", "Ground Floor");
			tree_map.put("G.011", "Ground Floor");
			tree_map.put("G.012", "Ground Floor");
			tree_map.put("G.019", "Ground Floor");
			tree_map.put("G.020", "Ground Floor");
			tree_map.put("G.021", "Ground Floor");
			tree_map.put("G.022", "Ground Floor");
			tree_map.put("G.044", "Ground Floor");
			tree_map.put("G.054", "Ground Floor");
			tree_map.put("G.069", "Ground Floor");
			tree_map.put("1.005", "1st Floor");
			tree_map.put("1.010", "1st Floor");
			tree_map.put("1.017", "1st Floor");
			tree_map.put("1.018", "1st Floor");
			tree_map.put("1.024", "1st Floor");
			tree_map.put("1.025", "1st Floor");
			tree_map.put("1.025A", "1st Floor");
			tree_map.put("1.026", "1st Floor");
			tree_map.put("1.025B", "1st Floor");
			tree_map.put("1.043", "1st Floor");
			tree_map.put("2.005", "2nd Floor");
			tree_map.put("2.008", "2nd Floor");
			tree_map.put("2.014", "2nd Floor");
			tree_map.put("2.015", "2nd Floor");
			tree_map.put("2.017", "2nd Floor");
			tree_map.put("2.019", "2nd Floor");
			tree_map.put("2.020", "2nd Floor");
			tree_map.put("2.021", "2nd Floor");
			tree_map.put("2.022", "2nd Floor");
			tree_map.put("2.026", "2nd Floor");
			tree_map.put("2.027", "2nd Floor");
			tree_map.put("2.037", "2nd Floor");
			tree_map.put("2.038", "2nd Floor");
			tree_map.put("2.048", "2nd Floor");
			tree_map.put("2.058", "2nd Floor");
			tree_map.put("2.060", "2nd Floor");
			tree_map.put("3.004", "3rd Floor");
			tree_map.put("3.005", "3rd Floor");
			tree_map.put("3.007", "3rd Floor");
			tree_map.put("3.014", "3rd Floor");
			tree_map.put("3.015", "3rd Floor");
			tree_map.put("3.018", "3rd Floor");
			tree_map.put("3.022", "3rd Floor");
			tree_map.put("3.029", "3rd Floor");
			tree_map.put("3.030", "3rd Floor");
			tree_map.put("3.031", "3rd Floor");
			tree_map.put("3.032", "3rd Floor");
			tree_map.put("3.033", "3rd Floor");
			tree_map.put("3.048", "3rd Floor");
			tree_map.put("3.049", "3rd Floor");
			tree_map.put("3.050", "3rd Floor");
			tree_map.put("4.022", "4th Floor");
			tree_map.put("4.026", "4th Floor");
			tree_map.put("4.034", "4th Floor");
			tree_map.put("4.035", "4th Floor");
			tree_map.put("4.036", "4th Floor");
			tree_map.put("4.037", "4th Floor");
			tree_map.put("4.052", "4th Floor");
			tree_map.put("4.053", "4th Floor");
			tree_map.put("5.008", "5th Floor");
			tree_map.put("5.009", "5th Floor");
			tree_map.put("5.010", "5th Floor");
			tree_map.put("5.011", "5th Floor");
			tree_map.put("5.022", "5th Floor");
			tree_map.put("5.023", "5th Floor");
			tree_map.put("5.024", "5th Floor");
			tree_map.put("5.025", "5th Floor");
			tree_map.put("5.030", "5th Floor");
			tree_map.put("5.031", "5th Floor");
			tree_map.put("5.032", "5th Floor");
			tree_map.put("6.007", "6th Floor");
			tree_map.put("6.008", "6th Floor");
			tree_map.put("6.009", "6th Floor");
			tree_map.put("6.010", "6th Floor");
			tree_map.put("6.011", "6th Floor");
			tree_map.put("6.012", "6th Floor");
			tree_map.put("6.015", "6th Floor");
			tree_map.put("6.019", "6th Floor");
			tree_map.put("6.024", "6th Floor");
			tree_map.put("6.025", "6th Floor");
			tree_map.put("6.027", "6th Floor");
			tree_map.put("6.030", "6th Floor");
			tree_map.put("6.031", "6th Floor");
			tree_map.put("6.032", "6th Floor");
			tree_map.put("6.037", "6th Floor");
			tree_map.put("6.038", "6th Floor");
			tree_map.put("6.038A", "6th Floor");
			
			return tree_map.get(s[0]) + "; " + "deleted; "; // Remove a zona
			
			
		}
		if(nivel == 3) {
			TreeMap<String, String> tree_map = new TreeMap<>();
			
			tree_map.put("G.006", "G.006");
			tree_map.put("G.007", "G.007");
			tree_map.put("G.009", "G.009");
			tree_map.put("G.010", "G.010");
			tree_map.put("G.011", "G.011");
			tree_map.put("G.012", "G.012");
			tree_map.put("G.019", "G.019");
			tree_map.put("G.020", "G.020");
			tree_map.put("G.021", "G.021");
			tree_map.put("G.022", "G.022");
			tree_map.put("G.044", "G.044");
			tree_map.put("G.054", "G.054");
			tree_map.put("G.069", "G.069");
			tree_map.put("1.005", "1.005");
			tree_map.put("1.010", "1.010");
			tree_map.put("1.017", "1.017");
			tree_map.put("1.018", "1.018");
			tree_map.put("1.024", "1.024");
			tree_map.put("1.025", "1.025");
			tree_map.put("1.025A", "1.025A");
			tree_map.put("1.026", "1.026");
			tree_map.put("1.025B", "1.025B");
			tree_map.put("1.043", "1.043");
			tree_map.put("2.005", "2.005");
			tree_map.put("2.008", "2.008");
			tree_map.put("2.014", "2.014");
			tree_map.put("2.015", "2.015");
			tree_map.put("2.017", "2.017");
			tree_map.put("2.019", "2.019");
			tree_map.put("2.020", "2.020");
			tree_map.put("2.021", "2.021");
			tree_map.put("2.022", "2.022");
			tree_map.put("2.026", "2.026");
			tree_map.put("2.027", "2.027");
			tree_map.put("2.037", "2.037");
			tree_map.put("2.038", "2.038");
			tree_map.put("2.048", "2.048");
			tree_map.put("2.058", "2.058");
			tree_map.put("2.060", "2.060");
			tree_map.put("3.004", "3.004");
			tree_map.put("3.005", "3.005");
			tree_map.put("3.007", "3.007");
			tree_map.put("3.014", "3.014");
			tree_map.put("3.015", "3.015");
			tree_map.put("3.018", "3.018");
			tree_map.put("3.022", "3.022");
			tree_map.put("3.029", "3.029");
			tree_map.put("3.030", "3.030");
			tree_map.put("3.031", "3.031");
			tree_map.put("3.032", "3.032");
			tree_map.put("3.033", "3.033");
			tree_map.put("3.048", "3.048");
			tree_map.put("3.049", "3.049");
			tree_map.put("3.050", "3.050");
			tree_map.put("4.022", "4.022");
			tree_map.put("4.026", "4.026");
			tree_map.put("4.034", "4.034");
			tree_map.put("4.035", "4.035");
			tree_map.put("4.036", "4.036");
			tree_map.put("4.037", "4.037");
			tree_map.put("4.052", "4.052");
			tree_map.put("4.053", "4.053");
			tree_map.put("5.008", "5.008");
			tree_map.put("5.009", "5.009");
			tree_map.put("5.010", "5.010");
			tree_map.put("5.011", "5.011");
			tree_map.put("5.022", "5.022");
			tree_map.put("5.023", "5.023");
			tree_map.put("5.024", "5.024");
			tree_map.put("5.025", "5.025");
			tree_map.put("5.030", "5.030");
			tree_map.put("5.031", "5.031");
			tree_map.put("5.032", "5.032");
			tree_map.put("6.007", "6.007");
			tree_map.put("6.008", "6.008");
			tree_map.put("6.009", "6.009");
			tree_map.put("6.010", "6.010");
			tree_map.put("6.011", "6.011");
			tree_map.put("6.012", "6.012");
			tree_map.put("6.015", "6.015");
			tree_map.put("6.019", "6.019");
			tree_map.put("6.024", "6.024");
			tree_map.put("6.025", "6.025");
			tree_map.put("6.027", "6.027");
			tree_map.put("6.030", "6.030");
			tree_map.put("6.031", "6.031");
			tree_map.put("6.032", "6.032");
			tree_map.put("6.037", "6.037");
			tree_map.put("6.038", "6.038");
			tree_map.put("6.038A", "6.038A");
			
			return tree_map.get(s[0]) + "; " + "deleted; "; // Remove a zona
			
		}
		if(nivel == 4) {
			return s[0] + "; "+ s[1] + "; ";
		}

		return null;
	}

}
