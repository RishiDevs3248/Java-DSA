
import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    public static void main(String[] args) {
        int val[] = {60, 100, 120};
        int weight[] = {10, 20, 30};
        int W = 50;


        double ratio[][] = new double[val.length][2];
        // idx 0 -> index // idx 1 -> ratio

        for(int i=0; i< val.length; i++){
            ratio[i][0] = i;
            ratio[i][1] = val[i]/(double)weight[i];
        }

        //assending order sorting
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        int capacity = W;
        int finalAns = 0;
        for(int i=ratio.length-1; i>=0; i--){
            int idx = (int) ratio[i][0];
            if(weight[idx] <= capacity ){
                capacity -= weight[idx];
                finalAns += val[idx];
            }else{ 
                finalAns += ratio[i][1] * capacity;
                capacity = 0;
                break;
            }
        }

        System.out.println("Final Ans = "+ finalAns);
    }
}
