package _wurfl;

import batch.common.UAReader;
import net.sourceforge.wurfl.core.CustomWURFLHolder;
import net.sourceforge.wurfl.core.Device;
import net.sourceforge.wurfl.core.WURFLHolder;
import net.sourceforge.wurfl.core.WURFLManager;

public class Wurfl implements UAReader {

	private static String path = "file:///C:/Users/pang.zineng/git/research_ua/wurfl/";
	private WURFLHolder wurflHolder;
	private WURFLManager manager;
	private Device device;
	
	public Wurfl() {
		wurflHolder = new CustomWURFLHolder(path + "wurfl.xml");
		manager = wurflHolder.getWURFLManager();
	}

	@Override
	public void read(String ua) {
		//String ua = "Mozilla/5.0 (iPad; CPU OS 5_1_1 like Mac OS X) AppleWebKit/534.46 (KHTML, like Gecko) CriOS/29.0.1547.11 Mobile/9B206 Safari/7534.48.3";
		device = manager.getDeviceForRequest(ua);
	}

	@Override
	public String get(String name) {
		/**
		 * Capability
		 * http://wurfl.sourceforge.net/help_doc.php#product_info
			System.out.println(device.getCapability("brand_name"));
			System.out.println(device.getCapability("model_name"));
			System.out.println(device.getCapability("marketing_name"));
			System.out.println(device.getCapability("is_wireless_device"));
			System.out.println(device.getCapability("is_tablet"));
			System.out.println(device.getCapability("device_os"));
			System.out.println(device.getCapability("device_os_version"));
			System.out.println(device.getCapability("mobile_browser"));
			System.out.println(device.getCapability("mobile_browser_version"));
		 * */  
		return device.getCapability(name);
	}

}
