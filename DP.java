import java.util.Arrays;
import java.util.HashSet;

public class DP {
    public static int climbingStairsRecrsion(int n){
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        return climbingStairsRecrsion(n-1)+climbingStairsRecrsion(n-2);
    }
    public static int climbingStairsMemoization(int n,int ways[]){
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        if(ways[n]!=-1){
            return ways[n];
        }
        ways[n]=climbingStairsMemoization(n-1,ways)+climbingStairsMemoization(n-2,ways);
        return ways[n];
    }
    public static int climbingStairsTabulation(int n){
        int dp[]=new int[n+1];
        dp[0]=1;
         for(int i=1;i<=n;i++){
             if(i==1){
                 dp[i]=dp[i-1]+0;
             }else{
                 dp[i]=dp[i-1]+dp[i-2];
             }
         }
         return dp[n];
    }

    public static int knapsack(int val[],int wt[],int W,int n){
        if(W==0||n==0){
            return 0;
        }
        if(wt[n-1]<=W){
            //including
            int ans1=val[n-1]+knapsack(val,wt,W-wt[n-1],n-1);
            //excluding
            int ans2=knapsack(val,wt,W,n-1);
            return Math.max(ans1,ans2);
        }else{
            return knapsack(val,wt,W,n-1);
        }
    }

