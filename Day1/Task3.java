package Day1;

public class Task3 {
	public static boolean leapyear(int year) {

		return(year % 4==0 && year %100 !=0)||( year % 400==0);

	}

	public static void main(String args[]) {

		int year=2024;

		if(leapyear(year)) {

		System.out.println("this is leap year");}

		else {

			System.out.println("this is not leap year");

		}

	}
}
