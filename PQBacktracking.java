public class PQBacktracking {
    public static void ratInMaze(int arr[][],int i,int j,int sol[][]) {
        //base coditions
        sol[i][j]=arr[i][j];
        if(i==arr.length-1&&j==arr.length-1){
            System.out.println("found");
            printarr(sol);
            return;
        }
        //down D
        if (isSafe(arr, i + 1, j)) {
            ratInMaze(arr, i + 1, j,sol);
        }
        //Right R
        if(isSafe(arr,i,j + 1)){
            ratInMaze(arr,i,j+1,sol);
        }
        if(isSafe(arr,i,j + 1) || isSafe(arr, i + 1, j)){
            sol[i][j]=1;
        }
        if(!isSafe(arr,i,j + 1)&&!isSafe(arr, i + 1, j)){
            sol[i][j]=0;
        }

    }

    public static boolean isSafe(int arr[][],int i,int j){
        if( i>=0 && i<arr.length && j>=0 && j<arr.length && arr[i][j]!=0){
            return true;
        }
        return false;
    }

    public static void printarr(int arr[][]){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    static int count=0;

    public static void main(String[] args) {
        int maze[][] = { { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 0, 1, 0, 0 },
                { 1, 1, 1, 1 } };
        int sol[][]=new int[maze.length][maze.length];
        ratInMaze(maze,0,0,sol);
    }
}
