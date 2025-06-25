package ss16_text_file;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SaoChepTapTin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập đường dẫn tệp nguồn: ");
        String duongDanNguon = scanner.nextLine();

        System.out.print("Nhập đường dẫn tệp đích: ");
        String duongDanDich = scanner.nextLine();

        File tepNguon = new File(duongDanNguon);
        File tepDich = new File(duongDanDich);

        if (!tepNguon.exists()) {
            System.out.println("Tệp nguồn không tồn tại.");
            return;
        }

        if (tepDich.exists()) {
            System.out.println("Tệp đích đã tồn tại. Không ghi đè.");
            return;
        }

        int soKyTu = 0;

        try (
                FileReader doc = new FileReader(tepNguon);
                FileWriter ghi = new FileWriter(tepDich)
        ) {
            int kyTu;
            while ((kyTu = doc.read()) != -1) {
                ghi.write(kyTu);
                soKyTu++;
            }

            System.out.println("Sao chép thành công!");
            System.out.println("Tổng số ký tự đã sao chép: " + soKyTu);

        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi: " + e.getMessage());
        }
    }
}
