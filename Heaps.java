import java.util.*;

public class Heaps {
//THIS WAS FOR PRIORITY QUEUES++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    static class Student implements Comparable<Student>
    {
        String name;
        int rank;
        public Student(String name,int rank){
            this.name=name;
            this.rank=rank;
        }
        @Override
        public int compareTo(Student s2){
            return this.rank-s2.rank;
        }
    }
//TILL HERE IT WAS FOR PRIORITYQUEUES+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    static class Heap{
        ArrayList<Integer> arr=new ArrayList<>();
        public void add(int data){
            arr.add(data);
            int x=arr.size()-1;//child index
            int par=(x-1)/2;//parent index
            while(arr.get(x)<arr.get(par)){
                int temp=arr.get(x);
                arr.set(x,arr.get(par));
                arr.set(par,temp);
            }
            x=par;
            par=(x-1)/2;
        }
        public int peek() {
            return arr.get(0);
        }
//        private void heapify(int i){
//            int left=2*i+1;
//            int right=2*i+2;
//            int minIdx=i;
//
//            if(left<arr.size()&&arr.get(left)<arr.get(minIdx)){
//                minIdx=left;
//            }
//            if(right<arr.size()&&arr.get(right)<arr.get(minIdx)){
//                minIdx=right;
//            }
//            if(minIdx!=i){
//                int temp=arr.get(minIdx);
//                arr.set(minIdx,arr.get(i));
//                arr.set(i,temp);
//                heapify(minIdx);
//            }
//        }
//        public int remove(){
//            int data=arr.get(0);
//            arr.set(0,arr.get(arr.size()-1));
//            arr.set(arr.size()-1,data);
//
//            arr.remove(arr.size()-1);
//
//            heapify(0);
//            return data;
//        }
        public boolean isEmpty(){
            return arr.size()==0;
        }
    }
//CODE FOR HEAPSORT+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public static void heapify(int arr[],int i,int size){
        int left = 2*i+1;
        int right = 2*i+2;
        int maxIdx=i;
        if(left<arr.length&&arr[left]>arr[maxIdx]){
            maxIdx=left;
        }
        if(right<arr.length&&arr[right]>arr[maxIdx]){
            maxIdx=right;
        }
        if(maxIdx!=i){
            int temp=arr[i];
            arr[i]=arr[maxIdx];
            arr[maxIdx]=temp;

            heapify(arr,maxIdx,size);
        }
    }
//CODE FOR NEARBY K CARS++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    static class Point implements Comparable<Point>{
        int x;
        int y;
        int distsq;
        int idx;
        public Point(int x,int y,int distsq,int idx){
            this.x=x;
            this.y=y;
            this.distsq=distsq;
            this.idx=idx;
        }
        @Override
        public int compareTo(Point p2){
            return this.distsq-p2.distsq;
    }

}
    public static void heapSort(int arr[]){
        int n=arr.length;
        for(int i=n/2;i>=0;i++){
            heapify(arr,i,n);
        }
        for(int i=n-1;i>=0;i++){
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;

            heapify(arr,0,i);
        }
    }
//CODE FOR WEAKEST SOLDIERS+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    static class Row implements Comparable<Row>{
        int soldiers;
        int idx;

        public Row(int soldiers,int idx){
            this.soldiers=soldiers;
            this.idx=idx;
        }
        @Override
    public int compareTo(Row r2){
            if(this.soldiers==r2.soldiers){
                return this.idx-r2.idx;
            }else{
                return this.soldiers-r2.soldiers;
            }
        }
    }
//MAXIMUM OF SLIDING WINDOW+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    static class Pair implements Comparable<Pair>{
        int val;
        int idx;
        public Pair(int val,int idx){
            this.val=val;
            this.idx=idx;
        }
        @Override
        public int compareTo(Pair p2){
            //ascending
            //return this.val-p2.val;
            //descending
            return p2.val-this.val;
        }
    }
    public static void main(String[] args) {
//COMMAND FOR JCF
//        PriorityQueue<Integer> pq=new PriorityQueue<>(Comparator.reverseOrder());
//        pq.add(1);
//        pq.add(7);
//        pq.add(3);
//        pq.add(5);
//COMMAND FOR PRIORITY QUEUES USING SELFDEFINED CLASS AND FUNCTIONS+++++++++++++++++++++++++++++++++++++++++++++++++++++
//        PriorityQueue<Student> pq=new PriorityQueue<>(Comparator.reverseOrder());
//        pq.add(new Student("A",1));
//        pq.add(new Student("B",4));
//        pq.add(new Student("C",3));
//        pq.add(new Student("D",7));
//        while(!pq.isEmpty()){
//            System.out.println(pq.peek().name+"->"+pq.peek().rank);
//            pq.remove();
//        }
//COMMAND FOR HEAPS+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//        Heap h=new Heap();
//        h.add(3);
//        h.add(4);
//        h.add(1);
//        h.add(5);
//        while (!h.isEmpty()) {
//            System.out.println(h.peek());
//            h.remove();
//        }
//        int pts[][]={{3,3},{5,-1},{-2,4}};
//        int k=2;
//        PriorityQueue<Point> pq=new PriorityQueue<>();
//        for(int i=0;i<pts.length;i++){
//            int distsq=pts[i][0]*pts[i][0]+pts[i][1]*pts[i][1];
//            pq.add(new Point(pts[i][0],pts[i][1],distsq,i));
//        }
//        for(int i=0;i<k;i++){
//            System.out.println("C"+pq.peek().idx);
//            pq.remove();
//        }
//CODE FOR MINIMUM COST FOR CONNECTING N ROPES++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//        PriorityQueue<Integer> pq=new PriorityQueue<>();
//        int ropes[]={2,3,3,4,6};
//        for(int i=0;i< ropes.length;i++){
//            pq.add(ropes[i]);
//        }
//        int cost=0;
//        while(pq.size()>1){
//            int min1=pq.remove();
//            int min2=pq.remove();
//            cost+=min1+min2;
//            pq.add(min1+min2);
//        }
//        System.out.println("minimu  cost is = "+cost);
//COMMAND FOR WEAKEST SOLDIERS++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//        int army[][]={{1,0,0,0},
//                       {1,1,1,1},
//                       {1,0,0,0},
//                       {1,0,0,0}};
//        int k=2;
//        PriorityQueue<Row> pq=new PriorityQueue<>();
//        for(int i=0;i<army.length;i++){
//            int count=0;
//            for(int j=0;j<army[0].length;j++){
//                count+=army[i][j]==1 ? 1:0;
//            }
//            pq.add(new Row(count,i));
//        }
//        for(int i=0;i<k;i++){
//            System.out.println("R"+pq.remove().idx);
//        }
//MAXIMUM OF SLIDING WINDOW+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        int arr[]={1,3,-1,-3,5,3,6,7};
        int k=3;
        int res[]=new int[arr.length-k+1];

        PriorityQueue<Pair> pq=new PriorityQueue<>();
        for(int i=0;i<k;i++){
            pq.add(new Pair(arr[i],i));
        }
        res[0]=pq.peek().val;
        for(int i=k;i<arr.length;i++){
            while(pq.size()>0&&pq.peek().idx<=(i-k)){
                pq.remove();
            }
            pq.add(new Pair(arr[i],i));
            res[i-k+1]=pq.peek().val;
        }
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }
        System.out.println();
    }
}
