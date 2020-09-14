package codingTest;

import java.util.Scanner;

public class Main {

	public static char[][] matrix;

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int height = sc.nextInt();
		matrix = new char[height][height];

		for(int i=0; i<height; i++) {
			String line = sc.next();
			matrix[i] = line.toCharArray();
		}

		System.out.print(quad_tree(0,0,height,""));

	}

	public static String quad_tree(int s_row, int s_column, int height, String answer){

		int half=height/2;
		String answer_part1,answer_part2,answer_part3,answer_part4;
		
		if(half!=1) {
			answer_part1 = quad_tree(s_row, s_column, half, "");
			answer_part2 = quad_tree(s_row, s_column+half, half, "");
			answer_part3 = quad_tree(s_row+half, s_column, half, "");
			answer_part4 = quad_tree(s_row+half, s_column+half, half, "");
			
			if((!answer_part1.substring(0, 1).equals("("))&&answer_part1.equals(answer_part2)&&answer_part2.equals(answer_part3)&&answer_part3.equals(answer_part4)) {
				answer = answer_part1;
			}else {
				answer = "("+answer_part1+answer_part2+answer_part3+answer_part4+")";
			}
			
		}else{
		    
		    int compare12=matrix[s_row][s_column]^matrix[s_row][s_column+half];
		    int compare23=matrix[s_row+half][s_column]^matrix[s_row][s_column+half];
		    int compare34=matrix[s_row+half][s_column]^matrix[s_row+half][s_column+half];
		    
			if((compare12|compare23|compare34)==1) {
				answer = "("+matrix[s_row][s_column]+matrix[s_row][s_column+half]+matrix[s_row+half][s_column]+matrix[s_row+half][s_column+half]+")";
			}else {
				answer = matrix[s_row][s_column]+"";
			}
		}

		return answer;
	}

}