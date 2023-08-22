import java.sql.SQLOutput;

public class Arrays2DPQ {
    //Question 1
    public static void numberOf7(int arr[][]){
        //basic method
        int count=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if (arr[i][j]==7){
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static void sumof2ndrow(int arr[][]){
        int sum=0;
        for(int i=0;i<arr[0].length;i++){
            sum=sum+arr[1][i];
        }
        System.out.println(sum);
    }

    public static void swap(int a,int b){
        int temp=a;
        a=b;
        b=temp;
    }

    public static void transpose(int arr[][]){
        int n=arr.length;
        int m=arr[0].length;
        int transpose[][]= new int[m][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                transpose[j][i]=arr[i][j];
            }
        }
        printarr(transpose);
    }

    public static void printarr(int arr[][]){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int arr[][]={{1,2,3},
                     {4,5,6},
                     {7,8,9}};
        numberOf7(arr);
        sumof2ndrow(arr);
        transpose(arr);
    }
}
