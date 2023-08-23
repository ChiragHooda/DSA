public class PQBacktracking {
    public static void ratInMaze(int arr[][],int i,int j) {
        //base coditions
        if(i==arr.length-1&&j==arr.length-1){
            System.out.println("found");
            return;
        }
        //up U
//        if (isSafe(arr, i - 1, j)) {
//            ratInMaze(arr, i - 1, j);
//        }else{
//            return false;
//        }
        //down D
        if (isSafe(arr, i + 1, j)) {
            ratInMaze(arr, i + 1, j);
        }
        //left L
//        if (isSafe(arr, i, j - 1)) {
//            ratInMaze(arr, i, j - 1);
//        }else{
//            return false;
//        }
        //Right R
        if(isSafe(arr,i,j + 1)){
            ratInMaze(arr,i,j+1);
        }
    }

    public static boolean isSafe(int arr[][],int i,int j){
        if( i>=0 && i<arr.length && j>=0 && j<arr.length && arr[i][j]!=0){
            return true;
        }
        return false;
    }
    static int count=0;

    public static void main(String[] args) {
        int maze[][] = { { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 0, 1, 0, 0 },
                { 1, 1, 1, 1 } };
        ratInMaze(maze,0,0);
    }
}
