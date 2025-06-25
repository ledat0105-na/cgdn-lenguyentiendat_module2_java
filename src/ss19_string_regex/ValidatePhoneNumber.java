package ss19_string_regex;

import java.util.Scanner;

public class ValidatePhoneNumber {
    public static boolean validatePhoneNumber(String phoneNumber) {
        String regexPhoneNumber = "^\\(\\d{2}\\)-\\(0\\d{9}\\)$";
        return phoneNumber.matches(regexPhoneNumber);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Định dạng số điện thoại hợp lệ: (xx)-(0xxxxxxxxx)");
        System.out.print("Nhập số điện thoại: ");
        String phoneNumber = sc.nextLine();

        boolean isValid = validatePhoneNumber(phoneNumber);
        System.out.println(isValid);
    }
}
