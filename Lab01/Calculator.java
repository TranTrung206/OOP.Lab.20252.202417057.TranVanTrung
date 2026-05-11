package Calculator;
import java.util.Scanner;
public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so thu nhat: ");
        String s1 = sc.nextLine();
        double a = Double.parseDouble(s1);
        System.out.print("Nhap so thu hai: ");
        String s2 = sc.nextLine();
        double b = Double.parseDouble(s2);
        System.out.println("Tong: " + (a + b));
        System.out.println("Hieu: " + (a - b));
        System.out.println("Tich: " + (a * b));
        if (b != 0) {
            System.out.println("Thuong: " + (a / b));
        } else {
            System.out.println("Khong the chia cho so 0");
        }
        
        sc.close();
    }
}