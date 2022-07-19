package Model;

import java.io.*;
import java.util.Scanner;

public class DAO {

	private String sourcePath;
	private String destinyPath;
	private String separator;

	private File srcFile;
	private File destFile;

	private Scanner in;
	private BufferedWriter out;

	private int line;
	private int totalLines;

	public DAO(String src, String dst, String separator) {
		this.line = 1;
		try {
			this.totalLines = calculateTotalines(src);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		try {
			this.separator = separator;
			this.sourcePath = src;
			this.destinyPath = dst;

			this.srcFile = new File(this.sourcePath);
			this.destFile = new File(this.destinyPath);

			in = new Scanner(this.srcFile);
			out = new BufferedWriter(new FileWriter(this.destFile));

		} catch (Exception e) {
			System.out.println("Erro DAO");
		}

	}

	public Row readLine() {
		Row r = new Row();

		if (!in.hasNext()) return null;
		String line = in.nextLine();
		String[] values = line.split(separator);

		for (int i = 0; i < values.length; i++) {
			r.addValue(values[i]);
		}

		return r;
	}

	public void writeLine(Row r) {
		String newLine = "";

		for (int i = 0; i < r.getColunas(); i++) {
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

	public int getTotalLines() {
		return totalLines;
	}

	public int getLine() {
		return line;
	}

	private int calculateTotalines(String src) throws IOException {
		InputStream is = new BufferedInputStream(new FileInputStream(src));
		try {
			byte[] c = new byte[1024];
			int count = 0;
			int readChars = 0;
			boolean empty = true;
			while ((readChars = is.read(c)) != -1) {
				empty = false;
				for (int i = 0; i < readChars; ++i) {
					if (c[i] == '\n') {
						++count;
					}
				}
			}
			return (count == 0 && !empty) ? 1 : count;
		} finally {
			is.close();
		}
	}
}
