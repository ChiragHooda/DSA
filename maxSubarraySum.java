public class maxSubarraySum {
    // Brute force method
    public static void subarrayMax(int arr[]){
        int largest= Integer.MIN_VALUE;
        for(int i=0; i<arr.length;i++){
            int start = i;
            for(int j=i;j<arr.length;j++){
                int sum=0;
                int end= j;
                for(int k=start;k<=end;k++){
                    //System.out.print(arr[k]+" ");
                    sum=sum+arr[k];
                    if(sum>largest){
                        largest=sum;
                    }
                }
                //System.out.println(sum);
                //System.out.println();
            }
        }
        System.out.println("Maximum sum is : "+ largest);
    }
    public static void prefixSum(int arr[]){
        int prearr[] = new int[arr.length];
        prearr[0]=arr[0];
        int maxsum=Integer.MIN_VALUE;
        for(int i=1;i<arr.length;i++){
            prearr[i]=prearr[i-1]+arr[i];
        }
        for(int i=0;i<arr.length;i++){
            int start=i;
            int currsum=0;
            for(int j=i;j<arr.length;j++){
                int end=j;
                currsum= start==0? prearr[end]:prearr[end]-prearr[start-1];
                if(currsum>maxsum){
                    maxsum=currsum;
                }
            }
        }
        System.out.println("Maximum sum is : "+maxsum);
    }
    public static void kadane(int arr[]){
        int currsum=0;
        int maxsum=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            currsum+=arr[i];
            if(currsum<0){
                currsum=0;
            }
            if(currsum>maxsum){
                maxsum=currsum;
            }
        }
        System.out.println("Maximum sum is : "+maxsum);
    }

    public static void main(String[] args) {
        int arr[]= {-2,-3,4,-1,-2,1,5,-3};
        subarrayMax(arr);
        prefixSum(arr);
        kadane(arr);
    }
}