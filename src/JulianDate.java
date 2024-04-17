import java.io.BufferedReader;
import java.net.SecureCacheResponse;
import java.time.MonthDay;
import java.util.Scanner;

public class JulianDate {
	
	int start = 0;
	int year = 0;
	int month=0;
	int day= 0;
	double JT = 0;

	BufferedReader inputReader;
	private static Scanner scanner=new Scanner(System.in);
		
	

	public static void main(String[] args) {

		System.out.print("Hi, what is the year of your Birthday?  ");
		int year =scanner.nextInt();
		System.out.print("...and the month of your Birthday?  ");
		int month=scanner.nextInt();
		System.out.print("Finally, what is the day of your Birthday?  ");
		int day = scanner.nextInt();
		
		JulianDate julianDate = new JulianDate();
		JulianDate currentJD = new JulianDate();
		
		currentJD.convertToJd(2023, 6, 7);
		julianDate.convertToJd(year, month, day);
		
		double difference =  currentJD.JT - julianDate.JT;
		String weekDay = julianDate.weekdayFinder(julianDate.JT);
		
		System.out.print("You are "+difference+" days old. You were born on a "+ weekDay+".");
		/*
		JulianDate convertDate = new JulianDate();
		convertDate.convertToJd(2023, 6, 7);
		System.out.println(convertDate);
		*/
	}
	public double convertToJd(int year, int month, int day) {
		JT = 367 * year - (7 * (year + (month + 9) / 12)) / 4 + (275 * month) / 9 + day + 1721013.5;
		return JT;
		
	}
	

	 
	public String weekdayFinder(double jd) {
        int weekdayNumber = (int) ((jd + 0.5) % 7); // Adjusted Julian Day
        String[] weekdays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        return weekdays[weekdayNumber];
    }
	public String toString() {
	        return "Julian Date: " + JT;
	    }

}
