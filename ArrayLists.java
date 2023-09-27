import java.util.ArrayList;
import java.util.Collections;
public class ArrayLists {
    public static int containerWithMostWater(ArrayList<Integer> height){
        int maxwater=0;
        int lp=0;
        int rp=height.size()-1;
        while(lp<rp){
            int ht=Math.min(height.get(lp),height.get(rp));
            int width=rp-lp;
            int currwater=ht*width;
            maxwater=Math.max(maxwater,currwater);
            if(height.get(lp)<height.get(rp)){
                lp++;
            }else{
                rp--;
            }
        }
        return maxwater;
    }

    public static boolean PairSum(ArrayList<Integer> lst, int target){
        int lp=0;
        int rp=lst.size()-1;
        while(lp<rp){
            if(lst.get(lp)+lst.get(rp)==target){
                return true;
            }
            if(lst.get(lp)+lst.get(rp)<target){
                lp++;
            }else{
                rp--;
            }
        }
        return false;
    }

    public static boolean PairSum2(ArrayList<Integer> list,int target){
        int bp=-1;
        for(int i=0;i<list.size();i++){
            if(list.get(i)>list.get(i+1)){
                bp=i;
                break;
            }
        }
        int n=list.size();
        int lp=bp+1;
        int rp=bp;
        while(lp!=rp){
            if(list.get(lp)+list.get(rp)==target){
                return true;
            }
            if(list.get(lp)+list.get(rp)<target){
                lp=(lp+1)%n;
            }else{
                rp=(n+rp-1)%n;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        //vectors
        //Classname onjectname=new Classname()
//        ArrayList<Integer> lst=new ArrayList<>();
//        ArrayList<String> lst1=new ArrayList<>();
//        ArrayList<Boolean> lst2=new ArrayList<>();
        //ADD ELEMENT
//        lst.add(2); //O(1)
//        lst.add(8);
//        lst.add(7);
//        lst.add(6);
//        lst.add(4);
        //SIZE
//        System.out.println(lst.size());
//        System.out.println(lst);
        //GET ELEMENT->O(1)
//        int element=lst.get(2);
//        System.out.println(element);//enteer index in bracket

        //DELETE ELEMENT->O(n)
//        lst.remove(2);
//        System.out.println(lst);

        //SET ELEMENT->O(n)
//        lst.set(2,11);
//        System.out.println(lst);

        //CONTAINS->O(n)
//        System.out.println(lst.contains(11));
//        System.out.println(lst.contains(8));
//        lst.add(1,9);//->O(n) will increse the six=ze of arraylist and put 9 at index 1 and push other elements one index further
//        System.out.println(lst.size());
//        System.out.println(lst);
        //PRINT ARRAYLIST
//        for(int i=0;i<lst.size();i++){
//            System.out.print(lst.get(i)+" ");
//        }
//        System.out.println();
        //SORTING
        //all types of sorts are applicable here also-> bubble, insertion, selection, merge, quick, count
        //IN-BUILT SORTING
//        System.out.println(lst);
//        Collections.sort(lst);
//        System.out.println(lst);
        //DESCCENDING
//        Collections.sort(lst,Collections.reverseOrder());
//        System.out.println(lst);
        //MULTI-DIMENTIONAL ARRAYLISTS
//        ArrayList<ArrayList<Integer>> mainlist=new ArrayList<>();
//        ArrayList<Integer> list1=new ArrayList<>();
//        ArrayList<Integer> list2=new ArrayList<>();
//        ArrayList<Integer> list3=new ArrayList<>();
//        for(int  i=1;i<=5;i++){
//            list1.add(i*1);
//            list2.add(i*2);
//            list3.add(i*3);
//        }
//        mainlist.add(list1);
//        mainlist.add(list2);
//        mainlist.add(list3);
//        list2.remove(2);
//        list3.remove(3);
//        System.out.println(mainlist);
//        for(int i=0;i<mainlist.size();i++){
//            ArrayList<Integer> currlist=mainlist.get(i);
//            for(int j=0;j<currlist.size();j++){
//                System.out.print(currlist.get(j)+" ");
//            }
//            System.out.println();
//        }
        ArrayList<Integer> height=new ArrayList<>();
        height.add(11);
        height.add(15);
        height.add(6);
        height.add(8);
        height.add(9);
        height.add(10);

        System.out.println(PairSum2(height,16));
    }
}
