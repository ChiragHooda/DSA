public class PQRecursion {
    public static int countContagiousSubstrings(String str,int i,int j,int n) {
        if (n == 1) {
            return 1;
        }
        if (n <= 0) {
            return 0;
        }
        int count = countContagiousSubstrings(str, i + 1, j, n - 1) +
                countContagiousSubstrings(str, i, j - 1, n - 1) -
                countContagiousSubstrings(str, i + 1, j - 1, n - 2);
        if (str.charAt(i) == str.charAt(j)) {
            count++;
        }
        return count;
    }

    public static void DiskProblem(int n,String src,String helper, String dest){
        if(n==1){
            System.out.println("transfer disk "+n+" from "+ src+" to "+dest);
            return;
        }
        DiskProblem(n-1,src,helper,dest);
        System.out.println("transfer disk "+n+" from "+ src+" to "+helper);
        DiskProblem(n-1,helper,src,dest);
    }

    public static void main(String[] args) {
        //System.out.println(countContagiousSubstrings("abcab",0,4,5));
        DiskProblem(3,"A","B","C");
    }
}
