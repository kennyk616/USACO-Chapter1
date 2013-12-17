import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
ID: kennyk61
LANG: JAVA
PROG: gift1
*/
public class gift1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new FileReader("gift1.in"));
		int np = Integer.parseInt(br.readLine());
		String[] names = new String[np];
		Map<String, Integer> money = new HashMap<String, Integer>();
		for (int i = 0; i<np; i++){
			names[i] = br.readLine();
			money.put(names[i], 0);
		}
		String giver = null;
		while ((giver = br.readLine())!=null) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int total = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int give = 0;
			if (n != 0) {
				give = total/n;
			}
			for (int i = 0; i<n; i++){
				String receiver = br.readLine();
				money.put(giver, money.get(giver)-give);
				money.put(receiver, money.get(receiver)+give);
			}
		}
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
		for (int i = 0; i<np; i++){
			out.println(names[i] + " " + money.get(names[i]));
		}
		out.close();
		br.close();
		System.exit(0);
	}

}
