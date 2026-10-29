import java.util.concurrent.PriorityBlockingQueue;

public class NearestKCars {
    public static class Point implements Comparable<Point>{
        int x;
        int y;
        int dist;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
            this.dist = (x * x) + (y * y);
        }

        @Override
        public int compareTo(Point p) {
            return Integer.compare(this.dist, p.dist);
        }
    }

    public static void main(String[] args) {
        int pts[][] = { { 3, 3 }, { 5, -1 }, { -2, 4 } };

        int k = 2;

        PriorityBlockingQueue<Point> pq = new PriorityBlockingQueue<>();
        for (int i = 0; i < pts.length; i++) {
            Point cord = new Point(pts[i][0], pts[i][1]);
            pq.add(cord);
        }
        for (int i = 0; i < k && !pq.isEmpty(); i++) {
            Point p = pq.poll(); // poll -> removes and return from pq
            System.out.print("{" + p.x + "," + p.y + "} ");
        }
    }
}
