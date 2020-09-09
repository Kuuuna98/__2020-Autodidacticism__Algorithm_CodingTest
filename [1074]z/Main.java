package codingTest;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		int c = sc.nextInt();
		
		int idx = -1;
		int height = (int)Math.pow(2, n);
		
		System.out.println(z(height,k,c,idx)+1);
	}
	
	public static int z(int height, int k, int c, int idx) {
		
		int row,column,mini_size=0;
		if(height < 2) return idx;
		height = height/2;
		
		row = k/height;
		column= c/height;
		mini_size = (int)Math.pow(height, 2);
		
		if(row==0) {
			if(column==0) {
				idx += mini_size*0;
			}else {
				idx += mini_size*1;
			}
		}else {
			if(column==0) {
				idx += mini_size*2;
			}else {
				idx += mini_size*3;
			}
		}
		
		k %= height;
		c %= height;
		
		return z(height,k,c,idx);
	}
	
}