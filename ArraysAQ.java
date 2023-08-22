public class ArraysAQ {
    //Question 2
    public static int searchMin(int arr[]){
        int indexmin=0;
        int min =Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<min){
                min=arr[i];
                indexmin=i;
            }
        }
        return indexmin;
    }

    public static int targetindex(int arr[],int left,int right, int target){
        int l = left;
        int r = right;
        while(l<=r){
            int mid=l+((r-l)/2);
            if(arr[mid]==target){
                return mid;
            }
            else if (arr[mid]>target) {
                r = mid-1;}
            else{
                l = mid+1;
            }
        }
        return -1;
    }

    public static void targetsearch(int arr[],int target){
        int minindex= searchMin(arr);
        int left=0;
        int right=0;
        if(arr[minindex]<=target && target<=arr[arr.length-1]){
            left= minindex;
            right=arr.length-1;
            System.out.println(targetindex(arr,left,right,target));
        } else{
            left=0;
            right=minindex-1;
            System.out.println(targetindex(arr,left,right,target));
        }
    }


    //Question 3

    public static int mostprofit(int arr[]){
        int bp=Integer.MAX_VALUE;
        int curr=0;
        int maxprofit=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>bp){
                int  profit= arr[i]-bp;
                maxprofit=Math.max(profit,maxprofit);
            }else{
                bp=arr[i];
            }
        }
        if(maxprofit<=0){
            return 0;
        }
        else{
            return maxprofit;
        }
    }

    public static void trappedwater(int arr[]){
        int n=arr.length;
        int leftmax[]= new int[arr.length];
        int rightmax[]= new int[arr.length];
        for(int i=0;i<arr.length;i++){
            leftmax[i]=(i==0)? arr[0]:Math.max(arr[i],leftmax[i-1]);
        }
        for(int i=n-1;i>0;i--){
            rightmax[i]=(i==n-1)? arr[n-1]:Math.max(arr[i],rightmax[i+1]);
        }
        int trappedwater=0;
        for(int i=0;i<n;i++){
            int watertlevel= Math.min(rightmax[i],leftmax[i]);
            trappedwater+= watertlevel-arr[i];
        }
        System.out.println(trappedwater);
    }
    public static void main(String[] args) {
        int height[]={0,1,0,2,1,0,1,3,2,1,2,1};
        int prices[]={7,1,5,3,6,4};
        int arr[]={4,5,6,7,8,0,1,2,3};
        //System.out.println(mostprofit(prices));
        trappedwater(height);
        //targetsearch(arr,7);
    }
}
