package fanalyze.utilities;

import java.time.Year;
import java.time.YearMonth;

public class SystemUtils {
	
	public static int getCurrentYearMinValue() {
		int year = Year.now().getValue();
		int month = (YearMonth.now().getMonth()).getValue();
		
		int returnValue = 0;
		if (month >= 9) 
			returnValue = year;
		else 
			returnValue = year - 1;
		
		return returnValue;
	}
	
	public static int getCurrentYearMaxValue() {
		int year = Year.now().getValue();
		int month = (YearMonth.now().getMonth()).getValue();
		
		int returnValue;
		if (month < 9) 
			returnValue = year;
		else 
			returnValue = year + 1;
		
		return returnValue;
	}
	
	public static int guessCurrentWeek() {
		return 0;
	}

}
