package ss11_stack_queue;

import java.util.Stack;
import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;

public class PalindromeQueue {
    public static boolean isPalindrome(String input) {
        String cleaned = input.replaceAll("[^a-zA-Z]", "").toLowerCase();

        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        for (char c : cleaned.toCharArray()) {
            stack.push(c);
            queue.offer(c);
        }

        while (!stack.isEmpty()) {
            if (stack.pop() != queue.poll()) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập chuỗi cần kiểm tra: ");
        String input = scanner.nextLine();

        if (isPalindrome(input)) {
            System.out.println("Đây là chuỗi Palindrome.");
        } else {
            System.out.println("Đây không phải là chuỗi Palindrome.");
        }
    }
}
