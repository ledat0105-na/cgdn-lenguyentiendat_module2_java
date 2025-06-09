package ss10_dsa_danh_sach;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.addFirst("C");
        list.addLast("D");
        list.addFirst("B");
        list.add(0, "A");

        System.out.print("Danh sách hiện tại: ");
        list.printList();
        System.out.println("Danh sách có chứa phần tử 'C' không? " + list.contains("C"));
        System.out.println("Vị trí của phần tử 'D': " + list.indexOf("D"));

        list.remove("B");

        System.out.print("Danh sách sau khi xóa 'B': ");
        list.printList();    // A C D

        System.out.println("Danh sách sao chép:");
        MyLinkedList<String> clone = list.clone();
        clone.printList();
    }
}
