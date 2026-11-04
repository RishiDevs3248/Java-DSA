import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CountDistinctElememt {
    public static void main(String[] args) {
        Integer nums[] = {4,3,2,5,6,7,3,4,2,1};

        Set<Integer> set = new HashSet<>(Arrays.asList(nums));

        System.out.println("distinct Elements : "+ set.size());
        
    }
}
