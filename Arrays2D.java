import java.util.Arrays;

public class Arrays2D {

    public static void printSpiral(int arr[][]){
        int n=arr.length;
        int m=arr[0].length;
        int startrow=0;
        int endcol=n-1;
        int endrow=m-1;
        int startcol=0;

        while(startcol<=endcol && startrow<=endrow){
            //top row

            for(int i=startrow;i<=endcol;i++){
                System.out.print(arr[startrow][i]+" ");
            }

            //last column

            for(int i=startrow+1;i<=endrow;i++){
                System.out.print(arr[i][endcol]+" ");
            }

            //last row

            for(int i=endcol-1;i>=startcol;i--){
                if(startcol==endcol){
                    return;
                }
                System.out.print(arr[endrow][i]+" ");
            }

            //first col

            for(int i=endrow-1;i>=startrow+1;i--){
                System.out.print(arr[i][startcol] +" ");
            }

            startrow++;
            endcol--;
            endrow--;
            startcol++;
        }
        System.out.println();
    }

    public static void diagonalsum(int arr[][]){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum=sum+arr[i][i];
            if(i!=arr.length-1-i){
                sum=sum+arr[i][arr.length-1-i];
            }
        }
        System.out.println(sum);
    }

    public static boolean SearchinSorted(int arr[][],int target){
        int n=arr.length;
        int m=arr[0].length;
        int r=n-1;
        int c=0;
        // taking arr[0][m-1]
        /*while(r<=n-1 && c>=0){
            if(target<arr[r][c]){
                //move left
                c--;
            }
            else if(target>arr[r][c]){
                //move down
                r++;
            }
            else{
                System.out.println("Element found at arr["+r+"]["+c+"]");
                return true;
            }
        }
        System.out.println("Element not found");
        return false;*/

        //taking arr[n-1][0]
        while(r>=0 && c<=m-1){
            if(target==arr[r][c]){
                System.out.println("Element found at arr["+r+"]["+c+"]");
                return true;
            }
            else if(target>arr[r][c]){
                c++;
            }
            else{
                r--;
            }
        }
        System.out.println("Element not found");
        return false;
    }

    public static void main(String[] args) {
        int arr[][]={{10,20,30,40},
                     {15,25,35,45},
                     {27,29,37,48},
                     {32,33,39,50}};
        printSpiral(arr);
        diagonalsum(arr);
        SearchinSorted(arr,49);
    }
}
