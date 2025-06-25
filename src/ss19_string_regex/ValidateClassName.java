package ss19_string_regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateClassName {

    public static boolean validateClassName(String className) {
        String pattern = "^[CAP]\\d{4}[GHIK]$";
        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(className);
        return matcher.matches();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập tên lớp học (VD: C0223G, A0323K): ");
        String className = sc.nextLine();
        boolean isValid = validateClassName(className);
        System.out.println(isValid);
    }
}