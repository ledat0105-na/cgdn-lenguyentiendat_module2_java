package ss11_stack_queue;

import java.util.Stack;

public class DaoNguocSoNguyen {
    public static void reverseArray(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            int currentElement = arr[i];
            stack.push(currentElement);
        }

        for (int i = 0; i < arr.length; i++) {
            int poppedElement = stack.pop();
            arr[i] = poppedElement;
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};

        System.out.println("Mảng ban đầu:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        reverseArray(arr);

        System.out.println("Mảng sau khi đảo ngược:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}