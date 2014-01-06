package batch;

import java.io.IOException;

import org.json.simple.JSONObject;

import batch.common.Reader;
import batch.dao.MasterLog;

public class R_DG_01_010 {

	public static void main(String[] args) throws IOException {
		String targetDate = "201401010105"; // yyyyMMddHHmm
		
		Reader reader = new Reader(targetDate);
		JSONObject jo = reader.readLineAsJSON();
		while(jo!=null){
			MasterLog masterLog = new MasterLog(jo); 
			String ua = masterLog.getAgent();
			// TODO process
			jo = reader.readLineAsJSON();
		}
		
	}
}
