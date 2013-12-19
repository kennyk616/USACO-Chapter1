import java.io.*;
import java.util.ArrayList;


/*
ID: kennyk61
LANG: JAVA
PROG: palsquare
*/

class valPair {
	String val;
	String square;
	public valPair(String val, String square) {
		this.val = val;
		this.square = square;
	}
}
public class palsquare {
	
	static ArrayList<valPair> palSquares = new ArrayList<valPair>();
	
	public static String convertBaseN(int val, int n) {
		StringBuffer sb = new StringBuffer();
		int div = val;
		int rem = 0;
		while(div >0) {
			rem = div%n;
			div = div/n;
			if(rem < 10) {
				sb.append(rem);
			}else {
				char ch = (char)('A' + (rem-10));
				sb.append(ch);
			}
		}
		return new String(sb.reverse());
	}
	
	
	
	public static boolean isPalindrome(String string) {	
		for (int i = 0; i<string.length()/2; i++) {
			if (string.charAt(i) != string.charAt(string.length()-1-i)){
				return false;
			}
		}
		return true;
	}
	
	public static void populatePalSquares(int n) {
		for (int i = 1; i <= 300; i++ ) {
			int square = i * i;
			String square_string = convertBaseN(square, n);
			if(isPalindrome(square_string)){
				palSquares.add(new valPair(convertBaseN(i, n), square_string));
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new FileReader("palsquare.in"));
		int n = Integer.parseInt(br.readLine());
		populatePalSquares(n);
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
		for (valPair vp : palSquares) {
			out.println(vp.val + " " + vp.square);
		}
		out.close();
		br.close();
		System.exit(0);
	}

}
