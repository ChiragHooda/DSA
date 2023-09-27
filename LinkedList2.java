import javax.imageio.stream.ImageInputStream;

//import java.util.LinkedList;
public class LinkedList2 {
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static boolean isCycle(){
        Node slow=head;
        Node fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
    public static Node head;
    public static Node tail;
    public static int size;

    public static void addFirst(int data){//->O(1)
        Node newnode=new Node(data);
        size++;
        if(head==null){
            head=tail=newnode;
            return;
        }
        newnode.next=head;
        head=newnode;
    }

    public static void addLast(int data){//->O(1)
        Node newnode=new Node(data);
        size++;
        if(head==null){
            head=tail=newnode;
            return;
        }
        tail.next=newnode;
        tail=newnode;
    }

    public void printLL(){
        if(head==null){
            System.out.println("LL is empty");
            return;
        }
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }

    public static void add(int idx,int data){
        if(idx==0){
            addFirst(data);
            return;
        }
        Node newnode=new Node(data);
        size++;
        Node temp=head;
        int i=0;
        while(i<idx-1){
            temp=temp.next;
            i++;
        }
        newnode.next=temp.next;
        temp.next=newnode;
    }

    public static int removeFirst(){
        if(size==0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }
        else if(size==1){
            int val=head.data;
            head=tail=null;
            size=0;
            return val;
        }
        int val=head.data;
        head=head.next;
        size--;
        return val;
    }

    public static int removeLast(){
        if(size==0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }else if(size==1){
            int val=head.data;
            head=tail=null;
            size--;
            return val;
        }
        Node prev=head;
        for(int i=0;i<size-2;i++){
            prev=prev.next;
        }
        int val=prev.next.data;
        prev.next=null;
        tail=prev;
        size--;
        return val;
    }

    public static void removeCycle(){
        Node slow=head;
        Node fast=head;
        boolean cycle;
        while(fast!=null&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                cycle=true;
                break;
            }
            cycle=false;
        }
        slow=head;
        Node prev=null;
        while(slow!=fast){
            prev=fast;
            slow=slow.next;
            fast=fast.next;
        }
        prev.next=null;
    }

    public static Node findMid(Node head){
        Node slow=head;
        Node fast=head.next;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    private static Node merge(Node head1,Node head2){
        Node mergeLL=new Node(-1);
        Node temp=mergeLL;
        while(head1!=null && head2!=null){
            if(head1.data>head2.data){
                temp.next=head1;
                head1=head1.next;
                temp=temp.next;
            }else{
                temp.next=head2;
                head2=head2.next;
                temp=temp.next;
            }
        }
        while(head1!=null){
            temp.next=head1;
            head1=head1.next;
            temp=temp.next;
        }
        while(head2!=null){
            temp.next=head2;
            head2=head2.next;
            temp=temp.next;
        }
        return mergeLL.next;
    }
    public static Node mergeSort(Node head){
        if(head==null||head.next==null){
            return head;
        }
        Node mid=findMid(head);
        Node rightHead=mid.next;
        mid.next=null;
        Node newleft=mergeSort(head);
        Node newright=mergeSort(rightHead);
        return merge(newleft,newright);
    }

    public void makeZigZag(Node head) {
        Node mid = findMid(head);
        //reverse
        Node prev = null;
        Node curr = mid.next;
        mid.next=null;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node RH = prev;
        Node LH=head;
        Node nextL, nextR;
        while (LH != null & RH != null) {
            nextL = LH.next;
            LH.next = RH;
            nextR = RH.next;
            RH.next = nextL;
            LH = nextL;
            RH = nextR;
            }
        }
    public static void main(String[] args){
//        head=new Node(1);
//        Node temp=new Node(2);
//        head.next=temp;
//        head.next.next=new Node(3);
//        head.next.next.next=temp;
//        System.out.println(isCycle());
//        removeCycle();
//        System.out.println(isCycle());
        LinkedList2 l2=new LinkedList2();;
        l2.addFirst(1);
        l2.addLast(2);
        l2.addLast(3);
        l2.addLast(4);
        l2.addLast(5);
        l2.addLast(6);
        l2.addLast(7);
        l2.addLast(8);
        l2.addLast(9);
        l2.printLL();
//        l2.head=l2.mergeSort(l2.head);
//        l2.printLL();
        l2.makeZigZag(l2.head);
        l2.printLL();
//****************************************************************************************
        //JCF LL
//        LinkedList<Integer> l1=new LinkedList<>();
        //add
//        l1.addFirst(2);
//        l1.addFirst(1);
//        l1.addLast(3);
//        l1.addLast(4);
//        System.out.println(l1);
//        //delete
//        l1.removeFirst();
//        l1.removeLast();
//        System.out.println(l1);
    }
}
