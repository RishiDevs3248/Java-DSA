
import java.util.Stack;

public class Histogram {

    public int[] nextSmallest(String direction, int ofArray[]) {
        Stack<Integer> s = new Stack<>();
        int resultArr[] = new int[ofArray.length];

        if (direction == "left") {
            for (int i = 0; i < ofArray.length; i++) {
                int curr = ofArray[i];

                while (!s.isEmpty() && ofArray[s.peek()] >= curr) {
                    s.pop();
                }
                if (s.isEmpty()) {
                    resultArr[i] = -1;
                } else {
                    resultArr[i] = s.peek();
                }

                s.push(i);
            }
        }else{
            for (int i = ofArray.length-1; i >= 0; i--) {
                int curr = ofArray[i];

                while (!s.isEmpty() && ofArray[s.peek()] >= curr) {
                    s.pop();
                }
                if (s.isEmpty()) {
                    resultArr[i] = ofArray.length;
                } else {
                    resultArr[i] = s.peek();
                }

                s.push(i);
            }
        }

        return resultArr;
    }


    public void histogram(int arr[]) {
        int smallestLeft[] = nextSmallest("left", arr);
        int smallestRight[] = nextSmallest("right", arr);

        int maxArea = Integer.MIN_VALUE;

        for(int i=0; i<arr.length; i++){
            int area = arr[i] * (smallestRight[i] - smallestLeft[i] -1);
            maxArea = Math.max(maxArea, area);
        }

        System.out.println(maxArea);

    }

    public static void main(String[] args) {
        int arr[] = {2, 1, 5, 6, 2, 3};
        Histogram h = new Histogram();
        h.histogram(arr);

    }
}
