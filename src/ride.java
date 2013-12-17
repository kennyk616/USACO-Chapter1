import java.io.*;

/*
ID: kennyk61
LANG: JAVA
PROG: ride
*/
public class ride {

	public static String goOrStay(String group, String comet) {
		int groupVal = 1;
		int cometVal = 1;
		for (int i = 0; i < group.length(); i++) {
			groupVal *= (group.charAt(i)-'A' + 1);
		}
		for (int j = 0; j < comet.length(); j++) {
			cometVal *= (comet.charAt(j) - 'A' + 1);
		}
		if ((groupVal%47)==(cometVal%47)) {
			return "GO";
		}
		return "STAY";
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new FileReader("ride.in"));
		String group = br.readLine();
		String comet = br.readLine();
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
		out.println(goOrStay(group, comet));
		out.close();
		br.close();
		System.exit(0);
	}

}
