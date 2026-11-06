import java.util.HashMap;
import java.util.Map;

public class LargestSubarrayWith0Sum {
    public static void main(String[] args) {
        int nums[] = {15,-2,2,-8,1,7,10};
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int len = 0 ;
        for(int j=0 ; j < nums.length; j++){
            sum += nums[j];

            if(map.containsKey(sum)){
                len = Math.max(len, j - map.get(sum));
            }else{
                map.put(sum, j);
            }
        }

        System.out.println("Largest subaray wit sum 0 : "+ len);
    }
}
