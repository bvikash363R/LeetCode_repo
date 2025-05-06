package Node;

public class ListNode {
    class SinglyNode {
        int data;
        SinglyNode next;

        SinglyNode(int data) {
            this.data = data;
            this.next = null;
        }

    }

    class DoublyNode {
        int data;
        DoublyNode next;
        DoublyNode prev;

        DoublyNode(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
}
