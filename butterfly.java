public class butterfly {
    public static void butterflyshorter(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(j>=i+1 && j<=n-i || j>n-i+1 && j<=i-1){
                    System.out.print(" ");
                }else{
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        butterflyshorter(8);
    }
}
