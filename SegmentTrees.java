public class SegmentTrees {
    static int tree[];
    public static void init(int n){
        tree = new int[4*n];
    }
    public static int buildST(int arr[],int i,int start,int end){
        if(start==end){
            tree[i]=arr[start];
            return arr[start];
        }
        int mid=start+(end-start)/2;
        buildST(arr,2*i+1,start,mid);//left subtree
        buildST(arr,2*i+2,mid+1,end);//right subtree
        tree[i]=tree[2*i+1]+tree[2*i+2];
        return tree[i];
    }
    public static int getSumUtil(int i,int si,int sj,int qi,int qj){
        if(qj <= si || sj <= qi){
            return 0;
        }else if(si >= qi && sj <= qj){
            return tree[i];
        }else{
            int mid = si + (sj-si)/2;
            int left = getSumUtil(2*i+1, si, mid, qi, qj);//left subtree
            int right = getSumUtil(2*i+2,mid+1, sj, qi, qj);//right subtree
            return left + right;
        }
    }
    public static int getSum(int arr[],int qi,int qj){
        int n=arr.length;
        return getSumUtil(0,0,n-1, qi, qj);
    }
    public static void updateUtil(int i, int si, int sj, int idx, int diff){
        if( si > idx || sj < idx ) {
            return;
        }
        tree[i]+=diff;
        if( si != sj ){//non leaf
            int mid=si+(sj-si)/2;
            updateUtil(2*i+1, si, mid, idx, diff);
            updateUtil(2*i+2, mid+1, sj, idx, diff);
        }
    }
    public static void update(int arr[], int idx, int newval){
        int n = arr.length;
        int diff = newval-arr[idx];
        arr[idx]= newval;

        updateUtil(0, 0, n-1, idx, diff);
    }
    public static void buildMaxMinTree(int i, int si, int sj, int arr[]){
        if( si == sj ){
            tree[i] = arr[si];
            return;
        }
        int mid = si + (sj-si)/2;
        buildMaxMinTree(2*i+1, si, mid, arr);
        buildMaxMinTree(2*i+2,mid+1, sj, arr);

        tree[i] = Math.max( tree[2*i+1], tree[2*i+2] );
    }
    public static int getMaxUtil(int i, int si, int sj, int qi, int qj){
        if( si > qj || qi > sj ){
            return Integer.MIN_VALUE;
        }else if( si >= qi && sj <= qj ){
            return tree[i];
        }else{
            int mid = si + (sj-si)/2;
            int leftAns = getMaxUtil(2 * i + 1, si, mid, qi, qj);
            int rightAns = getMaxUtil(2 * i + 2, mid + 1, sj, qi, qj);
            return Math.max(leftAns, rightAns);
        }
    }
    public static int getMax(int arr[], int qi, int qj){
        int n = arr.length;
        return getMaxUtil(0, 0, n-1, qi, qj);
    }
    public static void updateMaxUtil(int i, int si, int sj, int idx, int newVal){
        if( idx < si || idx > sj ){
            return;
        }
        else if( si == sj ){
            tree[i]=newVal;
        }else if( si != sj ){
            tree[i] = Math.max( newVal, tree[i] );
            int mid = si + (sj-si)/2;
            updateMaxUtil(2*i+1, si, mid, idx, newVal);
            updateMaxUtil(2*i+2, mid+1, sj, idx, newVal);
        }
    }

    public static void updateMax(int arr[], int idx, int newVal){
        arr[idx]=newVal;
        int n = arr.length;
        updateMaxUtil(0, 0, n-1, idx, newVal);
    }

    public static void main(String[] args) {
//        int arr[]={1,2,3,4,5,6,7,8};
//        int n=arr.length;
//        init(n);
//        buildST(arr,0,0,n-1);

//        for(int i=0;i<tree.length;i++){
//            System.out.print(tree[i]+" ");
//        }

//        System.out.println(getSum(arr,2,5));
//        update(arr, 2, 2);
//        System.out.println(getSum(arr,2,5));

        int arr2[] = {6, 8, -1, 2, 17, 1, 3, 2, 4};
        int n2= arr2.length;
        init(n2);
        buildMaxMinTree(0,0,n2-1,arr2);

        for(int i=0;i<tree.length;i++){
            System.out.print(tree[i]+" ");
        }
        System.out.println();
        int max = getMax(arr2,2,5);
        System.out.println(max);
        updateMax(arr2,2,20);
        max = getMax(arr2,2,5);
        System.out.println(max);
    }
}
