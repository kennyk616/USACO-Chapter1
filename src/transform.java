import java.io.*;
import java.util.Arrays;


/*
ID: kennyk61
LANG: JAVA
PROG: transform
*/
public class transform {

	public static int getTransform(char[][] before, char[][] after, int n) {
		char[][] transform = transform90(before, n);
		if (Arrays.deepEquals(transform, after)){
			return 1;
		}
		
		char[][] transform2 = transform90(transform, n);
		if (Arrays.deepEquals(transform2, after)) {
			return 2;
		}
		
		char[][] transform3 = transform90(transform2, n);
		if (Arrays.deepEquals(transform3, after)) {
			return 3;
		}
		
		char[][] reflection = reflect(before, n);
		if (Arrays.deepEquals(reflection, after)){
			return 4;
		}
		
		if (isCombo(before, after, n)) {
			return 5;
		}
		
		if (Arrays.deepEquals(before, after)) {
			return 6;
		}

		return 7;
	}
	
	public static boolean isCombo(char[][] before, char[][] after, int n){
		char[][] reflection = reflect(before, n);
		if (Arrays.deepEquals(transform90(reflection, n), after)){
			return true;
		}
		if (Arrays.deepEquals(transform90(transform90(reflection, n), n), after)) {
			return true;
		}
		if (Arrays.deepEquals(transform90(transform90(transform90(reflection, n), n), n), after)){			
			return true;
		}
		return false;
	}
	
	public static char[][] reflect(char[][] before, int n) {
		char[][] after = new char[n][n];
		for (int i = 0; i<n; i++){
			for (int j = 0; j<n; j++){
				after[i][j] = before[i][n-1-j];
			}
		}
		return after;
	}
	
	public static char[][] transform90(char[][] before, int n) {
		char[][] after = new char[n][n];
		for (int i = 0; i<n; i++) {
			for (int j = 0; j<n; j++){
				after[j][n-i-1] = before[i][j];
			}
		}
		return after;
	}
	
	public static void print(char[][] grid, int n) {
		for (int i = 0; i<n; i++){
			System.out.println(new String(grid[i]));
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new FileReader("transform.in"));
		int n = Integer.parseInt(br.readLine());
		char[][] before = new char[n][n];
		for (int i = 0; i < n; i++) {
			before[i] = br.readLine().toCharArray();
		}
		
		char[][] after = new char[n][n];
		for (int i = 0; i<n; i++) {
			after[i] = br.readLine().toCharArray();
		}
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
		int val = getTransform(before, after, n);
		out.println(val);
		out.close();
		br.close();
		System.exit(0);
	}

}
