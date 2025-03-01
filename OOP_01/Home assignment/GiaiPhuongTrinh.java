import java.util.Scanner;

public class GiaiPhuongTrinh {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Giai phuong trinh bac nhat mot an: ax + b = 0");
        System.out.print("Nhap a: ");
        double a = scanner.nextDouble();
        System.out.print("Nhap b: ");
        double b = scanner.nextDouble();
        
        if (a == 0) {
            if (b == 0) {
                System.out.println("Phuong trinh co vo so nghiem.");
            } else {
                System.out.println("Phuong trinh vo nghiem.");
            }
        } else {
            double x = -b / a;
            System.out.println("Nghiem cua phuong trinh la: x = " + x);
        }
        
        System.out.println("\nGiai he phuong trinh bac nhat hai an:");
        System.out.println("He phuong trinh co dang:");
        System.out.println("a11 * x1 + a12 * x2 = b1");
        System.out.println("a21 * x1 + a22 * x2 = b2");

        System.out.print("Nhap a11: ");
        double a11 = scanner.nextDouble();
        System.out.print("Nhap a12: ");
        double a12 = scanner.nextDouble();
        System.out.print("Nhap b1: ");
        double b1 = scanner.nextDouble();
        System.out.print("Nhap a21: ");
        double a21 = scanner.nextDouble();
        System.out.print("Nhap a22: ");
        double a22 = scanner.nextDouble();
        System.out.print("Nhap b2: ");
        double b2 = scanner.nextDouble();
        
        double D = a11 * a22 - a21 * a12;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;
        
        if (D != 0) {
            double x1 = D1 / D;
            double x2 = D2 / D;
            System.out.println("He co nghiem duy nhat: x1 = " + x1 + ", x2 = " + x2);
        } else {
            if (D1 == 0 && D2 == 0) {
                System.out.println("He phuong trinh co vo so nghiem.");
            } else {
                System.out.println("He phuong trinh vo nghiem.");
            }
        }
        
        scanner.close();
    }
}
