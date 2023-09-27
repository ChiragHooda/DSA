public class DoubleLL {
    public static class Node{
        int data;
        Node next;
        Node prev;
        public Node(int data){
            this.data=data;
            this.next=null;
            this.prev=null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;
    public void addFirst(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=tail=newNode;
            return;
        }
        newNode.next=head;
        head.prev=newNode;
        head=newNode;
    }
    public void addLast(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=tail=newNode;
            return;
        }
        tail.next=newNode;
        newNode.prev=tail;
        newNode.next=null;
        tail=newNode;
    }
    public int removeFirst(){
        if(head==null){
            System.out.println("DLL is empty");
            return -1;
        }
        if(size==1){
            int val=head.data;
            head=tail=null;
            size--;
            return val;
        }
        int val=head.data;
        Node curr=head.next;
        head.next.prev=null;
        head.next=null;
        head=curr;
        return val;
    }
    public int removeLast(){
        if(head==null){
            System.out.println("DLL is empty");
            return -1;
        }
        if(size==1){
            int val=head.data;
            head=tail=null;
            size--;
            return val;
        }
        Node temp=head;
        while(temp!=null){
            tail=temp;
            temp=temp.next;
        }
        int val=tail.data;
        Node curr=tail.prev;
        tail.prev.next=null;
        tail.prev=null;
        tail=curr;
        return val;
    }
    public static void print(){
        Node temp=head;
        System.out.print("null<->");
        while(temp!=null){
            System.out.print(temp.data+"<->");
            temp=temp.next;
        }
        System.out.println("null");
    }

    public void reverse(){
        Node curr=head;
        Node prev=null;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            curr.prev=next;
            prev=curr;
            curr=next;
        }
        head=prev;
    }
    public static void main(String[] args) {
        DoubleLL dll=new DoubleLL();
        dll.addFirst(1);
        dll.addLast(2);
        dll.addLast(3);
        dll.addLast(4);
        dll.addFirst(0);
        dll.print();
//        dll.removeFirst();
//        dll.removeLast();
//        dll.print();
        dll.reverse();
        dll.print();
    }
}
