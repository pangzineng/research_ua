package batch.filter;

import java.util.List;

import batch.dao.IPRepository;

public class BlacklistFilter {

	IPRepository ipRepo;
	
	List<String> botIP;
	List<String> botUA;
	
	List<String> blacklistIP;
	
	public BlacklistFilter() {
		// pre-load 
		
		
	}
	
	public boolean detectIP(){
		
		
		
		return true;
	}
}
