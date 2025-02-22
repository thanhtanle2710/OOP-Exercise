

public class TestMyDate {
public static void main(String[] args) {
	MyDate d1 = new MyDate(28, 2, 2012);
	System.out.println(d1);             // Tuesday 28 Feb 2012
	System.out.println(d1.nextDay());   // Wednesday 29 Feb 2012
	System.out.println(d1.nextDay());   // Thursday 1 Mar 2012
	System.out.println(d1.nextMonth()); // Sunday 1 Apr 2012
	System.out.println(d1.nextYear());  // Monday 1 Apr 2013

	MyDate d2 = new MyDate(2, 1, 2012);
	System.out.println(d2);                 // Monday 2 Jan 2012
	System.out.println(d2.previousDay());   // Sunday 1 Jan 2012
	System.out.println(d2.previousDay());   // Saturday 31 Dec 2011
	System.out.println(d2.previousMonth()); // Wednesday 30 Nov 2011
	System.out.println(d2.previousYear());  // Tuesday 30 Nov 2010

	MyDate d3 = new MyDate(29, 2, 2012);
	System.out.println(d3.previousYear());  // Monday 28 Feb 2011

	
}
}
