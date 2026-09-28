
import java.util.Stack;

public class ReverseAStrUsingStack {

    public StringBuilder reverseStr(String str) {
        Stack<Character> s = new Stack<>();
        for(int i=0; i<str.length(); i++){
            s.push(str.charAt(i));
        }
        StringBuilder resversedString = new StringBuilder("");
        while(!s.isEmpty()){
            resversedString.append(s.pop());
        }
        return resversedString;
    }

    public static void main(String[] args) {
        String str = "dlroW olleH";
        ReverseAStrUsingStack x = new ReverseAStrUsingStack();
        System.out.println(x.reverseStr(str));
    }
}
