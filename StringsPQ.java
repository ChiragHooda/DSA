import java.util.Arrays;

public class StringsPQ {
    //Question 1
    public static int lowercasevowels(String str){
        int count=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='a' || str.charAt(i)=='e' || str.charAt(i)=='i' ||str.charAt(i)=='o' ||str.charAt(i)=='u'){
                count++;
            }
        }
        return count;
    }

    public static boolean anagrams(String str1, String str2){
        str1=str1.toLowerCase();
        str2=str2.toLowerCase();
        if(str1.length()==str2.length()){
            char ch1[]= str1.toCharArray();
            char ch2[]=str2.toCharArray();
            Arrays.sort(ch1);
            Arrays.sort(ch2);
            return Arrays.equals(ch1,ch2);
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        String str="Hi My Name is Chirag Choudhary";
        System.out.println(lowercasevowels(str));
        String str1="care";
        String str2="race";
        System.out.println(anagrams(str1,str2));
    }
}
