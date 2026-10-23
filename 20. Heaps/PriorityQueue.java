

public class PriorityQueue {

    static  class Student implements Comparable<Student>{
        String name;
        int rank;

        public Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2){
            return this.rank - s2.rank;
        }
        
    }

    public static void main(String[] args) {
        // java.util.PriorityQueue<Integer> pq = new java.util.PriorityQueue<>(); //assending
        // java.util.PriorityQueue<Integer> pq = new java.util.PriorityQueue<>(Comparator.reverseOrder()); //descending
        java.util.PriorityQueue<Student> pq = new java.util.PriorityQueue<>();
        // java.util.PriorityQueue<Student> pq = new java.util.PriorityQueue<>(Comparator.reverseOrder());

        // pq.add(3);//O(log n)
        // pq.add(4);
        // pq.add(1);
        // pq.add(7);

        pq.add(new Student("a", 5));//O(log n)
        pq.add(new Student("b", 6));
        pq.add(new Student("c", 2));
        pq.add(new Student("d", 10));

        while(!pq.isEmpty()){
            System.out.println(pq.peek().name);// O(1)
            pq.remove();//O(log n)
        }
    }
}
