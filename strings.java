public class strings {

    public static void shortestpath(String str){
        int x=0;
        int y=0;
        for( int i=0;i<str.length();i++){
            if(str.charAt(i)=='N'){
                y++;
            }
            else if(str.charAt(i)=='S'){
                y--;
            }
            else if(str.charAt(i)=='E'){
                x++;
            }
            else{
                x--;
            }
        }
        int x2=x*x;
        int y2=y*y;
        float shortestdistance=(float) (Math.sqrt(x2+y2));
        System.out.println("shortest distance : "+shortestdistance);
    }

    public static String Uppercase(String str){
        StringBuilder sb= new StringBuilder("");

        char ch=Character.toUpperCase(str.charAt(0));
        sb.append(ch);
        for(int i=1;i<str.length();i++){
            if(str.charAt(i)==' ' && i<str.length()-1){
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            }else{
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static String StringCompress(String str){
        StringBuilder sb= new StringBuilder("");
        Integer count=1;
        for(int i=0;i<str.length();i++){
            while(i<str.length()-1  && str.charAt(i)==str.charAt(i+1)){
                count++;
                i++;
            }
            sb.append(str.charAt(i));
            if(count>1){
                sb.append(count.toString());
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        StringBuilder  sb= new StringBuilder("abc");
//        System.out.println(sb);
//        int a=10;
//        Integer b=10;
//        //System.out.println(a.toString());
//        System.out.println(b.toString()+sb);
//        StringBuilder str= new StringBuilder("");
//        for(char ch='a';ch<='z';ch++){
//            str.append(ch);
//        }
//        System.out.println(str);
//        System.out.println(str.length());
//        String ch = "WNEENESENNN";
//        shortestpath(ch);
//        String s1="Choudhary";
//        String s2=new String("Choudhary");
//        String s3="choudhary";
//        String s4="Choudhari";
//        System.out.println(s1.equalsIgnoreCase(s2));
//        System.out.println(s1.equalsIgnoreCase(s3));
//        System.out.println(s1.equalsIgnoreCase(s4));
//        System.out.println(s2.equalsIgnoreCase(s3));
//        String str1="hi my name is chirag choudhary";
//        System.out.println(Uppercase(str1));
        String str2="aaabbccccccccc";
        System.out.println(StringCompress(str2));
        String st=new String("Welcome to java");
        String st2=new String("Welcome to java").intern();
        System.out.println(st==st2);
    }
}
