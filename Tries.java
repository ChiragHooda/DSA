public class Tries {
    static class Node{
        Node children[]=new Node[26];
        boolean eow=false;
        int freq;
        Node(){
            for(int i=0;i<26;i++){
                children[i]=null;
            }
            freq=1;
        }
    }
    public static Node root=new Node();
    public static void insert(String s){//O(L)->L is the length of the longest word
        Node curr=root;
        for(int lvl=0;lvl<s.length();lvl++){
            int idx=s.charAt(lvl) - 'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new Node();
            }
//            else {
//                curr.children[idx].freq++;
//            }
            curr=curr.children[idx];
        }
        curr.eow=true;
    }
    public static boolean search(String s){
        Node curr=root;
        for(int lvl=0;lvl<s.length();lvl++){
            int idx=s.charAt(lvl)-'a';
            if(curr.children[idx]==null){
                return false;
            }
            curr=curr.children[idx];
        }
        return curr.eow==true;
    }
    public static boolean wordbreak(String s){
        if(s.length()==0){
            return true;
        }
        for(int lvl=1;lvl<=s.length();lvl++){
            if(search(s.substring(0,lvl)) && wordbreak(s.substring(lvl))){
                return true;
            }
        }
        return false;
    }
    public static void findPrefix(Node root,String ans){
        if(root==null){
            return;
        }
        if(root.freq==1){
            System.out.println(ans);
            return;
        }
        for(int i=0;i<root.children.length;i++){
            if(root.children[i]!=null){
                findPrefix(root.children[i],ans+(char)(i+'a'));
            }
        }
    }
    public static boolean startsWith(String Prefix){
        Node curr=root;
        for(int i=0;i<Prefix.length();i++){
            int idx=Prefix.charAt(i)-'a';
            if(curr.children[idx]==null){
                return false;
            }
            curr=curr.children[idx];
        }
        return true;
    }
    public static int countNodes(Node root){
        if(root==null){
            return 0;
        }
        int count =0;
        for(int i=0;i<26;i++){
            if(root.children[i]!=null){
                count+=countNodes(root.children[i]);
            }
        }
        return count+1;
    }
    public static String ans="";
    public static void longestWord(Node root, StringBuilder temp){
        if(root==null){
            return;
        }
        for(int i=0;i<26;i++){
            if(root.children[i]!=null&& root.children[i].eow==true){
                char ch=(char)(i+'a');
                temp.append(ch);
                if(temp.length()>ans.length()){
                    ans=temp.toString();
                }
                longestWord(root.children[i],temp);
                temp.deleteCharAt(temp.length()-1);
            }
        }
    }
    public static void main(String[] args) {
        String words[]={"a","banana","app","appl","ap","apply","apple"};
        for(int i=0;i< words.length;i++){
            insert(words[i]);
        }
//        System.out.println(search("any"));
//        System.out.println(search("thee"));
//        System.out.println(search("theree"));
//        String str="theretheiranyathe";
//        System.out.println(wordbreak(str));
//        root.freq=-1;
//        String ans="";
//        findPrefix(root,ans);
        StringBuilder sb=new StringBuilder("");
        longestWord(root,sb);
        System.out.println(ans);
        String str1="ababa";
        for(int i=0;i<str1.length();i++){
            String suffix=str1.substring(i);
            insert(suffix);
        }
        System.out.println(countNodes(root));
    }
}
