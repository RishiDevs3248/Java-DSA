public class LinkedList {

    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }        
    }

    public static Node head;
    public static Node tail;
    public static int size = 0;

    public void addFirst (int data){
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode; 
    }

    public void add(int data, int idx){
        Node newNode = new Node(data);
        Node temp = head ;
        if( head == null){
            addFirst(data);
            return;
        }
        size++;
        int i=0; 
        while(i != idx-1){
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;

    }

    public void printLL(){
        Node curr = head;
        while(curr != null){
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.print("null");
    }

    public void removeFirst(){
        System.out.println();
        if (head == null){
            System.out.println("ll empty ");
            return;
        }
        int val = head.data;
        size--;
        System.out.println("removed " + val);
        if (head == tail){
            head = tail = null;
            return;
        }
        head = head.next;
    }

    public void removeLast(){
        System.out.println();
        if (head == null) {
            System.out.println("ll empty ");
            return;
        }

        int val = tail.data;
        size--;
        System.out.println("removed " + val);
        if (head == tail) {
            head = tail = null;
            return;
        }
        
        Node curr = head;
        while(curr.next != tail){
            curr = curr.next;
        }
        curr.next = null;
        tail = curr;
    }


    public void search (int key){
        Node curr = head;
        int i = 0; 
        while (curr != null){
            if( curr.data == key){
                System.out.println("found at "+i);
                return;
            }
            i++;
            curr = curr.next;
        }
        System.out.println("Not found ");
    }


    public static void main(String[] args) {

        LinkedList ll = new LinkedList();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);
        ll.add(3,2);
        
        ll.removeFirst();
        ll.printLL();
        ll.removeLast();
        ll.printLL();

        ll.search(4);
        ll.search(10);
    }
}
