public class DivideandConquer {
    public static void mergeSort(int arr[],int si,int ei){
        if(si>=ei){
            return;
        }
        int mid=si+(ei-si)/2;
        mergeSort(arr,si,mid);
        mergeSort(arr,mid+1,ei);
        merge(arr,si,ei,mid);
    }

    public static void merge(int arr[],int si,int ei,int mid){
        int temp[]=new int[ei-si+1];
        int i=si;
        int j=mid+1;
        int k=0;
        while(i<=mid && j<=ei){
            if(arr[i]<arr[j]){
                temp[k]=arr[i];
                i++;
            }else{
                temp[k]=arr[j];
                j++;
            }
            k++;
        }
        while(i<=mid){
            temp[k++]=arr[i++];
        }
        while(j<=ei){
            temp[k++]=arr[j++];
        }
        for(k=0,i=si;k<temp.length;k++,i++){
            arr[i]=temp[k];
        }
    }
    public static void printarr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void quickSort(int arr[],int si,int ei){
        if(si>=ei){
            return;
        }
        int pIdx=partition(arr,si,ei);
        quickSort(arr,si,pIdx-1);
        quickSort(arr,pIdx+1,ei);
    }

    public static int partition(int arr[],int si,int ei){
        int pivot=arr[ei];
        int i=si-1;
        for(int j=si;j<ei;j++){
            if(arr[j]<=pivot){
                i++;
                int temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
            }
        }
        i++;
        int temp=pivot;
        arr[ei]=arr[i];
        arr[i]=temp;
        return i;
    }

    public static int search(int arr[],int si,int ei,int k){
        if(si>ei){
            return -1;
        }
        int mid=si+(ei-si)/2;

        if(arr[mid]==k){
            return mid;
        }

        if(arr[si]<=arr[mid]){
            if(arr[si]<=k && k<=arr[mid]){
                return search(arr,si,mid-1,k);
            }else{
                return search(arr,mid+1,ei,k);
            }
        }

        else{
            if(arr[mid]<=k && k<=arr[ei]){
                return search(arr,mid+1,ei,k);
            }else{
                return search(arr,si,mid-1,k);
            }
        }
    }
    public static void main(String[] args) {
        int arr[]={4,5,6,7,0,1,2};
        //mergeSort(arr,0,arr.length-1);
        //quickSort(arr,0,arr.length-1);
        System.out.println(search(arr,0,arr.length-1,2));
        //printarr(arr);
    }
}
