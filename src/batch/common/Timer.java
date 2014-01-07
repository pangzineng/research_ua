package batch.common;

/**
 * @author zineng.pang
 *
 */
public class Timer {

	public enum TimeType{
		second, minute, hour, day
	}
	
	private double start;
	
	public Timer() {
		start = -1;
	}
	
	public void startTimer(){
		start = System.currentTimeMillis();
	}
	

	public void currentTime(String msg) {
		System.out.println(currentTime() + " : " + msg);
	}
	
	/**
	 * get currentTime as second
	 * @return the second pass as timer started, with 5 decimal
	 */
	public double currentTime(){
		return currentTime(TimeType.second);
	}
	
	public double currentTime(TimeType type){
		if(start<0) return start;
		double elapsedTimeMillis = System.currentTimeMillis()-start;
		switch(type){
		case second:
			return elapsedTimeMillis/1000;
		case minute:
			return elapsedTimeMillis/(60*1000);
		case hour:
			return elapsedTimeMillis/(60*60*1000);
		case day:
			return elapsedTimeMillis/(24*60*60*1000);
		default:
			return -1;
		}
	}
}
