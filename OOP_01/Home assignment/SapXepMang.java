import java.util.Arrays;
import java.util.Scanner;

public class SapXepMang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Nhap so phan tu cua mang: ");
        int n = scanner.nextInt();
        int[] mang = new int[n];

        System.out.println("Nhap cac phan tu cua mang:");
        for (int i = 0; i < n; i++) {
            mang[i] = scanner.nextInt();
        }

        Arrays.sort(mang);
        
        int tong = 0;
        for (int num : mang) {
            tong += num;
        }
        double trungBinh = (double) tong / n;

        System.out.println("Mang sau khi sap xep: " + Arrays.toString(mang));
        System.out.println("Tong cac phan tu: " + tong);
        System.out.println("Gia tri trung binh: " + trungBinh);

        scanner.close();
    }
}
