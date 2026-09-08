
public class GridWays {

    public static int gwaysRecursionWay(int n, int m, int row, int col) {
        //base
        if (n == row - 1 && m == col - 1) {
            return 1;
        }

        int right = 0;
        int left = 0;
        // two ways 
        // right 

        if (m + 1 < col) {
            right += gwaysRecursionWay(n, m + 1, row, col);
        }

        //down
        if (n + 1 < row) {
            left += gwaysRecursionWay(n + 1, m, row, col);
        }
        return right + left;
    }

    public static int gwaysBackTrackingWay(int n, int m, int row, int col) {
        //base
        if (n == row - 1 && m == col - 1) {
            return 1;
        }else if(n == row || m == col){
            return 0;
        }

        int right = 0;
        int left = 0;
        // two ways 
        // right 
        right += gwaysBackTrackingWay(n, m + 1, row, col);
        //down
        left += gwaysBackTrackingWay(n + 1, m, row, col);

        return right + left;
    }

    // public static int gwaysLinearTimeComp(int n, int m){
        //  (n-1 + m-1)!
        //  -------------
        //  (n-1)! (m-1)! 
    // }

    public static void main(String[] args) {
        System.out.println(gwaysRecursionWay(0, 0, 3, 3));
        System.out.println(gwaysBackTrackingWay(0, 0, 3, 3));
    }
}
