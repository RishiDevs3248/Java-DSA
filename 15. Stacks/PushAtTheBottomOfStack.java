
import java.util.Stack;

public class PushAtTheBottomOfStack {

    public void bottomPush(Stack<Integer> s, int data){
        if(s.isEmpty()){
            s.push(data);  
            return;
        }

        Integer top = s.pop();
        bottomPush(s, data);
        s.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4); 

        PushAtTheBottomOfStack x = new PushAtTheBottomOfStack();
        x.bottomPush(s, 5);
        System.out.println(s);
    }


}
