package bai6_4;
import java.util.Scanner;

public class bai6_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int month = 0, year = 0;
        
        while (true) {
            System.out.print("Nhap thang: ");
            String mInput = sc.next();
            System.out.print("Nhap nam: ");
            if (sc.hasNextInt()) {
                year = sc.nextInt();
                if (year < 0) continue;
                if (mInput.equals("1") || mInput.startsWith("Jan")) month = 1;
                else if (mInput.equals("2") || mInput.startsWith("Feb")) month = 2;
                else month = Integer.parseInt(mInput);
                
                if (month >= 1 && month <= 12) break;
            }
            sc.nextLine();
        }

        int days = 31;
        if (month == 4 || month == 6 || month == 9 || month == 11) days = 30;
        else if (month == 2) {
            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) days = 29;
            else days = 28;
        }
        System.out.println("So ngay: " + days);
        sc.close();
    }
}