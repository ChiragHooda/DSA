import java.util.Arrays;

public class GreedyAlgoPQ {
    public static int ans=Integer.MAX_VALUE;
    public static void solve(int a[],int n,int k,int index,int sum,int maxsum){
        if(k==1){
            maxsum=Math.max(sum,maxsum);
            sum=0;
            for(int i=index;i<n;i++){
                sum+=a[i];
            }
            maxsum=Math.max(sum,maxsum);
            ans=Math.min(ans,maxsum);
            return ;
        }
        sum=0;
        for(int i=index;i<n;i++){
            sum+=a[i];
            maxsum=Math.max(maxsum,sum);
            solve(a,n,k-1,i+1,sum,maxsum);
        }
    }
    public static void main(String[] args) {
//        String str="LRRRRLLRLLRL";
//        int l=0,r=0;
//        int count=0;
//        for(int i=0;i<str.length();i++){
//            if(str.charAt(i)=='L'){
//                l++;
//            }else{
//                r++;
//            }
//            if(l==r){
//                count++;
//                l=0;
//                r=0;
//            }
//        }
//        System.out.println(count);
//        int L=-3;
//        int R=3;
//        int k=4;
//        int count;
//        if((R&1)>0){
//            count=(int)Math.ceil((R-L+1)/2);
//            if(k>count){
//                System.out.println("0");
//            }else{
//                System.out.println((R-2*k+2));
//            }
//        }else {
//            count=((R-L+1)/2);
//            if(k>count){
//                System.out.println("0");
//            }else{
//                System.out.println((R-2*k+1));
//            }
//        }
//        int N=5;
//        int K=42;
//        char arr[]=new char[N];
//        Arrays.fill(arr,'a');
//        for(int i=N-1;i>=0;i--){
//            K-=i;
//            if(K>0){
//                if(K>=26){
//                    K=K-26;
//                    arr[i]='z';
//                }else{
//                    arr[i]=(char)(K+97-1);
//                    K-=arr[i]-'a'+1;
//                }
//            }else{
//                break;
//            }
//            K+=i;
//        }
//        System.out.println(arr);
//        int prices[]={7,1,5,6,4};
//        int buy=prices[0];
//        int maxprofit=0;
//        for(int i=0;i<prices.length;i++){
//            if(buy>prices[i]){
//                buy=prices[i];
//            }else if(prices[i]-buy>maxprofit){
//                maxprofit=prices[i]-buy;
//            }
//        }
//        System.out.println(maxprofit);
        int arr[]={1,2,3,4};
        solve(arr,4,3,0,0,0);
        System.out.println(ans);
    }
}
