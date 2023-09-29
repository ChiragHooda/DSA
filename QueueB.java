import java.util.*;
import java.util.LinkedList;

public class QueueB {
//    static class Queue {
//CODE FOR NORMAL QUEUE*******************************************************************
//        static int arr[];
//        static int size;
//        static int rear;
//        Queue(int n){
//            arr=new int[n];
//            size=n;
//            rear=-1;
//        }
//        public static boolean isEmpty(){
//            return rear==-1;
//        }
//        public static void add(int data){
//            if(rear==arr.length-1){
//                System.out.println("Queue is full");
//                return;
//            }
//            rear=rear+1;
//            arr[rear]=data;
//        }
//        public static int remove(){
//            if(isEmpty()){
//                System.out.println("Queue is empty");
//                return -1;
//
//            }
//            int front=arr[0];
//            for(int i=0;i<rear;i++){
//                arr[i]=arr[i+1];
//            }
//            rear--;
//            return front;
//        }
//        public static int peek(){
//            if(isEmpty()){
//                System.out.println("Queue is empty");
//                return -1;
//            }
//            return arr[0];
//        }

//CODE FOR CIRCULAR QUEUE****************************************************************
//        static int arr[];
//        static int size;
//        static int rear;
//        static int front;
//        Queue(int n){
//            arr=new int[n];
//            size=n;
//            rear=front=-1;
//        }
//        public static boolean isEmpty(){
//            return front==-1&rear==-1;
//        }
//        public static boolean isFull(){
//            return (rear+1)%size==front;
//        }
//        public static void add(int data){
//            if(isFull()){
//                System.out.println("Queue is full");
//                return;
//            }
//            if(front==-1){
//                front=0;
//            }
//            rear=(rear+1)%size;
//            arr[rear]=data;
//        }
//        public static int remove(){
//            if(isEmpty()){
//                System.out.println("Queue is empty");
//                return -1;
//            }
//            int temp=arr[front];
//            if(rear==front){
//                rear=front=-1;
//            }else{
//                front=(front+1)%size;
//            }
//            return temp;
//        }
//        public static int peek(){
//            return arr[front];
//        }
//    }
//    }
//QUEUE USING LINKED LIST****************************************************************
//    static class Node{
//        int data;
//        Node next;
//        Node(int data){
//            this.data=data;
//            this.next=null;
//        }
//    }
//    static class Queue{
//        static Node head=null;
//        static Node tail=null;
//        public static boolean isEmpty(){
//            return head==null&tail==null;
//        }
//        public static void add(int data){
//            Node newnode=new Node(data);
//            if(isEmpty()){
//                head=tail=newnode;
//            }
//            tail.next=newnode;
//            newnode.next=null;
//            tail=newnode;
//        }
//        public static int remove(){
//            if(isEmpty()){
//                System.out.println("Queue is empty");
//                return -1;
//            }
//            Node temp=head;
//            if(head==tail){
//                head=tail=null;
//            }else {
//                head = head.next;
//            }
//            return temp.data;
//        }
//        public static int peek(){
//            if(isEmpty()){
//                System.out.println("Queue is empty");
//                return -1;
//            }
//            return head.data;
//        }
//    }
//QUEUE USING 2 STACKS*******************************************************************
//    static class Queue {
//    static Stack<Integer> mainstack = new Stack<>();
//    static Stack<Integer> helperstack = new Stack<>();
//
//    public static boolean isEmpty() {
//        return mainstack.isEmpty();
//    }
//    public static void add(int data){
//        if(mainstack.isEmpty()){
//            mainstack.push(data);
//            return;
//        }
//        while(!mainstack.isEmpty()){
//            helperstack.push(mainstack.pop());
//        }
//        mainstack.push(data);
//        while(!helperstack.isEmpty()){
//            mainstack.push(helperstack.pop());
//        }
//    }
//    public static int remove(){
//        if(mainstack.isEmpty()){
//            System.out.println("Queue is empty");
//            return -1;
//        }
//        return mainstack.pop();
//    }
//    public static int peek(){
//        return mainstack.peek();
//    }
//}

//STACK USING 2 QUEUES*******************************************************************
//    static class Stack{
//        static Queue<Integer> q1=new LinkedList<>();
//        static Queue<Integer> q2=new LinkedList<>();
//        public static boolean isEmpty(){
//            return q1.isEmpty()&&q2.isEmpty();
//        }
//        public static void push(int data){
//            if(isEmpty()){
//                q1.add(data);
//                return;
//            }
//            if(!q1.isEmpty()){
//                q1.add(data);
//            } else{
//                q2.add(data);
//            }
//        }
//        public static int pop(){
//            if(isEmpty()){
//                System.out.println("Stack is empty");
//                return -1;
//            }
//            int temp=-1;
//            if(!q1.isEmpty()){
//                while(!q1.isEmpty()){
//                    temp=q1.remove();
//                    if(q1.isEmpty()){
//                        break;
//                    }
//                    q2.add(temp);
//                }
//            }else{
//                while(!q2.isEmpty()){
//                    temp=q2.remove();
//                    if(q2.isEmpty()){
//                        break;
//                    }
//                    q1.add(temp);
//                }
//            }
//            return temp;
//        }
//        public static int peek(){
//            int temp=-1;
//            if(!q1.isEmpty()){
//                while(!q1.isEmpty()){
//                    temp=q1.remove();
//                    q2.add(temp);
//                }
//            }else{
//                while(!q2.isEmpty()){
//                    temp=q2.remove();
//
//                    q1.add(temp);
//                }
//            }
//            return temp;
//        }
//    }
//FIRST NON-REPEATING LETTER*************************************************************
//    public static void firstNonRepeating(String str){
//        int freq[]=new int[26];
//        Queue<Character> q= new LinkedList<>();
//        for(int i=0;i<str.length();i++){
//            char ch=str.charAt(i);
//            q.add(ch);
//            freq[ch-'a']++;
//            while(!q.isEmpty()&&freq[q.peek()-'a']>1){
//                q.remove();
//            }
//            if(q.isEmpty()){
//                System.out.print(-1+" ");
//            }else{
//                System.out.print(q.peek()+" ");
//            }
//        }
//        System.out.println();
//    }
//CODE FOR INTERLEAVE*******************************************************************
//    public static void interleave(Queue<Integer> q){
//        Queue<Integer> first=new LinkedList<>();
//        int size=q.size();
//        for(int i=0;i<size/2;i++){
//            first.add(q.remove());
//        }
//        while (!first.isEmpty()) {
//            q.add(first.remove());
//            q.add(q.remove());
//        }
//    }
//COMMAND FOR REVERSING QUEUE***********************************************************
//    public static void reversequeue(Queue<Integer> q){
//        Stack<Integer> s=new Stack<>();
//        while(!q.isEmpty()){
//            s.push(q.remove());
//        }
//        while(!s.isEmpty()){
//            q.add(s.pop());
//        }
//    }
//STACK USNIG DEQUE*********************************************************************
//    static class Stack{
//        static Deque<Integer> dq=new LinkedList<>();
//        public static void push(int data){
//            dq.addLast(data);
//        }
//        public static int pop(){
//            return dq.removeLast();
//        }
//        public static int peek(){
//            return dq.getLast();
//        }
//    }
//COMMAND FOR QUEUE USING DEQUE*********************************************************
    static class Queue{
        static Deque<Integer> dq=new LinkedList<>();
        public static void push(int data){
            dq.addLast(data);
        }
        public static int pop(){
            return dq.removeFirst();
        }
        public static int peek(){
            return dq.getFirst();
        }
}
    public static void main(String[] args) {
//COMMAND FOR NORMAL QUEUE****************************************************************
//        Queue q=new Queue(5);
//        q.add(1);
//        q.add(2);
//        q.add(3);
//        q.add(4);
//        q.add(5);
//        while(!q.isEmpty()){
//            System.out.println(q.remove());
//        }
//COMMAND FOR CIRCULAR QUEUE**************************************************************
//        Queue q=new Queue(3);
//        q.add(1);
//        q.add(2);
//        q.add(3);
//        System.out.println(q.remove());
//        q.add(4);
//        System.out.println(q.remove());
//        q.add(5);
//        while(!q.isEmpty()){
//            System.out.println(q.remove());
//        }
//COMMAND FOR QUEUE BY LL****************************************************************
//        Queue q=new Queue();
//        q.add(1);
//        q.add(2);
//        q.add(3);
//        System.out.println(q.remove());
//        q.add(4);
//        System.out.println(q.remove());
//        q.add(5);
//        while(!q.isEmpty()){
//            System.out.println(q.remove());
//        }
//COMMAND FOR QUEUE BY JCF
//        Queue<Integer> q = new ArrayDeque<>();
//        q.add(1);
//        q.add(2);
//        q.add(3);
//        while(!q.isEmpty()){
//            System.out.println(q.remove()+" ");
//COMMAND FOR QUEUE USING 2 STACKS*******************************************************
//        Queue q=new Queue();
//        q.add(1);
//        q.add(2);
//        q.add(3);
//        q.add(4);
//        q.add(5);
//        while(!q.isEmpty()){
//            System.out.println(q.remove());
//        }
//COMMAND FOR STACK USING 2 QUEUES*******************************************************
//        Stack s=new Stack();
//        s.push(1);
//        s.push(2);
//        s.push(3);
//        while(!s.isEmpty()){
//            System.out.println(s.peek());
//            s.pop();
//        }
//COMMAND FOR FIRST NON REPEATING LETTER************************************************
//        String str="aabccddbx";
//        firstNonRepeating(str);
//CODE FOR INTERLEAVE*******************************************************************
//        Queue<Integer>q=new LinkedList<>();
//        q.add(1);
//        q.add(2);
//        q.add(3);
//        q.add(4);
//        q.add(5);
//        q.add(6);
//        q.add(7);
//        q.add(8);
//        q.add(9);
//        q.add(10);
//        interleave(q);
//        while(!q.isEmpty()){
//            System.out.print(q.remove()+" ");
//        }
//        System.out.println();
//COMMAND FOR REVERSAL OFF QUEUE********************************************************
//        Queue<Integer>q=new LinkedList<>();
//        q.add(1);
//        q.add(2);
//        q.add(3);
//        q.add(4);
//        q.add(5);
//        q.add(6);
//        q.add(7);
//        q.add(8);
//        q.add(9);
//        q.add(10);
//        reversequeue(q);
//        while(!q.isEmpty()){
//            System.out.print(q.remove()+" ");
//        }
//        System.out.println();
//DEQUEi.e.,DOUBLE ENDED QUEUE (DIFFERENT FROM DEQUEUE(DELETING))***********************
//        Deque<Integer> dq=new LinkedList<>();
//        dq.addFirst(1);
//        dq.addFirst(2);
//        dq.addLast(3);
//        dq.addLast(4);
//        System.out.println(dq);
//        dq.removeLast();
//        System.out.println(dq);
//        dq.removeFirst();
//        System.out.println(dq);
//COMMAND FOR STACK USNIG DEQUE*********************************************************
//        Stack s=new Stack();
//        s.push(1);
//        s.push(2);
//        s.push(3);
//        System.out.println("peek = "+s.peek());
//        System.out.println(s.pop());
//        System.out.println(s.pop());
//        System.out.println(s.pop());
//COMMAND FOR QUEUE USING DEQUE*********************************************************
        Queue q=new Queue();
        q.push(1);
        q.push(2);
        q.push(3);
        System.out.println("peek = "+q.peek());
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());
    }
}
