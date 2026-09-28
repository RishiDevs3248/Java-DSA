import java.util.Stack;

public class ReverseAStack {

    public void reverseStack(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }

        Integer top = s.pop();
        reverseStack(s);
        pushAtBottom(s , top);

    }

    private void pushAtBottom(Stack<Integer> s, Integer num){
        if (s.isEmpty()) {
            s.push(num);
            return;
        }

        Integer top = s.pop();
        pushAtBottom(s, num);
        s.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4); 

        System.out.println(s);
        ReverseAStack rs = new ReverseAStack();
        rs.reverseStack(s);
        System.out.println(s);
        
    }
}
