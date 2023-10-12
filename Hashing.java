import java.util.*;
import java.util.LinkedList;

public class Hashing {
//HASHMAP IMPLEMENTATION CODE+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//    static class Hashmap<K,V>{//K,V  generic variables
//        public class Node{
//            K key;
//            V value;
//            public Node(K key,V value){
//                this.key=key;
//                this.value=value;
//            }
//        }
//        private int n;
//        private int N;
//        private LinkedList<Node> buckets[];
//        @SuppressWarnings("unchecked")
//        public Hashmap(){
//            this.N=4;
//            this.buckets=new LinkedList[4];
//            for(int i=0;i<4;i++){
//                this.buckets[i]=new LinkedList<>();
//            }
//        }
//        private int hashFunction(K key){
//            int hc=key.hashCode();
//            return Math.abs(hc) % N;
//        }
//        private int searchInLL(K key,int bi){
//            LinkedList<Node> ll=buckets[bi];
//            int di=0;
//            for(int i=0;i<ll.size();i++){
//                Node node=ll.get(i);
//                if(node.key==key){
//                    return di;
//                }
//                di++;
//            }
//            return -1;
//        }
////        @SuppressWarnings("unchecked")
//        private void rehash(){
//            LinkedList<Node> oldBuck[]=buckets;
//            buckets=new LinkedList[N*2];
//            for(int i=0;i<buckets.length;i++){
//                buckets[i]=new LinkedList<>();
//            }
//            for(int i=0;i<oldBuck.length;i++){
//                LinkedList<Node> ll=buckets[i];
//                for(int j=0;j<ll.size();j++){
//                    Node node=ll.get(j);
//                    put(node.key,node.value);
//                }
//            }
//        }
//        public void put(K key,V value){
//            int bi=hashFunction(key);
//            int di=searchInLL(key,bi);
//
//            if(di!=-1){
//                Node node=buckets[bi].get(di);
//                node.value=value;
//            }
//            else {
//                buckets[bi].add(new Node(key,value));
//                n++;
//            }
//            double lamda=(double)n/N;
//            if (lamda>2.0){
//                rehash();
//            }
//        }
//        public boolean containsKey(K key){
//            int bi=hashFunction(key);
//            int di=searchInLL(key,bi);
//            if(di!=-1){
//                return true;
//            }else {
//                return false;
//            }
//        }
//        public V remove(K key){
//            int bi=hashFunction(key);
//            int di=searchInLL(key,bi);
//            if(di!=-1){
//                Node node=buckets[bi].remove(di);
//                n--;
//                return node.value;
//            }else {
//                return null;
//            }
//        }
//        public V get(K key){
//            int bi=hashFunction(key);
//            int di=searchInLL(key,bi);
//            if(di!=-1){
//                Node node=buckets[bi].get(di);
//                return node.value;
//            }else {
//                return null;
//            }
//        }
//        public ArrayList<K> keySet(){
//            ArrayList<K> keys=new ArrayList<>();
//            for(int i=0;i<buckets.length;i++){
//                LinkedList<Node> ll=buckets[i];
//                for (Node node:ll) {
//                    keys.add(node.key);
//                }
//            }
//            return keys;
//        }
//        public boolean isEmpty(){
//            return n==0;
//        }
//}
//CODE OFR VALID ANAGRAM++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public static boolean isAnagram(String s,String t){
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            Character ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(int i=0;i<t.length();i++){
            Character ch=t.charAt(i);
            if(map.get(ch)!=null){
                if(map.get(ch)==1){
                    map.remove(ch);
                }else{
                    map.put(ch,map.get(ch)-1);
                }
            }else{
                return false;
            }
        }
        return map.isEmpty();
    }
