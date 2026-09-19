
import java.util.ArrayList;
import java.util.List;

public class ContainerWithMostWater {

    public static void main(String[] args) {

        ArrayList<Integer> height = new ArrayList<>(List.of(1, 8, 6, 2, 5, 4, 8, 3, 7));

        int lp = 0;
        int rp = height.size() - 1;

        int maxWater = Integer.MIN_VALUE;

        while (lp < rp) {
            maxWater = Math.max(maxWater, (Math.min(height.get(lp), height.get(rp))) * (rp - lp));

            if(height.get(lp) < height.get(rp)){
                lp++;
            }else{
                rp--;
            }
        }

        System.out.println(maxWater);
    }
}
