package codingTest;

import java.util.Scanner;

public class Main {
    
    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      int count = sc.nextInt();
      int[][] zero_one = new int[41][2];
      int N=1;
      
      zero_one[0][0]=1;
      zero_one[0][1]=0;
      zero_one[1][0]=0;
      zero_one[1][1]=1;
      
      for(int idx=0; idx<count; idx++){
          int number = sc.nextInt();
          if(N < number){
              for(int i=N+1; i<=number; i++){
                  zero_one = fibonacci_num(i,zero_one);
              }
          }
          System.out.println(zero_one[number][0]+" "+zero_one[number][1]);
        }
      }
      
      public static int[][] fibonacci_num(int idx, int[][] arr){
          arr[idx][0] = arr[idx-2][0] + arr[idx-1][0]; 
          arr[idx][1] = arr[idx-2][1] + arr[idx-1][1];
          return arr;
      }
}