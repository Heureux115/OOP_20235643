import java.util.Scanner;

public class CongMaTran {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Nhap so hang cua ma tran: ");
        int hang = scanner.nextInt();
        System.out.print("Nhap so cot cua ma tran: ");
        int cot = scanner.nextInt();
        
        int[][] maTran1 = new int[hang][cot];
        int[][] maTran2 = new int[hang][cot];
        int[][] ketQua = new int[hang][cot];

        System.out.println("Nhap ma tran thu nhat:");
        for (int i = 0; i < hang; i++) {
            for (int j = 0; j < cot; j++) {
                maTran1[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Nhap ma tran thu hai:");
        for (int i = 0; i < hang; i++) {
            for (int j = 0; j < cot; j++) {
                maTran2[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < hang; i++) {
            for (int j = 0; j < cot; j++) {
                ketQua[i][j] = maTran1[i][j] + maTran2[i][j];
            }
        }

        System.out.println("Ma tran ket qua sau khi cong:");
        for (int i = 0; i < hang; i++) {
            for (int j = 0; j < cot; j++) {
                System.out.print(ketQua[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
