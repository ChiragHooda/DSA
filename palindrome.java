import java.util.*;
public class palindrome {
    public static boolean isPalindrome(int n){
        int revnum=0;
        int num=n;
        while(num>0){
            int lastdigit= num%10;
            revnum=revnum*10+lastdigit;
            num=num/10;
        }
        if(revnum==n){
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the number : ");
        int a= sc.nextInt();
        System.out.println(isPalindrome(a));
    }
}
