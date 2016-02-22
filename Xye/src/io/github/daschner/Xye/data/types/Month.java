package io.github.daschner.Xye.data.types;


/**
 * @author Mr. Daschner
 */
public enum Month {
	
	JANUARY(0), FEBRUARY(1), MARCH(2), 
	APRIL(3), MAY(4), JUNE(5), 
	JULY(6),AUGUST(7), SEPTEMBER(8), 
	OCTOBER(9), NOVEMBER(10), DECEMBER(11);
	
	@SuppressWarnings("unused")
	private int month;
	
	private Month(int month)
	{
		this.month = month;
	}
	
	/**
	 * Gets the amount of days in a given month.
	 * 
	 * @param month - The month of which the number of days is gotten from.
	 * @param year - The year to check on. This is used to calculate leap days in February.
	 * @return The amount of days in a month.
	 */
	
	public static int getDaysInMonth(Month month, int year) {
		
		if(month != null) {
		
		if(month == Month.JANUARY) {
			
			return 31;
			
		}
		else if(month == Month.FEBRUARY) {
			
			if(year % 4 == 0) {
				
				return 29;
				
			}
			else
			{
				
				return 28;
				
			}
			
		}
		else if(month == Month.MARCH) {
			
			return 31;
			
		}
		else if(month == Month.APRIL) {
			
			return 30;
			
		}
		else if(month == Month.MAY) {
			
			return 31;
			
		}
		else if(month == Month.JUNE) {
			
			return 30;
			
		}
		else if(month == Month.JULY) {
			
			return 31;
			
		}
		else if(month == Month.AUGUST) {
			
			return 31;
			
		}
		else if(month == Month.SEPTEMBER) {
			
			return 30;
			
		}
		else if(month == Month.OCTOBER) {
			
			return 31;
			
		}
		else if(month == Month.NOVEMBER) {
			
			return 30;
			
		}
		else if(month == Month.DECEMBER) {
			
			return 31;
			
		}
		else
		{
			
			return 30;
			
		}
		
		}
		else
		{
			
			return 30;
			
		}
		
	}

}
