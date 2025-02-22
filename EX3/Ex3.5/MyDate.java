

public class MyDate {
private int month;
private int year;
private int day;
public static final String []MONTHS= {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
public static final String []DAYS= {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
public static final int []DAYSINMONTHS= {31,28,31,30,31,30,31,31,30,31,30,31};
public boolean isLeapYear(int year)
{
	if((year%400==0)||(year%4==0&&year%100!=0))
	{
		return true;
	}
	return false;
}
public boolean isValidDate(int day,int month, int year)
{
	 if (year < 1 || year > 9999 || month < 1 || month > 12 || day < 1) {
	        return false;
	    }
	   
	    if (month == 2) {
	        if (isLeapYear(year)) {
	            return day <= 29; 
	        } else {
	            return day <= 28; 
	        }
	    }
	    return day <= DAYSINMONTHS[month - 1];
}
public MyDate(int day,int month,int year) throws IllegalArgumentException{
	setDate(day,month,year);
}
public int getDayOfWeek() {
	
	    int m = (month < 3) ? month + 12 : month;
	    int y = (month < 3) ? year - 1 : year;
	    int K = y % 100;
	    int J = y / 100; 
	    int h = (day + (13 * (m + 1)) / 5 + K + (K / 4) + (J / 4) + (5 * J)) % 7;
	    return (h + 6) % 7; 
	
}

public void setDate(int day,int month, int year) throws IllegalArgumentException
{
	if(isValidDate(day, month, year)==false)
	{
		 throw new IllegalArgumentException("Invalid year, month, or day!");
	}
	this.month = month;
	this.year = year;
	this.day = day;
}
public int getMonth() {
	return month;
}
public void setMonth(int month) {
	this.month = month;
}
public int getYear() {
	return year;
}
public void setYear(int year) {
	this.year = year;
}
public int getDay() {
	return day;
}
public void setDay(int day) {
	this.day = day;
}
public String toString()
{  int i=getDayOfWeek();
    int j=this.month;
	return DAYS[i]+" " + this.day+" "+MONTHS[j-1]+" " +this.year;
}
public MyDate nextDay()
{
	 if (isValidDate(day + 1, month, year)) {
	        day++;
	    } else {
	        day = 1;
	        if (month == 12) {
	            month = 1;
	            year++;
	        } else {
	            month++;
	        }
	    }
  return this;
}

public MyDate previousDay() {
    if (day > 1) {
        day--;
    } else {
        if (month == 1) {
            month = 12;
            year--;
            day = DAYSINMONTHS[month - 1];
        } else {
            month--;
            day = (month == 2 && isLeapYear(year)) ? 29 : DAYSINMONTHS[month - 1];
        }
    }
    return this;
}

public MyDate nextMonth() {
    if (month == 12) {
        month = 1;
        year++;
    } else {
        month++;
    }
    day = Math.min(day, (month == 2 && isLeapYear(year)) ? 29 : DAYSINMONTHS[month - 1]);
    return this;
}

public MyDate previousMonth() {
    if (month == 1) {
        month = 12;
        year--;
    } else {
        month--;
    }
    day = Math.min(day, (month == 2 && isLeapYear(year)) ? 29 : DAYSINMONTHS[month - 1]);
    return this;
}

public MyDate nextYear() {
    year++;
    if (month == 2 && day == 29 && !isLeapYear(year)) {
        day = 28;
    
    }
    return this;
}

public MyDate previousYear() {
    year--;
    if (month == 2 && day == 29 && !isLeapYear(year)) {
        day = 28;
    }
    return this;
}


}
