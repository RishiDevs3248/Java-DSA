public class IncomeTaxCalculator {
    public static void main(String[] args) {

        System.out.println(incomTaxCalculator(5) + "% Tax");
        System.out.println(incomTaxCalculator(10) + "% Tax");
        System.out.println(incomTaxCalculator(15) + "% Tax");

    }

    public static int incomTaxCalculator(int amt){
        if (amt <= 5) {
            return 0;
        } else if (amt > 5 && amt <= 10){
            return 20;
        } else {
            return 30;
        }
    }
}
