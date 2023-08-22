public class Backtracking {

    public static boolean isSafe(char board[][],int row,int col){
        //top
        for(int i=row-1;i>=0;i--){
            if(board[i][col]=='Q'){
                return false;
            }
        }
        //diagonal left
        for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        //diagonal right
        for(int i=row-1,j=col+1;i>=0&&j< board.length;i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }

    public static boolean NQueens(char board[][],int row){
        if(row==board.length){
            count ++;
            return true;
        }
        for(int j=0;j<board.length;j++){
            if(isSafe(board,row,j)){
                board[row][j]='Q';
                if(NQueens(board,row+1)){
                    return true;
                }
                board[row][j]='x';
            }
        }
        return false;
    }

    static int count=0;

    public static void printboard(char board[][]){
        for(int i=0;i<board.length;i++){
            for(int j=0;j< board.length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static int gridWays(int startRow,int startCol,int n,int m) {
        if (startRow == n-1 && startCol == m-1) {
            return 1;
        }
        if (startCol == m || startRow == n) {
            return 0;
        }
        int w1 = gridWays(startRow + 1, startCol, n, m);
        int w2 = gridWays(startRow, startCol + 1, n, m);
        return w1 + w2;
    }

    public static void gridWaysOpt(int n,int m){
        //we have to go right n-1 times and down m-1 time so we use (n-1+m-1)!/(n-1)!*(m-1)! it's factorial
    }

    public static boolean sudukoIsSafe(int suduko[][],int i,int j,int key){
        //checking no in row
        for(int a=0;a<=8;a++){
            if(suduko[a][j]==key){
                return false;
            }
        }
        //checking for col
        for(int b=0;b<=8;b++){
            if(suduko[i][b]==key){
                return false;
            }
        }
        //checking grid
        int gridI=(i/3)*3;
        int gridJ=(j/3)*3;
        //checking no in grid
        for(int a=gridI;a<gridI+3;a++){
            for(int b=gridJ;b<gridJ+3;b++){
                if(suduko[a][b]==key){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean Suduko(int suduko[][],int i,int j){
        if(i==9){
            return true;
        }
        int nextrow=i,nextcol=j+1;
        if(j+1==9){
            nextrow=i+1;
            nextcol=0;
        }

        if(suduko[i][j]!=0){
            return Suduko(suduko,nextrow,nextcol);
        }
        for(int key=1;key<=9;key++){
            if(sudukoIsSafe(suduko,i,j,key)){
                suduko[i][j]=key;
                if(Suduko(suduko,nextrow,nextcol)){
                    return true;
                }
                suduko[i][j]=0;
            }
        }
        return false;
    }

    public static void printSuduko(int suduko[][]){
        for(int i=0;i<9;i++){
            for(int j=0;j< 9;j++){
                System.out.print(suduko[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
//        char board[][]=new char[4][4];
//        for(int i=0;i<board.length;i++){
//            for(int j=0;j<board.length;j++){
//                board[i][j]='x';
//            }
//        }
//        if(NQueens(board,0)){
//            printboard(board);
//        }
//        System.out.println(gridWays(0,0,3,3));
        int suduko[][]={{0,0,8,0,0,0,0,0,0},
                        {4,9,0,1,5,7,0,0,2},
                        {0,0,3,0,0,4,1,9,0},
                        {1,8,5,0,6,0,0,2,0},
                        {0,0,0,0,2,0,0,6,0},
                        {9,6,0,4,0,5,3,0,0},
                        {0,3,0,0,7,2,0,0,4},
                        {0,4,9,0,3,0,0,5,7},
                        {8,2,7,0,0,9,0,1,3}};
        if(Suduko(suduko,0,0)){
            System.out.println("Solution Exists");
            printSuduko(suduko);
        }else{
            System.out.println("solution DNE");
        }
    }
}
