import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class Date {
	private int day;
	private int month;
	private int year;
	public Date(int day, int month, int year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		if(day>=1&&day<=31)
		this.day = day;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		if(month>=1&&month<=12)
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		if(year>=1900&&year<=9999)
		this.year = year;
	}
	public void setDate(int day,int month,int year)
	{
		setDay(day);
		setMonth(month);
		setYear(year);
	}
	@Override
	public String toString() {
		LocalDate localDate=LocalDate.of(getYear(),getMonth(),getDay());
		return localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
}
