import java.util.Scanner;

public class Main {

	public static int[][] quadtree;
	public static char[] encrytion;

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int height = Integer.parseInt(sc.nextLine().split(" ")[2]);
		
		String[][] quadtree_hex=new String[height][height/8];
		quadtree= new int[height][height];;
		sc.nextLine(); sc.nextLine();

		for(int line=0; line<height; line++) {
			String[] line_bits = sc.next().split(",");
			for(int idx=0; idx<height/8; idx++) {
				quadtree_hex[line][idx]=line_bits[idx];
			}
		}

		quad_tree(quadtree_hex, height);

		System.out.println(height);
		System.out.println(encryption_quad_tree(0,0,height,""));

	}


	public static void quad_tree(String[][] quadtree_hex, int height) {

		for(int row=0; row<height; row++) {
			for(int column=0; column<height/8; column++) {
			  	hexTobinary(quadtree_hex[row][column].substring(2, 3),row,column*8+4);
				hexTobinary(quadtree_hex[row][column].substring(3, 4),row,column*8);
			}
		}

		return;
	}
	private static void hexTobinary(String target, int s_row, int s_column) {
		int num;

		switch(target) {
		case "a":
			num=10;
			break;
		case "b":
			num=11;
			break;
		case "c":
			num=12;
			break;
		case "d":
			num=13;
			break;
		case "e":
			num=14;
			break;
		case "f":
			num=15;
			break;
		default:
			num=Integer.parseInt(target);
			break;
		}
		quadtree[s_row][s_column+3]=num/8;
		quadtree[s_row][s_column+2]=num%8/4;
		quadtree[s_row][s_column+1]=num%8%4/2;
		quadtree[s_row][s_column]=num%8%4%2;

		return ;
	}
	public static String encryption_quad_tree(int s_row, int s_column, int height, String answer){

		int half=height/2;
		String answer_part1,answer_part2,answer_part3,answer_part4;

		if(half!=1) {
			answer_part1 = encryption_quad_tree(s_row, s_column, half, "");
			answer_part2 = encryption_quad_tree(s_row, s_column+half, half, "");
			answer_part3 = encryption_quad_tree(s_row+half, s_column, half, "");
			answer_part4 = encryption_quad_tree(s_row+half, s_column+half, half, "");

			if((!answer_part1.substring(0, 1).equals("Q"))&&answer_part1.equals(answer_part2)&&answer_part2.equals(answer_part3)&&answer_part3.equals(answer_part4)) {
				answer = answer_part1;
			}else {
				answer = "Q"+answer_part1+answer_part2+answer_part3+answer_part4;
			}

		}else{

			int compare12=quadtree[s_row][s_column]^quadtree[s_row][s_column+half];
			int compare23=quadtree[s_row+half][s_column]^quadtree[s_row][s_column+half];
			int compare34=quadtree[s_row+half][s_column]^quadtree[s_row+half][s_column+half];

			if((compare12|compare23|compare34)==1) {
				char left_top = quadtree[s_row][s_column]==1? 'B':'W';
				char right_top = quadtree[s_row][s_column+half]==1? 'B':'W';
				char left_bottom = quadtree[s_row+half][s_column]==1? 'B':'W';
				char right_bottom = quadtree[s_row+half][s_column+half]==1? 'B':'W';

				answer = "Q"+left_top+right_top+left_bottom+right_bottom; 
			}else {
				char left_top = quadtree[s_row][s_column]==1? 'B':'W';
				answer = left_top+"";
			}
		}

		return answer;
	}
}