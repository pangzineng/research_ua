package batch.common;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {
	
	FileWriter fw;
	BufferedWriter bw;
	private String newline;
	
	public Writer(String filePath) throws IOException {
		fw = new FileWriter(filePath);
		bw = new BufferedWriter(fw);
		newline = System.lineSeparator();
	}
	
	public void write(String line) throws IOException {
		bw.write(line + newline);
	}
	
	public void close() throws IOException {
		bw.close();
		fw.close();
	}
}
