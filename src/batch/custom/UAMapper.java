package batch.custom;

import java.util.HashMap;
import java.util.Map;

import batch.common.Constant.UAModel;

public class UAMapper {

	private Map<String, String> modelMap;
	
	public UAMapper() {
		//load pre-defined patterns
		modelMap = new HashMap<String, String>();
	}
	
	String getModel(String ua){
		
		// customized pattern mapping
		for(Map.Entry<String, String> model : modelMap.entrySet()){
			if(ua.contains(model.getKey())){
				return model.getValue();
			}
		}
		
		

		return UAModel.unknown.name();
	}
	
}
