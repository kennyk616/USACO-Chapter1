import java.io.*;

/*
ID: kennyk61
LANG: JAVA
PROG: beads
*/
public class beads {

	public static int maxBeads(int n, char[] seq) {
		int maxBeads = 0;
		for (int i = 0; i < n; i++) {
			int total = findSameSequence(seq, n, i, 1) + findSameSequence(seq, n, nextIdx(i, n, -1), -1);
			if (total > maxBeads) {
				maxBeads = total;
			}
		}
		if (maxBeads > n) {
			return n;
		}
		return maxBeads;
	}
	
	public static int findSameSequence(char[] seq, int n, int idx, int increment) {
		int curIdx = idx;
		char curChar = seq[curIdx];
		int count = 0;
		char nextChar = curChar;
		while ((curChar == nextChar || nextChar =='w') && (count < n)) {
			count ++;
			int nextIdx = nextIdx(curIdx, n, increment);
			nextChar = seq[nextIdx];
			if (curChar == 'w' && nextChar != curChar) {
				curChar = nextChar;
			}
			curIdx = nextIdx;
		}
		return count;
	}
	
	public static int nextIdx(int idx, int n, int increment) {
		int next = idx + increment;
		if (next == -1) {
			return n-1;
		}else if (next == n) {
			return 0;
		}else {
			return next;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new FileReader("beads.in"));
		int n = Integer.parseInt(br.readLine());
		char[] beadSeq = br.readLine().toCharArray();
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
		out.println(maxBeads(n, beadSeq));
		out.close();
		br.close();
		System.exit(0);
	}

}
