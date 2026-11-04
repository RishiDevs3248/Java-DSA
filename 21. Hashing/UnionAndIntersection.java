import java.util.HashSet;
import java.util.Set;

public class UnionAndIntersection {
    public static void main(String[] args) {
          int arr1[] = {7,3,9};
          int arr2[] = {6,3,9,2,9,4};

          Set<Integer> union = new HashSet<>();
          Set<Integer> intersection = new HashSet<>();
          int intersectionCount = 0;

          for (int i=0; i< arr1.length; i++){
            union.add(arr1[i]);
            intersection.add(arr1[i]);
          }

          for (int i=0; i< arr2.length; i++){
            if(intersection.contains(arr2[i])){
                intersectionCount++;
                intersection.remove(arr2[i]);
            }
            union.add(arr2[i]);
          }

          System.out.println("Union : "+ union.size());
          System.out.println("Intersection : "+ intersectionCount);

    }
}
