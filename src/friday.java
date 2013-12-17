import java.io.*;
import java.util.ArrayList;

/*
ID: kennyk61
LANG: JAVA
PROG: friday
*/
public class friday {
	final static int startYear = 1900;
	
	private class Date{
		final int[] daysInMonth = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int month;
		int day;
		int year;
		public Date(int year, int month, int day){
			this.year = year;
			this.month = month;
			this.day = day;
		}
		
		public int calculateDay(){
			int d = 365* (year - startYear) + numLeapYears();
			for (int i = 0; i<month; i++){
				d += daysInMonth[i];
			}
			if (isLeapYear(this.year) && this.month > 1){
				d ++;
			}
			d += day;
			return d;
		}
		
		private boolean isLeapYear(int year) {
			if (year%100 == 0) {
				if (year%400 == 0) {
					return true;
				}
			} else if (year%4 == 0){
				return true;
			}
			return false;
		}
		
		private int numLeapYears() {
			int count = 0;
			for (int i = 1900; i<year; i++){
				if (isLeapYear(i)){
					count ++;
				}
			}
			return count;
		}
	}
	
	
	public static int[] calculateFreq(int n) {
		friday f = new friday();
		ArrayList<Integer> allDays = new ArrayList<Integer>();
		for (int y = startYear; y<startYear + n; y++){
			for (int m = 0; m < 12; m++){
				friday.Date date = f.new Date(y, m, 13);
				int num = date.calculateDay();
				allDays.add(num);
			}
		}
		int[] freq = new int[7];
		for (int i:allDays){
			int val = i%7;
			freq[val] ++;
		}
		return freq;
		
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new FileReader("friday.in"));
		int n = Integer.parseInt(br.readLine());
		int[] freq = calculateFreq(n);
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
		out.print(freq[6] + " ");
		for (int i = 0; i<5; i++){
			out.print(freq[i] + " ");
		}
		out.println(freq[5]);
		out.close();
		br.close();
		System.exit(0);
	}

}
