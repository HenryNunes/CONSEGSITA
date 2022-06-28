package Model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DAO {
	
	private String sourcePath;
	private String destinyPath;
	private String separator;
	
	private File srcFile;
	private File destFile;
	
	private Scanner in;
	private BufferedWriter out;
	
	public DAO(String src, String dst, String separator) {
		try{
			this.separator = separator;
			this.sourcePath = src;
			this.destinyPath = dst;
			
			this.srcFile = new File(this.sourcePath);
			this.destFile = new File(this.destinyPath);
			
			in = new Scanner(this.srcFile );
			out = new BufferedWriter(new FileWriter(this.destFile));
			
		}
		catch (Exception e) {
			System.out.println("Erro DAO");
		}
		
	}
	public Row readLine() {
		Row r = new Row();
		
		String line = in.nextLine();
		String[] values = line.split(separator);
		
		for(int i = 0; i < values.length ;i++) {
			r.addValue(values[i]);	
		}
		
		return r;
	}
	public void writeLine(Row r) {
		String newLine = "";
		
		for(int i = 0; i < r.getColunas(); i++ ){
			newLine = newLine + r.getPos(i) + separator;
		}
		
		newLine = newLine + "\n";
		
		try {
			out.write(newLine);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	public void close() {
		in.close();
		
		try {
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
