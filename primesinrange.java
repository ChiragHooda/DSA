import java.util.*;
public class primesinrange {
    public static boolean isPrime(int n){
        if(n==2){
            return true;
        }
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    public static void PrimesInRange(int n){
        for(int j=2;j<=n;j++){
            if(isPrime(j)){
                System.out.print(j+" ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the number : ");
        int a= sc.nextInt();
        PrimesInRange(a);
    }
}