    public static int knapsackMemoization(int val[],int wt[],int W,int n,int dp[][]){
        if(W==0||n==0){
            return 0;
        }
        if(dp[n][W]!=-1){
            return dp[n][W];
        }
        if(wt[n-1]<=W){//valid
            //include
            int ans1=val[n-1]+knapsackMemoization(val,wt,W-wt[n-1],n-1,dp);
            //exclude
            int ans2=knapsackMemoization(val,wt,W,n-1,dp);
            dp[n][W]=Math.max(ans1,ans2);
            return dp[n][W];
        }else{//invalid
            dp[n][W]=knapsackMemoization(val,wt,W,n-1,dp);
            return dp[n][W];
        }
    }
    public static int knapsackTabulation(int val[],int wt[],int W) {
        int n = val.length;
        int dp[][] = new int[n + 1][W + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int v = val[i - 1];
                int w = wt[i - 1];
                if (w <= j) {//valid
                    int inclprofit=v+dp[i-1][j-w];
                    int exclprofit=dp[i-1][j];
                    dp[i][j]=Math.max(inclprofit,exclprofit);
                }else{//invalid
                    int exclprofit=dp[i-1][j];
                    dp[i][j]=exclprofit;
                }
            }
        }
        return dp[n][W];
    }
    public static boolean targetSumTabulation(int arr[],int sum){
        int n=arr.length;
        boolean dp[][]=new boolean[n+1][sum+1];
        for(int i=0;i< arr.length;i++){
            dp[i][0]=true;
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                int v=arr[i-1];
                if(v<=j && dp[i-1][j-v]==true){
                    dp[i][j]=true;
                }else if(dp[i-1][j]==true){
                    dp[i][j]=true;
                }
            }
        }
        printarr(dp);
        System.out.println();
        return dp[n][sum];
    }
    public static int unboundedKnapsack(int val[],int wt[],int W){//O(n*W)
        int n=val.length;
        int dp[][]=new int[n+1][W+1];

        for(int i=0;i<dp.length;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<dp[0].length;j++){
            dp[0][j]=0;
        }
        for(int i=1;i< dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                int v=val[i-1];
                int w=wt[i-1];
                if(w<=j){
                    dp[i][j]=Math.max(v+dp[i][j-w],dp[i-1][j]);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][W];
    }
    public static int coinChange(int coins[],int sum){
        int n=coins.length;
        int dp[][]=new int[n+1][sum+1];
        for(int i=0;i<dp.length;i++){
            dp[i][0]=1;
        }
        for(int j=0;j<dp[0].length;j++){
            dp[0][j]=0;
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                int v=coins[i-1];
                if(v<=j){
                    dp[i][j]=dp[i][j-v]+dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
    public static void printarr(boolean arr[][]){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static int rodCutting(int length[],int price[],int totRod){
        int n= price.length;
        int dp[][]=new int[n+1][totRod+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if( i == 0 || j == 0 ){
                    dp[i][j]=0;
                }
            }
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                int v=price[i-1];
                int w=length[i-1];
                if(w<=j){
                    dp[i][j]=Math.max(v+dp[i][j-w],dp[i-1][j]);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][totRod];
    }
    public static int lcs(String s1,String s2,int n,int m){//longest common subsequence
        if(n==0||m==0){
            return 0;
        }
        if(s1.charAt(n-1)==s2.charAt(m-1)){
            return lcs(s1,s2,n-1,m-1)+1;
        }else{
            int ans1=lcs(s1,s2,n-1,m);
            int ans2=lcs(s2,s2,n,m-1);
            return Math.max(ans1,ans2);
        }
    }
    public static int lcsMemoization(String s1,String s2,int n,int m,int dp[][]){
        if(n==0 || m==0){
            return 0;
        }
        if(dp[n][m]!=-1){
            return dp[n][m];
        }
        if(s1.charAt(n-1)==s2.charAt(m-1)){
            return dp[n][m]=1+lcsMemoization(s1,s2,n-1,m-1,dp);
        }else{
            int ans1=lcsMemoization(s1,s2,n-1,m,dp);
            int ans2=lcsMemoization(s1,s2,n,m-1,dp);
            return dp[n][m]=Math.max(ans1,ans2);
        }
    }
    public static int lcsTabulation(String str1,String str2){
        int n=str1.length();
        int m=str2.length();
        int dp[][]=new int[n+1][m+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(i==0||j==0){
                    dp[i][j]=0;
                }
            }
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    int ans1=dp[i-1][j];
                    int ans2=dp[i][j-1];
                    dp[i][j]=Math.max(ans1,ans2);
                }
            }
        }
        return dp[n][m];
    }
    public static int longestCommonSubstring(String str1,String str2){
        int n=str1.length();
        int m=str2.length();
        int max=Integer.MIN_VALUE;
        int dp[][]=new int[n+1][m+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(i==0||j==0){
                    dp[i][j]=0;
                }
            }
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                    max=Math.max(max,dp[i][j]);
                }else{
                    dp[i][j]=0;
                }
            }
        }
        return max;
    }
    public static int lcs(int arr1[],int arr2[]){
        int n=arr1.length;
        int m=arr2.length;
        int dp[][]=new int[n+1][m+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(i==0||j==0){
                    dp[i][j]=0;
                }
            }
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(arr1[i-1]==arr2[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else {
                    int ans1=dp[i-1][j];
                    int ans2=dp[i][j-1];
                    dp[i][j]=Math.max(ans1,ans2);
                }
            }
        }
        return dp[n][m];
    }
    public static int lis(int arr[]){//longest increasing subsequence
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<arr.length;i++){
            set.add(arr[i]);
        }
        int arr2[]=new int[set.size()];
        int i=0;
        for(int num:set){
            arr2[i]=num;
            i++;
        }
        Arrays.sort(arr2);
        return lcs(arr,arr2);
    }
    public static int editDistance(String str1,String str2){
        int n=str1.length();
        int m=str2.length();
        int dp[][]=new int[n+1][m+1];
        //initialize
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(i==0){
                    dp[i][j]=j;
                }
                if(j==0){
                    dp[i][j]=i;
                }
            }
        }
        //bottom up
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }
                else{
                    int add=dp[i-1][j]+1;
                    int del=dp[i][j-1]+1;
                    int rep=dp[i-1][j-1]+1;
                    dp[i][j]=Math.min(Math.min(add,del),rep);
                }
            }
        }
        return dp[n][m];
    }
    public static int StringConversion(String str1,String str2){
        return Math.abs(lcsTabulation(str1,str2)-str1.length())+Math.abs(str2.length()-lcsTabulation(str1,str2));
    }
    public static boolean isMatch(String s,String p){//Wildcard matching s->string,p->pattern
        int n=s.length();
        int m=p.length();
        boolean dp[][]=new boolean[n+1][m+1];
        dp[0][0]=true;
        for(int i=1;i<dp.length;i++){
            dp[i][0]=false;
        }
        for(int j=1;j<dp[0].length;j++){
            if(p.charAt(j-1) == '*'){
                dp[0][j]=dp[0][j-1];
            }
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(s.charAt(i-1)==p.charAt(j-1)||p.charAt(j-1)=='?'){
                    dp[i][j]=dp[i-1][j-1];
                }else if(p.charAt(j-1)=='*'){
                    boolean ans1=dp[i-1][j];
                    boolean ans2=dp[i][j-1];
                    dp[i][j]=(ans1||ans2);
                }else{
                    dp[i][j]=false;
                }
            }
        }
        return dp[n][m];
    }
    public static int catalanRecursion(int n){
        if(n==1||n==0){
            return 1;
        }
        int ans=0;
        for(int i=0;i<=n-1;i++){
            ans+=catalanRecursion(i)*catalanRecursion(n-i-1);
        }
        return ans;
    }
    public static int catalanMemoization(int n,int dp[]){
        if(n==0||n==1){
            return 1;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int ans=0;
        for(int i=0;i<=n-1;i++){
            ans+=catalanMemoization(i,dp)*catalanMemoization(n-i-1,dp);
        }
        return dp[n]=ans;
    }
    public static int catalanTabulation(int n){
        int dp[]=new int[n+1];
        dp[0]=dp[1]=1;
        for(int i=2;i< dp.length;i++){
            for(int j=0;j<i;j++){
                dp[i]+=dp[j]*dp[i-j-1];
            }
        }
        return dp[n];
    }
    public static int countBST(int n){
        int dp[]=new int[n+1];
        dp[0]=dp[1]=1;
        for(int i=2;i<dp.length;i++){
            for(int j=0;j<i;j++){
                int left=dp[j];
                int right=dp[i-j-1];
                dp[i]+=left*right;
            }
        }
        return dp[n];
    }
    public static int mountainRanges(int n){// n is the number of upstrokes(/) and downstrokes(\) pairs give
        //at any given time number of upstrokes is >= number of downstrokes
        int dp[]=new int [n+1];
        dp[0]=dp[1]=1;
        for(int i=2;i<dp.length;i++){
            for(int j=0;j<i;j++){
                dp[i]+=dp[j]*dp[i-j-1];
            }
        }
        return dp[n];
    }
    public static int mcm(int arr[],int i,int j){
        if(i==j){
            return 0;
        }
        int ans=Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int cost1=mcm(arr,i,k);
            int cost2=mcm(arr,k+1,j);
            int cost3=arr[i-1]*arr[k]*arr[j];
            int finalcost=cost1+cost2+cost3;
            ans=Math.min(ans,finalcost);
        }
        return ans;
    }
    public static int mcmMemoization(int arr[],int i,int j,int dp[][]){
        if(i==j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans=Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int cost1=mcmMemoization(arr,i,k,dp);
            int cost2=mcmMemoization(arr,k+1,j,dp);
            int cost3=arr[i-1]*arr[k]*arr[j];
            ans=Math.min(ans,cost1+cost2+cost3);
        }
        return dp[i][j]=ans;
    }
    public static int mcmTabulation(int arr[]){
        int n=arr.length;
        int dp[][]=new int[n][n];
        for(int i=0;i<arr.length;i++){
            dp[i][i]=0;
        }
        for(int len=2;len<=n-1;len++){
            for(int i=1;i<=n-len;i++){
                int j=i+len-1;
                dp[i][j]=Integer.MAX_VALUE;
                for(int k=i;k<=j-1;k++){
                    int cost1=dp[i][k];
                    int cost2=dp[k+1][j];
                    int cost3=arr[i-1]*arr[k]*arr[j];
                    dp[i][j]=Math.min(dp[i][j],cost1+cost2+cost3);
                }
            }
        }
        return dp[1][n-1];
    }
    public static int minimumPartition(int arr[]){
        int n=arr.length;
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        int W=sum/2;
        int dp[][]=new int[n+1][W+1];
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(arr[i-1]<=j){
                    dp[i][j]=Math.max(arr[i-1]+dp[i-1][j-arr[i-1]],dp[i-1][j]);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        int sum1=dp[n][W];
        int sum2=sum-sum1;
        return Math.abs(sum1-sum2);
    }
    public static int minJumps(int nums[]){
        int n=nums.length;
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        dp[n-1]=0;
        for(int i=n-2;i>=0;i--){
            int steps=nums[i];
            int ans=Integer.MAX_VALUE;
            for(int j=i+1;j<=i+steps&&j<n;j++){
                if(dp[i]!=-1){
                    ans=Math.min(dp[i],ans);
                }
            }
            if(ans!=Integer.MAX_VALUE){
                dp[i]=ans;
            }
        }
        return nums[0];
    }

    public static void main(String[] args) {
        int n=5;
        System.out.println(climbingStairsRecrsion(n));
        int ways[]=new int[n+1];
        Arrays.fill(ways,-1);
        System.out.println(climbingStairsMemoization(n,ways));
        System.out.println(climbingStairsTabulation(n));
        int val[]={15,14,10,45,30};
        int wt[]={2,5,1,3,4};
        int W=7;
        System.out.println(knapsack(val,wt,W,val.length));
        int dp[][]=new int[n+1][W+1];

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
        System.out.println(knapsackMemoization(val,wt,W,val.length,dp));
        System.out.println(knapsackTabulation(val,wt,W));
        int arr[]={4,2,7,1,3};
        int sum=10;
        System.out.println(targetSumTabulation(arr,sum));
        System.out.println(unboundedKnapsack(val,wt,W));
        int coins[]={1,2,3};
        int sum1=4;
        System.out.println(coinChange(coins,sum1));
        int length[]={1,2,3,4,5,6,7,8};
        int price[]={1,5,8,9,10,17,17,20};
        int totRod=8;
        System.out.println(rodCutting(length,price,totRod));
        String s1="abcdge";
        String s2="abedg";
        System.out.println(lcs(s1,s2,s2.length(),s2.length()));
        int dp1[][]=new int[s1.length()+1][s2.length()+1];
        for(int i=0;i<dp1.length;i++){
            for(int j=0;j<dp1[0].length;j++){
                dp1[i][j]=-1;
            }
        }
        System.out.println(lcsMemoization(s1,s2,s1.length(),s2.length(),dp1));
        System.out.println(lcsTabulation(s1,s2));
        String str1="ABCDE";
        String str2="ABGCE";
        System.out.println(longestCommonSubstring(str1,str2));
        int arr1[]={50,3,10,7,40,80};
        System.out.println(lis(arr1));
        String word1="intention";
        String word2="execution";
        System.out.println(editDistance(word1,word2));
        String str3="ABCDEF";
        String str4="ACEG";
        System.out.println(StringConversion(str3,str4));
        String s="baaabab";
        String p="*****ba*****ab";
        System.out.println(isMatch(s,p));
        int n1=5;
        System.out.println(catalanRecursion(n1));
        int dp2[]=new int[n1+1];
        Arrays.fill(dp2,-1);
        System.out.println(catalanMemoization(n1,dp2));
        System.out.println(catalanTabulation(n1));
        System.out.println(countBST(n1));
        System.out.println(mountainRanges(n1));
        int arr3[]={1,2,3,4,3};
        int n3=arr3.length;
        System.out.println(mcm(arr3,1,n3-1));
        int dp4[][]=new int[n3][n3];
        for(int i=0;i<dp4.length;i++){
            Arrays.fill(dp4[i],-1);
        }
        System.out.println(mcmMemoization(arr3,1,n3-1,dp4));
        System.out.println(mcmTabulation(arr3));
        int arr4[]={1,6,11,5};
        System.out.println(minimumPartition(arr4));
        int nums[]={2,3,1,1,4};
        System.out.println(minJumps(nums));
    }
}
