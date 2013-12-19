package _openddr;

import java.io.FileInputStream;
import java.util.Properties;

import org.openddr.simpleapi.oddr.ODDRService;
import org.openddr.simpleapi.oddr.model.ODDRHTTPEvidence;
import org.w3c.ddr.simple.Evidence;
import org.w3c.ddr.simple.PropertyRef;
import org.w3c.ddr.simple.PropertyValue;
import org.w3c.ddr.simple.PropertyValues;
import org.w3c.ddr.simple.Service;
import org.w3c.ddr.simple.ServiceFactory;
import org.w3c.ddr.simple.exception.NameException;

public class Main {

	private static Service service = null;

	public static void main(String[] args) {
		System.out.println("Initialize filter");
		Properties properties = new Properties();

		try {
		    properties.load(new FileInputStream("src/oddr.properties"));
		    service = ServiceFactory.newService("org.openddr.simpleapi.oddr.ODDRService", 
		    		properties.getProperty(ODDRService.ODDR_VOCABULARY_IRI), properties);
		} catch (Exception ex) {
		    throw new RuntimeException(ex);
		}

		PropertyRef vendorRef;
		PropertyRef modelRef;
		PropertyRef isMobile;
		PropertyRef isTablet;
	
		try {
		    vendorRef = service.newPropertyRef("vendor");
		    modelRef = service.newPropertyRef("model");
		    isMobile = service.newPropertyRef("is_wireless_device");
		    isTablet = service.newPropertyRef("is_tablet");
	
		} catch (NameException ex) {
		    throw new RuntimeException(ex);
		}
	
		PropertyRef[] propertyRefs = new PropertyRef[] {vendorRef, modelRef, isMobile, isTablet};
		Evidence e = new ODDRHTTPEvidence();
		String ua = "Mozilla/5.0%20(iPad;%20CPU%20OS%205_1_1%20like%20Mac%20OS%20X)%20AppleWebKit/534.46%20(KHTML,%20like%20Gecko)%20CriOS/29.0.1547.11%20Mobile/9B206%20Safari/7534.48.3";
		e.put("User-Agent", ua);
	
		try {
		    PropertyValues propertyValues = service.getPropertyValues(e, propertyRefs);
		    for(PropertyRef property : propertyRefs){
		    	PropertyValue value = propertyValues.getValue(property);
		    	if(value.exists()){
		    		System.out.println(value.getPropertyRef().getLocalPropertyName() + ": " + value.getString());
		    	} else {
		    		System.out.println(value.getPropertyRef().getLocalPropertyName() + ": --");
		    	}
		    }
		} catch (Exception ex) {
		    throw new RuntimeException(ex);
		}
	
    }
	

}
