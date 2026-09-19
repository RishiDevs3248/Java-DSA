
import java.util.ArrayList;
import java.util.Collections;

public class ArrayListBasics {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        //O(1)
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        System.out.println(list);


        //O(1)
        System.out.println(list.get(2));


        //O(n)
        list.remove(2);
        System.out.println(list);


        //O(n)
        list.set(2, 20);
        System.out.println(list);


        //O(n)
        System.out.println(list.contains(1));
        System.out.println(list.contains(40));


        // length of arraylist = size
        System.out.println(list.size());


        // Sort
        Collections.sort(list);//asc
        System.out.println(list);
        Collections.sort(list,Collections.reverseOrder());//desc
        System.out.println(list);
    }
}
