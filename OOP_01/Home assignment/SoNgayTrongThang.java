import java.util.Scanner;

public class SoNgayTrongThang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean nhapHopLe = false;

        while (!nhapHopLe) {
            System.out.print("Nhập tháng (tên đầy đủ, viết tắt 3 chữ cái hoặc số): ");
            String thangNhap = scanner.nextLine().trim().toLowerCase();

            int nam;
            do {
                System.out.print("Nhập năm (số không âm, đủ 4 chữ số, ví dụ: 1999): ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Định dạng năm không hợp lệ. Vui lòng nhập số nguyên dương, đủ 4 chữ số.");
                    scanner.next(); 
                }
                nam = scanner.nextInt();
                if (nam < 0) {
                    System.out.println("Năm phải là số không âm. Vui lòng nhập lại.");
                }
            } while (nam < 0);
            scanner.nextLine(); 

            String[] tenThang = {"tháng một", "tháng hai", "tháng ba", "tháng tư", "tháng năm", "tháng sáu", 
                                "tháng bảy", "tháng tám", "tháng chín", "tháng mười", "tháng mười một", "tháng mười hai"};
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
                System.out.println("Số ngày trong " + tenThang[thang] + " năm " + nam + " là: " + soNgayTrongThang[thang]);
            } else {
                System.out.println("Tháng không hợp lệ. Vui lòng nhập lại.");
            }
        }
        scanner.close();
    }
}