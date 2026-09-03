public class NoConsicutiveOnes {
    public static void noOncs(int n, int lastPlace, StringBuilder str){
        if(n==0){
            System.out.println(str);
            return;
        }

        //kaam
        noOncs(n-1, 0 , str.append("0"));
        str.deleteCharAt(str.length() - 1);
        if(lastPlace == 0){
            noOncs(n - 1, 1, str.append("1"));
            str.deleteCharAt(str.length() - 1);
        }
    }
    public static void main(String[] args) {
        noOncs(2, 0, new StringBuilder());
    }
}
