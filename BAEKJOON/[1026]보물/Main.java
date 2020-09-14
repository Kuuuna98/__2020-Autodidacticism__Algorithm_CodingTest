package codingTest;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    
    public static void main(String args[]) throws IOException{
      Scanner sc = new Scanner(System.in);
      int count = sc.nextInt();
      int [][] a_sort = new int[count][2];
      int [][] b_sort= new int[count][2];
      
      
      for(int idx=0; idx<count; idx++) {
    	  a_sort[idx][0]=sc.nextInt();
    	  a_sort[idx][1]=idx;
      }
      
      for(int idx=0; idx<count; idx++) {
    	  b_sort[idx][0]=sc.nextInt();
    	  b_sort[idx][1]=idx;
      }
      
      a_sort=quickSort(a_sort,0,a_sort.length-1);
      b_sort=quickSort(b_sort,0,b_sort.length-1);
      
      System.out.println(sum_multiplyAB(a_sort,b_sort));
      
    }
    private static int sum_multiplyAB(int[][] A, int[][] B){
    	int sum=0;
    	
    	for(int idx=0; idx<A.length; idx++) {
    		sum += A[idx][0]*B[idx][0];
    	}
    	return sum;
    }
    private static int partition (int[][] arr, int p, int r) {

		int pivot = arr[r][0];
		int i = p-1;
		int j = p;
		int[] temp = new int[3];

		for(; j < r; j++) {

			if(arr[j][0] <= pivot ) {

				i++;
				temp=arr[j];
				arr[j]=arr[i];
				arr[i]=temp;
			}	
		}

		i++;

		temp=arr[j];
		arr[j]=arr[i];
		arr[i]=temp;


		return i;

	}

    private static int[][] quickSort (int[][] arr, int p, int r) {

		if(p >= r) return arr;

		int q = partition(arr,p,r);

		arr = quickSort(arr, p, q-1);
		arr = quickSort(arr, q+1, r);


		return arr;

	}
}