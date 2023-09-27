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
    final static String[][] arr ={{" "},{" "},{"a","b","c"},{"d","e","f"},{"g","h","i"},{"j","k","l"},{"m","n","o"},{"p","q","r","s"},{"t","u","v"},{"w","x","y","z"}};

    public static void KeypadCombinations(int x,int y,int i,int j){
        if(i==arr[x].length){
            return;
        }
        if(j==arr[y].length&&i<arr[x].length){
            KeypadCombinations(x,y,i+1,0);
            return;
        }
        System.out.print('"'+arr[x][i]+arr[y][j]+'"'+',');
        KeypadCombinations(x,y,i,j+1);
    }

    static int N=8;

    public static boolean Knights(int arr[][],int i,int j,int n,int iMove[],int jMove[]){
        int k,next_i,next_j;
        if(n==N*N){
            return true;
        }
        for(k=0;k<N;k++){
            next_j=j+jMove[k];
            next_i=i+iMove[k];
            if(isSafeKnight(arr,next_i,next_j)){
                arr[next_i][next_j]=n;
                if(Knights(arr,next_i,next_j,n+1,iMove,jMove)){
                    return true;
                }else{
                    arr[next_i][next_j]=-1;
                }
            }
        }
        return false;
    }

    public static boolean isSafeKnight(int arr[][],int i,int j){
        return (i>=0&&i<N&&j>=0&&j<N&&arr[i][j]==-1);
    }

    public static boolean solveKT(){
        int sol[][]=new int[8][8];
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                sol[i][j]=-1;
            }
        }
        int iMove[]={2,1, -1, -2, -2, -1,1,2};
        int jMove[]={1,2,2,1, -1, -2, -2, -1};

        sol[0][0]=0;
        if(Knights(sol,0,0,1,iMove,jMove)){
            printarr(sol);
            return true;
        }else{
            System.out.println("False");
            return false;
        }
    }


    public static void main(String[] args) {
//        int maze[][] = { { 1, 0, 0, 0 },
//                { 1, 1, 0, 1 },
//                { 0, 1, 0, 0 },
//                { 1, 1, 1, 1 } };
//        int sol[][]=new int[maze.length][maze.length];
//        ratInMaze(maze,0,0,sol);
//        KeypadCombinations(2,3,0,0);
//        solveKT();
        for(int i=0;i<50;i=i+1){
            for(int j=i+1;j<=i+1+5;j++){
                System.out.println(j);
            }
        }
    }
}
