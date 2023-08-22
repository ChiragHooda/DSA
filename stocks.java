public class stocks {
    public static int buyAndSellStocks(int arr[]){
        int bp=Integer.MAX_VALUE;
        int maxprofit=0;
        for(int i=0;i<arr.length;i++){
            if(bp<arr[i]){
                int profit = arr[i]-bp;
                maxprofit= Math.max(profit,maxprofit);
            } else{
                bp=arr[i];
            }
        }
        return maxprofit;
    }

    public static void main(String[] args) {
        int prices[]={7,1,5,3,6,4};
        System.out.println(buyAndSellStocks(prices));
    }
}
