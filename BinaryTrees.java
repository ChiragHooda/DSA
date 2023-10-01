import java.util.*;
import java.util.LinkedList;

public class BinaryTrees {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    static class BinaryTree{
        static int idx=-1;
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }
            Node newnode=new Node(nodes[idx]);
            newnode.left=buildTree(nodes);
            newnode.right=buildTree(nodes);
            return newnode;
        }
    }
    public static void preOrder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
//    public static void inOrder(Node root){
//        if(root==null){
//            return;
//        }
//        inOrder(root.left);
//        System.out.print(root.data+" ");
//        inOrder(root.right);
//    }
//    public static void postOrder(Node root){
//        if(root==null){
//            return;
//        }
//        postOrder(root.left);
//        postOrder(root.right);
//        System.out.print(root.data+" ");
//    }
//    public static void levelOrder(Node root){
//        Queue<Node> q=new LinkedList<>();
//        q.add(root);
//        q.add(null);
//        while(!q.isEmpty()){
//            Node curr=q.remove();
//            if(curr==null){
//                System.out.println();
//                if(q.isEmpty()){
//                    break;
//                }else{
//                    q.add(null);
//                }
//            }else{
//                System.out.print(curr.data+" ");
//                if(curr.left!=null){
//                    q.add(curr.left);
//                }
//                if(curr.right!=null){
//                    q.add(curr.right);
//                }
//            }
//        }
//    }
//    public static int height(Node root){
//        if(root==null){
//            return 0;
//        }
//        int lh=height(root.left);
//        int rh=height(root.right);
//        return Math.max(lh,rh)+1;
//    }
//    public static int countNodes(Node root){
//        if(root==null){
//            return 0;
//        }
//        int lc=countNodes(root.left);
//        int rc=countNodes(root.right);
//        return lc+rc+1;
//    }
//    public static int sumOfNodes(Node root){
//        if(root==null){
//            return 0;
//        }
//        int ls=sumOfNodes(root.left);
//        int rs=sumOfNodes(root.right);
//        return ls+rs+root.data;
//    }
//    public static int diameter(Node root){
//        if(root==null){
//            return 0;
//        }
//        int leftdia=diameter(root.left);
//        int lh=height(root.left);
//        int rightdia=diameter(root.right);
//        int rh=height(root.right);
//
//        int selfdia=lh+rh+1;
//        return Math.max(Math.max(leftdia,rightdia),selfdia);
//    }
//    static class Info{
//        int dia;
//        int ht;
//        Info(int dia,int ht){
//            this.dia=dia;
//            this.ht=ht;
//        }
//    }
//    public static Info diameterbetter(Node root){
//        if(root==null){
//            return new Info(0,0);
//        }
//        Info leftInfo=diameterbetter(root.left);
//        Info rightInfo=diameterbetter(root.right);
//        int selfdia=leftInfo.ht+rightInfo.ht+1;
//        int dia=Math.max(Math.max(leftInfo.dia, rightInfo.dia),selfdia);
//        int ht=Math.max(leftInfo.ht,rightInfo.ht)+1;
//        return new Info(dia,ht);
//    }
//    public static boolean isIdentical(Node node,Node subroot){
//        if(node==null&&subroot==null){
//            return true;
//        }else if(node==null||subroot==null||node.data!=subroot.data){
//            return false;
//        }
//        if(!isIdentical(node.left,subroot.left)){
//            return false;
//        }
//        if(!isIdentical(node.right,subroot.right)){
//            return false;
//        }
//        return true;
//    }
//    public static boolean isSubtree(Node root,Node subroot){
//        if(root==null){
//            return false;
//        }
//        if(root.data==subroot.data){
//            if(isIdentical(root,subroot)){
//                return true;
//            }
//        }
//        return isSubtree(root.left,subroot)||isSubtree(root.right,subroot);
//    }
    static class Info{
        Node node;
        int hd;
        Info(Node node,int hd){
            this.node=node;
            this.hd=hd;
        }
    }
    public static void topview(Node root){
        int min=0,max=0;
        Queue<Info> q=new LinkedList<>();
        HashMap<Integer,Node> map=new HashMap<>();
        q.add(new Info(root,0));
        q.add(null);
        while(!q.isEmpty()){
            Info curr=q.remove();
            if(curr==null){
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                if(!map.containsKey(curr.hd)){
                    map.put(curr.hd,curr.node);
                }
                if(curr.node.left!=null){
                    q.add(new Info(curr.node.left,curr.hd-1));
                    min=Math.min(min,curr.hd-1);
                }
                if(curr.node.right!=null){
                    q.add(new Info(curr.node.right,curr.hd+1));
                    max=Math.max(max,curr.hd+1);
                }
            }
        }
        for(int i=min;i<=max;i++){
            System.out.print(map.get(i).data+" ");
        }
        System.out.println();
    }
    public static void KLevel(Node root,int level,int k){
        if(root==null){
            return;
        }
        if(level==k){
            System.out.print(root.data+" ");
        }
        KLevel(root.left,level+1,k);
        KLevel(root.right,level+1,k);
    }
    public static boolean getpath(Node root,int n,ArrayList<Node> a){
        if(root==null){
            return false;
        }
        a.add(root);
        if(root.data==n){
            return true;
        }
        boolean foundleft=getpath(root.left,n,a);
        boolean foundright=getpath(root.right,n,a);
        if(foundleft||foundright){
            return true;
        }
        a.remove(a.size()-1);
        return false;
    }
    public static Node lca(Node root,int n1,int n2){
        ArrayList<Node> a1=new ArrayList<>();
        ArrayList<Node> a2=new ArrayList<>();
        getpath(root,n1,a1);
        getpath(root,n2,a2);
        int i=0;
        for(;i<a1.size();i++){
            if(a1.get(i)!=a2.get(i)){
                break;
            }
        }
        Node lca=a1.get(i-1);
        return lca;
    }
    public static Node lca2(Node root,int n1,int n2){
        if(root==null||root.data==n1||root.data==n2){
            return root;
        }
        Node leftlca=lca2(root.left,n1,n2);
        Node rightlca=lca2(root.right,n1,n2);
        if(rightlca==null){
            return leftlca;
        }
        if(leftlca==null){
            return rightlca;
        }
        return root;
    }
    public static int lcadist(Node root,int n){
        if(root==null){
            return -1;
        }
        if(root.data==n){
            return 0;
        }
        int leftdist=lcadist(root.left,n);
        int rightdist=lcadist(root.right,n);
        if(leftdist==-1&&rightdist==-1){
            return -1;
        }else if(leftdist==-1){
            return rightdist+1;
        }else {
            return leftdist+1;
        }
    }
    public static int mindist(Node root,int n1,int n2){
        Node lca=lca2(root,n1,n2);
        int dist1=lcadist(lca,n1);
        int dist2=lcadist(lca,n2);
        return dist1+dist2;
    }
    public static int KAncestor(Node root,int n,int k){
        if(root==null){
            return -1;
        }
        if(root.data==n){
            return 0;
        }
        int lefftdist=KAncestor(root.left,n,k);
        int rightdist=KAncestor(root.right,n,k);
        if(lefftdist==-1&&rightdist==-1){
            return -1;
        }
        int max=Math.max(lefftdist,rightdist);
        if(max+1==k){
            System.out.println(root.data);
        }
        return max+1;
    }
    public static int sumTree(Node root){
        if(root==null){
            return 0;
        }
        int leftdist=sumTree(root.left);
        int rightdist=sumTree(root.right);
        int data=root.data;
        int newleft=root.left==null?0:root.left.data;
        int newright=root.right==null?0:root.right.data;
        root.data=newright+newleft+leftdist+rightdist;
        return data;
    }
    public static void main(String[] args) {
//        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
//        BinaryTree tree=new BinaryTree();
//        Node root=tree.buildTree(nodes);
//        System.out.println(root.data);
//        preOrder(root);
//        System.out.println();
//        inOrder(root);
//        System.out.println();
//        postOrder(root);
//        System.out.println();
//        levelOrder(root);
//        System.out.println(height(root));
//        System.out.println(countNodes(root));
//        System.out.println(sumOfNodes(root));
//        System.out.println(diameter(root));
//        System.out.println(diameterbetter(root).dia);
//        System.out.println(diameterbetter(root).ht);
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.left=new Node(6);
        root.right.right=new Node(7);

        Node subroot=new Node(2);
        subroot.left=new Node(4);
        subroot.right=new Node(5);
        subroot.right.right=new Node(6);
//        System.out.println(isSubtree(root,subroot));
//        topview(root);
//        KLevel(root,1,3);
//        System.out.println(lca(root,4,5).data);
//        System.out.println(lca2(root,4,5).data);
//        System.out.println(mindist(root,5,6));
//        KAncestor(root,4,2);
        sumTree(root);
        preOrder(root);
    }
}
