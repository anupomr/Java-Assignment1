import java.util.Scanner;
/*
 * Name: Anupom Roy
 * Student Id: 300853516
 * Assignment 01: Calender
 * */
public class Calendar
{
    public static int day(int month, int day, int year) 
    {
        int yearCode = year - (14 - month) / 12;
        int leapYearCode = yearCode + yearCode/4 - yearCode/100 + yearCode/400;
        int monthCode = month + 12 * ((14 - month) / 12) - 2;
        int startDay = (day + leapYearCode + (31*monthCode)/12) % 7;
        return startDay;
        
    }
    // LeapYear Checking  
    public static boolean isLeapYear(int year)
    {     
	    if ( ((year % 4 == 0) && (year % 100 != 0)) ||(year % 400 == 0)) 
	    return true;
	    return false;
    }
    
public static void main(String[] args)
{
	// Prompt the User to enter year and Month
	Scanner input= new Scanner (System.in);
	System.out.println("Enter the Year (e.g 2012) : ");
	int year = input.nextInt(); 
	System.out.println("Enter the Month between 1 and 12 : ");
	int month = input.nextInt();
 
	//String Array for Name of the months       
	String[] months = { "", "January", "February", "March",
            			"April", "May", "June",
            			"July", "August", "September",
            			"October", "November", "December"  };
        System.out.println("-------------------------------------------------------------");

        // days[i] = number of days in month i
        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        // condition for checking the leap year
        if (month == 2 && isLeapYear(year)) days[month] = 29;
        
        // Calendar Header 
        System.out.println("   " + months[month] + " " + year);
        System.out.println(" S  M Tu  W Th  F  S");

        // Starting day on a Month
        int d = day(month, 1, year);

        // Print the calendar
        for (int i = 0; i < d; i++)
        System.out.print("   ");
        for (int i = 1; i <= days[month]; i++) 
        {
        System.out.printf("%2d ", i);
            if (((i + d) % 7 == 0) || (i == days[month])) 
            	System.out.println();
        }
    }
}