import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


/*
ID: kennyk61
LANG: JAVA
PROG: namenum
*/
public class namenum {
	
	public static Set<String> dict;
	
	public static char[][] numPad = {
		{'A', 'B', 'C'},
		{'D', 'E', 'F'},
		{'G', 'H', 'I'},
		{'J', 'K', 'L'},
		{'M', 'N', 'O'},
		{'P', 'R', 'S'},
		{'T', 'U', 'V'},
		{'W', 'X', 'Y'}
	};
	
	public static ArrayList<String> names = new ArrayList<String>();
	
	public static void addWord(int[] indices, StringBuffer string) {
		if (string.length()==indices.length) {
			String word = string.toString();
			if (dict.contains(word)) {
				names.add(word);
			}
			return;
		}
		int idx = indices[string.length()];
		for (int i = 0; i < numPad[idx].length; i++) {
			addWord(indices, string.append(numPad[idx][i]));
			string.deleteCharAt(string.length()-1);
		}
	}
	
	public static void getNames(char[] number) {
		int [] indices = new int[number.length];
		for (int i = 0; i<number.length; i++){
			indices[i] = number[i]-'2';
		}	
		addWord(indices, new StringBuffer());
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new FileReader("namenum.in"));
		char[] number = br.readLine().toCharArray();
		
		BufferedReader dicReader = new BufferedReader(new FileReader("dict.txt"));
		dict = new HashSet<String>();
		String word = null;
		while((word = dicReader.readLine())!=null){
			dict.add(word);
		}
		
		getNames(number);
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
		for (String name : names) {
			out.println(name);
		}
		if (names.size()==0){
			out.println("NONE");
		}
		out.close();
		br.close();
		dicReader.close();
		System.exit(0);
	}

}
