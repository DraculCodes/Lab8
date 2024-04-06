
    import java.util.*;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    class SinglyLinkedList {
        private Node head;

        SinglyLinkedList() {
            this.head = null;
        }

        void insert(int data) {
            Node newNode = new Node(data);
            if (this.head == null) {
                this.head = newNode;
            } else {
                Node temp = this.head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newNode;
            }
        }

        void moveNumbersWithDigit3(SinglyLinkedList list) {
            Node current = this.head;
            Node prev = null;
            while (current != null) {
                if (hasDigit3(current.data)) {
                    if (prev == null) {
                        this.head = current.next;
                    } else {
                        prev.next = current.next;
                    }
                    list.insert(current.data);
                    current = current.next;
                } else {
                    prev = current;
                    current = current.next;
                }
            }
        }

        private boolean hasDigit3(int num) {
            while (num > 0) {
                if (num % 10 == 3) {
                    return true;
                }
                num /= 10;
            }
            return false;
        }

        int calculateSum() {
            int sum = 0;
            Node current = this.head;
            while (current != null) {
                sum += current.data;
                current = current.next;
            }
            return sum;
        }
    }

    public class Main {
        public static void main(String[] args) {
            SinglyLinkedList primeList = new SinglyLinkedList();
            SinglyLinkedList digit3List = new SinglyLinkedList();
            int n = 1000;
            for (int i = 0; i <= n; i++) {
                if (isPrime(i)) {
                    primeList.insert(i);
                }
            }
            primeList.moveNumbersWithDigit3(digit3List);
            int sum = digit3List.calculateSum();
            System.out.println("Sum of prime numbers with digit 3 between 0 and " + n + " is " + sum);
        }

        private static boolean isPrime(int num) {
            if (num <= 1) {
                return false;
            }
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }


