
public class ReverseNumber{
    public static void main(String[] args) {
        int num = 12345;
        int result = 0;
        while(num>0){
            int mod = num % 10;
            num /= 10;
            result = (result * 10) + mod;
        }

        System.out.println(result);
    }
}
