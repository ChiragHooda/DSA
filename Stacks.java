import java.util.*;
public class Stacks {
//STACK USING ARRAYLIST******************************************************************
    static ArrayList<Integer> list=new ArrayList<>();
    public static boolean isEmpty(){
        return  list.size()==0;
    }
    public static void push(int val){
        list.add(val);
    }
    public static int pop(){
        int val=list.get(list.size()-1);
        list.remove(list.size()-1);
        return val;
    }
    public static int peek(){
        return list.get(list.size()-1);
    }
//STACK USING LINKEDLIST****************************************************************
    public static class Node{
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    static class stack{
        static Node head=null;
        public static boolean isEmpty(){
            return head==null;
        }
        public static void push(int data){
            Node newnode=new Node(data);
            if(head==null){
                head=tail=newnode;
                return;
            }
            newnode.next=head;
            head=newnode;
        }
        public static int pop(){
            if(isEmpty()){
                System.out.println("Stack is empty");
                return -1;
            }
            int val=head.data;
            Node temp=head.next;
            head.next=null;
            head=temp;
            return val;
        }
        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            return head.data;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;
    public static void pushAtBottomofStack(Stack<Integer> s,int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top=s.pop();
        pushAtBottomofStack(s,data);
        s.push(top);
    }
    public static String reverseString(String str){
        Stack<Character> s=new Stack();
        int idx=0;
        while(idx<str.length()){
            s.push(str.charAt(idx));
            idx++;
        }
        StringBuilder result=new StringBuilder();
        while(!s.isEmpty()){
            char curr=s.pop();
            result.append(curr);
        }
        str=result.toString();
        return result.toString();
    }

    public static void reverseStack(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }
        int top=s.pop();
        reverseStack(s);
        pushAtBottomofStack(s,top);
    }

    public static void printStack(Stack<Integer> s){
        while(!s.isEmpty()){
            int top=s.pop();
            System.out.println(top);
        }
    }

    public static void StockSpan(int stock[],int span[]){
        Stack<Integer> s=new Stack<>();
        span[0]=1;
        s.push(0);
        for(int i=1;i<stock.length;i++){
            int curr=stock[i];
            while(!s.isEmpty()&&curr>stock[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                span[i]=i+1;
            }else{
                int prevHigh=s.peek();
                span[i]=i-prevHigh;
            }
            s.push(i);
        }
    }

    public static boolean isValidParenthesis(String str){
        Stack<Character> s=new Stack<>();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='('||str.charAt(i)=='['||str.charAt(i)=='{'){
                s.push(str.charAt(i));
            }else{
                if((str.charAt(i)==')'&&s.peek()=='(')||
                        (str.charAt(i)==']'&&s.peek()=='[')||
                        (str.charAt(i)=='}'&&s.peek()=='{')){
                    s.pop();
                }else{
                    return false;
                }
            }
        }
        if(s.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
    public static void nextGreaterElement(int arr[],int nxtgreater[]){//O(n)
        Stack<Integer> s=new Stack<>();
        int n=arr.length;
        for(int i=n-1;i>=0;i--) {
            while (!s.isEmpty() && arr[i] >= arr[s.peek()]) {
                s.pop();
            }
            if(s.isEmpty()){
                nxtgreater[i]=-1;
            }else{
                nxtgreater[i]=arr[s.peek()];
            }
            s.push(i);
        }
        //next greater right
        //next smallest left
        //next smallest right
    }

    public static boolean DuplicateParenthesis(String str){
        Stack<Character> s=new Stack<>();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==')'){
                int count=0;
                while(s.peek()!='('){
                    s.pop();
                    count++;
                }
                if(count<1){
                    return true;
                }else{
                    s.pop();
                }
            }else{
                s.push(str.charAt(i));
            }
        }
        return false;
    }

