package batch;

import java.io.File;
import java.io.IOException;

import org.json.simple.JSONObject;

import _openddr.OpenDDR;
import _uadetector.UADetector;
import _wurfl.Wurfl;
import batch.common.Reader;
import batch.common.Timer;
import batch.common.Writer;
import batch.dao.MasterLog;

public class R_DG_01_010 {

	public static void main(String[] args) throws IOException {
		
		File[] files = Reader.readFolder("log");
		
		Timer totalTime = new Timer();
		totalTime.startTimer();

		Timer timer = new Timer();
		
		timer.startTimer();
		Wurfl wurfl = new Wurfl();
		UADetector uaDetector = new UADetector();
		OpenDDR openDDR = new OpenDDR();
		timer.currentTime("UAReaders Init");

		Writer writer = new Writer("output.csv");
		writer.write("o_model,o_device,w_model,w_device,u_device, raw");

		for(File file : files){
			
			Reader reader = new Reader(file.getPath());
			JSONObject jo = reader.readLineAsJSON();

			int count = 0;
			double timeReadUA = 0;

			while(jo!=null){
				MasterLog masterLog = new MasterLog(jo); 
				String ua = masterLog.getAgent();
				
				timer.startTimer();
				wurfl.read(ua);
				uaDetector.read(ua);
				openDDR.read(ua);
				timeReadUA += timer.currentTime();

				StringBuilder sb = new StringBuilder();
				sb.append(openDDR.get("model") + "\t")
				  .append(openDDR.get("isMobile")+openDDR.get("isTablet")+"\t")
				  .append(wurfl.get("model_name") + "\t")
				  .append(wurfl.get("is_wireless_device")+wurfl.get("is_tablet")+"\t")
				  .append(uaDetector.get("DeviceCategory") + "\t")
				  .append(ua);
				writer.write(sb.toString());

				jo = reader.readLineAsJSON();
				count++;
			}

			System.out.println("Time for read(ua): " + timeReadUA);
			totalTime.currentTime("Total Time for " + count + " logs");
		}
		writer.close();
	}
}
