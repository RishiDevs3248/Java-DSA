import java.util.Stack;

public class DuplicateParenthesis {
    public boolean isDuplicateParenthesis(String str){

        Stack<Character> s = new Stack<>();
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == ')'){
                if(s.peek() == '('){
                    return true;
                }
                while(s.peek() != '('){
                    s.pop();
                }
                s.pop();
            }else{
                s.push(str.charAt(i));
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String str = "((a+b)+(c+d))"; // false
        String str2 = "((a+b))"; // true
        DuplicateParenthesis check = new DuplicateParenthesis();
        System.out.println(check.isDuplicateParenthesis(str));
        System.out.println(check.isDuplicateParenthesis(str2));
    }
}
