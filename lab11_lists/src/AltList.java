public class AltList {
    private ListNode head;
    private ListNode tail;

    public AltList() {
        this.head = null;
        this.tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public ListNode getHead() {
        return head;
    }

    public ListNode getTail() {
        return tail;
    }

    public void addFirst(String lastName, String firstName, String midName, String phone) {
        ListNode node = new ListNode(lastName, firstName, midName, phone);

        if (this.isEmpty()) {
            tail = node;
        } else {
            head.prev = node;
        }

        node.next = head;
        head = node;
    }

    public void addLast(String lastName, String firstName, String midName, String phone) {
        ListNode node = new ListNode(lastName, firstName, midName, phone);

        if (this.isEmpty()) {
            head = node;
        } else {
            tail.next = node;
        }

        node.prev = tail;
        tail = node;
    }

    public void addAtIndex(int index, String lastName, String firstName, String midName, String phone) {
        ListNode current = head;
        int counter = 0;

        while (current != null && counter != index) {
            current = current.next;
            counter++;
        }

        ListNode node = new ListNode(lastName, firstName, midName, phone);
        current.prev.next = node;
        node.prev = current.prev;
        current.prev = node;
        node.next = current;
    }

    public void removeFirst() {
        if (head.next == null) {
            tail = null;
        } else {
            head.next.prev = null;
        }

        head = head.next;
    }

    public void removeLast() {
        if (head.next == null) {
            head = null;
        } else {
            tail.prev.next = null;
        }

        tail = tail.prev;
    }

    public void removeByQueryLn(String queryLn, boolean onlyFirst) {
        ListNode current = head;

        while (!current.lastName.equals(queryLn)) {
            current = current.next;

            if (current == null) {
                return;
            }
        }

        if (current == head) {
            removeFirst();
        } else {
            current.prev.next = current.next;
        }

        if (current == tail) {
            removeLast();
        } else {
            current.next.prev = current.prev;
        }

        if (onlyFirst) {
            return;
        }
    }
}

