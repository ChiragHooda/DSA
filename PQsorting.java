public class PQsorting {
    public static void bubblesort(int arr[]){
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[i]){
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
    }

    public static void selectionsort(int arr[]){
        for(int i=0;i<arr.length-1;i++){
            int k=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[k]>arr[j]){
                    k=j;
                }
            }
            int temp=arr[k];
            arr[k]=arr[i];
            arr[i]=temp;
        }
    }

    public static void insertionsort(int arr[]){
        for(int i=1;i<arr.length;i++){
            int curr=arr[i];
            int prev=i-1;
            while(prev>=0 && arr[prev]>curr){
                arr[prev+1]=arr[prev];
                prev--;
            }
            arr[prev+1]=curr;
        }
    }

    public static void countingsort(int arr[]){
        int largest=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>largest){
                largest=arr[i];
            }
        }
        int count[]= new int[largest+1];
        for(int i=0;i<arr.length;i++){
            count[arr[i]]++;
        }
        int j=0;
        for(int i=0;i<largest+1;i++){
            while(count[i]>0){
                arr[j]=i;
                j++;
                count[i]--;
            }
        }
    }
    public static void printarr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[]={3,6,2,1,8,7,4,5,3,1};
        bubblesort(arr);
        printarr(arr);
        int arr2[]={4,6,2,5,9,1,2,5,3};
        selectionsort(arr2);
        printarr(arr2);
        int arr3[]={5,7,4,5,2,7,6,1};
        insertionsort(arr3);
        printarr(arr3);
        int arr4[]={7,8,9,4,4,9,2,4,3,8,5};
        countingsort(arr4);
        printarr(arr4);
    }
}
