import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MajorityElement {
    public static void main(String[] args) {
        int nums[] = {1,3,2,5,1,3,1,5,1};

        Map<Integer, Integer> mp = new HashMap();

        for(int i=0; i<nums.length; i++){
            if(mp.containsKey(nums[i])){
                mp.put(nums[i],mp.get(nums[i])+1);
            }else{
                mp.put(nums[i], 1);
            }
            // Shorthand
            // mp.put(nums[i], mp.getOrDefault(mp.get(nums[i])+1, 1));
        }

        System.out.print("[ ");
        for (Integer key : mp.keySet()) {
            if(mp.get(key) > nums.length/3){
                System.out.print(key+" ");
            }
        }
        System.out.print("]");
    }
}
