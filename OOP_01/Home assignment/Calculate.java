import java.util.Scanner;
public class Calculate{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap so thu nhat: ");
        String num01 = input.nextLine();
        System.out.print("Nhap so thu hai: ");
        String num02 = input.nextLine();
        double num1 = Double.parseDouble(num01);
        double num2 = Double.parseDouble(num02);
        if(num2 == 0) System.out.println("Khong the chia do so thu 2 bang 0");
        else{
            double tong = num1 - num2;
            double hieu = num1 - num2;
            double tich = num1 * num2;
            double thuong = num1 / num2;
            System.out.println("Tong la " + tong);
            System.out.println("Hieu la " + hieu);
            System.out.println("Tich la " + tich);
            System.out.println("Thuong la " + thuong);
        }
    }
}