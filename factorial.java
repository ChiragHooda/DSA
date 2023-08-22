import java.util.*;
public class factorial {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the number : ");
        int n= sc.nextInt();
        int fact=1;
        if(n==0 || n==1){
            System.out.println("Factorial of n is : "+ fact);
        }
        else {

            for (int i = 1; i <= n; i++) {
                fact *= i;
            }
            System.out.println("Factorial : "+ fact);
        }
    }
}