    public static void maxAreaOfHistogram(int arr[]){
        Stack<Integer> s=new Stack<>();
        int n=arr.length;
        int nsl[]=new int[n];
        int nsr[]=new int[n];
        int maxArea=0;
        for(int i=nsr.length-1;i>=0;i--){
            while(!s.isEmpty()&&arr[i]<=arr[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                nsr[i]=n;
            }else{
                nsr[i]=s.peek();
            }
            s.push(i);
        }
        for(int i=0;i<nsl.length;i++){
            while(!s.isEmpty()&&arr[i]<=arr[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                nsl[i]=-1;
            }else{
                nsl[i]=s.peek();
            }
            s.push(i);
        }
        for(int i=0;i<arr.length;i++){
            int height=arr[i];
            int width=nsr[i]-nsl[i]-1;
            int currarea=height*width;
            maxArea=Math.max(maxArea,currarea);
        }
        System.out.println(maxArea);
    }

    public static String decodeString(String str) {
        Stack<Integer> integer = new Stack<>();
        Stack<Character> string = new Stack<>();
        String temp="",result="";
        for(int i=0;i<str.length();i++){
            int count=0;
            if(Character.isDigit(str.charAt(i))){
                while(Character.isDigit(str.charAt(i))){
                    count=count*10+str.charAt(i)-'0';
                    i++;
                }
                i--;
                integer.push(count);
            }
            else if(str.charAt(i)==']'){
                temp="";
                count=0;
                if(!integer.isEmpty()){
                    count=integer.peek();
                    integer.pop();
                }
                while(!string.isEmpty()&&string.peek()!='['){
                    temp=temp+string.peek();
                    string.pop();
                }
                if(!string.isEmpty()&&string.peek()=='['){
                    string.pop();
                }
                for(int j=0;j<count;j++){
                    result=result+temp;
                }
                for(int j=0;j<result.length();j++){
                    string.push(result.charAt(j));
                }
                result="";
            }
            else if(str.charAt(i)=='['){
                if(Character.isDigit(str.charAt(i-1))){
                    string.push(str.charAt(i));
                }else{
                    string.push(str.charAt(i));
                    integer.push(1);
                }
            }
            else{
                if(str.charAt(i-1)==']'&&str.charAt(i)!=']'){

                }else{
                    string.push(str.charAt(i));
                }
            }
        }
        reverseStackString(string);
        while(!string.isEmpty()){
            result=string.peek()+result;
            string.pop();
        }
        return result;
    }
    public static void reverseStackString(Stack<Character> s){
        if(s.isEmpty()){
            return;
        }
        char top=s.pop();
        reverseStackString(s);
        pushAtBottomofStackString(s,top);
    }
    public static void pushAtBottomofStackString(Stack<Character> s,char data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        char top=s.pop();
        pushAtBottomofStackString(s,data);
        s.push(top);
    }
    public static void main(String[] args) {
        //STACK USING JCF***************************************************************
        Stack<Integer> s=new Stack<>();
        //COMMAND FOR ALL OF THE ABOVE METHODS******************************************
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        reverseStack(s);
        printStack(s);
//        pushAtBottomofStack(s,0);
        pushAtBottomofStack(s,-1);
        pushAtBottomofStack(s,-2);
        pushAtBottomofStack(s,-3);
        String str="abc";
        String result=reverseString(str);
        System.out.println(result);
        int stock[]={100,80,60,70,60,85,100};
        int span[]=new int[stock.length];
        StockSpan(stock,span);
        for(int i=0;i<span.length;i++){
            System.out.print(span[i]+" ");
        }
        System.out.println();
        int arr[]={6,8,0,1,3};
        int nxtgreater[]=new int[arr.length];
        nextGreaterElement(arr,nxtgreater);
        for(int i=0;i<nxtgreater.length;i++){
            System.out.print(nxtgreater[i]+" ");
        }
        String str4="((({}[({})])))";
        System.out.println(isValidParenthesis(str4));
        String str1="((a+b))";
        String str2="(a+b)";
        System.out.println(DuplicateParenthesis(str1));
        System.out.println(DuplicateParenthesis(str2));
        int arr1[]={2,1,5,6,2,3};
        maxAreaOfHistogram(arr1);
        String str3="3[b2[v]3[c]]L";
        System.out.println(decodeString(str3));
    }
}
