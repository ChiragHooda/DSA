public class SelfPractice {
//    public static void swap(int a, int b){
//        int temp=b;
//        b=a;
//        a=temp;
//    }
//
//    public static void bubbleSort(int arr[]) {
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = i + 1; j < arr.length; j++) {
//                if (arr[i] > arr[j]) {
//                    int temp = arr[i];
//                    arr[i] = arr[j];
//                    arr[j] = temp;
//                }
//            }
//        }
//    }
//
//    public static void selectionSort(int arr[]){
//        for(int i=0;i<arr.length;i++){
//            int k=i;
//            for(int j=i+1;j<arr.length;j++){
//                if(arr[k]>arr[j]){
//                    k=j;
//                }
//            }
//            int temp=arr[i];
//            arr[i]=arr[k];
//            arr[k]=temp;
//        }
//    }
//
//    public static void insertionSort(int arr[]){
//        for(int i=0;i<arr.length;i++){
//            int prev=i-1;
//            int curr=arr[i];
//            while(prev>=0 && arr[prev]>curr){
//                arr[prev+1]=arr[prev];
//                prev--;
//            }
//            arr[prev+1]=curr;
//        }
//    }
//
//    public static void countingSort(int arr[]){
//        int largest=Integer.MIN_VALUE;
//        for(int i=0;i<arr.length;i++){
//            if(arr[i]>largest){
//                largest=arr[i];
//            }
//        }
//        int count[]=new int[largest+1];
//        for(int i=0;i<arr.length;i++){
//            count[arr[i]]++;
//        }
//        int j=0;
//        for(int i=0;i<count.length;i++){
//            if(count[i]>0){
//                arr[j]=i;
//                j++;
//                count[i]--;
//            }
//        }
//    }
//
//    public static void printarr(int arr[]){
//        for(int i=0;i<arr.length;i++){
//            System.out.print(arr[i]+" ");
//        }
//    }
//
//    public static void oddEvenBM(int n){
//        if((n&1)==0){
//            System.out.println("even");
//        }else{
//            System.out.println("odd");
//        }
//    }
//
//    public static void getIBit(int n,int i){
//        int bitMask=1<<i;
//        if((n&bitMask)==0){
//            System.out.println("0");
//        }else{
//            System.out.println("1");
//        }
//    }
//
//    public static int setIBit(int n,int i){
//        int bitMask=1<<i;
//        return (n|bitMask);
//    }
//
//    public static int clearIBit(int n,int i){
//        int bitMask=~(1<<i);
//        return (n&bitMask);
//    }
//
//    public static int updateIBit(int n,int i,int k){
//        if(k==0){
//            return setIBit(n,i);
//        }else{
//            return setIBit(n,i);
//        }
//    }
//
//    public static int clearLastIBits(int n,int i){
//        int bitMask=~0<<i;
//        return (n&bitMask);
//    }
//
//    public static int clearRangeofBits(int n,int i,int j){
//        int a=(~0)<<(j+1);
//        int b=(int)(Math.pow(2,i))-1;
//        int bitMask=a|b;
//        return (n&bitMask);
//    }
//
//    public static boolean isPowerOf2(int n){
//        if((n&(n-1))==0){
//            return true;
//        }else{
//            return false;
//        }
//    }
//
//    public static int countSetBits(int n){
//        int count =0;
//        while(n>0){
//            if((n&1)!=0) {
//                count++;
//            }
//            n = (n >> 1);
//        }
//        return count;
//    }
//
//    public static int FastExponentiation(int a,int n){
//        int ans=1;
//        while(n>0){
//            if((n&1)!=0){
//                ans=ans*a;
//            }
//            a=a*a;
//            n=n>>1;
//        }
//        return ans;
//    }






//    public static void printInDecOrder(int n){
//        if(n==1){
//            System.out.println(1);
//            return;
//        }
//        System.out.print(n+" ");
//        printInDecOrder(n-1);
//    }
//
//    public static void printInIncOrder(int n){
//        if(n==1){
//            System.out.print(1+" ");
//            return;
//        }
//        printInIncOrder(n-1);
//        System.out.print(n+" ");
//    }
//
//    public static int factorial(int n){
//        if(n==0){
//            return 1;
//        }
//        return n*factorial(n-1);
//    }
//
//    public static int sumNnaturalNos(int n){
//        if(n==1){
//            return 1;
//        }
//        return n+sumNnaturalNos(n-1);
//    }
//
//    public static int fibonnaci(int n){
//        if(n==0 || n==1){
//                return n;
//        }
//        return fibonnaci(n-1)+fibonnaci(n-2);
//    }
//
//    public static boolean isSorted(int arr[],int i) {
//        if (i==arr.length-1) {
//            return true;
//        }
//        if (arr[i] > arr[i+1]) {
//            return false;
//        }
//        return isSorted(arr, i+1);
//    }
//
//    public static int FirstOccurrence(int arr[], int key,int index){
//        if(index==arr.length){
//            return -1;
//        }
//        if(arr[index]==key){
//            return index;
//        }
//        return FirstOccurrence(arr,key,index+1);
//    }
//
//    public static int LastOccurrence(int arr[],int key,int length){
//        if(length==0){
//            return 0;
//        }
//        if(arr[length-1]==key){
//            return length-1;
//        }
//        return LastOccurrence(arr,key,length-1);
//    }
//
//    public static int xtoPowern(int x,int n){
//        if(n==0){
//            return 1;
//        }
//        return x*xtoPowern(x,n-1);
//    }
//
//    public static int xToPowerNOptimised(int x,int n){
//        if(n==0){
//            return 1;
//        }
//        int halfpow=xToPowerNOptimised(x,n/2);
//        if(n%2==0){
//            return halfpow*halfpow;
//        }
//        else{
//            return x*halfpow*halfpow;
//        }
//    }
//
//    public static int Tiling(int n){
//        if(n==1||n==2){
//            return n;
//        }
//        //Horizontal
//        return Tiling(n-1)+Tiling(n-2);
//    }
//
//    public static void StringCompression(String str,int i,int count,StringBuilder sb){
//        if(i==str.length()-1){
//            count++;
//            sb.append(str.charAt(i));
//            sb.append(count);
//            System.out.println(sb);
//            return;
//        }
//        if(str.charAt(i)==str.charAt(i+1)){
//            count++;
//            StringCompression(str,i+1,count,sb);
//        }if(str.charAt(i)!=str.charAt(i+1)){
//            sb.append(str.charAt(i));
//
//            StringCompression(str,i+1,0,sb.append(count));
//        }
//    }
//
//    public static void RemoveDuplicates(String str,int i,StringBuilder sb,boolean maps[]){
//        if(i==str.length()){
//            System.out.println(sb);
//            return;
//        }
//        if(maps[str.charAt(i)-'a']==false){
//            maps[str.charAt(i)-'a']=true;
//            RemoveDuplicates(str,i+1,sb.append(str.charAt(i)),maps);
//        }else{
//            RemoveDuplicates(str,i+1,sb,maps);
//        }
//    }
//
//    public static int FriendsPairing(int n){
//        if(n==1 | n==2){
//            return 1;
//        }
//        return FriendsPairing(n-1)+(n-1)*FriendsPairing(n-2);
//    }
//
//    public static void PrintStrings(int n,int lastplace, String str){
//        if(n==0){
//            System.out.println(str);
//            return;
//        }
//        PrintStrings(n-1,0,str+"0");
//        if(lastplace==0){
//            PrintStrings(n-1,1,str+"1");
//        }
//    }







//    public static void mergeSort(int arr[],int si,int ei){
//        if(si>=ei){
//            return;
//        }
//        int mid=si+(ei-si)/2;
//        mergeSort(arr,si,mid);
//        mergeSort(arr,mid+1,ei);
//        merge(arr,si,ei,mid);
//    }
//
//    public static void merge(int arr[],int si,int ei,int mid){
//        int temp[]=new int[ei-si+1];
//        int i=si;
//        int j=mid+1;
//        int k=0;
//        while(i<=mid && j<=ei){
//            if(arr[i]<arr[j]){
//                temp[k]=arr[i];
//                i++;
//                k++;
//            }else{
//                temp[k]=arr[j];
//                j++;
//                k++;
//            }
//        }
//        while(i<=mid){
//            temp[k++]=arr[i++];
//        }
//        while(j<=ei){
//            temp[k++]=arr[j++];
//        }
//        for(k=0,i=si;k<temp.length;k++,i++){
//            arr[i]=temp[k];
//        }
//    }
//
//    public static void printarr(int arr[]){
//        for(int i=0;i<arr.length;i++){
//            System.out.print(arr[i]+" ");
//        }
//        System.out.println();
//    }
//
//    public static void quickSort(int arr[],int si,int ei){
//        if(si>=ei){
//            return;
//        }
//        int pIdx=partition(arr,si,ei);
//        quickSort(arr,si,pIdx-1);
//        quickSort(arr,pIdx+1,ei);
//    }
//
//    public static int partition(int arr[],int si,int ei){
//        int pivot=arr[ei];
//        int i=si-1;
//        for(int j=si;j<ei;j++){
//            if(arr[j]<pivot){
//                i++;
//                int temp=arr[i];
//                arr[i]=arr[j];
//                arr[j]=temp;
//            }
//        }
//        i++;
//        int temp=arr[i];
//        arr[i]=arr[ei];
//        arr[ei]=temp;
//        return i;
//    }
//
//    public static int search(int arr[],int si,int ei,int k){
//        if(si>ei){
//            return -1;
//        }
//        int mid=si+(ei-si)/2;
//
//        if(arr[mid]==k){
//            return mid;
//        }
//
//        if(arr[si]<=arr[mid]){
//            if(arr[si]<=k && arr[mid]>=k){
//                return search(arr,si,mid-1,k);
//            }else{
//                return search(arr,mid+1,ei,k);
//            }
//        }
//
//        else{
//            if(arr[mid]<=k && arr[ei]>=k){
//                return search(arr,mid+1,ei,k);
//            }else{
//                return search(arr,si,mid-1,k);
//            }
//        }
//    }








    public static void SubStrings(String str, int i,String ans){
        if(i==str.length()){
            if(ans.length()==0){
                System.out.println("null");
            }else{
                System.out.println(ans);
            }
            return;
        }

        SubStrings(str,i+1,ans+str.charAt(i));
        SubStrings(str,i+1,ans);
    }

    public static void Permutations(String str,String ans){

        if(str.length()==0){
            System.out.println(ans);
            return;
        }
        for(int i=0;i<str.length();i++){
            char curr=str.charAt(i);
            String newStr=str.substring(0,i)+str.substring(i+1);
            Permutations(newStr,ans+curr);
        }
    }

    public static void main(String[] args) {
//        int arr[]={5,4,3,1,2};
//        bubbleSort(arr);
//        selectionSort(arr);
//        insertionSort(arr);
//        countingSort(arr);
//        printarr(arr);
//        oddEvenBM(5);
//        getIBit(5,2);
//        System.out.println(setIBit(3,2));
//        System.out.println(clearIBit(15,1));
//        System.out.println(clearLastIBits(15,2));
//        System.out.println(clearRangeofBits(15,0,2));
//        System.out.println(isPowerOf2(16));
//        System.out.println(countSetBits(15));
//        System.out.println(FastExponentiation(3,5));
//        printInDecOrder(5);
//        printInIncOrder(5);
//        System.out.println();
//        System.out.println(factorial(5));
//        System.out.println(sumNnaturalNos(5));
//        System.out.println(fibonnaci(5));
//        int arr[]={1,2,3,4,5,6,3,4,5,8,2,1,0};
//        System.out.println(isSorted(arr,0));
//        System.out.println(FirstOccurrence(arr,5,0));
//        System.out.println(LastOccurrence(arr,5,arr.length));
//        System.out.println(xtoPowern(3,5));
//        System.out.println(xToPowerNOptimised(5,4));
//        System.out.println(Tiling(4));
//         String str="aaabbcccc";
//        StringBuilder sb=new StringBuilder("");
//        StringCompression(str,0,1,sb);
//        StringBuilder sb1=new StringBuilder("");
//        boolean maps[]=new boolean[26];
//        RemoveDuplicates(str,0,sb1,maps);
//        System.out.println(FriendsPairing(3));
//        String str=new String("");
//        PrintStrings(3,0,str);
//        int arr[]={4,5,6,7,0,1,2};
//        mergeSort(arr,0,arr.length-1);
        //quickSort(arr,0,arr.length-1);
//        int taridx=search(arr,0,arr.length-1,0);
//        System.out.println(taridx);
//        printarr(arr);
        String str="abc";
        String ans=new String("");
//        SubStrings(str,0,ans);
        Permutations(str,ans);
    }
}
