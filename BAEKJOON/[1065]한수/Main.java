package codingTest;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String args[]) throws IOException{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(calculator(n));
	}

	private static int calculator(int n) {
		int answer=0;
		int hundreds,tens,units;
		if(n<100) return n;

		answer=99;

		for(hundreds=1; hundreds<10; hundreds++) {
			if(n < hundreds*100) break;
			for(units=hundreds%2; units<10; units+=2) {
				tens = hundreds+(units-hundreds)/2;
				if(hundreds*100+tens*10+units < n) answer++;
				else break;
			}
		}

		return answer;
	}
}