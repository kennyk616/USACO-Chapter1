import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
ID: kennyk61
LANG: JAVA
PROG: milk2
*/

class MilkTime implements Comparable<MilkTime> {
	int start;
	int end;
	public MilkTime(int start, int end) {
		this.start = start;
		this.end = end;
	}
	@Override
	public int compareTo(MilkTime other) {
		return this.start - other.start;
	}
}

public class milk2 {

	public static int[] getLongestTimes(MilkTime[] times, int n){
		int longestIdle = 0;		
		int beginTime = times[0].start;
		int endTime = times[0].end;
		int longestContinuous = endTime - beginTime;
		for (int i = 1; i < n; i++) {
			int diff = times[i].start - endTime;
			if (diff > 0) {
				int length = endTime - beginTime;
				if (length > longestContinuous) {
					longestContinuous = length;
				}
				if (diff > longestIdle) {
					longestIdle = diff;
				}
				beginTime = times[i].start;
				endTime = times[i].end;
			} else {
				if (times[i].end > endTime) {
					endTime = times[i].end;
				}
			}
		}
		return new int[]{longestContinuous, longestIdle};
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new FileReader("milk2.in"));
		int n = Integer.parseInt(br.readLine());
		MilkTime[] times = new MilkTime[n];
		for (int i = 0; i < n; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			times[i] = new MilkTime(start, end);
		}
		Arrays.sort(times);
		int[] longestTimes = getLongestTimes(times, n);
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
		String s = longestTimes[0] + " " + longestTimes[1];
		// System.out.println(s);
		out.println(s);
		out.close();
		br.close();
		System.exit(0);
	}

}
