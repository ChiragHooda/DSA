public class PQBitMaipulation {

    public static int Add1(int n){
        return -~n;
    }

    public static void swap(int a, int b){
        System.out.println("("+a+" , "+b+")");
//        a=a-b;
//        b=b+a;
//        a=b-a;
        //OR
        a=a^b;
        b=a^b;
        a=a^b;
        System.out.println("("+a+" , "+b+")");
    }

    public static void printLowerCase(){
        for(char ch='A';ch<='Z';ch++){
            System.out.print((char)(ch | ' '));
        }
    }

    public static void main(String[] args) {
        System.out.println(Add1(63));
        swap(15,2);
        printLowerCase();
    }
}
