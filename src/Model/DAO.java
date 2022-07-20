package Model;

import java.io.*;
import java.util.Scanner;

public class DAO {

	private String separator;
	private File srcFile;
	private  File destFile;

	private Scanner in;
	private BufferedWriter out;
	private final int totalLines;

	public DAO(String src, String dst, String separator) {
		try {
			this.totalLines = calculateTotalines(src);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		try {
			this.separator = separator;
			this.srcFile = new File(src);
			this.destFile = new File(dst);

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

		for (String value : values) {
			r.addValue(value);
		}
		return r;
	}

	public void writeLine(Row r) {
		StringBuilder newLine = new StringBuilder();

		for (int i = 0; i < r.getColumns(); i++) {
			newLine.append(r.getPos(i)).append(separator);
		}
		newLine.append("\n");
		try {
			out.write(newLine.toString());
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

	private int calculateTotalines(String src) throws IOException {
		try (InputStream is = new BufferedInputStream(new FileInputStream(src))) {
			byte[] c = new byte[1024];
			int count = 0;
			int readChars;
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
		}
	}
}
