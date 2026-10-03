public class IndianCoins {
    public static void main(String[] args) {
        int coins[] = {1,2,5,10,20,50,100,500,1000};
        int value = 121;
        int count = 0;
        for(int i=coins.length-1 ; i>=0 ; i--){
            if(value == 0){
                break;
            }
            while(value >= coins[i]){
                count++;
                value -= coins[i];
            }
        }
        System.out.println("coin count : "+ count);
    }
}
