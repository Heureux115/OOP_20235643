import java.util.Scanner;

public class SoNgayTrongThang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean nhapHopLe = false;

        while (!nhapHopLe) {
            System.out.print("Nhap thang (ten day du, viet tat 3 chu cai hoac so): ");
            String thangNhap = scanner.nextLine().trim().toLowerCase();

            int nam;
            do {
                System.out.print("Nhap nam (so khong am, du 4 chu so, vi du: 1999): ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Dinh dang nam khong hop le. Vui long nhap so nguyen duong, du 4 chu so.");
                    scanner.next(); 
                }
                nam = scanner.nextInt();
                if (nam < 0) {
                    System.out.println("Nam phai la so khong am. Vui long nhap lai.");
                }
            } while (nam < 0);
            scanner.nextLine(); 

            String[] tenThang = {"thang mot", "thang hai", "thang ba", "thang tu", "thang nam", "thang sau", 
                                "thang bay", "thang tam", "thang chin", "thang muoi", "thang muoi mot", "thang muoi hai"};
            String[] vietTatThang = {"jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec"};
            int[] soNgayTrongThang = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

            boolean laNamNhuan = (nam % 4 == 0 && nam % 100 != 0) || (nam % 400 == 0);
            if (laNamNhuan) {
                soNgayTrongThang[1] = 29;
            }

            int thang = -1;
            if (thangNhap.matches("\\d+")) {
                thang = Integer.parseInt(thangNhap) - 1;
            } else {
                for (int i = 0; i < tenThang.length; i++) {
                    if (thangNhap.equals(tenThang[i]) || thangNhap.equals(vietTatThang[i])) {
                        thang = i;
                        break;
                    }
                }
            }

            if (thang >= 0 && thang < 12) {
                nhapHopLe = true;
                System.out.println("So ngay trong " + tenThang[thang] + " nam " + nam + " la: " + soNgayTrongThang[thang]);
            } else {
                System.out.println("Thang khong hop le. Vui long nhap lai.");
            }
        }
    }
}