//ITINERARY FOR TICKETS+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public static String getStart(HashMap<String,String> tickets){
        HashMap<String,String> revMap=new HashMap<>();
        for (String keys:tickets.keySet()) {
            revMap.put(tickets.get(keys),keys);
        }
        for (String keys:tickets.keySet()) {
            if(!revMap.containsKey(keys)){
                return keys;
            }
        }
        return null;
    }
    public static void main(String[] args) {
//        Hashmap<String,Integer> hmm=new Hashmap<>();
//
//        hmm.put("India",150);
//        hmm.put("China",135);
//        hmm.put("US",50);
//        hmm.put("Nepal",5);
//
//        ArrayList<String> keys=hmm.keySet();
//        for (String key:keys) {
//            System.out.println(key);
//        }
//        System.out.println(hmm.get("India"));
//        System.out.println(hmm.remove("US"));
//        System.out.println(hmm.get("US"));
        //O(1)
//        int population=hm.get("India");
//        System.out.println(population);
//        System.out.println(hm.get("Spain"));
//        //O(1)
//        System.out.println(hm.containsKey("India"));
//        System.out.println(hm.containsKey("Spain"));
//        System.out.println(hm.remove("Spain"));
//        System.out.println(hm);
//
//        System.out.println(hm.size());
//
//        hm.clear();
//        System.out.println(hm.isEmpty());
//        Set<String> keys=hm.keySet();
//        System.out.println(keys);
//        for (String k:keys) {
//            System.out.println("key = "+k+" , value = "+hm.get(k));
//        }
//        HashMap<String, Integer> hm=new HashMap<>();
//        hm.put("India",150);
//        hm.put("China",135);
//        hm.put("US",50);
//        System.out.println(hm);
//        LinkedHashMap<String,Integer> hmm=new LinkedHashMap<>();
//        hmm.put("India",150);
//        hmm.put("China",135);
//        hmm.put("US",50);
//        System.out.println(hmm);
//        TreeMap<String,Integer> tmm= new TreeMap<>();
//        tmm.put("India",150);
//        tmm.put("China",135);
//        tmm.put("US",50);
//        System.out.println(tmm);
//CODE FOR MAJORITY ELEMENT+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        int arr[]={1,3,2,5,1,3,1,5,1};
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        Set<Integer> keys=map.keySet();
        for (Integer key:keys) {
            if(map.get(key) > arr.length/3){
                System.out.println(key);
            }
        }
//CODE OFR VALID ANAGRAM++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        String s="race";
        String t="care";
        System.out.println(isAnagram(s,t));

        HashSet<Integer> hs=new HashSet<>();
        hs.add(5);
        hs.add(2);
        hs.add(3);
        hs.add(1);
        hs.add(6);
        hs.add(4);
        hs.add(1);
        hs.add(2);
//        System.out.println(hs);
        System.out.println(hs.size());
        if(hs.contains(2)){
            System.out.println("set contains 2");
        }
        if(hs.contains(9)){
            System.out.println("set contains 9");
        }
        Iterator it=hs.iterator();
        while(it.hasNext()){
            System.out.print(it.next()+" ");
        }
        System.out.println();
        LinkedHashSet<Integer> lhs=new LinkedHashSet<>();
        lhs.add(1);
        lhs.add(2);
        lhs.add(5);
        lhs.add(3);
        lhs.add(6);
        lhs.add(4);
        lhs.add(1);
        lhs.add(2);
        System.out.println(lhs);
        TreeSet<Integer> ts=new TreeSet<>();
        ts.add(1);
        ts.add(2);
        ts.add(5);
        ts.add(3);
        ts.add(6);
        ts.add(4);
        ts.add(1);
        ts.add(2);
        System.out.println(ts);
//COUNT DISTINCT ELEMENTS+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        int array[]={1,3,5,7,9,3,1,5,0,1,0,2,0,20,4,5,1,2,815,515,8,98,8,5,8,6,2,8,9,9,22,8,2,8};
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<array.length;i++){
            set.add(array[i]);
        }
        System.out.println("Number of distinct elements = "+set.size());
//UNION AND INTERSECTION++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        int arr1[]={7,3,9};
        int arr2[]={6,3,9,2,9,4};
        HashSet<Integer> hset=new HashSet<>();
        for(int i=0;i<arr1.length;i++){
            hset.add(arr1[i]);
        }
        for(int i=0;i<arr2.length;i++){
            hset.add(arr2[i]);
        }
        System.out.println(hset);
        System.out.println(("Union = "+hset.size()));
        hset.clear();
        int count=0;
        for(int i=0;i<arr1.length;i++){
            hset.add(arr1[i]);
        }
        for(int i=0;i<arr2.length;i++){
            if(hset.contains(arr2[i])){
                count++;
                System.out.print(arr2[i]+" ");
                hset.remove(arr2[i]);
            }
        }
        System.out.println();
        System.out.println("Intersection = "+count);
//INTINERARY FOR TICKETS++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        HashMap<String,String> tickets=new HashMap<>();
        tickets.put("Chennai","Bengaluru");
        tickets.put("Mumbai","Delhi");
        tickets.put("Goa","Chennai");
        tickets.put("Delhi","Goa");
        String start=getStart(tickets);
        System.out.print(start);
        for (String key:tickets.keySet()) {
            System.out.print("->"+tickets.get(start));
            start=tickets.get(start);
        }
        System.out.println();
//LARGEST SUBARRAY WITH SUM 0
        int arr3[]={15,-2,2,-8,1,7,10,23};
        HashMap<Integer,Integer> map1=new HashMap<>();

        int sum=0;
        int len=0;
        for(int j=0;j<arr3.length;j++){
            sum+=arr3[j];
            if(map1.containsKey(sum)){
                len=Math.max(len,j-map1.get(sum));
            }else{
                map1.put(sum,j);
            }
        }
        System.out.println("largest subarray length = "+len);
//NUMBER OF SUBARRAYS WITH SUM K++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        int arr4[]={10,2,-2,-20,10};
        int k=-10;

        HashMap<Integer,Integer> hm=new HashMap<>();
        hm.put(0,1);
        int sum1=0;
        int count1=0;

        for(int j=0;j<arr4.length;j++){
            sum1+=arr4[j];
            if(hm.containsKey(sum1-k)){
                count1+=hm.get(sum1-k);
            }
            hm.put(sum1,hm.getOrDefault(sum1,0)+1);
        }
        System.out.println(count1);
    }
}
