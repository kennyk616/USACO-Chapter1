import java.io.*;
import java.util.Arrays;



/*
ID: kennyk61
LANG: JAVA
PROG: calfflac
*/
public class calfflac {

	public static int findPal(char[] input, int lower, int higher, int max) {
		if (higher==input.length) return 0;
		int length = 0;
		for (int i = 0; i<=max; i++){
			if(higher+i>=input.length) break;
			if (input[lower-i]==input[higher+i]){
				length ++;
			}else{
				break;
			}
		}
		return length;
	}
	
	public static char[] getAlphabetOnly(char[] input) {
		char[] alphabetOnly = new char[input.length];
		int idx = 0;
		for (int i = 0; i < input.length; i++) {
			if (Character.isLetter(input[i])){
				alphabetOnly[idx] = Character.toLowerCase(input[i]);
				idx++;
			}
		}
		
		alphabetOnly = Arrays.copyOfRange(alphabetOnly, 0, idx);
		return alphabetOnly;
	}
	
	public static char[] truncateArray(char[] input) {
		for (int i = 0; i < input.length; i++) {
			if (input[i]=='\0'){
				return Arrays.copyOfRange(input, 0, i);
			}
		}
		return input;
	}
	
	public static int findIndex(char[] inputOrig, char[] input, int idx) {
		int i;
		int count = -1;
		for(i = 0; i<inputOrig.length; i++){
			if (Character.isLetter(inputOrig[i])){
				count ++;
				if(count==idx){
					break;
				}
			}
		}
		return i;
	}
	
	public static int findLowerIndex(char[] inputOrig, int center, int maxLength, int oddEven) {
		int i = center;
		int count = 0;
		for (i = center; i>=0; i--) {
			if(Character.isLetter(inputOrig[i])){
				count ++;
			}
			if (count == maxLength) {
				break;
			}
		}
		return i;
	}
	
	public static int findUpperIndex(char[] inputOrig, int center, int maxLength, int oddEven) {
		int start = center;
		int i;
		if (oddEven == 0) start++;
		int count = 0;
		for (i=start; i<inputOrig.length; i++){
			if(Character.isLetter(inputOrig[i])){
				count ++;
			}
			if (count == maxLength){
				break;
			}
		}
		return i;
	}
	
	public static void main(String[] args) throws IOException {

		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new FileReader("calfflac.in"));
		char[] inputOrig = new char[20000];
		br.read(inputOrig, 0, 20000);
		
		inputOrig = truncateArray(inputOrig);
		char[] input = getAlphabetOnly(inputOrig);
		
		int maxLength = 1;
		int centerIdx = 0;
		int oddEven = 1;
		
		for (int i = 0; i < input.length; i ++) {
			int possibleDeviation = Math.min(Math.min(999, i), input.length-1-i);
			int lengthOdd = findPal(input, i, i, possibleDeviation);
			int lengthEven = findPal(input, i, i+1, possibleDeviation);
			if (lengthOdd > maxLength) {
				maxLength = lengthOdd;
				centerIdx = i;
				oddEven = 1;
			}
			if (lengthEven > maxLength) {
				maxLength = lengthEven;
				centerIdx = i;
				oddEven = 0;
			}
		}
		
		int idxOrig = findIndex(inputOrig, input, centerIdx);
		int lowerIdx = findLowerIndex(inputOrig, idxOrig, maxLength, oddEven);
		int upperIdx = findUpperIndex(inputOrig, idxOrig, maxLength, oddEven);
		char[] longestPal = Arrays.copyOfRange(inputOrig, lowerIdx, upperIdx+1);
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("calfflac.out")));
		out.println(maxLength*2-oddEven);
		//System.out.println(maxLength*2-oddEven);
		out.println(new String(longestPal));
		//System.out.println(new String(longestPal));
		out.close();
		br.close();
		System.exit(0);
	}

}
