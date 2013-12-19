import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


/*
ID: kennyk61
LANG: JAVA
PROG: dualpal
*/
public class dualpal {

	static ArrayList<Integer> pals = new ArrayList<Integer>();
	
	public static void populatePals(int n, int s) {
		int nPals = 0;
		int val = s+1;
		while (nPals <n){
			int count = 0;
			for (int i = 2; i<=10; i++) {
				if (isPalindrome(convertBaseN(val, i))) {
					count++;
					if (count==2) {
						pals.add(val);
						nPals++;
						break;
					}
				}
			}
			val++;
		}
	}
	
	public static boolean isPalindrome(String string) {	
		for (int i = 0; i<string.length()/2; i++) {
			if (string.charAt(i) != string.charAt(string.length()-1-i)){
				return false;
			}
		}
		return true;
	}
	
	public static String convertBaseN(int val, int n) {
		StringBuffer sb = new StringBuffer();
		int div = val;
		int rem = 0;
		while(div >0) {
			rem = div%n;
			div = div/n;
			sb.append(rem);
		}
		return new String(sb.reverse());
	}
	
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new FileReader("dualpal.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		populatePals(n, s);
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));
		for (int pal : pals) {
			out.println(pal);
		}
		out.close();
		br.close();
		System.exit(0);
	}

}
