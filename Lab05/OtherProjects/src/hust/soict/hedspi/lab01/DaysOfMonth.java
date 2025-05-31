package month;
import java.util.Scanner;
public class DaysOfMonth {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int year = 0;
		int month = 0;
		boolean isValid = false;
		while(!isValid) {
			System.out.println("Enter a year (e.g., 2005): ");
			if(input.hasNextInt()) {
				year = input.nextInt();
				if(year >= 0) {
					isValid = true;
				} else {
					System.out.println("Invalid year! Please re-enter a valid year.");
				}
			} else {
				System.out.println("Invalid input! Please re-enter a valid year.");
				input.next();
			}
		}
		isValid = false;
		while(!isValid) {
			System.out.println("Enter a month (e.g., January, Jan., Jan, or 1): ");
			String monthInput = input.next().toLowerCase();
			switch(monthInput) {
			case "january" : case "jan." : case "jan" : case "1" : 
				month = 1;
				isValid = true;
				break;
			case "february" : case "feb." : case "feb" : case "2" :
				month = 2;
				isValid = true;
				break;
			case "march" : case "mar." : case "mar" : case "3" :
				month = 3;
				isValid = true;
				break;
			case "april" : case "apr." : case "apr" : case "4" :
				month = 4;
				isValid = true;
				break;
			case "may" : case "5" :
				month = 5;
				isValid = true;
				break;
			case "june" : case "jun" : case "6" :
				month = 6;
				isValid = true;
				break;
			case "july" : case "jul" : case "7" :
				month = 7;
				isValid = true;
				break;
			case "august" : case "aug." : case "aug" : case "8" :
				month = 8;
				isValid = true;
				break;
			case "september" : case "sept." : case "sep" : case "9" :
				month = 9;
				isValid = true;
				break;
			case "october" : case "oct." : case "oct" : case "10" :
				month = 10;
				isValid = true;
				break;
			case "november" : case "nov." : case "nov" : case "11" :
				month = 11;
				isValid = true;
				break;
			case "december" : case "dec." : case "dec" : case "12" :
				month = 12;
				isValid = true;
				break;
			default :
				System.out.println("Invalid month! Please re-enter a valid ones.");
				break;
			}
		}
		int daysInMonth = getDaysInMonth(month, year);
		System.out.println("Number of days in chosen month: " + daysInMonth);
		input.close();
	}
	public static int getDaysInMonth(int month, int year) {
		switch (month) {
		case 4: case 6: case 9: case 11: 
			return 30;
		case 2:
			return isLeapYear(year) ? 29 : 28;
		default:
			return 31;
		}
	}
	public static boolean isLeapYear(int year) {
		if((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
			return true;
		} else {
			return false;
		}
	}
}
