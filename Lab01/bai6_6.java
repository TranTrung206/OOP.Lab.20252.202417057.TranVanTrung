package bai6_6;
import java.util.Scanner;

public class bai6_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Nhap so hang: ");
        int r = sc.nextInt();
        System.out.print("Nhap so cot: ");
        int c = sc.nextInt();
        
        int[][] matrix1 = new int[r][c];
        int[][] matrix2 = new int[r][c];
        int[][] sum = new int[r][c];
        
        System.out.println("Nhap ma tran 1:");
        for(int i=0; i<r; i++) 
            for(int j=0; j<c; j++) matrix1[i][j] = sc.nextInt();
            
        System.out.println("Nhap ma tran 2:");
        for(int i=0; i<r; i++) 
            for(int j=0; j<c; j++) matrix2[i][j] = sc.nextInt();
            
        System.out.println("Ket qua cong 2 ma tran:");
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                sum[i][j] = matrix1[i][j] + matrix2[i][j];
                System.out.print(sum[i][j] + "\t");
            }
            System.out.println();
        }
        sc.close();
    }
}