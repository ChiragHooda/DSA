import java.awt.color.ICC_ColorSpace;
import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;

public class BST {//BINARY SEARCH TREES
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
//            this.left=null;
//            this.right=null;
        }
    }
    public static Node insert(Node root,int val){
        if(root==null){
            root=new Node(val);
            return root;
        }
        if(root.data>val){
            root.left=insert(root.left,val);
        }
        if(root.data<val){
            root.right=insert(root.right,val);
        }
        return root;
    }
    public static void inOrder(Node root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }
    public static boolean search(Node root,int val){
        if(root==null){
            return false;
        }
        if(root.data==val){
            return true;
        }
        if(root.data>val){
            return search(root.left,val);
        }
        else{
            return search(root.right,val);
        }
    }
    public static Node delete(Node root,int val){
        if(root.data>val){
            root.left=delete(root.left,val);
        }
        else if(root.data<val){
            root.right=delete(root.right,val);
        }
        else{
            if(root.left==null&&root.right==null){
                return null;
            }
            if(root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }
            Node IS=findInorderSuccessor(root.right);
            root.data=IS.data;
            root.right=delete(root.right,IS.data);
        }
        return root;
    }
    public static Node findInorderSuccessor(Node root){
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }
    public static void printInRange(Node root,int k1,int k2){
        if(root==null){
            return;
        }
        if(root.data>=k1&&root.data<=k2){
            printInRange(root.left,k1,k2);
            System.out.print(root.data+" ");
            printInRange(root.right,k1,k2);
        }
        else if(root.data<k1){
            printInRange(root.left,k1,k2);
        }
        else{
            printInRange(root.right,k1,k2);
        }
    }
    public static void printpath(ArrayList<Integer> a){
        for(int i=0;i<a.size();i++){
            System.out.print(a.get(i)+"->");
        }
        System.out.println("null");
    }
    public static void printPathroot2leaf(Node root, ArrayList<Integer> path){
        if(root==null){
            return;
        }
        path.add(root.data);
        if(root.left==null&&root.right==null){
            printpath(path);
        }
        printPathroot2leaf(root.left,path);
        printPathroot2leaf(root.right,path);
        path.remove(path.size()-1);
    }
    public static boolean isvalidBST(Node root,Node min,Node max){
        if(root==null){
            return true;
        }
        if(min!=null && root.data<=min.data){
            return false;
        }
        else if(max!=null && root.data>=max.data){
            return false;
        }
        return isvalidBST(root.left,min,root)
                && isvalidBST(root.right,root,max);
    }
    public static Node createMirror(Node root){
        if(root==null){
            return null;
        }
        Node leftMirror=createMirror(root.left);
        Node rightMirror=createMirror(root.right);
        root.left=rightMirror;
        root.right=leftMirror;
        return root;
    }
    public static void preOrder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
//    public static Node createBST(int arr[],int st,int end){
//        if(st>end){
//            return null;
//        }
//        int mid=st+(end-st)/2;
//        Node root=new Node(arr[mid]);
//        root.left=createBST(arr,st,mid-1);
//        root.right=createBST(arr,mid+1,end);
//        return root;
//    }
    public static Node createBST(ArrayList<Integer> a,int st,int end){
        if(st>end){
            return null;
        }
        int mid=st+(end-st)/2;
        Node root=new Node(a.get(mid));
        root.left=createBST(a,st,mid-1);
        root.right=createBST(a,mid+1,end);
        return root;
    }
    public static void getInorder(Node root,ArrayList<Integer> a){
        if(root==null){
            return;
        }
        getInorder(root.left,a);
        a.add(root.data);
        getInorder(root.right,a);
    }
    public static Node balancedBST(Node root){//O(n)
        ArrayList<Integer> a=new ArrayList<>();
        getInorder(root,a);
        root=createBST(a,0,a.size()-1);
        return root;
    }
    static class Info{
        boolean isBST;
        int size;
        int min;
        int max;
        public Info(boolean isBST,int size,int min,int max){
            this.isBST=isBST;
            this.size=size;
            this.min=min;
            this.max=max;
        }
    }
    public static int maxBST=0;
    public static Info largestBST(Node root){
        if(root==null){
            return new Info(true,0,Integer.MAX_VALUE,Integer.MIN_VALUE);
        }
        Info leftInfo=largestBST(root.left);
        Info rightInfo=largestBST(root.right);
        int size=leftInfo.size+rightInfo.size+1;
        int min=Math.min(root.data,Math.min(leftInfo.min,rightInfo.min));
        int max=Math.max(root.data,Math.max(leftInfo.max,rightInfo.max));
        if(root.data<=leftInfo.max||root.data>= rightInfo.min){
            return new Info(false,size,min,max);
        }
        if(leftInfo.isBST&& rightInfo.isBST){
            maxBST=Math.max(size,maxBST);
            return new Info(true,size,min,max);
        }
        return new Info(false,size,min,max);
    }
    public static Node merge2BST(Node root1,Node root2){
        ArrayList<Integer> a1=new ArrayList<>();
        getInorder(root1,a1);
        ArrayList<Integer> a2=new ArrayList<>();
        getInorder(root2,a2);
        int i=0,j=0;
        ArrayList<Integer> finalarr=new ArrayList<>();
        while(i<a1.size()&&j<a2.size()){
            if(a1.get(i)<=a2.get(j)){
                finalarr.add(a1.get(i));
                i++;
            }else{
                finalarr.add(a2.get(j));
                j++;
            }
        }
        while(i<a1.size()){
            finalarr.add(a1.get(i));
            i++;
        }
        while(j<a2.size()){
            finalarr.add(a2.get(j));
            j++;
        }
        return createBST(finalarr,0,finalarr.size()-1);
    }
    public static void main(String[] args) {
//        int values[]={8,5,3,6,10,11};
//        Node root=null;
//        for(int i=0;i< values.length;i++){
//            root=insert(root,values[i]);
//        }
//        inOrder(root);
//        System.out.println();
//        System.out.println(search(root,6));
//        root=delete(root,2);
//        System.out.println();
//        inOrder(root);
//        System.out.println();
//        printInRange(root,5,12);
//        System.out.println();
//        printPathroot2leaf(root,new ArrayList<Integer>());
//        if(isvalidBST(root,null,null)){
//            System.out.println("valid");
//        }else{
//            System.out.println("not valid");
//        }
//        root=createMirror(root);
//        preOrder(root);
//        int arr[]={3,5,6,8,10,11,12};
//        Node root=createBST(arr,0,arr.length-1);
//        preOrder(root);
//        Node root=new Node(50);
//        root.left=new Node(30);
//        root.left.left=new Node(5);
//        root.left.right=new Node(20);
//        root.right=new Node(60);
//        root.right.left=new Node(45);
//        root.right.right=new Node(70);
//        root.right.right.left=new Node(65);
//        root.right.right.right=new Node(80);
//        root=balancedBST(root);
//        preOrder(root);
//        Info info=largestBST(root);
//        System.out.println("largest bst size = "+maxBST);
        Node root1=new Node(2);
        root1.left=new Node(1);
        root1.right=new Node(4);
        Node root2=new Node(9);
        root2.left=new Node(3);
        root2.right=new Node(12);
        Node root=merge2BST(root1,root2);
        preOrder(root);
    }
}
