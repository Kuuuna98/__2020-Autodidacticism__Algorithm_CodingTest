package codingTest;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    
    public static void main(String args[]) throws IOException{
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int a_number = sc.nextInt();
      int b_number= sc.nextInt();
      
      System.out.println(game_round(n,a_number,b_number));

      
    }
    
    private static int game_round(int n, int a_number, int b_number) {
    	int round;
    	int next_a_num = a_number/2 + a_number%2;
    	int next_b_num = b_number/2 + b_number%2;
    	
    	if(next_a_num==next_b_num) return 1;
    	round = 1+game_round(n/2+n%2, next_a_num, next_b_num);
    	return round;
    }
}