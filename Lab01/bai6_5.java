package bai6_5;
import java.util.Arrays;
import java.util.Scanner;
public class bai6_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);     
        System.out.print("Nhap so luong phan tu cua mang: ");
        int n = sc.nextInt();
        double[] arr = new double[n];
        System.out.println("Nhap cac phan tu cua mang:");
        for (int i = 0; i < n; i++) {
            System.out.print("Phan tu [" + i + "]: ");
            arr[i] = sc.nextDouble();
        }
        Arrays.sort(arr);
        double sum = 0;
        for (double x : arr) {
            sum += x;
        }
        System.out.println("Mang sau khi sap xep: " + Arrays.toString(arr));
        System.out.println("Tong cac phan tu: " + sum);
        System.out.println("Trung binh cong: " + (sum / n));
        sc.close();
    }
}