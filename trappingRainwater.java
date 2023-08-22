public class trappingRainwater {
    public static void amountOfWater(int arr[]){
        int n=arr.length;
        int leftmax[]=new int[n];
        leftmax[0]=arr[0];
        for(int i=1;i<n;i++){
            //leftmax[i]=(leftmax[i-1]<arr[i])? arr[i]:leftmax[i-1];
            leftmax[i]=Math.max(arr[i],leftmax[i-1]);
        }
        int rightmax[]=new int[n];
        rightmax[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--){
            //rightmax[i]=(rightmax[i-1]<arr[i])? arr[i]:leftmax[i-1];
            rightmax[i]=Math.max(arr[i],rightmax[i+1]);
        }
        int trappedwater=0;
        for(int i=0;i<n;i++){
            int waterLevel=Math.min(rightmax[i],leftmax[i]);
            trappedwater+= waterLevel-arr[i];
        }
        System.out.println("Amount of water trapped is : "+ trappedwater);
    }

    public static void main(String[] args) {
        int height[]={0,1,0,2,1,0,1,3,2,1,2,1};
        amountOfWater(height);
    }
}
