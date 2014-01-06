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
		parse(agent);
		/*	for(Map.Entry<String, String> map : parse(agent).entrySet()){
			System.out.println(map.getValue() + "\t\t\t: " + map.getKey());
		}*/
	}
	
	@Override
	public String get(String name){
		return map.get(name);
	}

	private Map<String, String> parse(ReadableUserAgent agent){
		map.clear();
		map.put("agent.getIcon()", agent.getIcon());
		map.put("agent.getName()", agent.getName());
		map.put("agent.getProducer()", agent.getProducer());
		map.put("agent.getProducerUrl()", agent.getProducerUrl());
		map.put("agent.getTypeName()", agent.getTypeName());
		map.put("agent.getUrl()", agent.getUrl());
		map.put("agent.getDeviceCategory()", agent.getDeviceCategory().getName());
		map.put("agent.getFamily()", agent.getFamily().getName());
		map.put("agent.getOperatingSystem().getFamilyName()", agent.getOperatingSystem().getFamilyName());
		map.put("agent.getOperatingSystem().getName()", agent.getOperatingSystem().getName());
		map.put("agent.getOperatingSystem().getProducer()", agent.getOperatingSystem().getProducer());
		map.put("agent.getOperatingSystem().getProducerUrl()", agent.getOperatingSystem().getProducerUrl());
		map.put("agent.getOperatingSystem().getUrl()", agent.getOperatingSystem().getUrl());
		map.put("agent.getType()", agent.getType().getName());
		map.put("agent.getVersionNumber()", agent.getVersionNumber().toVersionString());
		return map;
	}
}
