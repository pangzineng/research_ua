package _uadetector;

import java.util.HashMap;
import java.util.Map;

import batch.common.UAReader;
import net.sf.uadetector.ReadableUserAgent;
import net.sf.uadetector.UserAgentStringParser;
import net.sf.uadetector.service.UADetectorServiceFactory;

public class UADetector implements UAReader {

	private UserAgentStringParser parser;
	private Map<String, String> map;
	
	public UADetector() {
		parser = UADetectorServiceFactory.getResourceModuleParser();
		map = new HashMap<String, String>();
	}

	@Override
	public void read(String ua) {
		//String ua = "Mozilla/5.0%20(iPad;%20CPU%20OS%205_1_1%20like%20Mac%20OS%20X)%20AppleWebKit/534.46%20(KHTML,%20like%20Gecko)%20CriOS/29.0.1547.11%20Mobile/9B206%20Safari/7534.48.3";
		
		ReadableUserAgent agent = parser.parse(ua);
		
		map.clear();
		map.put("Icon", agent.getIcon());
		map.put("Name", agent.getName());
		map.put("Producer", agent.getProducer());
		map.put("ProducerUrl", agent.getProducerUrl());
		map.put("TypeName", agent.getTypeName());
		map.put("Url", agent.getUrl());
		map.put("DeviceCategory", agent.getDeviceCategory().getName());
		map.put("Family", agent.getFamily().getName());
		map.put("OperatingSystem().getFamilyName", agent.getOperatingSystem().getFamilyName());
		map.put("OperatingSystem().getName", agent.getOperatingSystem().getName());
		map.put("OperatingSystem().getProducer", agent.getOperatingSystem().getProducer());
		map.put("OperatingSystem().getProducerUrl", agent.getOperatingSystem().getProducerUrl());
		map.put("OperatingSystem().getUrl", agent.getOperatingSystem().getUrl());
		map.put("Type", agent.getType().getName());
		map.put("VersionNumber", agent.getVersionNumber().toVersionString());
		/*	for(Map.Entry<String, String> map : parse(agent).entrySet()){
			System.out.println(map.getValue() + "\t\t\t: " + map.getKey());
		}*/
	}
	
	@Override
	public String get(String name){
		return map.get(name);
	}
}
