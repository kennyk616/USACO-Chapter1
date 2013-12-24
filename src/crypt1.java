import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;



/*
ID: kennyk61
LANG: JAVA
PROG: crypt1
*/
public class crypt1 {
	
	public static int calculateNumSolutions(int[] digits, int n) {
		ArrayList<Integer> topNumber = new ArrayList<Integer>();
		ArrayList<Integer> botNumber = new ArrayList<Integer>();
		for (int i = 0; i<n; i++){
			for (int j = 0; j<n; j++) {
				if(digits[i]>0){
					botNumber.add(digits[i]*10 + digits[j]);
				}
				for (int k = 0; k<n; k++) {
					if(digits[i]>0) {
						topNumber.add(digits[i]*100 + digits[j]*10 + digits[k]);
					}
				}
			}
		}
		
		return getNSolutions(digits, n, topNumber, botNumber);
	}
	
	public static boolean inDigits(int[] digits, int val){
		for (int i = 0; i<digits.length; i++){
			if (digits[i]==val) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean satisfyDigits(int val, int[] digits) {
		int div = val;
		int rem = val%10;
		while (div > 0){
			rem = div%10;
			div = div/10;
			if (!inDigits(digits, rem)){
				return false;
			}
		}
		return true;
	}
	
	public static int getNSolutions(int[] digits, int n, ArrayList<Integer> topNumbers, ArrayList<Integer> botNumbers) {
		int nSolutions = 0;
		for (int top : topNumbers) {
			for (int bot : botNumbers) {
				int product = top*bot;
				if (product/10000 > 0 || !satisfyDigits(product, digits)) { //product has 5 digits or doesn't satisfy digits
					continue;
				}
				
				int firstPartial = (bot%10)*top;
				if (firstPartial/1000 > 0 || !satisfyDigits(firstPartial, digits)) { //first partial has 4 digits or doesn't satisfy digits
					continue;
				}
				
				int secondPartial = (bot/10)*top;
				if (secondPartial/1000 > 0 || !satisfyDigits(secondPartial, digits)) { //second partial has 4 digits or doesn't satisfy digits
					continue;
				}
				nSolutions ++;
			}
		}
		
		return nSolutions;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new FileReader("crypt1.in"));
		int n = Integer.parseInt(br.readLine());
		int[] digits = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i ++) {
			digits[i] = Integer.parseInt(st.nextToken());
		}
		
		int nSolutions = calculateNumSolutions(digits, n);
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("crypt1.out")));
		out.println(nSolutions);
		System.out.println(nSolutions);
		
		br.close();
		out.close();
	}

}
