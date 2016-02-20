package io.github.daschner.Xye.data.types;

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
	

}
