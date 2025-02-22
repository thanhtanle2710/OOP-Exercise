
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class MyTime {
private int hour=0;
private int minute=0;
private int second=0;
public MyTime() {
}
public MyTime(int hour, int minute, int second) {
	setTime(hour, minute, second);
}
public void setTime(int hour, int minute, int second) throws IllegalArgumentException
{   
	if (hour < 0 || hour > 23 || minute < 0 || minute > 59 || second < 0 || second > 59)
		throw new IllegalArgumentException("Invalid hour, minute, or second!");
		this.hour=hour;
		this.minute=minute;
		this.second=second;
	
}
public int getHour() {
	return hour;
}
public void setHour(int hour) {
	this.hour = hour;
}
public int getMinute() {
	return minute;
}
public void setMinute(int minute) {
	this.minute = minute;
}
public int getSecond() {
	return second;
}
public void setSecond(int second) {
	this.second = second;
}
@Override
public String toString() {
  LocalTime localTime= LocalTime.of(hour, minute, second);
  return localTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
	 
}
public MyTime nextSecond()
{
	this.second++;
	if(this.second==60)
	{    this.second=0;
		this.minute++;
		 if(this.minute==60)
		{
			this.minute=0;
			this.hour++;
			 if(this.hour==24)
				{
					this.hour=0;
				}
		}
		
	}
	
	return this;
}
public MyTime nextMinute()
{
	this.minute++;
	   
		 if(this.minute==60)
		{
			this.minute=0;
			this.hour++;
			 if(this.hour==24)
				{
					this.hour=0;
				}
		
		
	}
	
	return this;
}
public MyTime nextHour()
{
	this.hour++;
    if(this.hour==24)
	{
	this.hour=0;
	}
	return this;
}
public MyTime previousSecond()
{
	this.second--;
	if(this.second==-1)
	{
		this.second=59;
		this.minute--;
		if(this.minute==-1)
		{
			this.minute=59;
			this.hour--;
			if(this.hour==-1)
			{
				this.hour=23;
			}
			
		}
		
	}
	return this;
}
public MyTime previousMinute()
{
	this.minute--;
	
		if(this.minute==-1)
		{
			this.minute=59;
			this.hour--;
			if(this.hour==-1)
			{
				this.hour=23;
			}
			
		}
		
	
	return this;
}
public MyTime previousHour()
{
	this.hour--;
	
		
			if(this.hour==-1)
			{
				this.hour=23;
			}
			
		
		
	
	return this;
}






}
