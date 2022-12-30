package day2;

public class TimeTest {
	public static void main(String[] args) {
		int time = 32150;  // 초시간
		int hour = time/3600;
		int min = (time-hour*3600)/60;
		int sec = time-hour*3600-min*60;
		
		
		System.out.println(hour+"시간 "+min+"분 "+sec+"초 ");
		
		int time1 = 32150;
		int sec1 = time1%60;
	    int min1 = time1/60;
	    int hour1 = min1/60;
	    
	    min1 = min1 % 60;

		System.out.println(hour1+"시간 "+min1+"분 "+sec1+"초");
		
		int time2 = 32150;
		int hour2 = time2 / 3600;
		int min2 = time2 % 3600 / 60;
		int sec2 = time2 % 3600 % 60; 
		System.out.println(hour2+"시간 "+ min2 + "분 " + sec2 + "초");
	}
	
}
