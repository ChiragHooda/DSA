import java.util.* ;
public class ConditionalStatementsPQ {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        // Question 1
        System.out.println("Enter the number");
        float a= sc.nextFloat();
        String rs= ((a>=0)? "positive number or zero":"negative number");
        System.out.println(rs);

        //Question 3
        System.out.println("Enter what day of week it is: ");
        int day= sc.nextInt();
        switch(day){
            case 1 -> {
                System.out.println("Monday");
                break;
            }
            case 2 -> {
                System.out.println("Tuesday");
                break;
            }
            case 3 -> {
                System.out.println("Wednesday");
                break;
            }
            case 4 -> {
                System.out.println("Thursday");
                break;
            }
            case 5 -> {
                System.out.println("Friday");
                break;
            }
            case 6 -> {
                System.out.println("Saturday");
                break;
            }
            case 7 -> {
                System.out.println("Sunday");
                break;
            }
            default -> System.out.println("There are only seven week days enter valid number from 1-7.");
        }

        // Question 5
        System.out.println("Enter the year");
        int year= sc.nextInt();
        String s1= ((year%4)==0)? "yes":"no" ;
        String s2= ((year%100)==0)? "yes":"no" ;
        String s3= ((year%400)==0)? "yes":"no" ;
        if((s1=="yes" && s2== "yes" && s3== "yes") || (s1=="yes" && s2=="no")){
            System.out.println("It's a leap year");
        }
        else{
            System.out.println("It's not a leap year");
        }
    }
}
