public class BitManipulation {
    public static void oddOrEven(int n){
        if(((n&1)==0)){
            System.out.println("even");
        }else{
            System.out.println("odd");
        }
    }

    public static void getBit(int n, int k){
        int bitMask=1<<k;
        if((n&bitMask)==0){
            System.out.println(0);
        }else{
            System.out.println(1);
        }
    }

    public static int setBit(int n, int k){
        int bitMask=1<<k;
        return n|bitMask;
    }

    public static int clearBit(int n, int k){
        int bitMask=~(1<<k);
        return n&bitMask;
    }

    public static int UpdateBit(int n,int i,int k){
        if(k==0){
            return clearBit(n,i);
        }
        else{
            return setBit(n,i);
        }
    }

    public static int ClearLastIBits(int n,int k){
        int bitMask=(~0<<k);
        return (n & bitMask);
    }

    public static int ClearRangeOfBits(int n, int i, int j){
        int a=((~0)<<(j+1));
        int b= (1<<i)-1;
        int bitMask= a|b;
        return n&bitMask;
    }

    public static boolean isPowerof2(int n){
        return (n&(n-1))==0;
    }

    public static int countSetBits(int n){
        int count=0;
        while(n>0){
            if((n&1)!=0){
                count++;
            }
            n=n>>1;
        }
        return count;
    }

    public static int FastExponentiation(int a, int n){
        int ans=1;
        while(n>0){
            if((n&1) !=0){
                ans*=a;
            }
            a=a*a;
            n=n>>1;
        }
        return ans;
    }

    public static void main(String[] args) {
        oddOrEven(101);
        getBit(101,0);
        System.out.println(setBit(10,5));
        System.out.println(clearBit(10,1));
        System.out.println(UpdateBit(10,2,1));
        System.out.println(ClearLastIBits(15,2));
        System.out.println(ClearRangeOfBits(15,1,2));
        System.out.println(isPowerof2(14));
        System.out.println(countSetBits(15));
        System.out.println(FastExponentiation(3,5));
    }
}
