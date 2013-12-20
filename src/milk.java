import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


/*
ID: kennyk61
LANG: JAVA
PROG: milk
*/

class MilkSupply implements Comparable<MilkSupply>{
	int supply;
	int price;
	public MilkSupply(int price, int supply) {
		this.price = price;
		this.supply = supply;
	}

	@Override
	public int compareTo(MilkSupply o) {
		return this.price - o.price;
	}
	
}

public class milk {
	
	public static int calculateMinPrice(ArrayList<MilkSupply> milkSupplies, int n){
		int price = 0;
		int vol = 0;
		for (MilkSupply ms : milkSupplies) {
			if ((n - vol) > ms.supply) {
				vol += ms.supply;
				price += ms.price * ms.supply;
			} else {
				price += ms.price * (n - vol);
				vol += (n-vol);
				break;
			}
		}
		return price;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new FileReader("milk.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		ArrayList<MilkSupply> milkSupplies = new ArrayList<MilkSupply>();
		for (int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int price = Integer.parseInt(st.nextToken());
			int supply = Integer.parseInt(st.nextToken());
			milkSupplies.add(new MilkSupply(price, supply));
		}
		Collections.sort(milkSupplies);
		
		int price = calculateMinPrice(milkSupplies, n);
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk.out")));
		out.println(price);
		out.close();
		br.close();
		System.exit(0);
	}

}
