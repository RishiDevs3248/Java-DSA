import java.util.Scanner;

public class Create {
    public static void main(String[] args) {

// --------------------------------------------------------------------------------------------------------

        // datatype name[] = new datatype[size];
        int marks[] = new int[10];


        // datatype name[] = {values}
        int marks2[] = {1,2,3,4};

// --------------------------------------------------------------------------------------------------------

        Scanner sc = new Scanner(System.in);

        // input
        marks[0] = sc.nextInt();

        // output
        System.out.println(marks[0]);

        // update
        marks[0] = 20;
    }
}
