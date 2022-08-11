package TransformationPatterns.Indonesia;

import java.text.SimpleDateFormat;
import java.util.Date;

import TransformationPatterns.IValueTransform;

public class CO2DUMPTemporal implements IValueTransform {
	
	private final int[] columns = {1};
	
	@Override
	public int[] getColumn() {
		return columns;
	}

	@Override
	public String transformValue(String[] s, int nivel) {
		Date data = new Date(Long.parseLong(s[0])*1000);
		
		if(nivel == 0) {
			return "deleted;";
		}
		if(nivel == 1) {
		    SimpleDateFormat formatter = new SimpleDateFormat("MM/--/yyyy");  
		    String strDate = formatter.format(data);  
			return strDate + "; "; //retorna mês
		}
		if(nivel == 2) {
		    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
		    String strDate = formatter.format(data);  
			return strDate + "; ";
			//return s[0] + "; deleted; "; //retorna apenas a data
		}
		if(nivel == 3) {
		    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy hh");  
		    String strDate = formatter.format(data);  
			return strDate + "; "; 
			//return s[0] + "; "+ s[1].charAt(0) + "0000; "; //remove segundos e minutos
		}
		if(nivel == 4) {
		    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy hh::mm:ss");  
		    String strDate = formatter.format(data);  
			return strDate + "; ";
		}
		return null;
	}
}
