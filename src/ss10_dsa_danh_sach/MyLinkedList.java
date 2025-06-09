package ss10_dsa_danh_sach;

public class MyLinkedList<E> {
    private Node head;
    private int numNodes = 0;

    public MyLinkedList() {
        this.head = null;
    }

    public void addFirst(E e) {
        Node temp = new Node(e);
        temp.setNext(head);
        numNodes++;
    }

    public void addLast(E e) {
        Node temp = new Node(e);
        if (head == null) {
            head = temp;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(temp);
        }
        numNodes++;
    }

    public void add(int index, E element) {
        if (index == 0) {
            addFirst(element);
        } else {
            Node temp = head;
            for (int i = 0; i < index - 1 && temp != null; i++) {
                temp = temp.getNext();
            }
            Node holder = temp.getNext();
            Node newNode = new Node(element);
            temp.setNext(newNode);
            newNode.setNext(holder);
            numNodes++;
        }
    }

    public E remove(int index) {
        if (index < 0 || index >= numNodes) return null;
        Node temp = head;
        E removedData;
        if (index == 0) {
            removedData = (E) head.getData();
            head = head.getNext();
        } else {
            for (int i = 0; i < index - 1; i++) {
                temp = temp.getNext();
            }
            removedData = (E) temp.getNext().getData();
            temp.setNext(temp.getNext().getNext());
        }
        numNodes--;
        return removedData;
    }

    public boolean remove(Object o) {
        if (head == null) return false;
        if (head.getData().equals(o)) {
            head = head.getNext();
            numNodes--;
            return true;
        }
        Node temp = head;
        while (temp.getNext() != null) {
            if (temp.getNext().getData().equals(o)) {
                temp.setNext(temp.getNext().getNext());
                numNodes--;
                return true;
            }
            temp = temp.getNext();
        }
        return false;
    }

    public int size() {
        return numNodes;
    }

    public E get(int index) {
        if (index < 0 || index >= numNodes) return null;
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
        return (E) temp.getData();
    }

    public E getFirst() {
        if (head == null) return null;
        return (E) head.getData();
    }

    public E getLast() {
        if (head == null) return null;
        Node temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        return (E) temp.getData();
    }

    public boolean contains(E o) {
        Node temp = head;
        while (temp != null) {
            if (temp.getData().equals(o)) {
                return true;
            }
            temp = temp.getNext();
        }
        return false;
    }

    public int indexOf(E o) {
        Node temp = head;
        int index = 0;
        while (temp != null) {
            if (temp.getData().equals(o)) {
                return index;
            }
            temp = temp.getNext();
            index++;
        }
        return -1;
    }

    public void clear() {
        head = null;
        numNodes = 0;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.getData() + " ");
            temp = temp.getNext();
        }
        System.out.println();
    }

    public MyLinkedList clone() {
        MyLinkedList clone = new MyLinkedList<>();
        Node temp = head;
        while (temp != null) {
            clone.addLast((E) temp.getData());
            temp = temp.getNext();
        }
        return clone;
    }

    public boolean add(E e) {
        addLast(e);
        return true;
    }
}
