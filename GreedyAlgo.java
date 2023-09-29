import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class GreedyAlgo {
//CODE FOR JOB SEQUENCING***********************************************************************************************
    static class Jobs{
        int deadline;
        int profit;
        int id;
        public Jobs(int a,int b,int c){
            id=a;
            deadline=b;
            profit=c;
        }
}
    public static void main(String[] args) {
//COMMAND FOR ACTIVITY SELECTION****************************************************************************************
        //O(nlog(n))
//        int start[]={0,1,3,5,5,8};
//        int end[]={6,2,4,7,9,9};
//        //SORTING BY END
//        int arr[][]=new int[start.length][3];
//        for(int i=0;i<start.length;i++){
//            arr[i][0]=i;
//            arr[i][1]=start[i];
//            arr[i][2]=end[i];
//        }
//        Arrays.sort(arr, Comparator.comparingDouble(o->o[2]));//Comparator.comparingDouble(o->o[2]) lamda function
//
//        int maxAct=0;
//        ArrayList<Integer> ans=new ArrayList<>();
//        maxAct=1;
//        ans.add(arr[0][0]);
//        int lastend=arr[0][2];
//        for(int i=0;i<end.length;i++){
//            if(arr[i][1]>=lastend){
//                maxAct++;
//                ans.add(arr[i][0]);
//                lastend=arr[i][2];
//            }
//        }
//        System.out.println("maximum activities = "+maxAct);
//        for(int i=0;i<ans.size();i++){
//            System.out.print("A"+ans.get(i)+" ");
//        }
//        System.out.println();
//CODE FOR FRACTION KNAPSACK********************************************************************************************
//        int val[]={60,100,120};
//        int weight[]={10,20,30};
//        int W=50;
//        int price=0;
//        double ratio[][]=new double[val.length][2];
//        for(int i=0;i<val.length;i++){
//            ratio[i][0]=i;
//            ratio[i][1]=val[i]/(double)weight[i];
//        }
//        Arrays.sort(ratio,Comparator.comparingDouble(o->o[1]));
//        int capacity=W;
//        int finalval=0;
//        for(int i=ratio.length-1;i>=0;i--){
//            int idx=(int)ratio[i][0];
//            if(weight[idx]<=capacity){
//                finalval=finalval+val[idx];
//                capacity=capacity-weight[idx];
//            }else{
//                finalval=finalval+(int)(ratio[i][1]*capacity);
//                capacity=0;
//                break;
//            }
//        }
//        System.out.println("final value is = "+finalval);
//CODE FOR MAXIMUM ABSOLUTE DIFFERENCE**********************************************************************************
//        int A[]={4,1,8,7};
//        int B[]={2,3,6,5};
//        Arrays.sort(A);
//        Arrays.sort(B);
//        int mindiff=0;
//        for(int i=0;i<A.length;i++){
//            mindiff+=Math.abs(A[i]-B[i]);
//        }
//        System.out.println("minimum difference is = "+mindiff);
//CODE FOR MAXIMUM LENGTH OF CHAIN OF PAIRS*****************************************************************************
//        int pairs[][]={{5,24},{39,60},{5,28},{27,40},{50,90}};
//        Arrays.sort(pairs,Comparator.comparingDouble(o->o[1]));
//        int maxlength=1;
//        int lastend=pairs[0][1];
//        for(int i=0;i< pairs.length;i++){
//            if(pairs[i][0]>=lastend){
//                maxlength++;
//                lastend=pairs[i][1];
//            }
//        }
//        System.out.println("maximum length of chain = "+maxlength);
//MINIMUM NO OF COINS***************************************************************************************************
//        int coins[]={1,2,5,10,20,50,100,500,2000};
//        Arrays.sort(coins);
//        int count=0;
//        int amount=2531;
//        for(int i= coins.length-1;i>=0;i--){
//            while(amount>=coins[i]){
//                count++;
//                amount-=coins[i];
//            }
//        }
//        System.out.println("minimum number of coins required = "+count);
//CODE FOR JOB SEQUENCING***********************************************************************************************
//        int jobsInfo[][]={{4,20},{1,10},{1,40},{1,30}};
//        ArrayList<Jobs> jobs=new ArrayList<>();
//        for(int i=0;i<jobsInfo.length;i++){
//            jobs.add(new Jobs(i,jobsInfo[i][0],jobsInfo[i][1]));
//        }
//        Collections.sort(jobs,(obj1,obj2) -> obj2.profit-obj1.profit);//SORTING IN DESCENDING ORDER
//        int time=0;
//        ArrayList<Integer> arr=new ArrayList<>();
//        for(int i=0;i<jobs.size();i++){
//            Jobs curr=jobs.get(i);
//            if(curr.deadline>time){
//                time++;
//                arr.add(curr.id);
//            }
//        }
//        System.out.println("maximum number of jobs possible = "+arr.size());
//        for(int i=0;i<arr.size();i++){
//            System.out.print(arr.get(i)+" ");
//        }
//        System.out.println();
//CHOCOLA PROBLEM*******************************************************************************************************
        int n=4,m=6;
        Integer costVer[]={2,1,3,1,4};
        Integer costHor[]={4,1,2};
        Arrays.sort(costVer,Collections.reverseOrder());
        Arrays.sort(costHor,Collections.reverseOrder());
        int cost=0;
        int h=0,v=0;
        int hp=1,vp=1;
        while(h<costHor.length&&v< costVer.length){
            if(costVer[v]<=costHor[h]){
                cost+=(costHor[h]*vp);
                h++;
                hp++;
            }else{
                cost+=(costVer[v]*hp);
                v++;
                vp++;
            }
        }
        while(h<costHor.length){
            cost+=(costHor[h]*vp);
            h++;
            hp++;
        }
        while(v<costVer.length){
            cost+=(costVer[v]*hp);
            v++;
            vp++;
        }
        System.out.println("minimum cost is = "+cost);
    }
}
