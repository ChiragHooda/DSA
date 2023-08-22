public class Recursion {
    public static void NosInDecreasingOrder(int n) {
        if(n==0){
            System.out.print(0+" ");
            return;
        }
        System.out.print(n+" ");
        NosInDecreasingOrder(n - 1);
    }

    public static void NosInIncreasingOrder(int n){
        if(n==0){
            System.out.print(0+" ");
            return;
        }
        NosInIncreasingOrder(n-1);
        System.out.print(n+" ");
    }

    public static int Factorial(int n){
        if(n==0){
            return 1;
        }
        return n*Factorial(n-1);
    }

    public static int SumofnNaturalNumbrs(int n){
        if(n==0){
            return 0;
        }
        return n+SumofnNaturalNumbrs(n-1);
    }

    public static int FibonnaciSeries(int n){
        if(n==0 ||  n==1){
            return n;
        }
        return FibonnaciSeries(n-1)+FibonnaciSeries(n-2);
    }

    public static boolean isSorted(int arr[],int i){
        int n=arr.length;
        if(i==n-1){
            return true;
        }
        if(arr[i]>arr[i+1]){
            return false;
        }
        return isSorted(arr,i+1);
    }

    public static int FirstOccurrence(int arr[],int i,int k){
        if(i==arr.length){
            return -1;
        }
        if(arr[i]==k){
            return i;
        }
        return FirstOccurrence(arr,i+1,k);
    }

    public static int LastOccurrence(int arr[],int length,int k){
        if(length==0){
            return length;
        }
        if(arr[length-1]==k){
            return length-1;
        }
        return LastOccurrence(arr,length-1,k);
    }

    public static int xPowerN(int x,int n){
        if(n==0){
            return 1;
        }
        int nby2= xPowerN(x,n/2)*xPowerN(x,n/2);
        if(n%2!=0){
            return x*nby2;
        }
        return nby2;
    }

    public static int Tiling(int n){
        if(n==0 || n==1){
            return 1;
        }
        return Tiling(n-1)+Tiling(n-2);
    }

    public static void RemoveDuplicates(String str,int i,StringBuilder newStr, boolean map[]){
        if(i==str.length()){
            System.out.println(newStr);
            return;
        }
        if(map[str.charAt(i)-'a']==false){
            map[str.charAt(i)-'a']=true;
            RemoveDuplicates(str,i+1,newStr.append(str.charAt(i)),map);
        }else{
            RemoveDuplicates(str,i+1,newStr,map);
        }
    }

    public static int FriendsPairing(int n){
        if(n==1 || n==2){
            return n;
        }
        return FriendsPairing(n-1)+(n-1)*FriendsPairing(n-2);
    }

    public static void PrintBinStrings(int n,int lastplace,String str){
        if(n==0){
            System.out.println(str);
            return;
        }
        PrintBinStrings(n-1,0,str+"0");
        if(lastplace==0){
            PrintBinStrings(n-1,1,str+"1");
        }
    }

    public static void main(String[] args) {
        //NosInDecreasingOrder(10);
        //NosInIncreasingOrder(10);
        //System.out.println(Factorial(7));
        //System.out.println(SumofnNaturalNumbrs(6));
        //System.out.println(FibonnaciSeries(4));
        //int arr[]={1,5,2,4,6,7,5,4,2,7};
        //System.out.println(isSorted(arr,1));
        //System.out.println(FirstOccurrence(arr,0,2));
        //System.out.println(LastOccurrence(arr,arr.length,1));
        //System.out.println(xPowerN(5,4));
        //System.out.println(Tiling(6));
        //String str="abc";
        //RemoveDuplicates(str,0,new StringBuilder(""),new boolean[26]);
        //System.out.println(FriendsPairing(3));
        PrintBinStrings(4,0,new String(""));
    }
}