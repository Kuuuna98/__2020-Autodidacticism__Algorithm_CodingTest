package codingTest;

import java.util.Scanner;

public class Main {

	public static int[][] arr;
	public static char[] encrytion;

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int height = sc.nextInt();
		String line = sc.next();
		encrytion = line.toCharArray();
		arr = new int[height][height];

		quad_tree(0,0,0,height);
		print(height);

	}

	public static int quad_tree(int s_row, int s_column, int target_idx, int height){
		int r,c;

		for(int count=0; count<4; count++) {

			switch(count) {
			case 0:
				r = s_row;
				c = s_column;
				break;
			case 1:
				r = s_row;
				c = s_column+height;
				break;
			case 2:
				r = s_row+height;
				c = s_column;
				break;
			default:
				r = s_row+height;
				c = s_column+height;
				break;
			}

			if(encrytion[target_idx]=='Q') {
				target_idx = quad_tree(r, c, target_idx+1, height/2);
				if(encrytion.length <= target_idx) break;

			}else {
				int input = encrytion[target_idx]=='W'? 0:1;
				for( int i=r; i<r+height ; i++) {
					for( int j=c; j<c+height; j++) {
						arr[i][j] = input;
					}
				}
				target_idx++;
			}

		}

		return target_idx;
	}

	public static void print(int height){


		System.out.println("#define quadtree_width "+height);
		System.out.println("#define quadtree_height "+height);
		System.out.println("static char quadtree_bits[] = {");

		for(int i=0; i<height; i++){
			binaryTohex(arr[i], height);
		}


		System.out.println("};");

	}

	public static void binaryTohex(int[] arr, int height){
		int number = 0;
		int idx=0;
		String hexS;

		for(int i=0; i<height/8; i++){

			hexS = "";
			
			for(int j=0; j<2;j++) {
				number = (int) (arr[idx] + arr[idx+1]*Math.pow(2,1) + arr[idx+2]*Math.pow(2,2) +arr[idx+3]*Math.pow(2,3));
			
				switch(number) {
				case 10:
					hexS = "a"+hexS;
					break;
				case 11:
					hexS = "b"+hexS;
					break;
				case 12:
					hexS = "c"+hexS;
					break;
				case 13:
					hexS = "d"+hexS;
					break;
				case 14:
					hexS = "e"+hexS;
					break;
				case 15:
					hexS = "f"+hexS;
					break;
				default:
					hexS = number+hexS;
					break;
				}
				
				idx+=4;
			}
			
			System.out.print("0x"+hexS+",");
		}
		System.out.println();
	}
}