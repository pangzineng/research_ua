package batch.common;


public class Timer {

	public enum TimeType{
		second, minute, hour, day
	}
	
	private long start;
	
	public Timer() {
		start = -1;
	}
	
	public void startTimer(){
		start = System.currentTimeMillis();
	}
	
	public void currentTime(){
		currentTime(TimeType.second);
	}
	
	public long currentTime(TimeType type){
		if(start<0) return start;
		long elapsedTimeMillis = System.currentTimeMillis()-start;
		switch(type){
		case second:
			return elapsedTimeMillis/1000L;
		case minute:
			return elapsedTimeMillis/(60*1000L);
		case hour:
			return elapsedTimeMillis/(60*60*1000L);
		case day:
			return elapsedTimeMillis/(24*60*60*1000L);
		default:
			return -1;
		}
	}
}
