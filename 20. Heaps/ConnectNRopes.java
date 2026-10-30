import java.util.PriorityQueue;

public class ConnectNRopes {
    public static void main(String[] args) {
        int ropes[] = {4,3,2,6};

        PriorityQueue<Integer> pq = new java.util.PriorityQueue<>();

        for(int i=0; i<ropes.length; i++){
            pq.add(ropes[i]);
        }
        int cost = 0;
        while(!pq.isEmpty()){
            int firstHalf = pq.poll();

            if(pq.isEmpty()){
                System.out.println("Cost : " + cost);
                break;
            }

            int newRope = firstHalf + pq.poll();
            cost += newRope;
            pq.add(newRope);
        }


    }
}
