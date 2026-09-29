import java.util.Stack;
public class NextGreaterElement {
    
    public static void main(String[] args) {
        int arr[] = {6, 8, 0, 1, 3};
        int resArr[] = new int[arr.length];
        Stack<Integer> s = new Stack<>();
        for (int i = arr.length-1; i >= 0; i--) {
            int curr = arr[i];
            //step 1
            while(!s.isEmpty() && curr >= s.peek()){
                s.pop();
            }

            //step 2
            if(s.isEmpty()){
                resArr[i] = -1;
            }else{
                resArr[i] = s.peek();
            }

            //step 3
            s.push(curr);
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(resArr[i]+" ");
        }
    }
}
