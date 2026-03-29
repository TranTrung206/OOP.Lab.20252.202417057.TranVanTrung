package EquationSolver;
import java.util.Scanner;
public class EquationSolver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. (ax + b = 0)");
        System.out.println("2. He bac nhat 2 an");
        System.out.println("3. (ax^2 + bx + c = 0)");
        int chon = sc.nextInt();
        
        if (chon == 1) {
            System.out.print("Nhap a: "); double a = sc.nextDouble();
            System.out.print("Nhap b: "); double b = sc.nextDouble();
            if (a == 0) {
                if (b == 0) System.out.println("Phuong trinh vo so nghiem");
                else System.out.println("Phuong trinh vo nghiem");
            } else {
                System.out.println("Nghiem x = " + (-b / a));
            }
        } 
        else if (chon == 2) {
            System.out.println("Nhap a11, a12, b1: ");
            double a11 = sc.nextDouble(); double a12 = sc.nextDouble(); double b1 = sc.nextDouble();
            System.out.println("Nhap a21, a22, b2: ");
            double a21 = sc.nextDouble(); double a22 = sc.nextDouble(); double b2 = sc.nextDouble();
            
            double D = a11 * a22 - a21 * a12;
            double D1 = b1 * a22 - b2 * a12;
            double D2 = a11 * b2 - a21 * b1;
            
            if (D != 0) {
                System.out.println("Nghiem: x1 = " + (D1/D) + ", x2 = " + (D2/D));
            } else {
                if (D1 == 0 && D2 == 0) System.out.println("He vo so nghiem");
                else System.out.println("He vo nghiem");
            }
        }
        else if (chon == 3) {
            System.out.print("Nhap a, b, c: ");
            double a = sc.nextDouble(); double b = sc.nextDouble(); double c = sc.nextDouble();
            if (a == 0) {
                if (b == 0) System.out.println(c == 0 ? "Vo so nghiem" : "Vo nghiem");
                else System.out.println("x = " + (-c / b));
            } else {
                double delta = b * b - 4 * a * c;
                if (delta > 0) {
                    double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                    double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                    System.out.println("x1 = " + x1 + ", x2 = " + x2);
                } else if (delta == 0) {
                    System.out.println("Nghiem kep x = " + (-b / (2 * a)));
                } else {
                    System.out.println("Phuong trinh vo nghiem");
                }
            }
        }
        sc.close();
    }
}