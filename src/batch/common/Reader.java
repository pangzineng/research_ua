package batch.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Reader {

	private File logFile;
	private BufferedReader br;
	private InputStream fis;
	private JSONParser parser;
	
	static File[] readFolder(String dir){
		File logDir = new File(dir);
		return logDir.listFiles();
	}
	
	public Reader(String filePath) throws IOException{
		logFile = new File(filePath);
		fis = new FileInputStream(logFile);
		br = new BufferedReader(new InputStreamReader(fis, "UTF-8"));
		parser = new JSONParser();
	}
	
	public String readLine() throws IOException{
		String log = br.readLine();
		if(log==null) closeReader();
		return log;
	}
	
	public JSONObject readLineAsJSON() {
		try {
			String log = readLine();
			return (JSONObject) parser.parse(log);
		} catch (IOException | ParseException e) {
			//TODO Exception Handle
			closeReader();
			return null;
		}
	}

	
	private void closeReader() {
		try {
			br.close();
			fis.close();
		} catch (IOException e) {
			//TODO Exception Handle
		}
	}
}
