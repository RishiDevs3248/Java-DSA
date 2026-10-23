
import java.util.Comparator;

public class PriorityQueue {
    public static void main(String[] args) {
        // java.util.PriorityQueue<Integer> pq = new java.util.PriorityQueue<>(); //assending
        java.util.PriorityQueue<Integer> pq = new java.util.PriorityQueue<>(Comparator.reverseOrder()); //assending

        pq.add(3);//O(log n)
        pq.add(4);
        pq.add(1);
        pq.add(7);

        while(!pq.isEmpty()){
            System.out.println(pq.peek());// O(1)
            pq.remove();//O(log n)
        }
    }
}
