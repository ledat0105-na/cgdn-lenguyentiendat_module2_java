package ss11_stack_queue;

import java.util.Scanner;
import java.util.Stack;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số thập phân: ");
        int number = scanner.nextInt();

        if (number == 0) {
            System.out.println("Nhị phân: 0");
            return;
        }

        Stack<Integer> stack = new Stack<>();

        while (number > 0) {
            int remainder = number % 2;
            stack.push(remainder);
            number = number / 2;
        }

        System.out.print("Nhị phân: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}
